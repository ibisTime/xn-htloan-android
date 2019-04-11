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

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.CommonDialog;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.SystemKeyDataBean;
import com.cdkj.baselibrary.model.eventmodels.EventFinishAll;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.PermissionHelper;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.MainActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.CarDetailsSettingAdapter;
import com.cdkj.huatuweitong.adapters.CarDetailsSettingAllAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarDetailsSettingBean;
import com.cdkj.huatuweitong.bean.CarModelActivityBean;
import com.cdkj.huatuweitong.bean.CollectionBean;
import com.cdkj.huatuweitong.bean.CommonSuccerBean;
import com.cdkj.huatuweitong.bean.DataDictionaryBean;
import com.cdkj.huatuweitong.bean.FirstPageBanner;
import com.cdkj.huatuweitong.common.GlideFirstPageBannerImageLoader;
import com.cdkj.huatuweitong.databinding.ActivityCarDetails2Binding;
import com.cdkj.huatuweitong.databinding.DailogInquiryLayoutBinding;
import com.cdkj.huatuweitong.databinding.DialogInquirySuccerBinding;
import com.cdkj.huatuweitong.dialog.FullBottomDialog;
import com.cdkj.huatuweitong.module.mfirst_page.CarLoanCalculator2Activity;
import com.cdkj.huatuweitong.utlis.DataHelper;
import com.cdkj.huatuweitong.utlis.OnSystemKeyListener;
import com.youth.banner.BannerConfig;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
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
    private ArrayList<FirstPageBanner> mBanners;
    private StringBuilder sbConfig = new StringBuilder();
    private String telephone;
    private String levelNumber = "";//规格的值
    private FullBottomDialog fullBottomSuccerDialog;
    private DialogInquirySuccerBinding fullBottomSuccerView;

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
        initBanner();
        initSettingDatas();
        initSettingDatas2();
        initListener();

    }

    private void initListener() {
        mBinding.btnSelectPrice.setOnClickListener(v -> {
            if (!SPUtilHelper.isLogin(this, false)) {
                return;
            }
            showBottomDialog();
        });

        mBinding.btnCall.setOnClickListener(v -> {
            getKfPhone();
        });

        mBinding.ivCollection.setOnClickListener(v -> {
            if (!SPUtilHelper.isLogin(this, false)) {
                return;
            }
            if (TextUtils.equals("1", currentBean.getIsCollect())) {
                cancelCollectionCarAndFootprint();
            } else {
                collectionCarAndFootprint("3");
            }
        });

        mBinding.ivBack.setOnClickListener(v -> {
            finish();
        });
        mBinding.llCalculator.setOnClickListener(v -> {
            CarLoanCalculator2Activity.open(this, currentBean);
        });
    }

    /**
     * 获取banner数据
     */
    private void initBanner() {

        mBinding.homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBinding.homeBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.homeBanner.setImageLoader(new GlideFirstPageBannerImageLoader());
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
                if (TextUtils.equals("3", type)) {
                    UITipDialog.showSuccess(CarDetailsActivity.this, "收藏成功");
                    currentBean.setIsCollect("1");
                    mBinding.ivCollection.setImageResource(R.mipmap.icon_collection);
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 取消收藏车辆
     * type   //0 分享，1 足迹，2 关注，3 收藏，4 点赞
     */
    private void cancelCollectionCarAndFootprint() {
        if (TextUtils.isEmpty(carCode))
            return;
        Map map = new HashMap();
        map.put("carCode", currentBean.getCode());
        map.put("userId", SPUtilHelper.getUserId());
        Call<BaseResponseModel<CollectionBean>> collection = RetrofitUtils.createApi(MyApiServer.class).collection("630462", StringUtils.getJsonToString(map));
        showLoadingDialog();
        collection.enqueue(new BaseResponseModelCallBack<CollectionBean>(this) {
            @Override
            protected void onSuccess(CollectionBean data, String SucMessage) {
                UITipDialog.showSuccess(CarDetailsActivity.this, "取消收藏");
                currentBean.setIsCollect("0");
                mBinding.ivCollection.setImageResource(R.mipmap.icon_un_collection);

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
            fullDialogView.incMiddle.tvProductTitle.setText(currentBean.getName());
            fullDialogView.incMiddle.tvType.setText(levelNumber + " " + currentBean.getOutsideColor() + " / " + currentBean.getInsideColor() + " " + currentBean.getFromPlace());
            fullDialogView.incMiddle.tvDate.setText(DateUtil.formatStringData(currentBean.getUpdateDatetime(), DateUtil.DATE_YMD));
            fullDialogView.incMiddle.tvPrice.setText(MoneyUtils.formatNum(currentBean.getSalePrice()));
            ImgUtils.loadQiniuImg(this, currentBean.getPic(), fullDialogView.incMiddle.imgProduct);
            fullDialogView.incMiddle.tvSlogan.setText(sbConfig.toString());
        }
        //更新数据

        fullDialogView.ivClose.setOnClickListener(v -> fullBottomDialog.dismiss());

        fullDialogView.btnConfirm.setOnClickListener(v -> {
            String name = fullDialogView.etName.getText().toString();
            String phone = fullDialogView.etPhone.getText().toString();
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone)) {
                UITipDialog.showInfo(this, "请填写个人信息");
                return;
            }
            requerstPrice(name, phone);
        });

        if (!fullBottomDialog.isShowing())
            fullBottomDialog.show();

    }

    /**
     * 询价成功
     */
    private void showBottomSuccerDialog() {
        if (fullBottomSuccerDialog == null) {
            fullBottomSuccerView = DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_inquiry_succer, null, false);
            fullBottomSuccerDialog = new FullBottomDialog(this, fullBottomSuccerView.getRoot());
            fullBottomSuccerView.ivClos.setOnClickListener(v -> fullBottomSuccerDialog.dismiss());
            fullBottomSuccerView.btnConfim.setOnClickListener(v -> {
                EventBus.getDefault().post(new EventFinishAll());
                MainActivity.open(this);
            });
        }
        if (!fullBottomSuccerDialog.isShowing())
            fullBottomSuccerDialog.show();
    }

    /**
     * 获取车的配置
     */
    private void initSettingDatas() {
        //1是带图片的  配置  0是不带图片的配置
        Map<String, String> map = new HashMap<>();
        map.put("carCode", code);
        map.put("isPic", "0");
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarDetailsSetting("630448", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseListCallBack<CarDetailsSettingBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(List<CarDetailsSettingBean> data, String SucMessage) {

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
     * 获取车的配置
     */
    private void initSettingDatas2() {
        //1是带图片的  配置  0是不带图片的配置
        Map<String, String> map = new HashMap<>();
        map.put("carCode", code);
        map.put("isPic", "1");
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarDetailsSetting("630448", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseListCallBack<CarDetailsSettingBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(List<CarDetailsSettingBean> data, String SucMessage) {
                CarDetailsSettingAdapter carDetailsSettingAdapter = new CarDetailsSettingAdapter(data);
                mBinding.rvCarSetting.setLayoutManager(new GridLayoutManager(CarDetailsActivity.this, 4) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
                mBinding.rvCarSetting.setAdapter(carDetailsSettingAdapter);
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
        map.put("userId", SPUtilHelper.getUserId());
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarDetails("630427", StringUtils.getJsonToString(map));

        addCall(call);
        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<CarModelActivityBean.CarsBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(CarModelActivityBean.CarsBean data, String SucMessage) {

                showViewData(data);
                getCarNumber();

                if (!TextUtils.isEmpty(SPUtilHelper.getUserId())) {
                    //如果是未登录状态就不 请求足迹接口了
                    collectionCarAndFootprint("1");
                }

                String advPic = data.getAdvPic();
                if (!TextUtils.isEmpty(advPic)) {
                    String[] split = advPic.split("\\|\\|");
                    mBanners = new ArrayList<>();
                    for (String string : split) {
                        FirstPageBanner bean = new FirstPageBanner();
                        bean.setPic(string);
                        mBanners.add(bean);
                    }
                    mBinding.homeBanner.setImages(mBanners);
                    mBinding.homeBanner.start();
                    mBinding.homeBanner.startAutoPlay();
                }
                //显示上面的配置信息
                List<CarModelActivityBean.CarsBean.CaonfigListBean> caonfigList = data.getCaonfigList();
                if (data != null && caonfigList.size() != 0) {
                    for (int i = 0; i < caonfigList.size(); i++) {
                        CarModelActivityBean.CarsBean.CaonfigListBean.ConfigBean config = caonfigList.get(i).getConfig();

                        if (config != null) {
                            sbConfig.append(config.getName());
                            sbConfig.append(" ");
                        }
                    }
                    if (sbConfig.length() > 0) {
                        sbConfig.deleteCharAt(sbConfig.length() - 1);
                    }
                    mBinding.tvMsg.setText(sbConfig.toString());

                }
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
        if (TextUtils.equals("1", currentBean.getIsCollect())) {
            mBinding.ivCollection.setImageResource(R.mipmap.icon_collection);
        } else {
            mBinding.ivCollection.setImageResource(R.mipmap.icon_un_collection);
        }

        mBinding.tvName.setText(data.getName());

        mBinding.tvPrice.setText(MoneyUtils.formatNum(data.getSalePrice()));
        mBinding.tvProcedures.setText(data.getProcedure());
        mBinding.tvCarLocation.setText(data.getFromPlace());
        mBinding.tvUpDate.setText(DateUtil.formatStringData(data.getUpdateDatetime(), DateUtil.DATE_YMD));

    }

    /**
     * 获取规格的值
     */
    private void getCarNumber() {
        Map<String, String> map = new HashMap<>();
        map.put("parentKey", "car_version");

        showLoadingDialog();
        Call<BaseResponseListModel<DataDictionaryBean>> dataDictionary = RetrofitUtils.createApi(MyApiServer.class).getDataDictionary("630036", StringUtils.getJsonToString(map));
        addCall(dataDictionary);
        dataDictionary.enqueue(new BaseResponseListCallBack<DataDictionaryBean>(this) {
            @Override
            protected void onSuccess(List<DataDictionaryBean> data, String SucMessage) {

                for (DataDictionaryBean item : data) {
                    if (TextUtils.equals(item.getDkey(), currentBean.getVersion())) {
                        levelNumber = item.getDvalue();
                        break;
                    }
                }
                mBinding.tvType.setText(levelNumber + currentBean.getOutsideColor() + " " + currentBean.getInsideColor() + " " + currentBean.getFromPlace());
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    /**
     * 询底价
     */
    private void requerstPrice(String name, String phone) {
        Map map = new HashMap();
        map.put("carCode", carCode);
        map.put("name", name);
        map.put("userId", SPUtilHelper.getUserId());
        map.put("userMobile", phone);

        map.put("periods", "12");//后面这个一个入参是 之前接口遗留的  随便传入一个就好
        map.put("saleDesc", "计算器信息");//后面这个一个入参是 之前接口遗留的  随便传入一个就好
        Call<BaseResponseModel<CommonSuccerBean>> baseResponseModelCall = RetrofitUtils.createApi(MyApiServer.class).requerstPrice("630430", StringUtils.getJsonToString(map));
        baseResponseModelCall.enqueue(new BaseResponseModelCallBack<CommonSuccerBean>(this) {
            @Override
            protected void onSuccess(CommonSuccerBean data, String SucMessage) {
                if (fullBottomDialog != null && fullBottomDialog.isShowing()) {
                    fullBottomDialog.dismiss();
                }
//                UITipDialog.showSuccess(CarDetailsActivity.this, "询价成功");
                showBottomSuccerDialog();
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 检查电话权限
     */
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

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telephone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    /**
     * 获取系统参数 客服电话 弹窗提示是否打电话
     */
    private void getKfPhone() {
        if (TextUtils.isEmpty(telephone)) {
            DataHelper.getSystemKey(this, "kf_phone", new OnSystemKeyListener() {
                @Override
                public void systemKeyValue(List<SystemKeyDataBean.ListBean> list) {
                    if (list == null || list.size() == 0) {
                        UITipDialog.showInfo(CarDetailsActivity.this, "暂无客服电话");
                        return;
                    }
                    telephone = list.get(0).getCvalue();
                    showCallPhoneDialog();
                }
            });
        } else {
            showCallPhoneDialog();
        }
    }

    private void showCallPhoneDialog() {
        new CommonDialog(CarDetailsActivity.this)
                .builder()
                .setTitle("提示").setContentMsg("是否拨打" + telephone)
                .setNegativeBtn("取消", null, false)
                .setPositiveBtn("确定", new CommonDialog.OnPositiveListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPositive(View view) {
                        checkPermission();
                    }
                }).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mBinding != null) {
            mBinding.homeBanner.startAutoPlay();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mBinding != null) {
            mBinding.homeBanner.stopAutoPlay();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
