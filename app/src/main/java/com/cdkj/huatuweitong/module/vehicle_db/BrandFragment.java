package com.cdkj.huatuweitong.module.vehicle_db;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.BrandHorAdapter;
import com.cdkj.huatuweitong.adapters.BrandVerAdapter;
import com.cdkj.huatuweitong.adapters.LetterAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.BrandBean;
import com.cdkj.huatuweitong.databinding.FragmentBrandBinding;
import com.cdkj.huatuweitong.utlis.HanyuPinyinHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrandFragment extends BaseLazyFragment {

    private FragmentBrandBinding mBinding;
    private BrandVerAdapter hotBrandAdapter;
    private BrandHorAdapter allBrandAdapter;
    private LetterAdapter letterAdapter;
    public static String[] letters = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    public static BrandFragment getInstance() {
        BrandFragment fragment = new BrandFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_brand, null, false);
        initHotBrandRecycler();
        initAllRecycler();
        initHotBrandData();
        initAllBrandData();
        initLetter();
        initListener();
        return mBinding.getRoot();
    }

    private void initListener() {
        mBinding.tvOrther.setOnClickListener(v -> {
            BrandActivity.open(mActivity);
        });
    }

    /*
    初始化上面recycler
     */
    private void initHotBrandRecycler() {
        hotBrandAdapter = new BrandVerAdapter(null);
        mBinding.rvHotBrand.setLayoutManager(new GridLayoutManager(mActivity, 5));
        mBinding.rvHotBrand.setAdapter(hotBrandAdapter);

        hotBrandAdapter.setOnItemClickListener((adapter, view, position) -> {
            BrandBean item = (BrandBean) adapter.getItem(position);

            CarSystemListActivity.open(mActivity, item.getCode());
        });
    }

    /**
     * 设置右边的小字母
     */
    private void initLetter() {
        letterAdapter = new LetterAdapter(mActivity, letters);
        mBinding.lvLetter.setAdapter(letterAdapter);
        mBinding.lvLetter.setOnItemClickListener((adapterView, view, i, l) -> {
            //该字母首次出现的位置
            int position = allBrandAdapter.getPositionBySort(letters[i]);
            if (position != -1) {
                mBinding.rvBrand.scrollToPosition(position);
                LinearLayoutManager mLayoutManager =
                        (LinearLayoutManager) mBinding.rvBrand.getLayoutManager();
                mLayoutManager.scrollToPositionWithOffset(position, 0);
            }
        });
    }


    /**
     * 获取精选车源数据
     */
    private void initHotBrandData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("isReferee", "1");//1 热门 0普通
        Call<BaseResponseListModel<BrandBean>> brandData = RetrofitUtils.createApi(MyApiServer.class).getBrandData("630406", StringUtils.getJsonToString(map));
        brandData.enqueue(new BaseResponseListCallBack<BrandBean>(mActivity) {
            @Override
            protected void onSuccess(List<BrandBean> data, String SucMessage) {
                hotBrandAdapter.replaceData(data);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }


    /**
     * 初始化最下面的 recy
     */
    private void initAllRecycler() {
        allBrandAdapter = new BrandHorAdapter(null);
        mBinding.rvBrand.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mBinding.rvBrand.setAdapter(allBrandAdapter);

        allBrandAdapter.setOnItemClickListener((adapter, view, position) -> {
            BrandBean item = (BrandBean) adapter.getItem(position);
            CarSystemListActivity.open(mActivity, item.getCode());
        });
    }

    private void initAllBrandData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        Call<BaseResponseListModel<BrandBean>> brandData = RetrofitUtils.createApi(MyApiServer.class).getBrandData("630406", StringUtils.getJsonToString(map));
        brandData.enqueue(new BaseResponseListCallBack<BrandBean>(mActivity) {
            @Override
            protected void onSuccess(List<BrandBean> data, String SucMessage) {
                List<BrandBean> allBrandBeans = addSort(data);
                allBrandAdapter.replaceData(allBrandBeans);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private List<BrandBean> addSort(List<BrandBean> data) {
        for (BrandBean mode : data) {
            String countryName = HanyuPinyinHelper.getFirstLetter(mode.getName());
            mode.setSort(countryName.toUpperCase());
        }
        return data;
    }
}
