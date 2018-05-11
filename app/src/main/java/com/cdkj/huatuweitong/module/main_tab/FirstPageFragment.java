package com.cdkj.huatuweitong.module.main_tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.views.ScrollGridLayoutManager;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.RecommendCarAdapter;
import com.cdkj.huatuweitong.adapters.RecommendProductAdapter;
import com.cdkj.huatuweitong.common.GlideImageLoader;
import com.cdkj.huatuweitong.databinding.FragmentFirstpageBinding;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * Created by cdkj on 2018/5/1.
 */

public class FirstPageFragment extends BaseLazyFragment {

    private FragmentFirstpageBinding mBinding;

    private List<String> mBanners;

    public static FirstPageFragment getInstance() {
        FirstPageFragment fragment = new FirstPageFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_firstpage, null, false);

        mBanners = new ArrayList<>();

        initBanner();

        setBannerData();

        initRecommendCarAdatper();
        initRecommendProductAdatper();

        return mBinding.getRoot();
    }

    /**
     * 初始化推荐产品
     */
    private void initRecommendProductAdatper() {

        RecommendProductAdapter recommendProductAdapter = new RecommendProductAdapter(mBanners, this);

        mBinding.recyclerViewRecommendProduct.setLayoutManager(new ScrollGridLayoutManager(mActivity, 2));

        mBinding.recyclerViewRecommendProduct.setAdapter(recommendProductAdapter);

    }

    /**
     * 初始化推荐车型
     */
    private void initRecommendCarAdatper() {

        RecommendCarAdapter recommendCarAdapter = new RecommendCarAdapter(mBanners, this);

        mBinding.recyclerViewRecommendCar.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayout.HORIZONTAL, false));

        mBinding.recyclerViewRecommendCar.setAdapter(recommendCarAdapter);


    }


    private void initBanner() {

        mBinding.firstBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBinding.firstBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.firstBanner.setImageLoader(new GlideImageLoader());

    }


    /**
     * 设置广告数据
     */
    private void setBannerData() {

        mBanners.add("");
        mBanners.add("");
        mBanners.add("");
        mBanners.add("");
        mBanners.add("");
        mBanners.add("");
        mBanners.add("");

        mBinding.firstBanner.setImages(mBanners);
        mBinding.firstBanner.start();
        mBinding.firstBanner.startAutoPlay();
    }


    @Override
    protected void lazyLoad() {
        if (mBinding != null) {
            mBinding.firstBanner.startAutoPlay();
        }
    }

    @Override
    protected void onInvisible() {
        if (mBinding != null) {
            mBinding.firstBanner.stopAutoPlay();
        }
    }

    @Override
    public void onDestroy() {
        if (mBinding != null) {
            mBinding.firstBanner.stopAutoPlay();
        }
        super.onDestroy();
    }
}
