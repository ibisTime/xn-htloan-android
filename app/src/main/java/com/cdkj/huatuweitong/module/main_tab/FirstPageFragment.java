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
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.baselibrary.views.ScrollGridLayoutManager;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.RecommendCarAdapter;
import com.cdkj.huatuweitong.adapters.RecommendProductAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.FirstPageCarRecommendBean;
import com.cdkj.huatuweitong.common.GlideImageLoader;
import com.cdkj.huatuweitong.databinding.FragmentFirstpageBinding;
import com.cdkj.huatuweitong.module.mfirst_page.CarLoanCalculatorActivity;
import com.cdkj.huatuweitong.module.mfirst_page.CarDetailsActivity;
import com.cdkj.huatuweitong.module.mfirst_page.ExhibitionCenterActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 首页
 * Created by cdkj on 2018/5/1.
 */

public class FirstPageFragment extends BaseLazyFragment {
    List<FirstPageCarRecommendBean> carData=new ArrayList<>();
    private FragmentFirstpageBinding mBinding;

    private List<String> mBanners;
    private RecommendCarAdapter recommendCarAdapter;

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
        initCarRecommendBeanData();
        initBanner();

        setBannerData();

        initRecommendCarAdatper();
        initRecommendProductAdatper();

        initOnclickList();

        return mBinding.getRoot();
    }

    /**
     * 获取推荐车型数据
     */
    private void initCarRecommendBeanData() {
        Map<String, String> map = new HashMap<>();
        map.put("location", "1");
        Call call = RetrofitUtils.createApi(MyApiServer.class).getFirstPageCarRecommendCar("630416", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseListCallBack<FirstPageCarRecommendBean>(getContext()) {

            @Override
            protected void onSuccess(List<FirstPageCarRecommendBean> data, String SucMessage) {
                carData.clear();
                carData.addAll(data);
                recommendCarAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(getContext(),errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }


    private void initOnclickList() {

        mBinding.tvCalculator.setOnClickListener(v->{
            CarLoanCalculatorActivity.open(getContext(),0);

        });
    }

    /**
     * 初始化推荐产品
     */
    private void initRecommendProductAdatper() {

        RecommendProductAdapter recommendProductAdapter = new RecommendProductAdapter(mBanners, this);

        mBinding.recyclerViewRecommendProduct.setLayoutManager(new ScrollGridLayoutManager(mActivity, 2));

        mBinding.recyclerViewRecommendProduct.setAdapter(recommendProductAdapter);

        recommendProductAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CarDetailsActivity.open(getContext());
            }
        });

    }

    /**
     * 初始化推荐车型
     */
    private void initRecommendCarAdatper() {

        recommendCarAdapter = new RecommendCarAdapter(carData, this);

        mBinding.recyclerViewRecommendCar.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayout.HORIZONTAL, false));

        mBinding.recyclerViewRecommendCar.setAdapter(recommendCarAdapter);

        recommendCarAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ExhibitionCenterActivity.open(getContext(),carData.get(position).getBrandCode());
            }
        });


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
