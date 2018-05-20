package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.DividerItemDecoration;
import com.cdkj.huatuweitong.adapters.ExhibitionCenterAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.ExhibitionCenterBean;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 展销中心
 */
public class ExhibitionCenterActivity extends AbsRefreshListActivity<ResponseInListModel<ExhibitionCenterBean>> {
    private String brandCode;
    private ExhibitionCenterAdapter adapter;
    private EditText etSearch;

    public static void open(Context context, String brandCode) {
        if (context != null) {
            Intent intent = new Intent(context, ExhibitionCenterActivity.class);
            //品牌号
            intent.putExtra("brandCode", brandCode);
            context.startActivity(intent);
        }

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        mRefreshBinding.rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter = new ExhibitionCenterAdapter(listData);
        View headView = View.inflate(this, R.layout.head_exhibition_center, null);
        etSearch = headView.findViewById(R.id.et_search);
        etSearch.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId==EditorInfo.IME_ACTION_SEARCH){
                    if (TextUtils.isEmpty(v.getText().toString())){
                        UITipDialog.showFall(ExhibitionCenterActivity.this,"请输入要搜索内容");
                        return true;
                    }
                    mRefreshHelper.onDefaluteMRefresh(true);
                }
                return true;
            }
        });
        adapter.addHeaderView(headView);
        adapter.setHeaderAndEmpty(true);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter aadapter, View view, int position) {

                CarDetailsActivity.open(ExhibitionCenterActivity.this, adapter.getItem(position).getCode());
            }
        });
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initData(pageindex, limit, isShowDialog);

    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.ExhibitionCenter));

        if (getIntent() != null) {
            brandCode = getIntent().getStringExtra("brandCode");
        }
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

    }


    private void initData(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }

        Map<String, String> map = new HashMap<>();
        map.put("brandCode", brandCode);
        map.put("location", "0");
        map.put("limit", limit + "");
        map.put("start", pageindex + "");

            //如果是检索的时候需要传一个  name  去检索  检索以后相当于重新获取数据  所以从第一页开始加载
            map.put("name", etSearch.getText().toString());

        Call call = RetrofitUtils.createApi(MyApiServer.class).getExhibitionCenter("630425", StringUtils.getJsonToString(map));

        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<ResponseInListModel<ExhibitionCenterBean>>>(ExhibitionCenterActivity.this) {
            @Override
            protected void onSuccess(ResponseInListModel<ResponseInListModel<ExhibitionCenterBean>> data, String SucMessage) {
                mRefreshHelper.setData(data.getList(),"暂无更多数据",0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(ExhibitionCenterActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
