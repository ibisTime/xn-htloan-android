package com.cdkj.baselibrary.activitys.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cdkj.baselibrary.R;
import com.cdkj.baselibrary.activitys.FindPwdActivity;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.databinding.ActivityLoginBinding;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.interfaces.LoginInterface;
import com.cdkj.baselibrary.interfaces.LoginPresenter;
import com.cdkj.baselibrary.model.UserLoginModel;

import static com.cdkj.baselibrary.appmanager.CdRouteHelper.DATASIGN;

/**
 * 登录
 * Created by cdkj on 2017/8/8.
 */
@Route(path = CdRouteHelper.APPLOGIN)
public class LoginActivity extends AbsBaseLoadActivity implements LoginInterface {

    private LoginPresenter mPresenter;
    private ActivityLoginBinding mBinding;
    private boolean canOpenMain;

    /**
     * 打开当前页面
     *
     * @param context
     */
    public static void open(Context context, boolean canOpenMain) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(DATASIGN, canOpenMain);
        context.startActivity(intent);
    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_login, null, false);
        return mBinding.getRoot();
    }

    @Override
    protected boolean canLoadTopTitleView() {
        return false;
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {


        mPresenter = new LoginPresenter(this);

        if (getIntent() != null) {
            canOpenMain = getIntent().getBooleanExtra(DATASIGN, false);
        }

        //登录
        mBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(mBinding.editUsername.getText().toString(), mBinding.editUserpass.getText().toString(), LoginActivity.this);
            }
        });
        mBinding.tvStartRegistr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterActivity.open(LoginActivity.this);
            }
        });

        mBinding.tvFindPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FindPwdActivity.open(LoginActivity.this, "");
            }
        });

    }

    @Override
    public void LoginSuccess(UserLoginModel user, String msg) {
        SPUtilHelpr.saveUserId(user.getUserId());
        SPUtilHelpr.saveUserToken(user.getToken());
        SPUtilHelpr.saveUserPhoneNum(mBinding.editUsername.getText().toString());
        startNext();
    }

    @Override
    public void LoginFailed(String code, String msg) {
        disMissLoading();
        UITipDialog.showFall(LoginActivity.this, msg);
    }

    @Override
    public void StartLogin() {
        showLoadingDialog();
    }

    @Override
    public void EndLogin() {
        disMissLoading();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.clear();
            mPresenter = null;
        }
    }

    @Override
    protected boolean canFinish() {
        if (canOpenMain) {
            finish();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (canOpenMain) {
            finish();
        } else {
            super.onBackPressed();
        }
    }


    /**
     * 启动聊天
     */
    private void startNext() {
        if (canOpenMain) {
        } else {
        }
        finish();
    }

}
