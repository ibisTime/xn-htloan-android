package com.cdkj.huatuweitong.module.user;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.cdkj.baselibrary.activitys.BankCardListActivity;
import com.cdkj.baselibrary.activitys.FindPwdActivity;
import com.cdkj.baselibrary.activitys.ImageSelectActivity;
import com.cdkj.baselibrary.activitys.PayPwdModifyActivity;
import com.cdkj.baselibrary.activitys.address.AddressListActivity;
import com.cdkj.baselibrary.activitys.login.LoginActivity;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.model.eventmodels.EventFinishAll;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.*;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.NickNameUpdateModel;
import com.cdkj.huatuweitong.bean.UserFragmentBean;
import com.cdkj.huatuweitong.databinding.ActivityUpdateUserInfoBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class UserInfoUpdateActivity extends AbsBaseLoadActivity {

    ActivityUpdateUserInfoBinding mBinding;

    private int PHOTOFLAG = 111;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, UserInfoUpdateActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.activity_update_user_info, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.UserInfoUpdateActivityTitle));
        initOnclick();

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mBinding.rowNickName.setTvRight(SPUtilHelper.getUserName());
        mBinding.rowPhone.setTvRight(SPUtilHelper.getUserPhoneNum());

    }

    private void initOnclick() {
        Log.e("pppppp", "initOnclick: " + SPUtilHelper.getUserPhoto());
        ImgUtils.loadQiniuLogo(this, SPUtilHelper.getUserPhoto(), mBinding.imgLogo);

        mBinding.layoutLogo.setOnClickListener(v -> {
            //头像
            ImageSelectActivity.launch(this, PHOTOFLAG, false);
        });
        mBinding.rowNickName.setOnClickListener(v -> {
//            getUserInfo();
            showUnDoDialog(SPUtilHelper.getUserName());
        });
        mBinding.rowPhone.setOnClickListener(v -> {
            //修改手机号
            UpDataPhoneActivity.open(UserInfoUpdateActivity.this);
        });
        mBinding.rowPsw.setOnClickListener(v -> {
            //修改密码
            FindPwdActivity.open(UserInfoUpdateActivity.this, SPUtilHelper.getUserPhoneNum());
        });
        mBinding.rowPayPsw.setOnClickListener(v -> {
            //修改支付密码
            PayPwdModifyActivity
                    .open(this, SPUtilHelper.isTradepwdFlag(), SPUtilHelper.getUserPhoneNum());

        });
        mBinding.rowReceiveAddress.setOnClickListener(v -> {
            //地址
            AddressListActivity.open(this, false);
        });

        mBinding.rowReceiveBankCaard.setOnClickListener(v -> {
            BankCardListActivity.open(this, false);
        });

        mBinding.rowSignout.setOnClickListener(v -> {
            //退出

            showDoubleWarnListen(getString(R.string.sure_logout), view -> {
                SPUtilHelper.logOutClear();
                EventBus.getDefault().post(new EventFinishAll());
                LoginActivity.open(UserInfoUpdateActivity.this, true);
            });
        });

    }


    /**
     * 接收上个下个界面修改的名字  eventBus
     *
     * @param nickNameUpdateModel
     */
    @Subscribe
    public void nickUpdateSucc(NickNameUpdateModel nickNameUpdateModel) {
        if (nickNameUpdateModel == null) {
            return;
        }
        mBinding.rowNickName.setTvRight(nickNameUpdateModel.getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SPUtilHelper.isTradepwdFlag()) {
            mBinding.rowPayPsw.setTvLeft(getString(R.string.pay_psw));
        } else {
            mBinding.rowPayPsw.setTvLeft(getString(R.string.set_pay_pwd));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) {
            return;
        }
        if (requestCode == PHOTOFLAG) {
            String path = data.getStringExtra(CameraHelper.staticPath);

            LogUtil.E("拍照获取路径" + path);
            showLoadingDialog();
            new QiNiuHelper(this).uploadSinglePic(new QiNiuHelper.QiNiuCallBack() {
                @Override
                public void onSuccess(String key) {
//                    Log.i("pppppp", "onSuccess: 七牛返回地址:" + key);
                    updateUserPhoto(key);
                }

                @Override
                public void onFal(String info) {
//                    Log.i("pppppp", "onSuccess: 七牛返回失败了:" + info);
                    UITipDialog.showFall(UserInfoUpdateActivity.this, "头像修改失败");
                    disMissLoading();
                }
            }, path);

        }
    }


    private void updateUserPhoto(final String key) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", SPUtilHelper.getUserId());
        map.put("photo", key);
        map.put("token", SPUtilHelper.getUserToken());
        Call call = RetrofitUtils.getBaseAPiService()
                .successRequest("805080", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(UserInfoUpdateActivity.this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                UITipDialog.showSuccess(UserInfoUpdateActivity.this,
                        getString(R.string.update_logo_succ));
                ImgUtils.loadQiniuLogo(UserInfoUpdateActivity.this, key, mBinding.imgLogo);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(UserInfoUpdateActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    public void getUserInfo() {

        Map<String, String> map = new HashMap();
        map.put("userId", SPUtilHelper.getUserId());
        showLoadingDialog();
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getUserDetails("805121", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<UserFragmentBean>(this) {
            @Override
            protected void onSuccess(UserFragmentBean data, String SucMessage) {
                //昵称
                NickNameUpdateActivity.open(UserInfoUpdateActivity.this, data);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private void showUnDoDialog(String nick) {
        View view = LayoutInflater.from(this)
                .inflate(R.layout.dialog_nick, null);
        Dialog dialog = new Dialog(this, R.style.TipsDialog);
        dialog.setContentView(view);

        EditText etNick = view.findViewById(R.id.et_nick);
        etNick.setHint(nick);

        view.findViewById(R.id.tv_confirm).setOnClickListener(view1 -> {
            if (TextUtils.isEmpty(etNick.getText())){
                ToastUtil.show(UserInfoUpdateActivity.this, "请输入昵称");
                return;
            }

            updateNickNameRequest(etNick.getText().toString());
            dialog.dismiss();
        });

        view.findViewById(R.id.tv_cancel).setOnClickListener(view1 -> {
            dialog.dismiss();
        });

        dialog.getWindow()
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setGravity(Gravity.CENTER);

        dialog.show();
    }

    /**
     * 更新昵称
     *
     * @param string
     */
    private void updateNickNameRequest(String string) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("nickname", string);
        map.put("userId", SPUtilHelper.getUserId());
        Call call = RetrofitUtils.getBaseAPiService()
                .successRequest("805084", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {

                NickNameUpdateModel nickNameUpdateModel = new NickNameUpdateModel(); //通知上一页
                nickNameUpdateModel.setName(string);
                EventBus.getDefault().post(nickNameUpdateModel);

                UITipDialog.showSuccess(UserInfoUpdateActivity.this,
                        "信息保存成功", dialogInterface -> {
                            SPUtilHelper.saveUserName(string);
                            finish();
                        });
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(UserInfoUpdateActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
