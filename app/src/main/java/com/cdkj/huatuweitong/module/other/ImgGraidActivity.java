package com.cdkj.huatuweitong.module.other;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.cdkj.baselibrary.activitys.ShowBigPhotoActivity;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.ImgGraidAdapter;
import com.cdkj.huatuweitong.databinding.ActivityImgGraidBinding;

import java.util.ArrayList;

public class ImgGraidActivity extends AbsBaseLoadActivity {

    private ActivityImgGraidBinding mBinding;
    private ArrayList<String> imgList;
    private String title;


    public static void open(Context mContext, String title, ArrayList<String> imges) {
        Intent intent = new Intent(mContext, ImgGraidActivity.class);
        intent.putExtra(CdRouteHelper.DATASIGN, imges);
        intent.putExtra(CdRouteHelper.TITLE, title);
        mContext.startActivity(intent);

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_img_graid, null, false);
//        activity_img_graid
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        if (getIntent() != null) {
            imgList = getIntent().getStringArrayListExtra(CdRouteHelper.DATASIGN);
            title = getIntent().getStringExtra(CdRouteHelper.TITLE);
        }
        mBaseBinding.titleView.setMidTitle(title);
        mBinding.rv.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        ImgGraidAdapter imgGraidAdapter = new ImgGraidAdapter(imgList);
        mBinding.rv.setAdapter(imgGraidAdapter);
        imgGraidAdapter.setOnItemClickListener((adapter, view, position) -> {
            String item = imgGraidAdapter.getItem(position);
            ShowBigPhotoActivity.open(this, MyCdConfig.QINIUURL + item);
        });
    }
}
