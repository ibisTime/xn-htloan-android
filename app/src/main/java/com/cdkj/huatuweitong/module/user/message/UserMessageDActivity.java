package com.cdkj.huatuweitong.module.user.message;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MsgListModel;
import com.cdkj.huatuweitong.databinding.ActivityMessageBinding;
import com.cdkj.huatuweitong.module.user.message.bean.UserMessageBean;
import retrofit2.Call;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cdkj on 2019/7/18.
 */

public class UserMessageDActivity extends AbsBaseLoadActivity {

    private ActivityMessageBinding mBinding;

    public static void open(Context activity, String code) {
        if (activity == null) {
            return;
        }

        Intent intent = new Intent(activity, UserMessageDActivity.class);
        intent.putExtra(CdRouteHelper.DATASIGN, code);
        activity.startActivity(intent);

    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.activity_message, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("消息详情");

        String code = getIntent().getStringExtra(CdRouteHelper.DATASIGN);

        if (!TextUtils.isEmpty(code)) {
            msgDetail(code);
        }

    }

    private void msgDetail(String code) {

        Map<String, String> map = new HashMap<>();
        map.put("code", code + "");
        map.put("userId", SPUtilHelper.getUserId());
        map.put("token", SPUtilHelper.getUserToken());

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMsgDetail("805307", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<MsgListModel.ListBean>(this) {
            @Override
            protected void onSuccess(MsgListModel.ListBean data, String SucMessage) {

                mBinding.tvTitle.setText(data.getTitle());
                mBinding.tvTime.setText(DateUtil.formatStringData(data.getUpdateDatetime(),
                        DateUtil.DEFAULT_DATE_FMT));

                mBinding.wvContent.loadData(data.getContent(), "text/html;charset=UTF-8", "UTF-8");

            }


            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


    public void read(String readId) {
        Map<String, String> map = new HashMap<>();
        map.put("id", readId);

        Call call = RetrofitUtils.getBaseAPiService()
                .successRequest("805310", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();
        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }
}
