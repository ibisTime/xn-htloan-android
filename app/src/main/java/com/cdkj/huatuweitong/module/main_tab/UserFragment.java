package com.cdkj.huatuweitong.module.main_tab;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.dialog.InputDialog;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.baselibrary.utils.ToastUtil;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.AccountListModel;
import com.cdkj.huatuweitong.bean.UserFragmentBean;
import com.cdkj.huatuweitong.databinding.FragmentUserBinding;
import com.cdkj.huatuweitong.module.order.AllOrderTabActivity;
import com.cdkj.huatuweitong.module.user.AccountIntegraActivity;
import com.cdkj.huatuweitong.module.user.ConnectionServerActivity;
import com.cdkj.huatuweitong.module.user.MyAccountActivity;
import com.cdkj.huatuweitong.module.user.MyCarLoanActivity;
import com.cdkj.huatuweitong.module.user.MyCurrentActivity;
import com.cdkj.huatuweitong.module.user.MyMessageActivity;
import com.cdkj.huatuweitong.module.user.UserInfoUpdateActivity;
import com.cdkj.huatuweitong.module.user.interview.RoomActivity;
import com.cdkj.huatuweitong.module.user.zx.ZXListActivity;
import com.cdkj.huatuweitong.tencent.TencentLoginHelper;
import com.cdkj.huatuweitong.tencent.logininterface.TencentLoginInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * Created by cdkj on 2018/5/1.
 */

public class UserFragment extends BaseLazyFragment implements View.OnClickListener, TencentLoginInterface {

    private FragmentUserBinding mBinding;

    private int roomId;
    private TencentLoginHelper mHelper;

    public static UserFragment getInstance() {
        UserFragment fragment = new UserFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, null, false);
        mBinding.linUserHead.setOnClickListener(this);
        mBinding.rflMyCarLoan.setOnClickListener(this);
        mBinding.rflMyOrder.setOnClickListener(this);
        mBinding.rilCredit.setOnClickListener(this);
        mBinding.rilMessage.setOnClickListener(this);
        mBinding.rifCallPhone.setOnClickListener(this);
        mBinding.rifAboutUs.setOnClickListener(this);
        mBinding.llCoin.setOnClickListener(this);
        mBinding.llTicket.setOnClickListener(this);
        mBinding.rilZx.setOnClickListener(this);

        mBinding.rilInterview.setOnClickListener(view -> {
            showRoomDialog();
        });

