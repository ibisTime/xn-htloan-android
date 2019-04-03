package com.cdkj.huatuweitong.module.vehicle_db;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.CommonDialog;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.PermissionHelper;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.CarDetailsSettingAdapter;
import com.cdkj.huatuweitong.adapters.CarDetailsSettingAllAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarDetailsSettingBean;
import com.cdkj.huatuweitong.bean.CarModelActivityBean;
import com.cdkj.huatuweitong.bean.CollectionBean;
import com.cdkj.huatuweitong.bean.CommonSuccerBean;
import com.cdkj.huatuweitong.databinding.ActivityCarDetails2Binding;
import com.cdkj.huatuweitong.databinding.DailogInquiryLayoutBinding;
import com.cdkj.huatuweitong.dialog.FullBottomDialog;
import com.cdkj.huatuweitong.module.mfirst_page.CarLoanCalculator2Activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class CarDetailsActivity extends AbsBaseLoadActivity {
    private FullBottomDialog fullBottomDialog;
    private DailogInquiryLayoutBinding fullDialogView;
    private ActivityCarDetails2Binding mBinding;
    private String code;
    private String carCode;
    private CarModelActivityBean.CarsBean currentBean;

    public static void open(Context context, String code) {
        Intent intent = new Intent(context, CarDetailsActivity.class);
        intent.putExtra("code", code);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_car_details2, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        setShowTitle(false);
        if (getIntent() != null) {
            code = getIntent().getStringExtra("code");
        }
        initDatas();
        initSettingDatas();
        initListener();

    }

    private void initListener() {
        mBinding.btnSelectPrice.setOnClickListener(v -> {
            showBottomDialog();
        });

        mBinding.btnCall.setOnClickListener(v -> {
            showCallPhoneDialog();
        });

        mBinding.ivCollection.setOnClickListener(v -> {
            collectionCarAndFootprint("3");
        });

        mBinding.ivBack.setOnClickListener(v -> {
            finish();
        });
        mBinding.llCalculator.setOnClickListener(v -> {
            CarLoanCalculator2Activity.open(this, currentBean);
        });
    }

    /**
     * 收藏车辆
     * type   //0 分享，1 足迹，2 关注，3 收藏，4 点赞
     */
    private void collectionCarAndFootprint(String type) {
        if (TextUtils.isEmpty(carCode))
            return;
        Map map = new HashMap<String, String>();
        map.put("creater", SPUtilHelper.getUserId());
        map.put("toCode", carCode);
        map.put("toType", "0");//0 车，1 资讯
        map.put("type", type);//0 分享，1 足迹，2 关注，3 收藏，4 点赞
        Call<BaseResponseModel<CollectionBean>> collection = RetrofitUtils.createApi(MyApiServer.class).collection("630460", StringUtils.getJsonToString(map));
        showLoadingDialog();
        collection.enqueue(new BaseResponseModelCallBack<CollectionBean>(this) {
            @Override
            protected void onSuccess(CollectionBean data, String SucMessage) {
                if (TextUtils.equals("3", type))
                    UITipDialog.showSuccess(CarDetailsActivity.this, "收藏成功");
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 显示询底价的内容
     */
    private void showBottomDialog() {
        if (fullBottomDialog == null) {
            fullDialogView = DataBindingUtil.inflate(getLayoutInflater(), R.layout.dailog_inquiry_layout, null, false);
            fullBottomDialog = new FullBottomDialog(this, fullDialogView.getRoot());
            fullDialogView.tvName.setText(SPUtilHelper.getUserName());
            fullDialogView.tvPhone.setText(SPUtilHelper.getUserPhoneNum());
            ImgUtils.loadQiniuImg(this, currentBean.getPic(), fullDialogView.incMiddle.imgProduct);

            CarDetailsSettingAllAdapter adapterAll = (CarDetailsSettingAllAdapter) mBinding.rvCarSettingAll.getAdapter();
            List<CarDetailsSettingBean> data = adapterAll.getData();
            StringBuilder sb = new StringBuilder();
            if (data != null && data.size() != 0) {
                for (int i = 0; i < data.size(); i++) {
                    CarDetailsSettingBean.ConfigBean config = data.get(i).getConfig();

                    if (config != null) {
                        sb.append(config.getName());
                        sb.append(",");
                    }
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                fullDialogView.incMiddle.tvSlogan.setText(sb.toString());
            }
        }
        //更新数据

        fullDialogView.ivClose.setOnClickListener(v -> fullBottomDialog.dismiss());

        fullDialogView.btnConfirm.setOnClickListener(v -> {
            requerstPrice();
        });

        if (!fullBottomDialog.isShowing())
            fullBottomDialog.show();

    }

    /**
     * 获取车的配置
     */
    private void initSettingDatas() {
        Map<String, String> map = new HashMap<>();
        map.put("carCode", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarDetailsSetting("630448", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseListCallBack<CarDetailsSettingBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(List<CarDetailsSettingBean> data, String SucMessage) {

                List<CarDetailsSettingBean> carDetailsSettingBeans = data.subList(0, data.size() >= 4 ? 4 : data.size());
                CarDetailsSettingAdapter carDetailsSettingAdapter = new CarDetailsSettingAdapter(carDetailsSettingBeans);
                mBinding.rvCarSetting.setLayoutManager(new GridLayoutManager(CarDetailsActivity.this, 4) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
                mBinding.rvCarSetting.setAdapter(carDetailsSettingAdapter);

                CarDetailsSettingAllAdapter carDetailsSettingAllAdapter = new CarDetailsSettingAllAdapter(data);
                mBinding.rvCarSettingAll.setLayoutManager(new GridLayoutManager(CarDetailsActivity.this, 2) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
                mBinding.rvCarSettingAll.setAdapter(carDetailsSettingAllAdapter);
            }

            @Override
            protected void onFinish() {

            }
        });

    }

    /**
     * 获取界面的总数据
     */
    private void initDatas() {

        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarDetails("630427", StringUtils.getJsonToString(map));

        addCall(call);
        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<CarModelActivityBean.CarsBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(CarModelActivityBean.CarsBean data, String SucMessage) {
                showViewData(data);
                collectionCarAndFootprint("1");
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarDetailsActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 设置界面数据
     *
     * @param data
     */
    private void showViewData(CarModelActivityBean.CarsBean data) {
        this.currentBean = data;
        carCode = data.getCode();
        ImgUtils.loadQiniuImg(this, data.getAdvPic(), mBinding.ivImg);

        mBinding.tvName.setText(data.getBrandName() + "  " + data.getSeriesName() + "  " + data.getName());
        mBinding.tvType.setText(data.getFromPlace());
        mBinding.tvPrice.setText(MoneyUtils.formatNum(data.getSalePrice()));
        mBinding.tvMsg.setText(data.getSlogan());
    }

    /**
     * 询底价
     */
    private void requerstPrice() {
        Map map = new HashMap();
        map.put("carCode", carCode);
        map.put("name", SPUtilHelper.getUserName());
        map.put("userId", SPUtilHelper.getUserId());
        map.put("userMobile", SPUtilHelper.getUserPhoneNum());

        map.put("periods", "12");//后面这个一个入参是 之前接口遗留的  随便传入一个就好
        map.put("saleDesc", "计算器信息");//后面这个一个入参是 之前接口遗留的  随便传入一个就好
        Call<BaseResponseModel<CommonSuccerBean>> baseResponseModelCall = RetrofitUtils.createApi(MyApiServer.class).requerstPrice("630430", StringUtils.getJsonToString(map));
        baseResponseModelCall.enqueue(new BaseResponseModelCallBack<CommonSuccerBean>(this) {
            @Override
            protected void onSuccess(CommonSuccerBean data, String SucMessage) {
                UITipDialog.showSuccess(CarDetailsActivity.this, "询价成功");
                if (fullBottomDialog != null && fullBottomDialog.isShowing()) {
                    fullBottomDialog.dismiss();
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private void checkPermission() {
        if (!PermissionHelper.hasPermissions(this, Manifest.permission.CALL_PHONE)) {
            PermissionHelper permissionHelper = new PermissionHelper(this);
            permissionHelper.requestPermissions(new PermissionHelper.PermissionListener() {
                @Override
                public void doAfterGrand(String... permission) {
                    //成功
                    callPhone();
                }

                @Override
                public void doAfterDenied(String... permission) {
                    UITipDialog.showInfo(CarDetailsActivity.this, "请到设置中打开电话权限");
                }
            }, Manifest.permission.CALL_PHONE);
        } else {
            callPhone();
        }
    }

    private void callPhone() {

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "13333333333"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    private void showCallPhoneDialog() {
        new CommonDialog(CarDetailsActivity.this)
                .builder()
                .setTitle("提示").setContentMsg("是否拨打客服电话")
                .setNegativeBtn("取消", null, false)
                .setPositiveBtn("确定", new CommonDialog.OnPositiveListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPositive(View view) {
                        checkPermission();
                    }
                }).show();
    }
}
