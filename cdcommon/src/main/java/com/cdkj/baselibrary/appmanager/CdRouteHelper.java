package com.cdkj.baselibrary.appmanager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cdkj.baselibrary.model.BankCardModel;

import static com.cdkj.baselibrary.activitys.PayPwdModifyActivity.ISSETPWD;
import static com.cdkj.baselibrary.activitys.PayPwdModifyActivity.MOBILE;
import static com.cdkj.baselibrary.activitys.WebViewActivity.WEBVIEWCODE;
import static com.cdkj.baselibrary.activitys.WebViewActivity.WEBVIEWISZOOM;
import static com.cdkj.baselibrary.activitys.WebViewActivity.WEBVIEWTITLE;
import static com.cdkj.baselibrary.activitys.WebViewActivity.WEBVIEWURL;

/**
 * 路由管理
 * Created by cdkj on 2017/10/12.
 */

public class CdRouteHelper {
    //跳转到登录页面
    public static final String APPLOGIN = "/user/login";
    //找回登录密码
    public static final String FINDPWD = "/user/findpwd";
    //修改电话号码
    public static final String PAYPWDMODIFY = "/user/PayPwdModify";
    public static final String UPDATEBANKCARD = "/user/UPDATEBANKCARD";
    public static final String UPDATEPHONE = "/user/UPDATEPHONE";
    public static final String WEBVIEWACTIVITY = "/user/webView";

    //获取数据标志
    public static final String DATASIGN = "dataSign";


    /**
     * 打开登录界面
     *
     * @param canopenmain 打开后是否跳转到主页
     */
    public static void openLogin(boolean canopenmain) {
        ARouter.getInstance().build(APPLOGIN)
                .withBoolean(DATASIGN, canopenmain)
                .greenChannel()                                       //不使用任何拦截器
                .navigation();
    }

    /**
     * 打开找回登录密码界面
     *
     * @param phoneNum 用户手机号码
     */
    public static void openFindPwdActivity(String phoneNum) {
        ARouter.getInstance().build(FINDPWD)
                .withString(DATASIGN, phoneNum)
                .navigation();
    }

    /**
     * 修改用户手机号
     */
    public static void openUpdatePhoneActivity() {
        ARouter.getInstance().build(UPDATEPHONE)
                .navigation();
    }

    /**
     * 删除、修改银行卡
     *
     * @param data
     */
    public static void openUpdateBankCardActivity(BankCardModel data) {
        ARouter.getInstance().build(UPDATEBANKCARD)
                .withParcelable(DATASIGN, data)
                .navigation();
    }

    /**
     * 打开 修改支付密码
     *
     * @param isSetPwd //是否设置过支付密码
     * @param mobile
     */
    public static void openPayPwdModifyActivity(boolean isSetPwd, String mobile) {
        ARouter.getInstance().build(PAYPWDMODIFY)
                .withString(MOBILE, mobile)
                .withBoolean(ISSETPWD, isSetPwd)
                .navigation();
    }

    /**
     * 用 数据字典方式打开webViewWctivity
     *
     * @param title
     * @param code
     */
    public static void openWebViewActivityForkey(String title, String code) {
        ARouter.getInstance().build(WEBVIEWACTIVITY)
                .withString(WEBVIEWTITLE, title)
                .withString(WEBVIEWCODE, code)
                .withBoolean(WEBVIEWISZOOM, false)
                .greenChannel()
                .navigation();
    }

    /**
     * 用 URL 方式打开webViewWctivity
     *
     * @param title
     * @param url
     */
    public static void openWebViewActivityForUrl(String title, String url) {
        ARouter.getInstance().build(APPLOGIN)
                .withString(WEBVIEWACTIVITY, title)
                .withString(WEBVIEWURL, url)
                .withBoolean(WEBVIEWISZOOM, true)
                .greenChannel()
                .navigation();
    }


}
