package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.interfaces.BaseRefreshCallBack;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.CarTypeListAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.*;
import com.cdkj.huatuweitong.common.GlideFirstPageBannerImageLoader;
import com.cdkj.huatuweitong.databinding.ActivityCarListBinding;
import com.cdkj.huatuweitong.module.other.ImgGraidActivity;
import com.youth.banner.BannerConfig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class CarListActivity extends AbsBaseLoadActivity {

    private ActivityCarListBinding mBinding;
    private RefreshHelper mRefreshHelper;
    private String currentCode = "";
    private ArrayList<String> imgList = new ArrayList<>();
    private String title;
    private CarSystemBean currentBean;

    public static void open(Context context, String code) {
        Intent intent = new Intent(context, CarListActivity.class);
        intent.putExtra("data", code);
        context.startActivity(intent);
    }

    public static void open(Context context, CarSystemBean bean) {
        Intent intent = new Intent(context, CarListActivity.class);
        intent.putExtra("bean", bean);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.activity_car_list, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        if (getIntent() != null) {
            currentCode = getIntent().getStringExtra("data");
            currentBean = (CarSystemBean) getIntent().getSerializableExtra("bean");
        }
        initBanner();
        initListener();
        initRecyclerView();
    }

    private void initListener() {

        mBinding.llPicNumber.setOnClickListener(v -> {
            //跳转查看图片视图
            if (imgList != null && imgList.size() > 0) {
                ImgGraidActivity.open(this, title, imgList);
            }
        });
    }

    /**
     * 获取banner数据
     */
    private void initBanner() {
        mBinding.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBinding.banner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.banner.setImageLoader(new GlideFirstPageBannerImageLoader());
    }

    /**
     * 设置数据
     */
    private void initRecyclerView() {
        mRefreshHelper = new RefreshHelper(this, new BaseRefreshCallBack(this) {
            @Override
            public View getRefreshLayout() {
                return mBinding.refreshLayout;
            }

            @Override
            public RecyclerView getRecyclerView() {
                return mBinding.rvCarList;
            }

            @Override
            public RecyclerView.Adapter getAdapter(List listData) {
                CarTypeListAdapter adapter = new CarTypeListAdapter(listData);
                adapter.setOnItemClickListener((adapter1, view, position) -> {

                    CarBean item = (CarBean) adapter1
                            .getItem(position);
                    CarDetailsActivity.open(CarListActivity.this, item.getCode());
                });
                return adapter;
            }

            @Override
            public void getListDataRequest(int pageindex, int limit, boolean isShowDialog) {
//                initDate(pageindex, limit, isShowDialog);

                initData(pageindex, limit, isShowDialog);
            }
        });
        mRefreshHelper.init(10);

        mRefreshHelper.onDefaluteMRefresh(true);//不用请求接口了  全部用的是上个界面传递的数据
        mRefreshHelper.getmRefreshLayout().setEnableLoadmore(false);
        //如果是上个界面传递过来的数据 就不用请求数据了  如不穿过来的不是数据是 code  记去请求数据
        if (currentBean != null) {
            steData();
        }
    }

    public void steData() {
        if (currentBean == null) {
            return;
        }
        mBinding.tvNumber.setText(currentBean.getPicNumber() + "");
        mBinding.tvPrice
                .setText(MoneyUtils.formatNum(currentBean.getLowest()) + "-" + MoneyUtils.formatNum(
                        currentBean.getHighest()));
        mBinding.tvTitle.setText(currentBean.getName());
        title = currentBean.getName();
        mBaseBinding.titleView.setMidTitle(title);
        //分割获取下页的图片数据
        String[] split = currentBean.getAdvPic().split("\\|\\|");
        imgList.addAll(Arrays.asList(split));
        //构造轮播图数据
        ArrayList<FirstPageBanner> mBanners = new ArrayList<>();
        for (String s : imgList) {
            FirstPageBanner firstPageBanner = new FirstPageBanner();
            firstPageBanner.setPic(s);
            mBanners.add(firstPageBanner);
        }
        mBinding.banner.setImages(mBanners);
        mBinding.banner.start();


    }
    

    private void initData(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }
        Map<String, Serializable> map = new HashMap<>();

        if (currentBean!=null){
            map.put("seriesCode", currentBean.getCode());
        }

        map.put("start", pageindex + "");
        map.put("limit", limit + "");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarTypePage("630492", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<CarSelectPageBean>(CarListActivity.this) {
            @Override
            protected void onSuccess(CarSelectPageBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "车型数据为空", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
