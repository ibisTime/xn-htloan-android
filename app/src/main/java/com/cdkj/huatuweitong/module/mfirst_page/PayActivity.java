package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.activitys.PayPwdModifyActivity;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.InputDialog;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.IsSetPayPassWord;
import com.cdkj.huatuweitong.bean.PaySucc;
import com.cdkj.huatuweitong.databinding.ActivityPayBinding;
import com.cdkj.huatuweitong.module.order.AllOrderTabActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class PayActivity extends AbsBaseLoadActivity {

    ActivityPayBinding mBinding;

    private int payType = 3;

    private static final int ALI_PAY = 0;//支付宝
    private static final int WE_PAY = 1;//微信支付

    private static final String PAYMONEY = "1";//支付金额
    private static final String ISLIST = "2";//是否来自支付列表

    private String mOrderCode;//生成的订单code

    private boolean isFromPayList;


    /**
     * @param context
     * @param payMoney 支付金额
     */
    public static void open(Context context, String orderCode, String payMoney, boolean isFromList) {
        if (context != null) {
            Intent intent = new Intent(context, PayActivity.class);
            intent.putExtra(CdRouteHelper.DATASIGN, orderCode);
            intent.putExtra(PAYMONEY, payMoney);
            intent.putExtra(ISLIST, isFromList);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_pay, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.OrderSubmit));

        if (getIntent() != null) {
            mOrderCode = getIntent().getStringExtra(CdRouteHelper.DATASIGN);
            isFromPayList = getIntent().getBooleanExtra(ISLIST, false);
            mBinding.tvPayMoney.setText(getIntent().getStringExtra(PAYMONEY));
        }

        initOnclick();
    }

    private void initOnclick() {
        mBinding.llYue.setOnClickListener(v -> {
            payType = 3;
            mBinding.ivYue.setImageResource(R.mipmap.ic_pay_check);
            mBinding.ivWechat.setImageResource(R.mipmap.ic_pay_uncheck);
            mBinding.ivAli.setImageResource(R.mipmap.ic_pay_uncheck);
        });

        mBinding.llWechat.setOnClickListener(v -> {
            payType = ALI_PAY;
            mBinding.ivYue.setImageResource(R.mipmap.ic_pay_uncheck);
            mBinding.ivWechat.setImageResource(R.mipmap.ic_pay_check);
            mBinding.ivAli.setImageResource(R.mipmap.ic_pay_uncheck);
        });

        mBinding.llAli.setOnClickListener(v -> {
            payType = WE_PAY;
            mBinding.ivYue.setImageResource(R.mipmap.ic_pay_uncheck);
            mBinding.ivWechat.setImageResource(R.mipmap.ic_pay_uncheck);
            mBinding.ivAli.setImageResource(R.mipmap.ic_pay_check);
        });

        mBinding.btnToPay.setOnClickListener(v -> {
            switch (payType) {
                case ALI_PAY:
                    UITipDialog.showInfo(PayActivity.this, "支付宝支付暂未开放");
                    break;
                case WE_PAY:
                    UITipDialog.showInfo(PayActivity.this, "微信支付暂未开放");
                    break;
                default:
                    isSetPayPassWord();
            }

        });
    }

    /**
     * @param payPwd 支付密码
     */
    public void payRequest(String payPwd) {
        /*codeList 编号（必填） array<string> @mock=DD2017083014164562074991
 payType 支付方式（必填） string @mock=1
 tradePwd
*/

        if (TextUtils.isEmpty(mOrderCode) || TextUtils.isEmpty(payPwd)) {
            return;
        }

        Map<String, Object> map = new HashMap<>();
//        List<String> codeList = new ArrayList<>();
//        codeList.add(mOrderCode);
        map.put("code", mOrderCode);
        map.put("payType", "1");//余额支付
        map.put("tradePwd", payPwd);

        showLoadingDialog();

        Call<BaseResponseModel<IsSuccessModes>> call = RetrofitUtils.getBaseAPiService().successRequest("808052", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                if (data.isSuccess()) {
                    UITipDialog.showSuccess(PayActivity.this, "支付成功", dialog -> {

                        EventBus.getDefault().post(new PaySucc());//发送支付成功通知

                        if (!isFromPayList) {
                            AllOrderTabActivity.open(PayActivity.this);
                        }
                        finish();
                    });
                } else {
                    UITipDialog.showFall(PayActivity.this, "支付失败");
                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }


    public void isSetPayPassWord() {

        Map<String, String> map = new HashMap<>();

        map.put("userId", SPUtilHelpr.getUserId());

        Call<BaseResponseModel<IsSetPayPassWord>> call = RetrofitUtils.createApi(MyApiServer.class).isSetPayPassWord("805121", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<IsSetPayPassWord>(this) {
            @Override
            protected void onSuccess(IsSetPayPassWord data, String SucMessage) {

                if (data.isTradepwdFlag()) {
                    showPwdDialog();
                } else {
                    showDoubleWarnListen("您还未设置支付密码,请先设置支付密码", view -> {
                        PayPwdModifyActivity.open(PayActivity.this, false, SPUtilHelpr.getUserPhoneNum());
                    });
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }

    /**
     * 设置显示用户支付密码弹框
     */
    private void showPwdDialog() {

        InputDialog inputDialog = new InputDialog(this).builder().setTitle("支付密码")
                .setPositiveBtn("确定", new InputDialog.OnPositiveListener() {
                    @Override
                    public void onPositive(View view, String inputMsg) {
                        if (TextUtils.isEmpty(inputMsg)) {
                            showToast("请输入密码");
                            return;
                        }
                        payRequest(inputMsg);
                    }
                })
                .setNegativeBtn("取消", null)
                .setContentMsg("");
        inputDialog.getContentView().setHint("请输入支付密码");
        inputDialog.getContentView().setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        inputDialog.show();

    }


}
