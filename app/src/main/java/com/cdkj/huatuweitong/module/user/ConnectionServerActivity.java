package com.cdkj.huatuweitong.module.user;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.CommonDialog;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityConnectionServerBinding;

public class ConnectionServerActivity extends AbsBaseLoadActivity {
    private ActivityConnectionServerBinding mBinding;


    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ConnectionServerActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public View addMainView() {
//        ActivityConn
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_connection_server, null, false);
        return mBinding.getRoot();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("客服");
        mBinding.btnCall.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:123"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
//            showCallPhoneDialog();
        });
        mBinding.btnCancel.setOnClickListener(v -> finish());
    }

    private void showCallPhoneDialog() {
        new CommonDialog(ConnectionServerActivity.this)
                .builder()
                .setTitle("提示").setContentMsg("是否拨打客服电话")
                .setNegativeBtn("取消", null, false)
                .setPositiveBtn("确定", new CommonDialog.OnPositiveListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPositive(View view) {

                    }
                }).show();
    }
}
