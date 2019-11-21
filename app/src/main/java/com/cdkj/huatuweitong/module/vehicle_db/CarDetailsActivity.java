package com.cdkj.huatuweitong.module.vehicle_db;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;

import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.cdkj.baselibrary.utils.*;
import com.cdkj.huatuweitong.MainActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.*;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.*;
import com.cdkj.huatuweitong.common.GlideFirstPageBannerImageLoader;
import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import com.cdkj.huatuweitong.databinding.ActivityCarDetails2Binding;
import com.cdkj.huatuweitong.databinding.DailogInquiryLayoutBinding;
import com.cdkj.huatuweitong.databinding.DialogInquirySuccerBinding;
import com.cdkj.huatuweitong.dialog.FullBottomDialog;
import com.cdkj.huatuweitong.module.mfirst_page.CarLoanCalculator2Activity;
import com.cdkj.huatuweitong.share.ShareActivity;
import com.cdkj.huatuweitong.utlis.DataHelper;
import com.cdkj.huatuweitong.utlis.OnSystemKeyListener;
import com.google.android.flexbox.FlexboxLayout;
import com.youth.banner.BannerConfig;

import org.greenrobot.eventbus.EventBus;

import java.util.*;

import retrofit2.Call;

public class CarDetailsActivity extends AbsBaseLoadActivity {

    private FullBottomDialog fullBottomDialog;
    private DailogInquiryLayoutBinding fullDialogView;
    private ActivityCarDetails2Binding mBinding;
    private String code;
    private String carCode;
    private CarBean currentBean;
    private ArrayList<FirstPageBanner> mBanners;
    private StringBuilder sbConfig = new StringBuilder();
    private String telephone;
    private String levelNumber = "";//规格的值
    private FullBottomDialog fullBottomSuccerDialog;
    private DialogInquirySuccerBinding fullBottomSuccerView;

    private List<DataDictionaryBean> list = new ArrayList<>();

    public static void open(Context context, String code) {
        Intent intent = new Intent(context, CarDetailsActivity.class);
        intent.putExtra("code", code);
        context.startActivity(intent);
    }

    @Override
    protected boolean canLoadTopTitleView() {
        return false;
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.activity_car_details2, null, false);



        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        if (getIntent() != null) {
            code = getIntent().getStringExtra("code");
        }

        initDatas();
        initBanner();
        initConfigDatas();

//        initSettingDatas();
//        initSettingDatas2();
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

        mBinding.llCalculator.setOnClickListener(v -> {
            CarLoanCalculator2Activity.open(this, currentBean);
        });

        mBinding.llMerchant.setOnClickListener(view -> {

            if (currentBean.getCarDealer() != null) {
                CarMerchantDetailActivity.open(this, currentBean.getCarDealer().getCode());
            }

        });

        mBinding.flLike.setOnClickListener(view -> {
            if (!SPUtilHelper.isLogin(this, false)) {
                return;
            }
            if (TextUtils.equals("1", currentBean.getIsCollect())) {
                cancelCollectionCarAndFootprint();
            } else {
                collectionCarAndFootprint("3");
            }
        });

