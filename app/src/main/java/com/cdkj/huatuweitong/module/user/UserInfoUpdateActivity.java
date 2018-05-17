package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cdkj.baselibrary.activitys.FindPwdActivity;
import com.cdkj.baselibrary.activitys.ImageSelectActivity;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.model.eventmodels.EventFinishAll;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.CameraHelper;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.baselibrary.utils.QiNiuHelper;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.NickNameUpdateModel;
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
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_update_user_info, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.UserInfoUpdateActivityTitle));

        mBinding.layoutLogo.setOnClickListener(v -> {
            //头像
            ImageSelectActivity.launch(this, PHOTOFLAG, false);
        });
        mBinding.rowNickName.setOnClickListener(v -> {
            //昵称
            NickNameUpdateActivity.open(this, "");
        });
        mBinding.rowPhone.setOnClickListener(v -> {
            //修改手机号
            UpDataPhoneActivity.open(UserInfoUpdateActivity.this);

        });
        mBinding.rowPsw.setOnClickListener(v -> {
            //修改密码
            FindPwdActivity.open(UserInfoUpdateActivity.this, SPUtilHelpr.getUserPhoneNum(), 1);
        });
        mBinding.rowPayPsw.setOnClickListener(v -> {
            //修改支付密码
            FindPwdActivity.open(UserInfoUpdateActivity.this, SPUtilHelpr.getUserPhoneNum(), 2);
        });
        mBinding.rowReceiveAddress.setOnClickListener(v -> {
            //地址
        });
        mBinding.rowSignout.setOnClickListener(v -> {
            //退出

            showDoubleWarnListen(getString(R.string.sure_logout), view -> {
                SPUtilHelpr.logOutClear();
                EventBus.getDefault().post(new EventFinishAll());
//                setShowState();
//                UITipDialog.showSuccess(mActivity, getString(R.string.logout_succ), dialogInterface -> {
//                    LoginActivity.open(mActivity,false);
//                });
            });
        });

    }

    @Subscribe
    public void nickUpdateSucc(NickNameUpdateModel nickNameUpdateModel) {
        if (nickNameUpdateModel == null) return;
        mBinding.rowNickName.setTvRight(nickNameUpdateModel.getName());
//        if (mUserInfo != null) {
//            mUserInfo.setNickname(nickNameUpdateModel.getName());
//        }
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
                    Log.i("pppppp", "onSuccess: 七牛返回地址:" + key);
                    updateUserPhoto(key);
                }

                @Override
                public void onFal(String info) {
                    Log.i("pppppp", "onSuccess: 七牛返回失败了:" + info);

                    disMissLoading();
                }
            }, path);

        }
    }


    private void updateUserPhoto(final String key) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", SPUtilHelpr.getUserId());
        map.put("photo", key);
        map.put("token", SPUtilHelpr.getUserToken());
        Call call = RetrofitUtils.getBaseAPiService().successRequest("805080", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(UserInfoUpdateActivity.this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                UITipDialog.showSuccess(UserInfoUpdateActivity.this, getString(R.string.update_logo_succ));
                ImgUtils.loadQiniuLogo(UserInfoUpdateActivity.this, key, mBinding.imgLogo);
//                ImgUtils.load
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