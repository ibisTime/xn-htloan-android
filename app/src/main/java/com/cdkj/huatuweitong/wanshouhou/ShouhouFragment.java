package com.cdkj.huatuweitong.wanshouhou;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.PermissionHelper;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MainResourceBean;
import com.cdkj.huatuweitong.bean.SysConfigBean;
import com.cdkj.huatuweitong.databinding.FrgFenqiBinding;
import com.cdkj.huatuweitong.databinding.FrgShouhouBinding;
import com.cdkj.huatuweitong.module.vehicle_db.CarDetailsActivity;
import com.cdkj.huatuweitong.wanshouhou.bean.ShouhouIssueBean;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.cdkj.baselibrary.utils.DateUtil.DEFAULT_DATE_FMT;

/**
 * @author : qianLei
 * @since : 2019/11/4 10:24
 */
public class ShouhouFragment extends BaseLazyFragment {

    private FrgShouhouBinding mBinding;

    private SysConfigBean sysConfigBean;

    public static ShouhouFragment getInstance() {
        ShouhouFragment fragment = new ShouhouFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.frg_shouhou, null, false);

        initListener();

        getData();
        getVideo();

        return mBinding.getRoot();
    }

    private void initListener() {

        // 类型(1售后问答，2用车咨询)
        mBinding.rlAnswer.setOnClickListener(view -> {
            ShouhouIssueActivity.open(mActivity, "1");
        });

        mBinding.rlAsk.setOnClickListener(view -> {
            ShouhouIssueActivity.open(mActivity, "2");
        });

        mBinding.btnConfirm.setOnClickListener(view -> {

            if (sysConfigBean != null) {
                showUnDoDialog(sysConfigBean.getCustomerServicePhone());
            }

        });

    }

    private void getVideo() {

        Map<String, String> map = RetrofitUtils.getRequestMap();

        // { "code": "RT201911011052453667232", "name": "玩售后" },
        // { "code": "RT201911011052313086637", "name": "玩汽车" },
        // { "code": "RT201911011052165353997", "name": "玩保险" },
        // { "code": "RT201911011050254727016", "name": "玩分期" }

        map.put("bizCode", "RT201911011052453667232");
        map.put("kind", "");
        map.put("location", "1");
        map.put("status", "1");
        map.put("start", "1");
        map.put("limit", "100");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMainResource("630585", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<MainResourceBean>(mActivity) {

            @Override
            protected void onSuccess(MainResourceBean data, String SucMessage) {

                for (MainResourceBean.ListBean bean : data.getList()) {

                    if (bean.getKind().equals("1")) {

                        // startDismissControlViewTimer
                        mBinding.jzVideo.setTag(bean.getCode());
                        mBinding.jzVideo.setUp(MyCdConfig.QINIUURL + bean.getUrl(), bean.getName());
                        mBinding.jzVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImgUtils.loadQiniuImg(mActivity, MyCdConfig.QINIUURL + bean.getThumbnail(), mBinding.jzVideo.thumbImageView);

//                        mBinding.tvName.setText(bean.getName());
                        mBinding.tvTime.setText(DateUtil.formatStringData(bean.getPushDatetime(),
                                DEFAULT_DATE_FMT));
                        mBinding.tvPlays.setText(bean.getVisitNumber() + "次播放");

                    }

                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    private void getData() {
        Map<String, String> map = RetrofitUtils.getRequestMap();

        map.put("type", "shouhou");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getSysConfig("630048", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<SysConfigBean>(mActivity) {

            @Override
            protected void onSuccess(SysConfigBean data, String SucMessage) {

                sysConfigBean = data;

                mBinding.tvWork.setText(data.getServiceRange());
                mBinding.tvTime2.setText(data.getWorkDatetime());

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private void showUnDoDialog(String kefu) {
        View view = LayoutInflater.from(mActivity)
                .inflate(R.layout.dialog_kefu, null);
        Dialog dialog = new Dialog(mActivity, R.style.TipsDialog);
        dialog.setContentView(view);

        TextView tvTitle = view.findViewById(R.id.tv_kefu);
        tvTitle.setText("客服电话：" + sysConfigBean.getCustomerServicePhone());

        view.findViewById(R.id.tv_call).setOnClickListener(view1 -> {
            checkPermission();
            dialog.dismiss();
        });

        view.findViewById(R.id.tv_cancel).setOnClickListener(view1 -> {
            dialog.dismiss();
        });

        dialog.getWindow()
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setGravity(Gravity.CENTER);

        dialog.show();
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
                    UITipDialog.showInfo(mActivity, "请到设置中打开电话权限");
                }
            }, Manifest.permission.CALL_PHONE);
        } else {
            callPhone();
        }
    }

    private void callPhone() {

        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:" + sysConfigBean.getCustomerServicePhone()));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }
}
