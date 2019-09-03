package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.interfaces.BaseRefreshCallBack;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.CarMerchantBrandAdapter;
import com.cdkj.huatuweitong.adapters.HomeSelectedAdapter;
import com.cdkj.huatuweitong.adapters.InformationAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.*;
import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import com.cdkj.huatuweitong.databinding.ActivityCarMerchantDetailBinding;
import retrofit2.Call;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : qianLei
 * @since : 2019/8/29 18:01
 */
public class CarMerchantDetailActivity extends AbsBaseLoadActivity {

    private ActivityCarMerchantDetailBinding mBinding;

    private String code;

    private RefreshHelper mRefreshHelper;

    public static void open(Context context, String code) {
        Intent intent = new Intent(context, CarMerchantDetailActivity.class);
        intent.putExtra("data", code);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.activity_car_merchant_detail, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        setShowTitle(false);

        init();
        initListener();

        initRefreshHelper();
        getMerchantData();
        getSelectedData();
    }

    private void init() {
        code = getIntent().getStringExtra("data");
    }

    private void initListener() {
        mBinding.ivClose.setOnClickListener(view -> finish());
    }


    /**
     * 获取优质车商
     */
    private void getMerchantData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMerchant("632066", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<MerchantBean>(CarMerchantDetailActivity.this) {

            @Override
            protected void onSuccess(MerchantBean data, String SucMessage) {
                setView(data);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private void setView(MerchantBean data) {
        ImgUtils.loadQiniuImg(this, data.getShopBackGround(), mBinding.ivBg);
        mBinding.tvName.setText(data.getFullName());
        mBinding.tvLocation.setText(data.getAddress());

        CarMerchantBrandAdapter mAdapter = new CarMerchantBrandAdapter(data.getBrandList());
        mAdapter.setOnItemClickListener((adapter, view, position) -> {

            MerchantBean.BrandListBean item = (MerchantBean.BrandListBean) adapter
                    .getItem(position);
            CarSystemListActivity.open(this, item.getCode());
        });

        mBinding.rvMainBusiness
                .setLayoutManager(new LinearLayoutManager(CarMerchantDetailActivity.this,
                        LinearLayout.HORIZONTAL, false));
        mBinding.rvMainBusiness.setAdapter(mAdapter);


    }

    /**
     * 获取精选车源数据
     */
    private void getSelectedData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("carDealerCode", code);
        map.put("start", "1");
        map.put("limit", "200");
        map.put("orderDir", "asc");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarTypePage("630492", StringUtils.getJsonToString(map));
        call.enqueue(
                new BaseResponseModelCallBack<CarSelectPageBean>(CarMerchantDetailActivity.this) {

                    @Override
                    protected void onSuccess(CarSelectPageBean data, String SucMessage) {

                        HomeSelectedAdapter mAdapter = new HomeSelectedAdapter(data.getList());
                        mBinding.rvCar.setLayoutManager(
                                new LinearLayoutManager(CarMerchantDetailActivity.this,
                                        LinearLayout.HORIZONTAL, false));
                        mBinding.rvCar.setAdapter(mAdapter);

                        mAdapter.setOnItemClickListener((adapter, view, position) -> {

                            CarSelectPageBean.ListBean item = (CarSelectPageBean.ListBean) adapter
                                    .getItem(position);
                            CarDetailsActivity.open(CarMerchantDetailActivity.this, item.getCode());
                        });

                        mBinding.tvCar
                                .setText(data.getList() == null ? "0" : data.getList().size() + "");
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

        mRefreshHelper = new RefreshHelper(this, new BaseRefreshCallBack(this) {
            @Override
            public View getRefreshLayout() {
                return mBinding.refreshLayout;
            }

            @Override
            public void onRefresh(int pageindex, int limit) {
                super.onRefresh(pageindex, limit);

                getMerchantData();
                getSelectedData();
            }

            @Override
            public RecyclerView getRecyclerView() {
                return mBinding.rvActive;
            }

            @Override
            public RecyclerView.Adapter getAdapter(List listData) {
                InformationAdapter informationAdapter = new InformationAdapter(listData);
                informationAdapter.setOnItemClickListener((adapter, view, position) -> {
                    InformationListBean.ListBean item = (InformationListBean.ListBean) adapter
                            .getItem(position);
                    WebViewArticleActivity
                            .open(CarMerchantDetailActivity.this, item.getCode());
                });
                return informationAdapter;
            }

            @Override
            public void getListDataRequest(int pageindex, int limit, boolean isShowDialog) {
                getInformation(pageindex, limit, isShowDialog);
            }
        });

        mBinding.rvActive.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
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
        map.put("carDealerCode", code);
        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("status", "1");//0待上架，1已上架，2已下架
        Call<BaseResponseModel<InformationListBean>> information = RetrofitUtils
                .createApi(MyApiServer.class)
                .getInformationList("630455", StringUtils.getJsonToString(map));
        information.enqueue(new BaseResponseModelCallBack<InformationListBean>(this) {
            @Override
            protected void onSuccess(InformationListBean data, String SucMessage) {
                mBinding.tvActive
                        .setText(data.getList() == null ? "0" : data.getList().size() + "");
                mRefreshHelper.setData(data.getList(), "暂无资讯", 0);
            }

            @Override
            protected void onFinish() {

            }
        });
    }
}
