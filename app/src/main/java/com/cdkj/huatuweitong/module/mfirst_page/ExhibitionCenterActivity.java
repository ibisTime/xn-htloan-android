package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.DividerItemDecoration;
import com.cdkj.huatuweitong.adapters.ExhibitionCenterAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.ExhibitionCenterBean;
import com.cdkj.huatuweitong.databinding.ActivityExhibitionCenterBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 展销中心
 */
public class ExhibitionCenterActivity extends AbsBaseLoadActivity {
    ActivityExhibitionCenterBinding mBinding;
    private String brandCode;
    private ArrayList<ExhibitionCenterBean> datas = new ArrayList<>();
    private ExhibitionCenterAdapter adapter;

    public static void open(Context context, String brandCode) {
        if (context != null) {
            Intent intent = new Intent(context, ExhibitionCenterActivity.class);
            //品牌号
            intent.putExtra("brandCode", brandCode);
            context.startActivity(intent);
        }

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_exhibition_center, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.ExhibitionCenter));

        if (getIntent() != null) {
            brandCode = getIntent().getStringExtra("brandCode");
        }
        initData("");
        initRecyclerView();

        initOnclick();


    }

    private void initRecyclerView() {
        adapter = new ExhibitionCenterAdapter(datas);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

    }

    private void initOnclick() {

        mBinding.btnSearch.setOnClickListener(v -> {
            String text = mBinding.etText.getText().toString();
            if (TextUtils.isEmpty(text)) {
               // UITipDialog.showFall(ExhibitionCenterActivity.this, "请输入要搜索的车名");
//                return;
            }
            initData(text);
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CarDetailsActivity.open(ExhibitionCenterActivity.this, datas.get(position).getCode());
            }
        });
    }

    private void initData(String name) {

        showLoadingDialog();

        Map<String, String> map = new HashMap<>();
        map.put("brandCode", brandCode);
        map.put("location", "0");
        map.put("limit", "20");
        map.put("start", "1");
        if (!TextUtils.isEmpty(name)) {
            //如果是检索的时候需要传一个  name  去检索  检索以后相当于重新获取数据  所以从第一页开始加载
            map.put("name", name);
        }
        Call call = RetrofitUtils.createApi(MyApiServer.class).getExhibitionCenter("630425", StringUtils.getJsonToString(map));

        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<ExhibitionCenterBean>>(ExhibitionCenterActivity.this) {

            @Override
            protected void onSuccess(ResponseInListModel<ExhibitionCenterBean> data, String SucMessage) {
//               datas= (ArrayList<ExhibitionCenterBean>) data.getList();
                datas.clear();
                datas.addAll(data.getList());
                adapter.notifyDataSetChanged();
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
