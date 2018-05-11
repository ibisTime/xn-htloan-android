package com.cdkj.baselibrary.activitys.address;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.R;
import com.cdkj.baselibrary.api.BaseApiServer;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.databinding.ActivityAddAddressBinding;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.AddressModel;
import com.cdkj.baselibrary.model.CodeModel;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.lljjcoder.citypickerview.widget.CityPicker;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 添加修改地址
 * Created by cdkj on 2017/10/13.
 */

public class AddAddressActivity extends AbsBaseLoadActivity {

    private ActivityAddAddressBinding mBinding;

    private boolean isDefault;

    private AddressModel mAddressData;

    private String mProvince;
    private String mCity;
    private String mDistrict;
    private CityPicker cityPicker;


    /**
     * @param context
     * @param data    地址数据
     */
    public static void open(Context context, AddressModel data, boolean isDefault) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, AddAddressActivity.class);

        intent.putExtra("data", data);

        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_add_address, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.add_address));
        if (getIntent() != null) {
            mAddressData = getIntent().getParcelableExtra("data");
            isDefault = getIntent().getBooleanExtra("isDefault", false);
        }

        initListener();

        setShowData();

        initDefalutAddressInfo();

    }

    /**
     * 设置传递过来的数据
     */
    private void setShowData() {

        if (mAddressData == null) {
            return;
        }
        isDefault = mAddressData.isDefaultAddress();
        mProvince = mAddressData.getProvince();
        mCity = mAddressData.getCity();
        mDistrict = mAddressData.getDistrict();
        mBinding.txtAddress.setText(mAddressData.getProvince() + " " + mAddressData.getCity() + " " + mAddressData.getDistrict());
        mBinding.edtName.setText(mAddressData.getAddressee());
        mBinding.edtPhone.setText(mAddressData.getMobile());
        mBinding.edtDetailed.setText(mAddressData.getDetailAddress());


    }

    private void initListener() {

        mBinding.linAddressDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cityPicker == null) {
                    initCityPicker();
                }
                cityPicker.show();
            }
        });

        mBinding.txtConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(mBinding.edtName.getText().toString())) {
                    UITipDialog.showFall(AddAddressActivity.this, getString(R.string.please_input_name));
                    return;
                }

                if (TextUtils.isEmpty(mBinding.edtPhone.getText().toString())) {
                    UITipDialog.showFall(AddAddressActivity.this, getString(R.string.please_input_phone));
                    return;
                }

                if (!StringUtils.isMobileExact(mBinding.edtPhone.getText().toString())) {
                    UITipDialog.showFall(AddAddressActivity.this, getString(R.string.please_input_phone_2));
                    return;
                }

                if (TextUtils.isEmpty(mBinding.txtAddress.getText().toString())) {
                    UITipDialog.showFall(AddAddressActivity.this, getString(R.string.please_select_city));
                    return;
                }

                if (TextUtils.isEmpty(mBinding.edtDetailed.getText().toString())) {
                    UITipDialog.showFall(AddAddressActivity.this, getString(R.string.please_input_address));
                    return;
                }

                if (mAddressData != null) {  //编辑地址
                    editAddressRequest();
                } else {                     //新增地址
                    addAressRequest();
                }

            }
        });

    }


    private void initCityPicker() {

        cityPicker = new CityPicker.Builder(AddAddressActivity.this)
                .textSize(18)
                .titleBackgroundColor("#ffffff")
                .titleTextColor("#ffffff")
                .backgroundPop(0xa0000000)
                .confirTextColor("#48b0fb")
                .cancelTextColor("#48b0fb")
                .province(mProvince)
                .city(mCity)
                .district(mDistrict)
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();


        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                mProvince = citySelected[0];
                //城市
                mCity = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                mDistrict = citySelected[2];
                //邮编
                String code = citySelected[3];

                mBinding.txtAddress.setText(mProvince + " " + mCity + " " + mDistrict);
            }

            @Override
            public void onCancel() {

            }
        });
    }

    /**
     * 初始化选择框默认地址
     */
    public void initDefalutAddressInfo() {

        if (!TextUtils.isEmpty(mProvince) && !TextUtils.isEmpty(mCity) && !TextUtils.isEmpty(mDistrict)) {

        } else {
            mProvince = getString(R.string.select_province_def);
            mCity = getString(R.string.select_city_def);
            mDistrict = getString(R.string.select_district_def);
        }
    }

    /**
     * 添加地址请求
     */
    private void addAressRequest() {

        Map<String, String> object = new HashMap<>();

        if (isDefault) {
            object.put("isDefault", "1");
        } else {
            object.put("isDefault", "0");
        }
        object.put("userId", SPUtilHelpr.getUserId());
        object.put("addressee", mBinding.edtName.getText().toString().trim());
        object.put("mobile", mBinding.edtPhone.getText().toString().trim());
        object.put("province", mProvince);
        object.put("city", mCity);
        object.put("district", mDistrict);
        object.put("detailAddress", mBinding.edtDetailed.getText().toString().trim());
        object.put("token", SPUtilHelpr.getUserToken());
        object.put("systemCode", MyCdConfig.SYSTEMCODE);

        Call call = RetrofitUtils.createApi(BaseApiServer.class).AddAddress("805160", StringUtils.getJsonToString(object));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<CodeModel>(this) {

            @Override
            protected void onSuccess(CodeModel data, String SucMessage) {

                showToast(getString(R.string.add_address_succ));

                finish();
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(AddAddressActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


    private void editAddressRequest() {
        Map<String, String> object = new HashMap<>();
        if (isDefault) {
            object.put("isDefault", "1");
        } else {
            object.put("isDefault", "0");
        }
        object.put("code", mAddressData.getCode());
        object.put("userId", SPUtilHelpr.getUserId());
        object.put("addressee", mBinding.edtName.getText().toString().trim());
        object.put("mobile", mBinding.edtPhone.getText().toString().trim());
        object.put("province", mProvince);
        object.put("city", mCity);
        object.put("district", mDistrict);
        object.put("detailAddress", mBinding.edtDetailed.getText().toString().trim());
        object.put("token", SPUtilHelpr.getUserToken());
        object.put("systemCode", MyCdConfig.SYSTEMCODE);
        Call call = RetrofitUtils.getBaseAPiService().successRequest("805162", StringUtils.getJsonToString(object));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(this) {

            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                if (data != null && data.isSuccess()) {
                    finish();
                } else {
                    UITipDialog.showFall(AddAddressActivity.this, getString(R.string.add_address_fall));
                }

            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(AddAddressActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


}
