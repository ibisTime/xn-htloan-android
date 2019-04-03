package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.interfaces.BaseRefreshCallBack;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.MyCollectionAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.DeleteCollectionBean;
import com.cdkj.huatuweitong.bean.MyCollectionBean;
import com.cdkj.huatuweitong.databinding.ActivityMyCollectionListBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class MyCollectionListActivity extends AbsBaseLoadActivity {
    private ActivityMyCollectionListBinding mBinding;
    private RefreshHelper mRefreshHelper;
    private MyCollectionAdapter adapter;
    private String type;//0 分享，1 足迹，2 关注，3 收藏，4 点赞

    public static void open(Context context, String type) {
        Intent intent = new Intent(context, MyCollectionListActivity.class);
        intent.putExtra(CdRouteHelper.DATASIGN, type);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_my_collection_list, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        if (getIntent() != null) {
            type = getIntent().getStringExtra(CdRouteHelper.DATASIGN);
        }
        if (TextUtils.equals("1", type)) {
            //足迹
            mBaseBinding.titleView.setMidTitle("我的足迹");
        } else if ((TextUtils.equals("3", type))) {
            mBaseBinding.titleView.setMidTitle("我的收藏");
        }
        mBaseBinding.titleView.setRightTitle("编辑");
        initRefreshHelper(10);

        initListener();
    }

    private void initListener() {
        mBaseBinding.titleView.setRightFraClickListener(v -> {
            List<MyCollectionBean.ListBean> data = adapter.getData();
            if (mBinding.llButtom.getVisibility() == View.VISIBLE) {
                mBinding.llButtom.setVisibility(View.GONE);
                for (MyCollectionBean.ListBean datum : data) {
                    datum.setShowSelect(false);
                }
            } else {
                mBinding.llButtom.setVisibility(View.VISIBLE);
                for (MyCollectionBean.ListBean datum : data) {
                    datum.setShowSelect(true);
                }
            }
            adapter.notifyDataSetChanged();
        });

        mBinding.cbSelectAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
            List<MyCollectionBean.ListBean> data = adapter.getData();
            for (MyCollectionBean.ListBean datum : data) {
                datum.setSelect(isChecked);
            }
            adapter.notifyDataSetChanged();
        });

        mBinding.btnDelete.setOnClickListener(v -> {
            List<MyCollectionBean.ListBean> data = adapter.getData();
            ArrayList<String> codeList = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                MyCollectionBean.ListBean listBean = data.get(i);
                if (listBean.isSelect()) {
                    codeList.add(listBean.getCode());
                }
            }
            if (codeList.size() == 0) {
                UITipDialog.showSuccess(this, "请选择要删除的收藏");
                return;
            }
            deleteCollection(codeList);
        });
    }

    /**
     * 初始化刷新相关
     */
    protected void initRefreshHelper(int limit) {
        //mRefreshBinding.rv.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
        mRefreshHelper = new RefreshHelper(this, new BaseRefreshCallBack<MyCollectionBean.ListBean>(this) {

            @Override
            public View getRefreshLayout() {
                return mBinding.refreshLayout;
            }

            @Override
            public RecyclerView getRecyclerView() {
                return mBinding.rv;
            }

            @Override
            public RecyclerView.Adapter getAdapter(List<MyCollectionBean.ListBean> listData) {

                adapter = new MyCollectionAdapter(listData);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                    }
                });

                adapter.setOnItemChildClickListener((adapter1, view, position) -> {
                    switch (view.getId()) {
                        case R.id.cb_select:
                            MyCollectionBean.ListBean item = (MyCollectionBean.ListBean) adapter1.getItem(position);
                            item.setSelect(((CheckBox) view).isChecked());
                            adapter1.notifyDataSetChanged();
                            break;
                    }

                });
                return adapter;
            }

            @Override
            public void getListDataRequest(int pageindex, int limit, boolean isShowDialog) {
                getData(pageindex, limit, isShowDialog);
            }
        });
        mRefreshHelper.init(limit);
        mRefreshHelper.onDefaluteMRefresh(true);

    }

    private void getData(int pageindex, int limit, boolean isShowDialog) {

        Map map = new HashMap<String, String>();
        map.put("creater", SPUtilHelper.getUserId());
        map.put("limit", limit);
        map.put("start", pageindex);
//        map.put("toCode", "");
//        map.put("toType", "0");//0 车，1 资讯
        map.put("type", type);//0 分享，1 足迹，2 关注，3 收藏，4 点赞
        if (isShowDialog)
            showLoadingDialog();
        Call<BaseResponseModel<MyCollectionBean>> collection = RetrofitUtils.createApi(MyApiServer.class).getCollection("630465", StringUtils.getJsonToString(map));
        collection.enqueue(new BaseResponseModelCallBack<MyCollectionBean>(this) {
            @Override
            protected void onSuccess(MyCollectionBean data, String SucMessage) {
                String strEmpty = null;
                if (TextUtils.equals("3", type)) {
                    strEmpty = "暂无收藏数据";
                } else if (TextUtils.equals("1", type)) {
                    strEmpty = "暂无足迹数据";
                }
                mRefreshHelper.setData(data.getList(), strEmpty, 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

//                mRefreshHelper.setData(data.getList(), "暂无收藏数据", 0);
//        ArrayList<MyCollectionBean> data = new ArrayList<>();
//
//        data.add(new MyCollectionBean());
//        data.add(new MyCollectionBean());
//        data.add(new MyCollectionBean());
//        mRefreshHelper.setData(data, "暂无收藏数据", 0);
    }

    /**
     * 删除收藏
     */
    private void deleteCollection(ArrayList<String> codeList) {
        Map map = new HashMap();
        map.put("codeList", codeList);
        Call<BaseResponseModel<DeleteCollectionBean>> baseResponseModelCall = RetrofitUtils.createApi(MyApiServer.class).deleteCollection("630461", StringUtils.getJsonToString(map));
        showLoadingDialog();
        baseResponseModelCall.enqueue(new BaseResponseModelCallBack<DeleteCollectionBean>(this) {
            @Override
            protected void onSuccess(DeleteCollectionBean data, String SucMessage) {
                List<MyCollectionBean.ListBean> currentData = adapter.getData();
                mBinding.llButtom.setVisibility(View.GONE);
                for (MyCollectionBean.ListBean datum : currentData) {
                    datum.setShowSelect(false);
                }
                adapter.notifyDataSetChanged();
                UITipDialog.showSuccess(MyCollectionListActivity.this, "删除成功");
                mRefreshHelper.onDefaluteMRefresh(true);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }
}