        mBinding.flShare.setOnClickListener(view -> {
            ShareActivity.open(CarDetailsActivity.this,
                    "http://h5.htwt.hichengdai.com/vehicleDetail?code=" + code, "分享", "欢迎使用会玩车");
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
        if (TextUtils.isEmpty(carCode)) {
            return;
        }
        Map map = new HashMap<String, String>();
        map.put("creater", SPUtilHelper.getUserId());
        map.put("toCode", carCode);
        map.put("toType", "0");//0 车，1 资讯
        map.put("type", type);//0 分享，1 足迹，2 关注，3 收藏，4 点赞
        Call<BaseResponseModel<CollectionBean>> collection = RetrofitUtils
                .createApi(MyApiServer.class)
                .collection("630460", StringUtils.getJsonToString(map));
        showLoadingDialog();
        collection.enqueue(new BaseResponseModelCallBack<CollectionBean>(this) {
            @Override
            protected void onSuccess(CollectionBean data, String SucMessage) {
                if (TextUtils.equals("3", type)) {
                    UITipDialog.showSuccess(CarDetailsActivity.this, "收藏成功");
                    currentBean.setIsCollect("1");
                    mBinding.ivLike.setImageResource(R.mipmap.icon_collection);
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
        if (TextUtils.isEmpty(carCode)) {
            return;
        }
        Map map = new HashMap();
        map.put("carCode", currentBean.getCode());
        map.put("userId", SPUtilHelper.getUserId());
        Call<BaseResponseModel<CollectionBean>> collection = RetrofitUtils
                .createApi(MyApiServer.class)
                .collection("630462", StringUtils.getJsonToString(map));
        showLoadingDialog();
        collection.enqueue(new BaseResponseModelCallBack<CollectionBean>(this) {
            @Override
            protected void onSuccess(CollectionBean data, String SucMessage) {
                UITipDialog.showSuccess(CarDetailsActivity.this, "取消收藏");
                currentBean.setIsCollect("0");
                mBinding.ivLike.setImageResource(R.mipmap.icon_un_collection);
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
            fullDialogView = DataBindingUtil
                    .inflate(getLayoutInflater(), R.layout.dailog_inquiry_layout, null, false);
            fullBottomDialog = new FullBottomDialog(this, fullDialogView.getRoot());
            fullDialogView.incMiddle.tvProductTitle.setText(currentBean.getName());
            fullDialogView.incMiddle.tvType.setText(
                    levelNumber + " 外观:" + currentBean.getOutsideColor() + " 内饰" + currentBean
                            .getInsideColor() + " " + currentBean.getFromPlace());
            fullDialogView.incMiddle.tvDate.setText(
                    DateUtil.formatStringData(currentBean.getUpdateDatetime(), DateUtil.DATE_YMD));
            fullDialogView.incMiddle.tvPrice
                    .setText(MoneyUtils.formatNum(currentBean.getSalePrice()));
            ImgUtils.loadQiniuImg(this, currentBean.getPic(), fullDialogView.incMiddle.imgProduct);

            fullDialogView.incMiddle.tvSlogan.setVisibility(View.VISIBLE);
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

        if (!fullBottomDialog.isShowing()) {
            fullBottomDialog.show();
        }

    }

    /**
     * 询价成功
     */
    private void showBottomSuccerDialog() {
        if (fullBottomSuccerDialog == null) {
            fullBottomSuccerView = DataBindingUtil
                    .inflate(getLayoutInflater(), R.layout.dialog_inquiry_succer, null, false);
            fullBottomSuccerDialog = new FullBottomDialog(this, fullBottomSuccerView.getRoot());
            fullBottomSuccerView.ivClos.setOnClickListener(v -> fullBottomSuccerDialog.dismiss());
            fullBottomSuccerView.btnConfim.setOnClickListener(v -> {
                EventBus.getDefault().post(new EventFinishAll());
                MainActivity.open(this);
            });
        }
        if (!fullBottomSuccerDialog.isShowing()) {
            fullBottomSuccerDialog.show();
        }
    }

    /**
     * 获取车的配置
     */
    private void initConfigDatas() {
        //1是带图片的  配置  0是不带图片的配置
        Map<String, String> map = new HashMap<>();
        map.put("carCode", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarDetailsSetting("630448", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseListCallBack<CarDetailsSettingBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(List<CarDetailsSettingBean> data, String SucMessage) {

                for (CarDetailsSettingBean bean : data) {

                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                            FlexboxLayout.LayoutParams.WRAP_CONTENT,
                            DisplayHelper.dp2px(CarDetailsActivity.this, 25));
                    layoutParams.bottomMargin = DisplayHelper.dp2px(CarDetailsActivity.this, 10);
                    layoutParams.rightMargin = DisplayHelper.dp2px(CarDetailsActivity.this, 10);
                    TextView textView = createText(bean.getConfig().getName());

                    mBinding.flexLayout.addView(textView, layoutParams);

                }

            }

            @Override
            protected void onFinish() {

            }
        });

    }

    /**
     * 根据文本创建TextView用于显示助记词
     *
     * @param word
     */
    public TextView createText(String word) {

        TextView textView = new TextView(this);
        textView.setText("  " + word + "  ");
        textView.setTextSize(12f);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.parseColor("#666666"));
        textView.setBackgroundResource(R.drawable.shape_car_config);
        textView.setPadding(10, 0,
                10, 0);

        return textView;

    }

    /**
     * 获取车的配置
     */
    private void initSettingDatas() {
        //1是带图片的  配置  0是不带图片的配置
        Map<String, String> map = new HashMap<>();
        map.put("carCode", code);
        map.put("isPic", "0");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarDetailsSetting("630448", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseListCallBack<CarDetailsSettingBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(List<CarDetailsSettingBean> data, String SucMessage) {

                CarDetailsSettingAllAdapter carDetailsSettingAllAdapter = new CarDetailsSettingAllAdapter(
                        data);
                mBinding.rvCarSettingAll
                        .setLayoutManager(new GridLayoutManager(CarDetailsActivity.this, 2) {
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
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarDetailsSetting("630448", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseListCallBack<CarDetailsSettingBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(List<CarDetailsSettingBean> data, String SucMessage) {
                CarDetailsSettingAdapter carDetailsSettingAdapter = new CarDetailsSettingAdapter(
                        data);
                mBinding.rvCarSetting
                        .setLayoutManager(new GridLayoutManager(CarDetailsActivity.this, 4) {
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
        map.put("token", SPUtilHelper.getUserToken());
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarDetails("630427", StringUtils.getJsonToString(map));

        addCall(call);
        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<CarBean>(CarDetailsActivity.this) {
            @Override
            protected void onSuccess(CarBean data, String SucMessage) {

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
                List<CarBean.CaonfigListBean> caonfigList = data.getCaonfigList();
                if (data != null && caonfigList.size() != 0) {
                    for (int i = 0; i < caonfigList.size(); i++) {
                        CarBean.CaonfigListBean.ConfigBean config = caonfigList.get(i).getConfig();

                        if (config != null) {
                            sbConfig.append(config.getName());
                            sbConfig.append(" ");
                        }
                    }
                    if (sbConfig.length() > 0) {
                        sbConfig.deleteCharAt(sbConfig.length() - 1);
                    }


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
    private void showViewData(CarBean data) {
        this.currentBean = data;
        carCode = data.getCode();
        if (TextUtils.equals("1", currentBean.getIsCollect())) {
            mBinding.ivLike.setImageResource(R.mipmap.icon_collection);
        } else {
            mBinding.ivLike.setImageResource(R.mipmap.icon_un_collection);
        }

        mBinding.tvTitle.setText(data.getName());
        mBinding.tvName.setText(data.getName());

        mBinding.tvPrice.setText(MoneyUtils.formatNum(data.getSalePrice()));
        mBinding.tvMonthAmount.setText(MoneyUtils.formatNum(data.getMonthAmount()));
        mBinding.tvProcedures.setText(data.getProcedure());
        mBinding.tvCarLocation.setText(data.getFromPlace());
        mBinding.tvUpDate
                .setText(DateUtil.formatStringData(data.getUpdateDatetime(), DateUtil.DATE_YMD));
        mBinding.tvMsg.setText(data.getDescription());

        if (data.getCarDealer() != null) {

            mBinding.llMerchant.setVisibility(View.VISIBLE);

            ImgUtils.loadQiniuImg(this, data.getCarDealer().getShopLogo(),
                    mBinding.ivMerchantAvatar);
            mBinding.tvMerchantName.setText(data.getCarDealer().getFullName());

            getActiveConfig();
            getSelectedData();
        }

    }

    /**
     * 获取规格的值
     */
    private void getCarNumber() {
        Map<String, String> map = new HashMap<>();
        map.put("parentKey", "car_version");

        showLoadingDialog();
        Call<BaseResponseListModel<DataDictionaryBean>> dataDictionary = RetrofitUtils
                .createApi(MyApiServer.class)
                .getDataDictionary("630036", StringUtils.getJsonToString(map));
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
                mBinding.tvType.setText(
                        levelNumber + " 外观:" + currentBean.getOutsideColor() + " 内饰:" + currentBean
                                .getInsideColor() + " " + currentBean.getFromPlace());
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    /**
     * 获取规格的值
     */
    private void getActiveConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("parentKey", "car_news_tag");

        showLoadingDialog();
        Call<BaseResponseListModel<DataDictionaryBean>> dataDictionary = RetrofitUtils
                .createApi(MyApiServer.class)
                .getDataDictionary("630036", StringUtils.getJsonToString(map));
        addCall(dataDictionary);
        dataDictionary.enqueue(new BaseResponseListCallBack<DataDictionaryBean>(this) {
            @Override
            protected void onSuccess(List<DataDictionaryBean> data, String SucMessage) {

                if (data != null) {
                    list.addAll(data);
                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();
                getInformation();
            }
        });

    }

    /**
     * 获取资讯数据
     */
    private void getInformation() {

        Map<String, String> map = new HashMap<>();
        map.put("carDealerCode", currentBean.getCarDealer().getCode());
        map.put("limit", "2");
        map.put("start", "1");
        map.put("status", "1");//0待上架，1已上架，2已下架

        Call<BaseResponseModel<InformationListBean>> information = RetrofitUtils
                .createApi(MyApiServer.class)
                .getInformationList("630455", StringUtils.getJsonToString(map));

        showLoadingDialog();

        information.enqueue(new BaseResponseModelCallBack<InformationListBean>(this) {
            @Override
            protected void onSuccess(InformationListBean data, String SucMessage) {

                InformationAdapter informationAdapter = new InformationAdapter(data.getList(),
                        list);
                informationAdapter.setOnItemClickListener((adapter, view, position) -> {
                    InformationListBean.ListBean item = (InformationListBean.ListBean) adapter
                            .getItem(position);
                    WebViewArticleActivity
                            .open(CarDetailsActivity.this, item.getCode());
                });
                mBinding.rvActive.setAdapter(informationAdapter);
                mBinding.rvActive.setLayoutManager(new LinearLayoutManager(CarDetailsActivity.this,
                        LinearLayoutManager.VERTICAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });

                if (null == data.getList() || 0 == data.getList().size()) {
                    mBinding.llActive.setVisibility(View.GONE);
                } else {
                    mBinding.llActive.setVisibility(View.VISIBLE);
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 获取精选车源数据
     */
    private void getSelectedData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("carDealerCode", currentBean.getCarDealer().getCode());
        map.put("isReferee", "1");
        map.put("start", "1");
        map.put("limit", "200");
        map.put("orderDir", "asc");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarTypePage("630492", StringUtils.getJsonToString(map));
        call.enqueue(
                new BaseResponseModelCallBack<CarSelectPageBean>(this) {

                    @Override
                    protected void onSuccess(CarSelectPageBean data, String SucMessage) {

                        CarTypeListAdapter mAdapter = new CarTypeListAdapter(data.getList());
                        mBinding.rvRecommend
                                .setLayoutManager(new LinearLayoutManager(CarDetailsActivity.this,
                                        LinearLayout.VERTICAL, false) {
                                    @Override
                                    public boolean canScrollVertically() {
                                        return false;
                                    }
                                });
                        mBinding.rvRecommend.setAdapter(mAdapter);

                        mAdapter.setOnItemClickListener((adapter, view, position) -> {

                            CarBean item = (CarBean) adapter
                                    .getItem(position);
                            CarDetailsActivity.open(CarDetailsActivity.this, item.getCode());
                        });

                        if (null == data.getList() || 0 == data.getList().size()) {
                            mBinding.llRecommend.setVisibility(View.GONE);
                        } else {
                            mBinding.llRecommend.setVisibility(View.VISIBLE);
                        }
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
        map.put("token", SPUtilHelper.getUserToken());
        map.put("userMobile", phone);

        map.put("periods", "12");//后面这个一个入参是 之前接口遗留的  随便传入一个就好
        map.put("saleDesc", "计算器信息");//后面这个一个入参是 之前接口遗留的  随便传入一个就好
        Call<BaseResponseModel<CommonSuccerBean>> baseResponseModelCall = RetrofitUtils
                .createApi(MyApiServer.class)
                .requerstPrice("630430", StringUtils.getJsonToString(map));
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
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
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
