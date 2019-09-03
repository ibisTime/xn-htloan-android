package com.cdkj.huatuweitong.module.main_tab;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.interfaces.BaseRefreshCallBack;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.*;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.*;
import com.cdkj.huatuweitong.common.GlideFirstPageBannerImageLoader;
import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import com.cdkj.huatuweitong.databinding.FragmentHomeBinding;
import com.cdkj.huatuweitong.module.vehicle_db.*;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.greenrobot.eventbus.EventBus;
import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseLazyFragment {

    private FragmentHomeBinding mBinding;
    private ArrayList<FirstPageBanner> mBanners;
    private RefreshHelper mRefreshHelper;
    private HomeSelectedAdapter homeSelectedAdapter;

    public static HomeFragment getInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void lazyLoad() {
        if (mBinding != null) {
            mBinding.homeBanner.startAutoPlay();
        }
    }

    @Override
    protected void onInvisible() {
        if (mBinding != null) {
            mBinding.homeBanner.stopAutoPlay();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false);

        initBanner();
        initBannerData();
        initBrandData();
        initCarSystemData();
        getMerchantData();
        getSelectedData();
        initRefreshHelper();
        mRefreshHelper.onDefaluteMRefresh(true);
        initOnclickListener();
        return mBinding.getRoot();
    }

    private void initBannerData() {
        Map<String, String> map = RetrofitUtils.getRequestMap();
        map.put("location", "index_banner");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getFirstBanner("805806", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseListCallBack<FirstPageBanner>(mActivity) {

            @Override
            protected void onSuccess(List<FirstPageBanner> data, String SucMessage) {
                mBanners.clear();
                mBanners.addAll(data);

                mBinding.homeBanner.setImages(mBanners);
                mBinding.homeBanner.start();
                mBinding.homeBanner.startAutoPlay();
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
     * 获取热门品牌数据  跳转到车系界面
     */
    private void initBrandData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("location", "0");//1 热门 0普通
        map.put("start", "1");
        map.put("limit", "100");
        map.put("orderDir", "asc");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getBrandPage("630490", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<BrandPageBean>(mActivity) {

            @Override
            protected void onSuccess(BrandPageBean data, String SucMessage) {

                HomeFragmentBrandAdapter homeFragmentBrandAdapter = new HomeFragmentBrandAdapter(
                        data.getList());
                mBinding.rvBrand.setLayoutManager(new GridLayoutManager(mActivity, 4));
                mBinding.rvBrand.setAdapter(homeFragmentBrandAdapter);
                homeFragmentBrandAdapter.setOnItemClickListener((adapter, view, position) -> {
                    BrandPageBean.ListBean item = (BrandPageBean.ListBean) adapter
                            .getItem(position);
                    CarSystemListActivity.open(mActivity, item.getCode());
                });

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    /**
     * 获取热门车系  跳转到性情界面
     */
    private void initCarSystemData() {
        showLoadingDialog();
        Map<String, Serializable> map = new HashMap<>();
        map.put("status", "1");
        map.put("location", "0");//热门推荐
        map.put("start", "1");
        map.put("limit", "200");
        map.put("orderDir", "asc");
        map.put("orderColumn", "order_no");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarSystemPage("630491", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<CarSystemPageBean>(mActivity) {
            @Override
            protected void onSuccess(CarSystemPageBean data, String SucMessage) {

                HomeFragmentCarSystemAdapter homeFragmentCarSystemAdapter = new HomeFragmentCarSystemAdapter(
                        data.getList());
                mBinding.rvCarSystem.setLayoutManager(new GridLayoutManager(mActivity, 3) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
                mBinding.rvCarSystem.setAdapter(homeFragmentCarSystemAdapter);
                homeFragmentCarSystemAdapter.setOnItemClickListener((adapter, view, position) -> {
                    CarSystemBean item = (CarSystemBean) adapter.getItem(position);
                    CarListActivity.open(mActivity, item);
                });
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 获取优质车商
     */
    private void getMerchantData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("isHighQuality", "1");
        map.put("start", "1");
        map.put("limit", "200");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMerchantPage("632065", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<MerchantPageBean>(mActivity) {

            @Override
            protected void onSuccess(MerchantPageBean data, String SucMessage) {

                HomeMerchantAdapter merchantAdapter = new HomeMerchantAdapter(data.getList());
                mBinding.rvMerchant.setLayoutManager(
                        new LinearLayoutManager(mActivity, LinearLayout.HORIZONTAL, false));
                mBinding.rvMerchant.setAdapter(merchantAdapter);

                merchantAdapter.setOnItemClickListener((adapter, view, position) -> {
                    MerchantPageBean.ListBean item = (MerchantPageBean.ListBean) adapter
                            .getItem(position);
                    CarMerchantDetailActivity.open(mActivity, item.getCode());
                });

            }

            @Override
            protected void onFinish() {

            }
        });
    }

    /**
     * 获取精选车源数据
     */
    private void getSelectedData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("location", "0");//1 热门 0普通
        map.put("start", "1");
        map.put("limit", "200");
        map.put("orderDir", "asc");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarTypePage("630492", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<CarSelectPageBean>(mActivity) {

            @Override
            protected void onSuccess(CarSelectPageBean data, String SucMessage) {

                homeSelectedAdapter = new HomeSelectedAdapter(data.getList());
                mBinding.rv1.setLayoutManager(
                        new LinearLayoutManager(mActivity, LinearLayout.HORIZONTAL, false));
                mBinding.rv1.setAdapter(homeSelectedAdapter);

                homeSelectedAdapter.setOnItemClickListener((adapter, view, position) -> {

                    CarSelectPageBean.ListBean item = (CarSelectPageBean.ListBean) adapter
                            .getItem(position);
                    CarDetailsActivity.open(mActivity, item.getCode());
                });

            }

            @Override
            protected void onFinish() {

            }
        });
    }

    private void initOnclickListener() {

        mBinding.tvAll.setOnClickListener(v -> {
            EventBus.getDefault().post(2);
//            InformationActivity.open(mActivity);
        });
        mBinding.tvPrice3050.setOnClickListener(v -> {
            HashMap<String, Serializable> map = new HashMap<>();
            map.put("priceStart", "300000000");
            map.put("priceEnd", "500000000");
            CarTypeListActivity.open(mActivity, map);
        });
        mBinding.tvPrice5070.setOnClickListener(v -> {
            HashMap<String, Serializable> map = new HashMap<>();
            map.put("priceStart", "500000000");
            map.put("priceEnd", "700000000");
            CarTypeListActivity.open(mActivity, map);
        });
        mBinding.tvPrice70.setOnClickListener(v -> {
            HashMap<String, Serializable> map = new HashMap<>();
            map.put("priceStart", "700000000");
            map.put("priceEnd", "");
            CarTypeListActivity.open(mActivity, map);
        });
        mBinding.tvPriceOther.setOnClickListener(v -> {
            HashMap<String, Serializable> map = new HashMap<>();
            map.put("priceStart", "");
            map.put("priceEnd", "");
            map.put("isMore", "1");
            CarTypeListActivity.open(mActivity, map);
        });
    }

    /**
     * 获取微车资讯数据
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
                //刷新回调
//                initCarRecommendBeanData();
//                getBannerDataRequest();
                initBannerData();
                initBrandData();
                initCarSystemData();
                getMerchantData();
                getSelectedData();
            }

            @Override
            public RecyclerView getRecyclerView() {
                return mBinding.rv2;
            }

            @Override
            public RecyclerView.Adapter getAdapter(List listData) {
                InformationAdapter informationAdapter = new InformationAdapter(listData);
                informationAdapter.setOnItemClickListener((adapter, view, position) -> {
                    InformationListBean.ListBean item = (InformationListBean.ListBean) adapter
                            .getItem(position);
                    WebViewArticleActivity.open(mActivity, item.getCode());
                });
                return informationAdapter;
            }

            @Override
            public void getListDataRequest(int pageindex, int limit, boolean isShowDialog) {
                getInformation(pageindex, limit, isShowDialog);
            }
        });
        mBinding.rv2.setLayoutManager(
                new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
        mRefreshHelper.init(10);

    }


    /**
     * 获取资讯数据
     */
    private void getInformation(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }
        Map<String, String> map = new HashMap<>();
        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("location", "0");//1 热门 0普通
        Call<BaseResponseModel<InformationListBean>> information = RetrofitUtils
                .createApi(MyApiServer.class)
                .getInformationList("630455", StringUtils.getJsonToString(map));
        information.enqueue(new BaseResponseModelCallBack<InformationListBean>(mActivity) {
            @Override
            protected void onSuccess(InformationListBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无资讯", 0);
            }

            @Override
            protected void onFinish() {

            }
        });
    }

    /**
     * 获取banner数据
     */
    private void initBanner() {
        mBanners = new ArrayList<>();
        mBinding.homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBinding.homeBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.homeBanner.setImageLoader(new GlideFirstPageBannerImageLoader());

        mBinding.homeBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                FirstPageBanner firstPageBanner = mBanners.get(position);
                if (firstPageBanner == null || TextUtils.isEmpty(firstPageBanner.getUrl())) {
                    return;
                }

                if (firstPageBanner.getUrl() != null) {
                    if (firstPageBanner.getUrl().indexOf("http") != -1) {
                        CdRouteHelper.openWebViewActivityForUrl(firstPageBanner.getName(),
                                firstPageBanner.getUrl());
                    }
                }
            }
        });
    }

}
