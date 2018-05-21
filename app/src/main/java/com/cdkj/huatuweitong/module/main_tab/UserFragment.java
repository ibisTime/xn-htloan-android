package com.cdkj.huatuweitong.module.main_tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.AccountListModel;
import com.cdkj.huatuweitong.bean.UserFragmentBean;
import com.cdkj.huatuweitong.databinding.FragmentUserBinding;
import com.cdkj.huatuweitong.module.order.AllOrderTabActivity;
import com.cdkj.huatuweitong.module.user.MyCarLoanActivity;
import com.cdkj.huatuweitong.module.user.MyCurrentActivity;
import com.cdkj.huatuweitong.module.user.MyMessageActivity;
import com.cdkj.huatuweitong.module.user.UserInfoUpdateActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * Created by cdkj on 2018/5/1.
 */

public class UserFragment extends BaseLazyFragment implements View.OnClickListener {

    private FragmentUserBinding mBinding;

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
        if (!SPUtilHelpr.isLoginNoStart()){
//            LoginActivity.open(mActivity,true);

            return;
        }

        Map<String, String> map = new HashMap();
        map.put("userId", SPUtilHelpr.getUserId());
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

                SPUtilHelpr.saveUserId(data.getUserId());
                SPUtilHelpr.saveUserPhoneNum(data.getMobile());
                SPUtilHelpr.saveisTradepwdFlag(data.isTradepwdFlag());
                SPUtilHelpr.saveUserPhoto(data.getPhoto());
                SPUtilHelpr.saveUserName(data.getNickname());

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
            case R.id.img_user_logo:

                UserInfoUpdateActivity.open(getContext());
                break;
            case R.id.lin_user_head:
                UserInfoUpdateActivity.open(getContext());
                break;
            case R.id.ril_message:
                MyMessageActivity.open(mActivity);
                break;
            case R.id.rfl_my_car_loan:
                MyCarLoanActivity.open(mActivity);
                break;
            case R.id.rfl_my_order:
                AllOrderTabActivity.open(mActivity);
                break;
            case R.id.ril_credit:
                MyCurrentActivity.open(mActivity);
                break;
        }
    }

    /**
     * 获取用户账户
     */
    public void getUserAccount() {

        if (!SPUtilHelpr.isLoginNoStart()) {  //没有登录不用请求
            return;
        }

        Map<String, String> map = RetrofitUtils.getRequestMap();

        map.put("currency", "");
        map.put("userId", SPUtilHelpr.getUserId());

        Call call = RetrofitUtils.createApi(MyApiServer.class).getAccount("802503", StringUtils.getJsonToString(map));

        addCall(call);

//        if (isShowDialog) showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<AccountListModel>(mActivity) {

            @Override
            protected void onSuccess(AccountListModel data, String SucMessage) {

                if (data == null )
                    return;

                for (AccountListModel.AccountListInsideModel model : data.getAccountList()){
                    if (model.getCurrency().equals("JF")){
                        mBinding.tvTicket.setText(MoneyUtils.showPrice(model.getAmount()));
                        mBinding.tvTicket.setTag(model.getAccountNumber());
                    }else if (model.getCurrency().equals("CNY")){
                        mBinding.tvAmount.setText(MoneyUtils.showPrice(model.getAmount()));
                        mBinding.tvAmount.setTag(model.getAccountNumber());
                    }else {

                    }

                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
