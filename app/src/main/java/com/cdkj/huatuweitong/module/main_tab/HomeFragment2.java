package com.cdkj.huatuweitong.module.main_tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.jzvd.Jzvd;
import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.interfaces.BaseRefreshCallBack;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.InformationAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.DataDictionaryBean;
import com.cdkj.huatuweitong.bean.FirstPageBanner;
import com.cdkj.huatuweitong.bean.InformationListBean;
import com.cdkj.huatuweitong.bean.MainResourceBean;
import com.cdkj.huatuweitong.common.GlideFirstPageBannerImageLoader;
import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import com.cdkj.huatuweitong.databinding.FrgHomeBinding;
import com.cdkj.huatuweitong.module.user.CarVideoActivity;
import com.cdkj.huatuweitong.module.vehicle_db.CarMerchantPageActivity;
import com.cdkj.huatuweitong.module.vehicle_db.CarShowActivity;
import com.cdkj.huatuweitong.module.vehicle_db.InfoPageActivity;
import com.cdkj.huatuweitong.module.vehicle_db.SerchActivity;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cdkj.baselibrary.utils.DateUtil.DEFAULT_DATE_FMT;

/**
 * @author : qianLei
 * @since : 2019/11/4 22:10
 */
public class HomeFragment2 extends BaseLazyFragment {

    private FrgHomeBinding mBinding;

    private ArrayList<FirstPageBanner> mBanners;

    private RefreshHelper mRefreshHelper;
    private List<DataDictionaryBean> list = new ArrayList<>();

    public static HomeFragment2 getInstance() {
        HomeFragment2 fragment = new HomeFragment2();
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
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.frg_home, null, false);

        initListener();

        initBanner();
        getBannerData();

        getVedio();

        getCarNumber();

        return mBinding.getRoot();
    }

    private void initListener() {

        mBinding.llSearch.setOnClickListener(view -> {
            SerchActivity.open(mActivity);
        });

        mBinding.llMerchant.setOnClickListener(view -> {
            CarMerchantPageActivity.open(mActivity);
        });

        mBinding.llShow.setOnClickListener(view -> {
            CarShowActivity.open(mActivity);
        });

        mBinding.flVideoAll.setOnClickListener(view -> {
            CarVideoActivity.open(mActivity);
        });

        mBinding.tvAll.setOnClickListener(view -> {
            InfoPageActivity.open(mActivity);
        });

    }

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

    private void getBannerData() {
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
        dataDictionary.enqueue(new BaseResponseListCallBack<DataDictionaryBean>(mActivity) {
            @Override
            protected void onSuccess(List<DataDictionaryBean> data, String SucMessage) {

                if (data != null) {
                    list.addAll(data);
                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();

                initRefreshHelper();
                mRefreshHelper.onDefaluteMRefresh(true);
            }
        });

    }

    private void getVedio() {

        Map<String, String> map = RetrofitUtils.getRequestMap();

        // { "code": "RT201911011052453667232", "name": "玩售后" },
        // { "code": "RT201911011052313086637", "name": "玩汽车" },
        // { "code": "RT201911011052165353997", "name": "玩保险" },
        // { "code": "RT201911011050254727016", "name": "玩分期" }

        map.put("bizCode", "RT201911011052313086637");
        map.put("kind", "1");
        map.put("location", "1");
        map.put("status", "1");
        map.put("start", "1");
        map.put("limit", "100");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMainResource("630585", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<MainResourceBean>(mActivity) {

            @Override
            protected void onSuccess(MainResourceBean data, String SucMessage) {

                for (MainResourceBean.ListBean bean : data.getList()) {

                    if (bean.getKind().equals("1")) {

                        // startDismissControlViewTimer
                        mBinding.jzVideo.setTag(bean.getCode());
                        mBinding.jzVideo.setUp(MyCdConfig.QINIUURL + bean.getUrl(), bean.getName());
                        mBinding.jzVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImgUtils.loadQiniuImg(mActivity, MyCdConfig.QINIUURL + bean.getThumbnail(),
                                mBinding.jzVideo.thumbImageView);

                        mBinding.tvTime.setText(DateUtil.formatStringData(bean.getPushDatetime(),
                                DEFAULT_DATE_FMT));
                        mBinding.tvPlays.setText(bean.getVisitNumber() + "次播放");

                        return;
                    }
                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
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
                getBannerData();
            }

            @Override
            public RecyclerView getRecyclerView() {
                return mBinding.rv2;
            }

            @Override
            public RecyclerView.Adapter getAdapter(List listData) {
                InformationAdapter informationAdapter = new InformationAdapter(listData, list);
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
        map.put("location", "1");//1 热门 0普通
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
                disMissLoading();
            }
        });
    }
}
