package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.CarListAdapter;
import com.cdkj.huatuweitong.bean.CarListBean;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.cdkj.huatuweitong.databinding.ActivityCarListBinding;

import java.util.ArrayList;

public class CarListActivity extends AbsBaseLoadActivity {
    private ActivityCarListBinding mBinding;
    private RefreshHelper mRefreshHelper;
    private CarSystemListBean currentBean;

    public static void open(Context context, CarSystemListBean carSystemListBean) {
        Intent intent = new Intent(context, CarListActivity.class);
        intent.putExtra("data", carSystemListBean);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_car_list, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        if (getIntent() != null) {
            currentBean = (CarSystemListBean) getIntent().getSerializableExtra("data");
        }
        mBaseBinding.titleView.setMidTitle(currentBean.getName());

        initTopData();
        initRceyclerView();

    }

    private void initTopData() {
        ImgUtils.loadQiniuImg(this, currentBean.getAdvPic(), mBinding.ivTopImg);
        mBinding.tvPrice.setText(MoneyUtils.formatNum(currentBean.getLowest()) + "-" + MoneyUtils.formatNum(currentBean.getHighest()));
        mBinding.tvTitle.setText(currentBean.getName());
    }

    /**
     * 设置数据
     */
    private void initRceyclerView() {
        CarListAdapter adapter = new CarListAdapter(currentBean.getCars());
        mBinding.rvCarList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.rvCarList.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            CarSystemListBean.CarsBean item = (CarSystemListBean.CarsBean) adapter1.getItem(position);
            CarDetailsActivity.open(CarListActivity.this,item.getCode());

        });

    }

    private void initDate(int pageindex, int limit, boolean isShowDialog) {
        ArrayList<CarListBean> carListBeans = new ArrayList<>();
        carListBeans.add(new CarListBean());
        carListBeans.add(new CarListBean());
        carListBeans.add(new CarListBean());
        mRefreshHelper.setData(carListBeans, "数据为空", 0);
    }
}