        return mBinding.getRoot();
    }

    @Override
    protected void lazyLoad() {
        if (mBinding == null) return;
        setUsetPotoImg();
//        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    public void initData() {
        if (!SPUtilHelper.isLoginNoStart()) {
//            LoginActivity.open(mActivity,true);

            return;
        }

        Map<String, String> map = new HashMap();
        map.put("userId", SPUtilHelper.getUserId());
        showLoadingDialog();
        Call call = RetrofitUtils.createApi(MyApiServer.class).getUserDetails("805121", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<UserFragmentBean>(mActivity) {
            @Override
            protected void onSuccess(UserFragmentBean data, String SucMessage) {

//                mBinding.imgUserLogo
                ImgUtils.loadQiniuLogo(mActivity, data.getPhoto(), mBinding.imgUserLogo);
                mBinding.tvUserName.setText(data.getNickname());
                mBinding.tvUserPhone.setText(data.getMobile());

                SPUtilHelper.saveUserId(data.getUserId());
                SPUtilHelper.saveUserPhoneNum(data.getMobile());
                SPUtilHelper.saveisTradepwdFlag(data.isTradepwdFlag());
                SPUtilHelper.saveUserPhoto(data.getPhoto());
                SPUtilHelper.saveUserName(data.getNickname());
                SPUtilHelper.saveIdCarde(data.getIdNo() == null ? "" : data.getIdNo());
                SPUtilHelper.saveRealName(data.getRealName() == null ? "" : data.getRealName());

                getUserAccount();
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(mActivity, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }

    private void setUsetPotoImg() {

        showPotoDialog();
    }

    private void showPotoDialog() {


    }

    @Override
    protected void onInvisible() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_coin:
                //账户余额
                MyAccountActivity.open(mActivity);
                break;
            case R.id.ll_ticket:
                //账户积分
                AccountIntegraActivity.open(mActivity);
                break;
            case R.id.lin_user_head:
                //修改头像手机号等
                UserInfoUpdateActivity.open(getContext());
                break;
            case R.id.ril_message:
                //我的消息
                MyMessageActivity.open(mActivity);
                break;
            case R.id.rfl_my_car_loan:
                //我的车贷申请
                MyCarLoanActivity.open(mActivity);
                break;
            case R.id.rfl_my_order:
                //我的商品订单
                AllOrderTabActivity.open(mActivity);
                break;
            case R.id.ril_zx:
                //征信认证
                ZXListActivity.open(mActivity);
                break;
            case R.id.ril_credit:
                //信用报告
                MyCurrentActivity.open(mActivity);
                break;
            case R.id.rif_call_phone:
                //联系客服
                ConnectionServerActivity.open(mActivity);
                break;
            case R.id.rif_about_us:
                //关于我们
//                AboutUsActivity.open(mActivity);
                CdRouteHelper.openWebViewActivityForkey("关于我们", "about_us");//630047
                break;
        }
    }

    /**
     * 获取用户账户
     */
    public void getUserAccount() {

        if (!SPUtilHelper.isLoginNoStart()) {  //没有登录不用请求
            return;
        }

        Map<String, String> map = RetrofitUtils.getRequestMap();

        map.put("currency", "");
        map.put("userId", SPUtilHelper.getUserId());

        Call call = RetrofitUtils.createApi(MyApiServer.class).getAccount("802503", StringUtils.getJsonToString(map));

        addCall(call);

//        if (isShowDialog) showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<AccountListModel>(mActivity) {

            @Override
            protected void onSuccess(AccountListModel data, String SucMessage) {

                if (data == null)
                    return;

                for (AccountListModel.AccountListInsideModel model : data.getAccountList()) {
                    if (model.getCurrency().equals("JF")) {
                        mBinding.tvTicket.setText(MoneyUtils.showPrice(model.getAmount()));
                        mBinding.tvTicket.setTag(model.getAccountNumber());
                    } else if (model.getCurrency().equals("CNY")) {
                        mBinding.tvAmount.setText(MoneyUtils.showPrice(model.getAmount()));
                        mBinding.tvAmount.setTag(model.getAccountNumber());
                    } else {

                    }
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 设置显示用户面签房间号
     */
    private void showRoomDialog() {

        InputDialog inputDialog = new InputDialog(mActivity).builder().setTitle("面签")
                .setPositiveBtn("确定", new InputDialog.OnPositiveListener() {
                    @Override
                    public void onPositive(View view, String inputMsg) {
                        if (TextUtils.isEmpty(inputMsg)) {
                            ToastUtil.show(mActivity, "请输入面签房间号");
                            return;
                        }

                        try {
                            roomId = Integer.parseInt(inputMsg);
                        } catch (Exception e) {
                            ToastUtil.show(mActivity, "请输入正确的面签房间号");
                        }
                        checkRoomId(roomId + "");

                    }
                })
                .setNegativeBtn("取消", null)
                .setContentMsg("");
        inputDialog.getContentView().setHint("请输入面签房间号");
        inputDialog.getContentView().setInputType(InputType.TYPE_CLASS_PHONE);

        inputDialog.show();

    }

    @Override
    public void updateLoginState(boolean state) {

    }

    @Override
    public void onLoginSDKSuccess() {
        if (checkPermission()) {
            RoomActivity.open(mActivity, roomId);
        }
    }

    @Override
    public void onLoginSDKFailed(String module, int errCode, String errMsg) {
        ToastUtil.show(mActivity, "登录失败" + ":::" + errCode + "=" + errMsg);
    }

    protected boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> permissions = new ArrayList<>();
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.CAMERA)) {
                permissions.add(Manifest.permission.CAMERA);
            }
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.RECORD_AUDIO)) {
                permissions.add(Manifest.permission.RECORD_AUDIO);
            }
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.READ_PHONE_STATE)) {
                permissions.add(Manifest.permission.READ_PHONE_STATE);
            }
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (permissions.size() != 0) {
                ActivityCompat.requestPermissions(mActivity, (String[]) permissions.toArray(new String[0]), 100);
                return false;
            }
        }
        return true;
    }


    /**
     * 检查房间人数,超过三人  就不让再进入房间了
     *
     * @param roomid
     */
    public void checkRoomId(String roomid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("roomId", roomid);
        Call<BaseResponseModel<Integer>> roomId = RetrofitUtils.createApi(MyApiServer.class).checkRoomId("632953", StringUtils.getJsonToString(map));
        showLoadingDialog();
        roomId.enqueue(new BaseResponseModelCallBack<Integer>(mActivity) {
            @Override
            protected void onSuccess(Integer data, String SucMessage) {
                //房间人数大于三人就不让进入了
                if (data == 0) {
                    UITipDialog.showInfo(mActivity, "房间未创建请检查房间号");
                } else if (data >= 3) {
                    UITipDialog.showInfo(mActivity, "房间人数已满");
                } else {
                    mHelper = new TencentLoginHelper(mActivity, UserFragment.this);
                    mHelper.login();
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
