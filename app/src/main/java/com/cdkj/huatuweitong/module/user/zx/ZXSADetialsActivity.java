package com.cdkj.huatuweitong.module.user.zx;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.SADetailsBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.databinding.ActivityZxsadetialsBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class ZXSADetialsActivity extends AbsBaseLoadActivity {
    ActivityZxsadetialsBinding mBinding;
    private String id;
    private String code;
    private String name;


    public static void open(Context context, String code, String id, String name) {
        if (context != null) {
            Intent intent = new Intent(context, ZXSAActivity.class);
            intent.putExtra(CdRouteHelper.DATASIGN, code);
            intent.putExtra("id", id);
            intent.putExtra("name", name);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxsadetials, null, false);
        mBinding.rilBeigao.requestFocus();

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("涉案详情");
        if (getIntent() != null) {
            code = getIntent().getStringExtra(CdRouteHelper.DATASIGN);
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
        }

        getDetails();
    }

    private void getDetails() {
        Map map = new HashMap<String, String>();
        map.put("bankCardNo", code);
        map.put("identityNo", id);
        map.put("name", name);

        Call<BaseResponseModel<ZXSuccessIDBean>> zxid = RetrofitUtils.createApi(MyApiServer.class).getZXRZ("632922", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                SADetailsBean saDetailsBean = JSON.parseObject(data.getResult(), new TypeReference<SADetailsBean>() {
                });
                if (saDetailsBean == null) {
                    UITipDialog.showInfo(ZXSADetialsActivity.this, "查询失败");
                    return;
                }
                if (TextUtils.equals(saDetailsBean.getCode(), "0000")) {
                    setView(saDetailsBean.getData());

                } else {
                    UITipDialog.showInfo(ZXSADetialsActivity.this, saDetailsBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    private void setView(SADetailsBean.DataBean data) {
        mBinding.rilBeigao.setTvRight(data.getBeigao());
        mBinding.rilBeishangshuren.setTvRight(data.getBeishangshuren());
        mBinding.rilCourt.setTvRight(data.getCourt());
        mBinding.rilCourtType.setTvRight(data.getCourt_type());
        mBinding.rilDanshiren.setTvRight(data.getDanshiren());
        mBinding.rilIdentityCard.setTvRight(data.getIdentity_card());
        mBinding.rilJcase.setTvRight(data.getJcase());
        mBinding.rilJprocess.setTvRight(data.getJprocess());
        mBinding.rilJnum.setTvRight(data.getJnum());
        mBinding.rilJsummary.setTvRight(data.getJsummary());
        mBinding.rilJtype.setTvRight(data.getJtype());
        mBinding.rilJudgeDate.setTvRight(data.getJudge_date());
        mBinding.rilMatchfit.setTvRight(data.getMatchfit());
        mBinding.rilResultStr.setTvRight(data.getResult_str());
        mBinding.rilShangshuren.setTvRight(data.getShangshuren());
        mBinding.rilTitle.setTvRight(data.getTitle());
        mBinding.rilWeitobianhuren.setTvRight(data.getWeitobianhuren());
        mBinding.rilYuangao.setTvRight(data.getYuangao());
    }
}
