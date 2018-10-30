package com.cdkj.huatuweitong.module.user.zx;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bigkoo.pickerview.OptionsPickerView;
import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.SBAreaListBean;
import com.cdkj.huatuweitong.bean.ZXSuccessBean;
import com.cdkj.huatuweitong.databinding.ActivityZxgjjBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class ZXGJJActivity extends AbsBaseLoadActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_zxgjj);
//
// }

    ActivityZxgjjBinding mBinding;
    public List<SBAreaListBean> addressList;//地区列表
    private int options;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXGJJActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxgjj, null, false);
        mBinding.rMLArea.requestFocus();
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("公积金");
        initOnClick();
    }

    private void initOnClick() {
        mBinding.btnConfirm.setOnClickListener(v -> {
            if (check()) {
                submit();
            }
        });

        mBinding.rMLArea.setOnClickListener(v -> {
            if (addressList != null) {
                shoAddressDialog();
                return;
            }

            Call<BaseResponseListModel<SBAreaListBean>> zxsbArea = RetrofitUtils.createApi(MyApiServer.class).getZXSBArea("632928", "{}");
            showLoadingDialog();
            zxsbArea.enqueue(new BaseResponseListCallBack<SBAreaListBean>(this) {
                @Override
                protected void onSuccess(List<SBAreaListBean> data, String SucMessage) {
                    addressList = data;
                    shoAddressDialog();
                }

                @Override
                protected void onFinish() {
                    disMissLoading();
                }
            });
        });
    }

    /**
     * 显示地区的选择的弹窗
     */
    private void shoAddressDialog() {
        OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                options = options1;
                mBinding.rMLArea.setTextCenter(addressList.get(options1).getAreaName());
            }
        }).build();
        pickerView.setPicker(addressList);
        pickerView.setSelectOptions(options);
        pickerView.show();
    }


    private boolean check() {
        if (TextUtils.isEmpty(SPUtilHelper.getIdCarde())) {
            UITipDialog.showInfo(this, "请先去进行实名认证");
            return false;
        }
        if (addressList == null || addressList.size() == 0) {
            UITipDialog.showInfo(this, "请选择地区");
            return false;
        }

        if (TextUtils.isEmpty(mBinding.myELUsername.check())) {
//            UITipDialog.showInfo(this, "请填写账号");
            return false;
        }
        if (TextUtils.isEmpty(mBinding.myELRealName.check())) {
//            UITipDialog.showInfo(this, "请填写姓名");
            return false;
        }

        if (TextUtils.isEmpty(mBinding.myELPassword.check())) {
            UITipDialog.showInfo(this, "请填写密码");
            return false;
        }
        return true;
    }

    private void submit() {
        Map map = new HashMap<String, String>();
        map.put("area", addressList.get(options).getAreaCode());//	地区
        map.put("otherInfo", mBinding.myELOtherInfo.getText());//其他信息 选填
        map.put("password", mBinding.myELPassword.getText());//密码
        map.put("realName", mBinding.myELRealName.getText());//真实姓名
        map.put("username", mBinding.myELUsername.getText());//账号
        map.put("idNo", SPUtilHelper.getIdCarde());//身份证从用详情中取
        map.put("customerName", SPUtilHelper.getRealName());//姓名从用详情中取
        Call<BaseResponseModel<String>> zxid = RetrofitUtils.createApi(MyApiServer.class).getZXRZ2("632930", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<String>(this) {
            @Override
            protected void onSuccess(String data, String SucMessage) {
                ZXSuccessBean zxSuccessBean = JSON.parseObject(data, new TypeReference<ZXSuccessBean>() {
                });
                if (zxSuccessBean == null) {
                    UITipDialog.showInfo(ZXGJJActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(zxSuccessBean.getCode(), "0010")) {
                    UITipDialog.showSuccess(ZXGJJActivity.this, "成功", dialog -> finish());
                } else {
                    UITipDialog.showInfo(ZXGJJActivity.this, zxSuccessBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
