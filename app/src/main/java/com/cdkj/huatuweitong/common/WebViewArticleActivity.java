package com.cdkj.huatuweitong.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cdkj.baselibrary.activitys.WebViewActivity;
import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.model.IntroductionInfoModel;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.DataDictionaryBean;
import com.cdkj.huatuweitong.bean.InformationListBean;
import com.cdkj.huatuweitong.bean.MsgListModel;
import com.cdkj.huatuweitong.databinding.ActivityWebviewArticleBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdkj.huatuweitong.share.ShareActivity;
import com.cdkj.huatuweitong.utlis.WxUtil;
import retrofit2.Call;


/**
 * 介绍类webview
 */
public class WebViewArticleActivity extends AbsActivity {

    private SslErrorHandler mHandler;

    private ActivityWebviewArticleBinding mBinding;

    private List<DataDictionaryBean> list = new ArrayList<>();

    /**
     * 加载activity
     *
     * @param context 上下文
     */
    public static void open(Context context, String code) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, WebViewArticleActivity.class);
        intent.putExtra("code", code);
        context.startActivity(intent);

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.activity_webview_article, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        setSubLeftImgState(true);
        setTopLineState(true);

        setTopTitle("文章");
        setSubRightImgAndClick(R.mipmap.active_share, view -> {
            ShareActivity.open(WebViewArticleActivity.this,
                    "http://h5.htwt.hichengdai.com/articleDetail?code=" + getIntent()
                            .getStringExtra("code"), "分享", "欢迎使用会玩车");
        });

        initLayout();

        initData();
    }

    private void initLayout() {
        //输入法
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mBinding.webview.getSettings().setJavaScriptEnabled(true);//js
        mBinding.webview.getSettings().setDefaultTextEncodingName("UTF-8");
//       mBinding.webview.getSettings().setSupportZoom(true);   //// 支持缩放
//       mBinding.webview.getSettings().setBuiltInZoomControls(true);//// 支持缩放
//       mBinding.webview.getSettings().setDomStorageEnabled(true);//开启DOM
//       mBinding.webview.getSettings().setLoadWithOverviewMode(false);//// 缩放至屏幕的大小
//       mBinding.webview.getSettings().setUseWideViewPort(true);//将图片调整到适合mBinding.webview的大小
//       webView.getSettings().setLoadsImagesAutomatically(true);//支持自动加载图片
        mBinding.webview.setWebChromeClient(new MyWebViewClient1());

        mBinding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        mBinding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                handler.proceed();  // 接受所有网站的证书

                // 处理Google play因WebView SSL Error Handler alerts被拒的问题
                mHandler = handler;
                AlertDialog.Builder builder = new AlertDialog.Builder(WebViewArticleActivity.this);
                builder.setMessage("ssl证书验证失败");
                builder.setPositiveButton("继续", (dialog, which) -> mHandler.proceed());
                builder.setNegativeButton(com.cdkj.baselibrary.R.string.cancel,
                        (dialog, which) -> mHandler.cancel());
                builder.setOnKeyListener((dialog, keyCode, event) -> {
                    if (event.getAction() == KeyEvent.ACTION_UP
                            && keyCode == KeyEvent.KEYCODE_BACK) {
                        mHandler.cancel();
                        dialog.dismiss();
                        return true;
                    }
                    return false;
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }


    private void initData() {
        if (getIntent() == null) {
            return;
        }

        getCarNumber();

    }

    /**
     * 获取规格的值
     */
    private void getCarNumber() {
        Map<String, String> map = new HashMap<>();
        map.put("parentKey", "car_news_tag");

        showLoadingDialog();
        Call<BaseResponseListModel<DataDictionaryBean>> dataDictionary = RetrofitUtils
                .createApi(MyApiServer.class)
                .getDataDictionary("630036", StringUtils.getJsonToString(map));
        addCall(dataDictionary);
        dataDictionary.enqueue(new BaseResponseListCallBack<DataDictionaryBean>(this) {
            @Override
            protected void onSuccess(List<DataDictionaryBean> data, String SucMessage) {

                if (data != null) {
                    list.addAll(data);
                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();
                getDetail(getIntent().getStringExtra("code"));
            }
        });

    }

    public void getDetail(String code) {

        Map<String, String> map = new HashMap<>();
        map.put("code", code + "");
        map.put("userId", SPUtilHelper.getUserId());
        map.put("token", SPUtilHelper.getUserToken());

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getInformation("630456", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<InformationListBean.ListBean>(this) {
            @Override
            protected void onSuccess(InformationListBean.ListBean bean, String SucMessage) {

                for (DataDictionaryBean dictionaryBean : list) {

                    if (dictionaryBean.getDkey().equals(bean.getTag())) {
                        mBinding.tvYuanchuang.setText(dictionaryBean.getDvalue());
                    }

                }

                mBinding.tvArticleTitle.setText(bean.getTitle());
                mBinding.tvAuthor.setText(bean.getAuthor());
                String date = DateUtil
                        .formatStringData(bean.getUpdateDatetime(), DateUtil.DATE_YMD);
                mBinding.tvDate.setText(date);

                showContent(bean.getContext());
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }

    private void showContent(String content) {
        mBinding.webview.loadData(content, "text/html;charset=UTF-8", "UTF-8");
    }


    private class MyWebViewClient1 extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mBinding.pb.setProgress(newProgress);

            if (newProgress > 90) {
                mBinding.pb.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }


    @Override
    public void onBackPressed() {
        goBack();
    }

    private void goBack() {
        if (mBinding.webview != null && mBinding.webview.canGoBack()) {
            mBinding.webview.goBack();
        } else {
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        if (mBinding.webview != null) {
            mBinding.webview.clearHistory();
            ((ViewGroup) mBinding.webview.getParent()).removeView(mBinding.webview);
            mBinding.webview.loadUrl("about:blank");
            mBinding.webview.stopLoading();
            mBinding.webview.setWebChromeClient(null);
            mBinding.webview.setWebViewClient(null);
            mBinding.webview.destroy();
        }
        super.onDestroy();
    }
}
