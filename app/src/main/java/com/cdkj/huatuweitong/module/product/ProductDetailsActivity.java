package com.cdkj.huatuweitong.module.product;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.OrderSubmitIntentBean;
import com.cdkj.huatuweitong.bean.RecommendProductBean;
import com.cdkj.huatuweitong.common.GlideImageLoader;
import com.cdkj.huatuweitong.databinding.ActivityProductDetailsBinding;
import com.cdkj.huatuweitong.databinding.DialogCommodityDetailsCheckBinding;
import com.cdkj.huatuweitong.dialog.FullBottomDialog;
import com.cdkj.huatuweitong.module.mfirst_page.OrderSubmitActivity;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * Created by cdkj on 2018/5/17.
 */

public class ProductDetailsActivity extends AbsBaseLoadActivity {

    private ActivityProductDetailsBinding mBinding;

    private String productCode;//产品编号
    private FullBottomDialog productDialog;
    private DialogCommodityDetailsCheckBinding dialogBinding;

    private RecommendProductBean recommendProductBean; //产品数据

    private RecommendProductBean.ProductSpecsListBean specsListBean;//用户选择的规格

    private List<TextView> specViewList = new ArrayList<>();


    /**
     * @param context
     * @param productCode
     */
    public static void open(Context context, String productCode) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, ProductDetailsActivity.class);
        intent.putExtra(CdRouteHelper.DATASIGN, productCode);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_product_details, null, false);
        return mBinding.getRoot();
    }


    @Override
    public void afterCreate(Bundle savedInstanceState) {
        if (getIntent() != null) {
            productCode = getIntent().getStringExtra(CdRouteHelper.DATASIGN);
        }

        mBaseBinding.titleView.setMidTitle(getString(R.string.product_details));
        initBanner();
        getProductDetails();
        initListener();
    }

    private void initListener() {
        mBinding.buttomLayout.btnYes.setOnClickListener(v -> {

            if (productDialog == null) {
                dialogBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_commodity_details_check, null, false);
                dialogBinding.ivClose.setOnClickListener(v1 -> productDialog.dismiss());
                dialogBinding.buttomLayout.btnYes.setOnClickListener(v1 -> {

                    if (specsListBean == null) {
                        UITipDialog.showInfo(ProductDetailsActivity.this, getString(R.string.please_select_product_spec));
                        return;
                    }

                    if (specsListBean.getQuantity() <= 0) {
                        UITipDialog.showInfo(ProductDetailsActivity.this, getString(R.string.no_product));
                        return;
                    }

                    if (!SPUtilHelpr.isLogin(ProductDetailsActivity.this, false)) {
                        return;
                    }

                    productDialog.dismiss();

                    OrderSubmitIntentBean orderSubmitIntentBean = new OrderSubmitIntentBean(recommendProductBean.getName(), recommendProductBean.getPrice(), recommendProductBean.getAdvPic(), specsListBean);

                    OrderSubmitActivity.open(ProductDetailsActivity.this, orderSubmitIntentBean);

                });
                setDialogData(recommendProductBean);
                productDialog = new FullBottomDialog(this, dialogBinding.getRoot());
            }
            productDialog.show();
        });
    }

    /**
     *
     */
    private void getProductDetails() {

        if (TextUtils.isEmpty(productCode)) return;

        Map<String, String> map = new HashMap<>();

        map.put("code", productCode);


        Call<BaseResponseModel<RecommendProductBean>> call = RetrofitUtils.createApi(MyApiServer.class).getRecommentdProductDetails("808026", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<RecommendProductBean>(this) {
            @Override
            protected void onSuccess(RecommendProductBean data, String SucMessage) {
                recommendProductBean = data;
                setShowData(data);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


    private void initBanner() {
        mBinding.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBinding.banner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.banner.setImageLoader(new GlideImageLoader());

    }


    /**
     * 设置广告数据
     */
    private void setBannerData(List<String> bannsers) {
        mBinding.banner.setImages(bannsers);
        mBinding.banner.start();
        mBinding.banner.startAutoPlay();
    }

    /**
     * 设置显示数据
     *
     * @param data
     */
    public void setShowData(RecommendProductBean data) {
        if (data == null) return;
        setBannerData(StringUtils.splitAsPicList(data.getAdvPic()));
        mBinding.tvProductName.setText(data.getName());
        mBinding.tvProductPrice.setText(MoneyUtils.getShowPriceSign(data.getPrice()));

        mBinding.web.loadData(data.getDescription(), "text/html;charset=UTF-8", "UTF-8");

        if (data.getProductSpecsList() != null && data.getProductSpecsList().size() > 0) {
            RecommendProductBean.ProductSpecsListBean productSpecsListBean = data.getProductSpecsList().get(0);
            mBinding.buttomLayout.tvMouthMoney.setText(MoneyUtils.showPrice(productSpecsListBean.getMonthAmount()) + "X" + productSpecsListBean.getPeriods() + "期");
        }

    }

    /**
     * 设置dialog显示数据
     *
     * @param data
     */
    public void setDialogData(RecommendProductBean data) {
        if (data == null) return;

        ImgUtils.loadQiniuImg(this, StringUtils.getAsPicListIndexOne(data.getAdvPic()), dialogBinding.ivImg);
        dialogBinding.tvName.setText(data.getName());
        dialogBinding.tvPrice.setText(MoneyUtils.getShowPriceSign(data.getPrice()));

        if (data.getProductSpecsList() != null && data.getProductSpecsList().size() > 0) {
            RecommendProductBean.ProductSpecsListBean productSpecsListBean = data.getProductSpecsList().get(0);
            dialogBinding.buttomLayout.tvMouthMoney.setText(MoneyUtils.showPrice(productSpecsListBean.getMonthAmount()) + "X" + productSpecsListBean.getPeriods() + "期");
        }

        /*添加包装*/
        if (data.getProductSpecsList() != null) {

            int i = -1;
            for (RecommendProductBean.ProductSpecsListBean productSpecsListBean : data.getProductSpecsList()) {
                if (productSpecsListBean == null) continue;
                i++;

                TextView tv2 = new TextView(ProductDetailsActivity.this);
                tv2.setText(productSpecsListBean.getName());
                tv2.setBackgroundResource(R.drawable.product_spce_bg_waite);
                tv2.setPadding(15, 2, 15, 2);
                tv2.setTag(i);
                tv2.setOnClickListener(v -> {
                    specViewStateChange((Integer) v.getTag());
                });

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                layoutParams.setMargins(0, 15, 30, 15);
                tv2.setTextColor(ContextCompat.getColor(ProductDetailsActivity.this, R.color.text_black_cd));
                specViewList.add(tv2);
                dialogBinding.flexboxSpec.addView(tv2, layoutParams);
            }
        }
    }


    /**
     * 规格点击
     *
     * @param position
     */
    private void specViewStateChange(int position) {
        if (recommendProductBean == null || recommendProductBean.getProductSpecsList() == null) {
            return;
        }
        int i = 0;
        for (TextView textView : specViewList) {
            if (position == i) {
                textView.setBackgroundResource(R.drawable.product_spce_bg_blue);
                textView.setTextColor(ContextCompat.getColor(ProductDetailsActivity.this, R.color.white));
                specsListBean = recommendProductBean.getProductSpecsList().get(i);
                int quantity = specsListBean.getQuantity();
                if (quantity <= 0) {
                    dialogBinding.tvXianhuo.setText("缺货");
                } else {
                    dialogBinding.tvXianhuo.setText("现货");
                }
                dialogBinding.buttomLayout.tvMouthMoney.setText(MoneyUtils.showPrice(specsListBean.getMonthAmount()) + "X" + specsListBean.getPeriods() + "期");
            } else {
                textView.setTextColor(ContextCompat.getColor(ProductDetailsActivity.this, R.color.text_black_cd));
                textView.setBackgroundResource(R.drawable.product_spce_bg_waite);
            }
            i++;
        }

    }


    @Override
    public void onDestroy() {
        if (mBinding != null) {
            mBinding.banner.stopAutoPlay();
        }
        super.onDestroy();
    }

}
