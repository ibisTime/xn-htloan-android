package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.activitys.address.AddAddressActivity;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.NickNameUpdateModel;
import com.cdkj.huatuweitong.bean.UserFragmentBean;
import com.cdkj.huatuweitong.databinding.ActivityNickNameUpdateBinding;

import com.lljjcoder.citypickerview.widget.CityPicker;
import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;

public class NickNameUpdateActivity extends AbsBaseLoadActivity {

    private ActivityNickNameUpdateBinding mBinding;

    private String mProvince;
    private String mCity;
    private String mDistrict;
    private CityPicker cityPicker;

    public static void open(Context context, UserFragmentBean data) {
        if (context != null) {
            Intent intent = new Intent(context, NickNameUpdateActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.activity_nick_name_update, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {


        init();
        initListener();
    }

    private void init() {
        mBaseBinding.titleView.setMidTitle("个人信息");
        mBaseBinding.titleView.setRightTitle(getString(R.string.sure));

        mBinding.etName.setText(SPUtilHelper.getUserName());
        mBinding.etName.setFilters(new NameLengthFilter[]{new NameLengthFilter(16)});
    }

    private void initListener() {
        mBinding.llLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cityPicker == null) {
                    initCityPicker();
                }
                cityPicker.show();
            }
        });
    }


    //确定按钮的点击回调监听
    @Override
    public void topTitleViewRightClick() {
        if (TextUtils.isEmpty(mBinding.etName.getText().toString())) {
            UITipDialog.showInfo(this, getString(R.string.please_input_nick_name));
            return;
        }

        if (TextUtils.isEmpty(mBinding.etRealName.getText().toString())) {
            UITipDialog.showInfo(this, "请输入真实姓名");
            return;
        }

        if (TextUtils.isEmpty(mBinding.etId.getText().toString())) {
            UITipDialog.showInfo(this, "请输入身份证");
            return;
        }

        if (TextUtils.isEmpty(mProvince) || TextUtils.isEmpty(mCity) || TextUtils
                .isEmpty(mDistrict)) {
            UITipDialog.showInfo(this, "请选择省市区");
            return;
        }

        if (TextUtils.isEmpty(mBinding.etAddress.getText().toString())) {
            UITipDialog.showInfo(this, "请输入详细地址");
            return;
        }

        updateNickNameRequest(mBinding.etName.getText().toString());

    }

    private void initCityPicker() {

        cityPicker = new CityPicker.Builder(NickNameUpdateActivity.this)
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

                mBinding.tvLocation.setText(mProvince + " " + mCity + " " + mDistrict);
            }

            @Override
            public void onCancel() {

            }
        });
    }


    /**
     * 更新昵称
     *
     * @param string
     */
    private void updateNickNameRequest(String string) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("nickname", string);
        map.put("realName", mBinding.etRealName.getText().toString());
        map.put("idNo", mBinding.etId.getText().toString());
        map.put("province", mProvince);
        map.put("city", mCity);
        map.put("area", mDistrict);
        map.put("address", mBinding.etAddress.getText().toString());
        map.put("userId", SPUtilHelper.getUserId());
        Call call = RetrofitUtils.getBaseAPiService()
                .successRequest("805084", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(NickNameUpdateActivity.this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {

                NickNameUpdateModel nickNameUpdateModel = new NickNameUpdateModel(); //通知上一页
                nickNameUpdateModel.setName(string);
                EventBus.getDefault().post(nickNameUpdateModel);

                UITipDialog.showSuccess(NickNameUpdateActivity.this,
                        getString(R.string.update_nick_name_succ), dialogInterface -> {
                            SPUtilHelper.saveUserName(string);
                            finish();
                        });
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(NickNameUpdateActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    public class NameLengthFilter implements InputFilter {

        int MAX_EN;
        String regEx = "[\\u4e00-\\u9fa5]";

        public NameLengthFilter(int mAX_EN) {
            super();
            MAX_EN = mAX_EN;
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end,
                Spanned dest, int dstart, int dend) {
            int destCount = dest.toString().length()
                    + getChineseCount(dest.toString());
            int sourceCount = source.toString().length()
                    + getChineseCount(source.toString());
            if (destCount + sourceCount > MAX_EN) {
                int surplusCount = MAX_EN - destCount;
                String result = "";
                int index = 0;
                while (surplusCount > 0) {
                    char c = source.charAt(index);
                    if (isChinest(c + "")) {
                        if (sourceCount >= 2) {
                            result += c;
                        }
                        surplusCount = surplusCount - 2;
                    } else {
                        result += c;
                        surplusCount = surplusCount - 1;
                    }
                    index++;
                }
                return result;
            } else {
                return source;
            }
        }

        private int getChineseCount(String str) {
            int count = 0;
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            while (m.find()) {
                for (int i = 0; i <= m.groupCount(); i++) {
                    count = count + 1;
                }
            }
            return count;
        }

        private boolean isChinest(String source) {
            return Pattern.matches(regEx, source);
        }
    }
}
