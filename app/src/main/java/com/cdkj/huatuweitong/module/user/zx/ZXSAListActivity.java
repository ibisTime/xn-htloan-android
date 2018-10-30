package com.cdkj.huatuweitong.module.user.zx;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.SAListAdapter;
import com.cdkj.huatuweitong.bean.SAListBean;
import com.cdkj.huatuweitong.databinding.ActivityZxsalistBinding;

import java.io.Serializable;
import java.util.List;

public class ZXSAListActivity extends AbsBaseLoadActivity {
    ActivityZxsalistBinding mBinding;
    private List<SAListBean.DataBean> list;
    private String name;
    private String id;

    public static void open(Context context, List<SAListBean.DataBean> list, String id, String name) {
        if (context != null) {
            Intent intent = new Intent(context, ZXSAActivity.class);
            intent.putExtra(CdRouteHelper.DATASIGN, (Serializable) list);
            intent.putExtra("id", id);
            intent.putExtra("name", name);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxsalist, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("涉案列表");
        if (getIntent() != null) {
            list = (List<SAListBean.DataBean>) getIntent().getSerializableExtra(CdRouteHelper.DATASIGN);
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
        }
        SAListAdapter adapter = new SAListAdapter(list);
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.rv.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            //跳转到涉案详情
            SAListBean.DataBean dataBean = list.get(position);
            String recordId = dataBean.getRecordId();

            ZXSADetialsActivity.open(this, recordId, id, name);
        });
    }

}
