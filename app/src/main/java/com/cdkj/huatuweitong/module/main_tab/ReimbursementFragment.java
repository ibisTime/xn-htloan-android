package com.cdkj.huatuweitong.module.main_tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.FragmentReimbursementBinding;
import com.cdkj.huatuweitong.module.reimbursement.ReimbursementListFragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cdkj on 2018/5/1.
 */

public class ReimbursementFragment extends BaseLazyFragment {

    private FragmentReimbursementBinding mBinding;

    public static ReimbursementFragment getInstance() {
        ReimbursementFragment fragment = new ReimbursementFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reimbursement, null, false);

        initViews();

        return mBinding.getRoot();
    }

    private void initViews() {

        //设置fragment数据
        ArrayList fragments = new ArrayList<>();

        fragments.add(ReimbursementListFragment.getInstance("1"));
        fragments.add(ReimbursementListFragment.getInstance("2"));

        mBinding.viewpager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), fragments));
        mBinding.viewpager.setOffscreenPageLimit(fragments.size());

        mBinding.viewpager.setPagingEnabled(true);

        mBinding.viewindicator.setmLinWidth(28);
        mBinding.viewindicator.setVisibleTabCount(fragments.size());
        mBinding.viewindicator.setTabItemTitles(Arrays.asList("近期还款", "借款记录"));
        mBinding.viewindicator.setViewPager(mBinding.viewpager, 0);

    }


    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }
}
