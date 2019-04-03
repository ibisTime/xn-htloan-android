package com.cdkj.huatuweitong.module.vehicle_db;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.FragmentVehicleDbBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 车型库
 */
public class VehicleDBFragment extends BaseLazyFragment {

    private FragmentVehicleDbBinding mBinding;
    List<Fragment> mList = new ArrayList<>();
    private List<String> titleString = new ArrayList<>();
    private int position;

    public static VehicleDBFragment getInstance() {
        VehicleDBFragment fragment = new VehicleDBFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_vehicle_db, null, false);
        initTabAndViewpager();
        initListener();
        return mBinding.getRoot();
    }

    private void initListener() {
        mBinding.ivSerch.setOnClickListener(v -> {
            SerchActivity.open(mActivity);
        });
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }

    private void initTabAndViewpager() {
        mList.add(SelectedFragment.getInstance());
        mList.add(BrandFragment.getInstance());
        titleString = new ArrayList<>();
        titleString.add("按条件");
        titleString.add("按品牌");
//
        mBinding.tabTitle.addTab(mBinding.tabTitle.newTab().setText("按条件"));
        mBinding.tabTitle.addTab(mBinding.tabTitle.newTab().setText("按品牌"));
        ViewPagerAdapter mAdapter = new ViewPagerAdapter(getFragmentManager(), mList, titleString);
        mBinding.viewpager.setAdapter(mAdapter);//给ViewPager设置适配器
        mBinding.tabTitle.setupWithViewPager(mBinding.viewpager);
        mBinding.tabTitle.setTabsFromPagerAdapter(mAdapter);
        mBinding.tabTitle.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                LogUtil.E("当前索引为" + position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
