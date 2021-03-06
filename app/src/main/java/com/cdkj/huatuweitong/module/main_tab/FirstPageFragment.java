package com.cdkj.huatuweitong.module.main_tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.interfaces.BaseRefreshCallBack;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.RecommendCarAdapter;
import com.cdkj.huatuweitong.adapters.RecommendProductAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.FirstPageBanner;
import com.cdkj.huatuweitong.bean.FirstPageCarRecommendBean;
import com.cdkj.huatuweitong.bean.RecommendProductBean;
import com.cdkj.huatuweitong.common.GlideFirstPageBannerImageLoader;
import com.cdkj.huatuweitong.databinding.FragmentFirstpageBinding;
import com.cdkj.huatuweitong.module.mfirst_page.CarLoanCalculatorActivity;
import com.cdkj.huatuweitong.module.mfirst_page.ExhibitionCenterActivity;
import com.cdkj.huatuweitong.module.mfirst_page.RecommendProductListActivity;
import com.cdkj.huatuweitong.module.product.ProductDetailsActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

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
    List<FirstPageCarRecommendBean> carData = new ArrayList<>();
    private FragmentFirstpageBinding mBinding;

    private List<FirstPageBanner> mBanners;
    private RecommendCarAdapter recommendCarAdapter;

    private RefreshHelper mRefreshHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_firstpage, null, false);

        mBanners = new ArrayList<>();
        initCarRecommendBeanData();
        initBanner();
        initRecommendCarAdatper();
        initRefreshHelper();
        initOnclickList();
        getBannerDataRequest();
        mRefreshHelper.onDefaluteMRefresh(true);

        return mBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        if (mBinding != null) {
            mBinding.firstBanner.stopAutoPlay();
        }
        super.onDestroy();
    }

    public static FirstPageFragment getInstance() {
        FirstPageFragment fragment = new FirstPageFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     *
     */
    private void initRefreshHelper() {

        mRefreshHelper = new RefreshHelper(mActivity, new BaseRefreshCallBack(mActivity) {
            @Override
            public View getRefreshLayout() {
                return mBinding.refreshLayout;
            }

            @Override
            public void onRefresh(int pageindex, int limit) {
                super.onRefresh(pageindex, limit);
                initCarRecommendBeanData();
                getBannerDataRequest();
            }

            @Override
            public RecyclerView getRecyclerView() {
                return mBinding.recyclerViewRecommendProduct;
            }

            @Override
            public RecyclerView.Adapter getAdapter(List listData) {
                return getRecommendProductAdatper(listData);
            }

            @Override
            public void getListDataRequest(int pageindex, int limit, boolean isShowDialog) {
                getRecommentdProduct(pageindex, limit, isShowDialog);
            }

        });

        mRefreshHelper.init(10);

    }

    /**
     * 获取分期产品
     */
    private void getRecommentdProduct(int pageindex, int limit, boolean isShowDialog) {

        Map<String, String> map = new HashMap<>();
        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("status", "3");
        map.put("location", "0");

        Call<BaseResponseModel<ResponseInListModel<RecommendProductBean>>> call = RetrofitUtils.createApi(MyApiServer.class).getRecommentdProductList("808025", StringUtils.getJsonToString(map));

        addCall(call);

        if (isShowDialog) {
            showLoadingDialog();
        }

        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<RecommendProductBean>>(mActivity) {
            @Override
            protected void onSuccess(ResponseInListModel<RecommendProductBean> data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), getString(R.string.no_recommend_product), 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


    /**
     * 获取banner
     */
    public void getBannerDataRequest() {

        Map<String, String> map = RetrofitUtils.getRequestMap();
        map.put("location", "index_banner");
        map.put("type", "2");
        map.put("orderColumn", "order_no");
        map.put("orderDir", "asc");

        Call call = RetrofitUtils.createApi(MyApiServer.class).getFirstBanner("805806", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseListCallBack<FirstPageBanner>(mActivity) {

            @Override
            protected void onSuccess(List<FirstPageBanner> data, String SucMessage) {
                mBanners.clear();
                mBanners.addAll(data);
                setBannerData();
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
            }

            @Override
            protected void onFinish() {
            }
        });
    }

    /**
     * 获取推荐车型数据
     */
    private void initCarRecommendBeanData() {
        Map<String, String> map = new HashMap<>();
        map.put("location", "0");//0是首页推荐  1是普通
        map.put("status", "1");
        Call call = RetrofitUtils.createApi(MyApiServer.class).getFirstPageCarRecommendCar("630416", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseListCallBack<FirstPageCarRecommendBean>(getContext()) {

            @Override
            protected void onSuccess(List<FirstPageCarRecommendBean> data, String SucMessage) {
                // recommendCarAdapter = new RecommendCarAdapter(data, this);
                carData.clear();
                carData.addAll(data);
                recommendCarAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(getContext(), errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }


    private void initOnclickList() {
        //跳转车贷计算器
        mBinding.tvCalculator.setOnClickListener(v -> {
            CarLoanCalculatorActivity.open(getContext(), 0);
        });

        mBinding.llRecommendProduct.setOnClickListener(v -> {
            RecommendProductListActivity.open(mActivity);
        });
    }

    /**
     * 初始化推荐产品
     * 下面的
     */
    private RecommendProductAdapter getRecommendProductAdatper(List data) {

        RecommendProductAdapter recommendProductAdapter = new RecommendProductAdapter(data, this);

        mBinding.recyclerViewRecommendProduct.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        mBinding.recyclerViewRecommendProduct.setNestedScrollingEnabled(false);

        mBinding.recyclerViewRecommendProduct.addItemDecoration(new DividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL));

        mBinding.recyclerViewRecommendProduct.setAdapter(recommendProductAdapter);

        recommendProductAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                RecommendProductBean recommendProductBean = recommendProductAdapter.getItem(position);
                if (recommendProductBean == null) return;
                ProductDetailsActivity.open(mActivity, recommendProductBean.getCode());
            }
        });

        return recommendProductAdapter;
    }

    /**
     * 初始化推荐车型  上面的
     */
    private void initRecommendCarAdatper() {

        recommendCarAdapter = new RecommendCarAdapter(carData, this);

        mBinding.recyclerViewRecommendCar.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayout.HORIZONTAL, false));

        mBinding.recyclerViewRecommendCar.setAdapter(recommendCarAdapter);

        recommendCarAdapter.setOnItemClickListener((adapter, view, position) -> {
            ExhibitionCenterActivity.open(getContext(), carData.get(position).getCode());
        });
    }


    private void initBanner() {
        mBinding.firstBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBinding.firstBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.firstBanner.setImageLoader(new GlideFirstPageBannerImageLoader());

        mBinding.firstBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                FirstPageBanner firstPageBanner = mBanners.get(position);
                if (firstPageBanner == null || TextUtils.isEmpty(firstPageBanner.getUrl())) {
                    return;
                }
                if (firstPageBanner.getUrl() != null) {
                    if (firstPageBanner.getUrl().indexOf("http") != -1) {
                        CdRouteHelper.openWebViewActivityForUrl(firstPageBanner.getName(), firstPageBanner.getUrl());
                    }
                }
            }
        });
    }


    /**
     * 设置广告数据
     */
    private void setBannerData() {
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

}
