package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.common.GlideImageLoader;
import com.cdkj.huatuweitong.databinding.ActivityCarDetailsBinding;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

/**
 * 车辆详情
 */
public class CarDetailsActivity extends AbsBaseLoadActivity {
    private ActivityCarDetailsBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, CarDetailsActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {

        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_car_details, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.CarDetails));
        initOnclick();

        initBrean();

        initwebView();
    }

    private void initwebView() {
        WebSettings webSettings = mBinding.web.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        mBinding.web.loadUrl("http://www.baidu.com");
        //设置Web视图
        mBinding.web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
                return false;
            }
        });
    }

    private void initBrean() {
        ArrayList<String> mBanners = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mBanners.add("标题" + i);
        }

        mBinding.firstBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBinding.firstBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.firstBanner.setImageLoader(new GlideImageLoader());

        mBinding.firstBanner.setImages(mBanners);
        mBinding.firstBanner.start();
        //初始化轮播图上面的页码
        mBinding.tvIndicator.setText("1/" + mBanners.size());


        mBinding.firstBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBinding.tvIndicator.setText((position + 1) + "/" + mBanners.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initOnclick() {
        mBinding.tvPayCar.setOnClickListener(v -> {
            //申请购买 跳转到提交界面
            OrderSubmitActivity.open(CarDetailsActivity.this);
        });

    }


}
