package com.cdkj.huatuweitong.module.main_tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.interfaces.BaseRefreshCallBack;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.InformationAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.DataDictionaryBean;
import com.cdkj.huatuweitong.bean.FirstPageBanner;
import com.cdkj.huatuweitong.bean.InformationListBean;
import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import com.cdkj.huatuweitong.databinding.FragmentHomeBinding;
import com.cdkj.huatuweitong.databinding.FragmentInfoBinding;
import com.cdkj.huatuweitong.databinding.FragmentReimbursementBinding;
import retrofit2.Call;

import java.util.*;

/**
 * Created by cdkj on 2018/5/1.
 */

public class InfoFragment extends BaseLazyFragment {


    private FragmentInfoBinding mBinding;

    private RefreshHelper mRefreshHelper;

    private List<DataDictionaryBean> list = new ArrayList<>();

    public static InfoFragment getInstance() {
        InfoFragment fragment = new InfoFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, null, false);

        getCarNumber();

        return mBinding.getRoot();
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
                if (isShowDialog) {
                    showLoadingDialog();
                }

                Map<String, String> map = new HashMap<>();
                map.put("limit", limit + "");
                map.put("start", pageindex + "");
                map.put("status", "1");//0待上架，1已上架，2已下架
                map.put("orderDir", "asc");
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

}
