package com.cdkj.huatuweitong.module.vehicle_db;


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

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.BrandHorAdapter;
import com.cdkj.huatuweitong.adapters.BrandVerAdapter;
import com.cdkj.huatuweitong.adapters.LetterRVAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.BrandBean;
import com.cdkj.huatuweitong.databinding.FragmentBrandBinding;
import com.cdkj.huatuweitong.utlis.HanyuPinyinHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.Arrays;
import java.util.Collections;
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
        mBinding.rvHotBrand.setLayoutManager(new GridLayoutManager(mActivity, 5) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
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
//        letterAdapter = new LetterAdapter(mActivity, letters);
//        mBinding.lvLetter.setOnItemClickListener((adapterView, view, i, l) -> {
//            //该字母首次出现的位置
//            int position = allBrandAdapter.getPositionBySort(letters[i]);
//            if (position != -1) {
//                mBinding.rvBrand.scrollToPosition(position);
//                LinearLayoutManager mLayoutManager =
//                        (LinearLayoutManager) mBinding.rvBrand.getLayoutManager();
//                mLayoutManager.scrollToPositionWithOffset(position, 0);
//            }
//        });


        List<String> lettersList = Arrays.asList(letters);
        LetterRVAdapter letterAdapter = new LetterRVAdapter(lettersList);
        mBinding.rvLetter.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mBinding.rvLetter.setAdapter(letterAdapter);
        letterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int cposition = allBrandAdapter.getPositionBySort(letters[position]);
                if (cposition != -1) {
//                    scrollToPosition 会把不在屏幕的 Item 移动到屏幕上，原来在上方的 Item 移动到 可见 Item 的第一项，在下方的移动到屏幕可见 Item 的最后一项。已经显示的 Item 不会移动。
                    mBinding.rvBrand.scrollToPosition(cposition);
//                    scrollToPositionWithOffset 会把 Item 移动到可见 Item 的第一项，即使它已经在可见 Item 之中。另外它还有 offset 参数，表示 Item 移动到第一项后跟 RecyclerView 上边界或下边界之间的距离（默认是 0）
                    LinearLayoutManager mLayoutManager =
                            (LinearLayoutManager) mBinding.rvBrand.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(cposition, 0);
                }
            }
        });

    }

    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        if (position < firstItem) {
            // 第一种可能:跳转位置在第一个可见位置之前，使用smoothScrollToPosition
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 第二种可能:跳转位置在第一个可见位置之后，最后一个可见项之前
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                // smoothScrollToPosition 不会有效果，此时调用smoothScrollBy来滑动到指定位置
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
//            mToPosition = position;
//            mShouldScroll = true;
        }
    }


    /**
     * 获取精选车源数据
     */
    private void initHotBrandData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("location", "0");
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
//                List<BrandBean> allBrandBeans = addSort(data);

                //使用冒泡排序  调整集合中的数据  使其从a-z排序
//                int size = data.size();
                for (int i = 0; i < data.size() - 1; i++) {
                    for (int j = 0; j < data.size() - 1 - i; j++) {
                        if (TextUtils.isEmpty(data.get(j).getLetter())) {
                            data.remove(j);
                            continue;
                        }
                        char sort1 = data.get(j).getLetter().toCharArray()[0];
                        char sort2 = data.get(j + 1).getLetter().toCharArray()[0];
                        if (sort1 > sort2) {  //交换两数位置
                            Collections.swap(data, j + 1, j);//交换位置
                        }
                    }
                }
                allBrandAdapter.replaceData(data);
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
