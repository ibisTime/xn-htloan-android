package com.cdkj.baselibrary.interfaces;

import android.content.Context;
import android.text.TextUtils;

import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.baselibrary.utils.ToastUtil;

import java.util.HashMap;

import retrofit2.Call;

/**
 * 发送验证码
 * Created by cdkj on 2017/8/8.
 */
public class SendPhoneCoodePresenter {

    private SendCodeInterface mListener;
    private Context mContext;
    private Call call;

    public SendPhoneCoodePresenter(SendCodeInterface view) {
        this.mListener = view;
    }

    //处理登录逻辑
    public void sendCodeRequest(String phone, String bizType, String kind, Context context) {
        this.mContext = context;
        if (TextUtils.isEmpty(phone)) {
            UITipDialog.showFall(context, "请输入手机号");
            return;
        }

        request(phone, bizType, kind);
    }

    /**
     * 请求
     */
    private void request(String phone, String bizType, String kind) {

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("systemCode", MyCdConfig.SYSTEMCODE);
        hashMap.put("companyCode", MyCdConfig.COMPANYCODE);
        hashMap.put("mobile", phone);
        hashMap.put("bizType", bizType);

        call = RetrofitUtils.getBaseAPiService().successRequest("805950", StringUtils.getJsonToString(hashMap));

        mListener.StartSend();
        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(mContext) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                if (data.isSuccess()) {
                    mListener.CodeSuccess("验证码已经发送请注意查收");
                } else {
                    mListener.CodeFailed("", "验证码发送失败");
                }
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                mListener.CodeFailed(errorCode, errorMessage);
            }


            @Override
            protected void onNoNet(String msg) {
                ToastUtil.show(mContext, msg);
            }

            @Override
            protected void onFinish() {
                mListener.EndSend();
            }
        });
    }

    //处理持有对象
    public void clear() {
        if (this.call != null) {
            this.call.cancel();
            this.call = null;
        }
        this.mListener = null;
        this.mContext = null;
    }


}
