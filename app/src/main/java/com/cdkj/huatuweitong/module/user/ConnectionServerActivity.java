package com.cdkj.huatuweitong.module.user;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.CommonDialog;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.SystemKeyDataBean;
import com.cdkj.baselibrary.utils.PermissionHelper;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityConnectionServerBinding;
import com.cdkj.huatuweitong.utlis.DataHelper;
import com.cdkj.huatuweitong.utlis.OnSystemKeyListener;

import java.util.List;

public class ConnectionServerActivity extends AbsBaseLoadActivity {
    private ActivityConnectionServerBinding mBinding;
    private String telephone;

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
        initOnClick();
        getData();
    }

    private void initOnClick() {
        mBinding.btnCall.setOnClickListener(v -> {
            if (TextUtils.isEmpty(telephone)) {
                UITipDialog.showInfo(this, "暂无客服电话");
                return;
            }
            checkPermission();
        });
        mBinding.btnCancel.setOnClickListener(v -> finish());
    }

    private void getData() {
        DataHelper.getSystemKey(this, "telephone", new OnSystemKeyListener() {
            @Override
            public void systemKeyValue(List<SystemKeyDataBean.ListBean> list) {
                if (list == null || list.size() == 0) {
                    mBinding.tvTelephone.setText("暂无客服电话");
                    return;
                }
                telephone = list.get(0).getCvalue();
                mBinding.tvTelephone.setText(telephone);

            }
        });
    }

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
                    UITipDialog.showInfo(ConnectionServerActivity.this, "请到设置中打开电话权限");
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
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
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
