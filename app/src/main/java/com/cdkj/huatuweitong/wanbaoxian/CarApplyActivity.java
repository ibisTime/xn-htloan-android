package com.cdkj.huatuweitong.wanbaoxian;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.opengl.Visibility;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.cdkj.baselibrary.activitys.ImageSelectActivity;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.CodeModel;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.*;
import com.cdkj.huatuweitong.MainActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarBean;
import com.cdkj.huatuweitong.databinding.ActBaoxianAskBinding;
import com.cdkj.huatuweitong.module.mfirst_page.CarBrandActivity;
import com.cdkj.huatuweitong.module.mfirst_page.CarLoanCalculator2Activity;
import com.cdkj.huatuweitong.wanshouhou.ShouhouIssueActivity;
import org.greenrobot.eventbus.Subscribe;
import retrofit2.Call;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : qianLei
 * @since : 2019/11/4 20:21
 */
public class CarApplyActivity extends AbsBaseLoadActivity {

    private ActBaoxianAskBinding mBinding;

    private int FRONT = 111;
    private int BACK = 112;

    private String openType;
    public static String FENQI = "0";
    public static String BAOXIAN = "1";

    private String carCode;
    private String xszFront;
    private String xszReverse;

    public static void open(Context context, String openType) {
        Intent intent = new Intent(context, CarApplyActivity.class);
        intent.putExtra(CdRouteHelper.DATASIGN, openType);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.act_baoxian_ask, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {



        init();
        initListener();
    }

    private void init() {

        openType = getIntent().getStringExtra(CdRouteHelper.DATASIGN);

        if (BAOXIAN.equals(openType)) {
            mBinding.llXsz.setVisibility(View.VISIBLE);
            mBaseBinding.titleView.setMidTitle("车险咨询");
        }else {
            mBaseBinding.titleView.setMidTitle("分期申请");
        }
    }

    private void initListener() {
        mBinding.tvCar.setOnClickListener(view -> {
            CarBrandActivity.open(this, true);
        });

        mBinding.ivQian.setOnClickListener(view -> {
            ImageSelectActivity.launch(this, FRONT, false);
        });

        mBinding.ivQianDelete.setOnClickListener(view -> {
            xszFront = "";
            mBinding.ivQian.setImageResource(0);
            mBinding.ivQian.setBackgroundResource(R.mipmap.baoxian_qian);
            mBinding.ivQianDelete.setVisibility(View.GONE);
            mBinding.ivQianPai.setVisibility(View.VISIBLE);
        });

        mBinding.ivHou.setOnClickListener(view -> {
            ImageSelectActivity.launch(this, BACK, false);
        });

        mBinding.ivHouDelete.setOnClickListener(view -> {
            xszReverse = "";
            mBinding.ivHou.setImageResource(0);
            mBinding.ivHou.setBackgroundResource(R.mipmap.baoxian_qian);
            mBinding.ivHouDelete.setVisibility(View.GONE);
            mBinding.ivHouPai.setVisibility(View.VISIBLE);
        });

        mBinding.btnConfirm.setOnClickListener(view -> {
            if (check()) {
                apply();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) {
            return;
        }

        String path = data.getStringExtra(CameraHelper.staticPath);

        LogUtil.E("拍照获取路径" + path);
        showLoadingDialog();
        new QiNiuHelper(this).uploadSinglePic(new QiNiuHelper.QiNiuCallBack() {
            @Override
            public void onSuccess(String key) {

                if (requestCode == FRONT) {
                    xszFront = key;
                    ImgUtils.loadQiniuImg(CarApplyActivity.this, xszFront, mBinding.ivQian);
                    mBinding.ivQianDelete.setVisibility(View.VISIBLE);
                    mBinding.ivQianPai.setVisibility(View.GONE);
                } else {
                    xszReverse = key;
                    ImgUtils.loadQiniuImg(CarApplyActivity.this, xszReverse, mBinding.ivHou);
                    mBinding.ivHouDelete.setVisibility(View.VISIBLE);
                    mBinding.ivHouPai.setVisibility(View.GONE);
                }
                disMissLoading();
            }

            @Override
            public void onFal(String info) {
                UITipDialog.showFall(CarApplyActivity.this, "图片上传失败");
                disMissLoading();
            }
        }, path);

    }

    private boolean check() {

        if (TextUtils.isEmpty(mBinding.edtName.getText().toString())) {
            ToastUtil.show(this, "请填写姓名");
            return false;
        }

        if (TextUtils.isEmpty(mBinding.edtMobile.getText().toString())) {
            ToastUtil.show(this, "请填写电话");
            return false;
        }

        if (TextUtils.isEmpty(carCode)) {
            ToastUtil.show(this, "请选择车型");
            return false;
        }

        if (BAOXIAN.equals(openType)) {

            if (TextUtils.isEmpty(xszFront)) {
                ToastUtil.show(this, "请上传行驶证正面照片");
                return false;
            }

            if (TextUtils.isEmpty(xszReverse)) {
                ToastUtil.show(this, "请上传行驶证正面照片");
                return false;
            }

        }

        return true;
    }

    private void apply() {

        Map<String, String> object = new HashMap<>();

        object.put("userId", SPUtilHelper.getUserId());
        object.put("token", SPUtilHelper.getUserToken());
        object.put("name", mBinding.edtName.getText().toString());
        object.put("userMobile", mBinding.edtMobile.getText().toString());
        object.put("carCode", carCode);

        String code;
        if (BAOXIAN.equals(openType)) {
            code = "630433";
            object.put("xszFront", xszFront);
            object.put("xszReverse", xszReverse);
        } else {
            code = "630430";
        }

        Call call = RetrofitUtils.getBaseAPiService()
                .codeRequest(code, StringUtils.getJsonToString(object));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<CodeModel>(this) {

            @Override
            protected void onSuccess(CodeModel data, String SucMessage) {
                UITipDialog.showSuccess(CarApplyActivity.this, "提交成功", dialogInterface -> {
                    finish();
                });
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 接受车型数据
     *
     * @param bean
     */
    @Subscribe
    public void breakCarModelActivityBean(CarBean bean) {

        carCode = bean.getCode();
        mBinding.tvCar.setText(bean.getBrandName() + bean.getName());//车型
    }
}
