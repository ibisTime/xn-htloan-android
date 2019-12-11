package com.cdkj.huatuweitong;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;
import com.cdkj.baselibrary.activitys.WebViewActivity;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.base.BaseActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.IntroductionInfoModel;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.FirstPageBanner;
import com.cdkj.huatuweitong.common.GlideFirstPageBannerImageLoader;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Call;

/**
 * 启动页
 * Created by cdkj on 2017/6/8.
 */

public class WelcomeActivity extends BaseActivity {

    private Banner banner;
    private TextView tvJump;
    private Disposable subscribe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 用于第一次安装APP，进入到除这个启动activity的其他activity，点击home键，再点击桌面启动图标时，
        // 系统会重启此activty，而不是直接打开之前已经BrandVerAdapter打开过的activity，因此需要关闭此activity

        try {
            if (getIntent() != null
                    && (getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
                finish();
                return;
            }

            setContentView(R.layout.activity_welcom);
            ImageView img = (ImageView) findViewById(R.id.img_start);
            img.setBackgroundResource(R.drawable.loading);

//            mSubscription.add(Observable.timer(2, TimeUnit.SECONDS)
//                    .subscribeOn(AndroidSchedulers.mainThread())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Consumer<Long>() {
//
//                        @Override
//                        public void accept(Long aLong) throws Exception {
//                            System.out.println("LogUtil.isDeBug=" + LogUtil.isDeBug);
//                            LogUtil.E("accept ");
//                            MainActivity.open(WelcomeActivity.this);
//                            finish();
//                        }
//                    }, new Consumer<Throwable>() {
//                        @Override
//                        public void accept(Throwable throwable) throws Exception {
//                            LogUtil.E("welcome error");
//                        }
//                    }));

        } catch (Exception e) {
            e.printStackTrace();
        }

        init();
        getKeyUrl();
    }


    private void init() {
        banner = (Banner) findViewById(R.id.banner);
        tvJump = (TextView) findViewById(R.id.tv_jump);
        tvJump.setOnClickListener(v -> {
            if (subscribe != null) {
                subscribe.dispose();
            }
            MainActivity.open(WelcomeActivity.this);
            finish();
        });
    }

    public void getKeyUrl() {

        Map<String, String> map = new HashMap<>();
        map.put("key", "app_start_pic");
        map.put("systemCode", MyCdConfig.SYSTEM_CODE);
        map.put("companyCode", MyCdConfig.COMPANY_CODE);

        Call call = RetrofitUtils.getBaseAPiService()
                .getKeySystemInfo("630047", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<IntroductionInfoModel>(this) {
            @Override
            protected void onSuccess(IntroductionInfoModel data, String SucMessage) {

                List<FirstPageBanner> list = new ArrayList<>();
                for (String s : data.getCvalue().split("\\|\\|")) {
                    FirstPageBanner banner = new FirstPageBanner();
                    banner.setPic(s);
                    list.add(banner);
                }

                startPageImg(list);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                startPageImg(null);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    public void startPageImg(List<FirstPageBanner> data) {
        if (data == null || data.isEmpty()) {
            MainActivity.open(WelcomeActivity.this);
            finish();
            return;
        }
        banner.setVisibility(View.VISIBLE);
        tvJump.setVisibility(View.VISIBLE);
        banner.setImageLoader(new GlideFirstPageBannerImageLoader());
        //设置图片集合
        banner.setImages(data);
//        Banner.CIRCLE_INDICATOR
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.isAutoPlay(false);//关闭自动轮播  默认是开启的
        //banner设置方法全部调用完毕时最后调用
        banner.start();
//        banner.startAutoPlay();
        startDown(10);
    }

    /**
     * 启动倒计时跳转
     */
    private void startDown(int count) {
        // 创建一个按照给定的时间间隔发射从0开始的整数序列
//只发射开始的N项数据或者一定时间内的数据
        subscribe = Observable.interval(0, 1, TimeUnit.SECONDS,
                AndroidSchedulers.mainThread())    // 创建一个按照给定的时间间隔发射从0开始的整数序列
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .take(count)//只发射开始的N项数据或者一定时间内的数据
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {

                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        tvJump.setText((count - aLong) + "秒 跳过");
                        if (aLong >= 9) {
                            MainActivity.open(WelcomeActivity.this);
                            finish();
                        }
                    }
                });
    }
}
