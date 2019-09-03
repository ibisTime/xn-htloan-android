package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.baselibrary.utils.ToastUtil;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarSystemBean;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.cdkj.huatuweitong.bean.CarSystemPageBean;
import com.cdkj.huatuweitong.databinding.ActivitySerchBinding;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class SerchActivity extends AbsBaseLoadActivity {
    private ActivitySerchBinding mBinding;
    ArrayList<TextView> fblItemData = new ArrayList<>();

    private ArrayList<String> labelData = new ArrayList<>();//标签数据
    //    private BaseResponseListCallBack<BrandBean> callback;
    private List<CarSystemBean> dataList;
    private CarSystemBean currentBean;

    public static void open(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, SerchActivity.class);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_serch, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        setShowTitle(false);//取消标题
//        initAddFlexboxLayou();
        initListener();
        getCarSystem();
    }

    private void initListener() {
        mBinding.tvSearch.setOnClickListener(v -> {
            if (TextUtils.isEmpty(mBinding.etSearch.getText().toString())) {
                ToastUtil.show(SerchActivity.this, "请输入搜索的内容");
                return;
            }
            CarSystemListActivity.open(mBinding.etSearch.getText().toString(), SerchActivity.this);
        });
        mBinding.ivBack.setOnClickListener(v -> {
            finish();
        });
    }

    /**
     * 获取推荐车系数据
     */
    private void getCarSystem() {

        showLoadingDialog();
        showLoadingDialog();
        Map<String, Serializable> map = new HashMap<>();
        map.put("status", "1");
        map.put("location", "0");//热门推荐
        map.put("start", "1");
        map.put("limit", "200");
        map.put("orderDir", "asc");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarSystemPage("630491", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<CarSystemPageBean>(this) {
            @Override
            protected void onSuccess(CarSystemPageBean data, String SucMessage) {
                dataList = data.getList();
                for (CarSystemBean datum : data.getList()) {
                    labelData.add(datum.getName());
                }
                initAddFlexboxLayou();
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


//        showLoadingDialog();
////        Map<String, String> map = new HashMap<>();
//        map.put("status", "1");//0待上架，1已上架，2已下架
//        map.put("location", "0");//0 热门 1普通
//        Call<BaseResponseListModel<BrandBean>> brandData = RetrofitUtils.createApi(MyApiServer.class).getBrandData("630406", StringUtils.getJsonToString(map));
//        callback = new BaseResponseListCallBack<BrandBean>(this) {
//            @Override
//            protected void onSuccess(List<BrandBean> data, String SucMessage) {
//                dataList = data;
//                for (BrandBean datum : data) {
//                    labelData.add(datum.getName());
//                }
//                initAddFlexboxLayou();
//            }
//
//            @Override
//            protected void onFinish() {
//                disMissLoading();
//            }
//        };
//        brandData.enqueue(callback);
    }

    private void initAddFlexboxLayou() {

        for (int i = 0; i < labelData.size(); i++) {
            TextView tv2 = new TextView(this);
            tv2.setText(labelData.get(i));
            tv2.setPadding(DensityUtil.dp2px(8), DensityUtil.dp2px(8), DensityUtil.dp2px(8), DensityUtil.dp2px(8));
            tv2.setGravity(Gravity.CENTER);
            tv2.setBackgroundResource(R.drawable.bg_gary);
            tv2.setSingleLine();
            // tv2.setTag(i);// 如果有点击事件  或者其他的 可以用集合存放个起来  通过tag判断
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            //这里设置的是标签间的间隔  如果不设置  每个标签之间会紧紧的贴在一起 比较难看
            layoutParams.setMargins(0, DensityUtil.dp2px(10), DensityUtil.dp2px(8), 0);
            tv2.setTextColor(ContextCompat.getColor(this, R.color.text_black_cd));
            tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
//            mBinding.fblLabel.setFlexWrap(FlexWrap.WRAP);//设置模式  默认模式  就是可换行  从左到右
            fblItemData.add(tv2);
            mBinding.fblLabel.addView(tv2, layoutParams);
            int currentPostin = i;
            tv2.setOnClickListener(v -> {
                currentBean = dataList.get(currentPostin);
                CarListActivity.open(this, currentBean.getCode());
            });

        }
    }
}
