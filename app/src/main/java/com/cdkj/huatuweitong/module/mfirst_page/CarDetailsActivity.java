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
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarDetailsBean;
import com.cdkj.huatuweitong.common.GlideImageLoader;
import com.cdkj.huatuweitong.databinding.ActivityCarDetailsBinding;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 车辆详情
 */
public class CarDetailsActivity extends AbsBaseLoadActivity {
    private ActivityCarDetailsBinding mBinding;
    private String code;
    private ArrayList<String> mBanners = new ArrayList<>();
    private CarDetailsBean currentData;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, CarDetailsActivity.class);
            context.startActivity(intent);
        }
    }

    public static void open(Context context, String code) {
        if (context != null) {
            Intent intent = new Intent(context, CarDetailsActivity.class);
            //车的编号
            intent.putExtra("code", code);
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

        if (getIntent() != null) {
            code = getIntent().getStringExtra("code");
        }


        initDatas();
        initOnclick();

        initBrean();

        initwebView();
    }

    private void initDatas() {

        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarDetails("630427", StringUtils.getJsonToString(map));

        addCall(call);
        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<CarDetailsBean>(CarDetailsActivity.this) {


            @Override
            protected void onSuccess(CarDetailsBean data, String SucMessage) {
                currentData = data;
                mBinding.web.loadData("<style>\n" +           //设置图片自适应
                        "img{\n" +
                        " max-width:100%;\n" +
                        " height:auto;\n" +
                        "}\n" +
                        "</style>" + data.getDescription(), "text/html; charset=UTF-8", "utf-8");

                //这看效果图显示的好像是    品牌名字/名字/车系名字
                mBinding.tvCarName.setText(data.getBrandName()+data.getName()+data.getSeriesName());

                String price = com.cdkj.baselibrary.utils.MoneyUtils.getShowPriceSign(data.getSfAmount());
                String referencePrice = com.cdkj.baselibrary.utils.MoneyUtils.getShowPriceSign(data.getOriginalPrice());
                String directionPrice = com.cdkj.baselibrary.utils.MoneyUtils.getShowPriceSign(data.getSalePrice());

                mBinding.tvCarPrice.setText(price);
                mBinding.tvReferencePrice.setText("经销商参考价" + referencePrice);
                mBinding.tvDirectionPrice.setText("经厂商指导价" + directionPrice);
                String advPic = data.getAdvPic();

                String[] split = advPic.split("\\|\\|");
                for (int i = 0; i < split.length; i++) {
                    mBanners.add(split[i]);
                }
                initBrean();

            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarDetailsActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });
    }

    private void initwebView() {
        WebSettings webSettings = mBinding.web.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(false);
        //加载需要显示的网页

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

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
            //跳转车贷计算器
            CarLoanCalculatorActivity.open(CarDetailsActivity.this, currentData);
        });

    }


}
