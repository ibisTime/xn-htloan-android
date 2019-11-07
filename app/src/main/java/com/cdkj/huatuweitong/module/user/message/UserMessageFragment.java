package com.cdkj.huatuweitong.module.user.message;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MsgListModel;
import com.cdkj.huatuweitong.module.user.message.adapter.UserMessageAdapter;
import com.cdkj.huatuweitong.module.user.message.bean.UserMessageBean;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : qianLei
 * @since : 2019/10/29 15:58
 */
public class UserMessageFragment extends AbsRefreshListFragment<MsgListModel.ListBean> {

    private String type;

    public static UserMessageFragment getInstance(String type) {
        UserMessageFragment fragment = new UserMessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CdRouteHelper.DATASIGN, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void lazyLoad() {
        if (null != mRefreshHelper) {
            mRefreshHelper.onDefaluteMRefresh(true);
        }
    }

    @Override
    protected void onInvisible() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != mRefreshHelper) {
            mRefreshHelper.onDefaluteMRefresh(true);
        }
    }

    @Override
    protected void afterCreate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        type = getArguments().getString(CdRouteHelper.DATASIGN);

        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<MsgListModel.ListBean> listData) {
        UserMessageAdapter adapter = new UserMessageAdapter(listData);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            UserMessageDActivity.open(mActivity, adapter.getItem(position).getCode());
        });
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {

        List<String> typeList = new ArrayList<>();
        if (TextUtils.isEmpty(type)) {

        } else if (type.equals("1")) {
            typeList.add("1");
        } else {
            typeList.add("2");
            typeList.add("3");
            typeList.add("4");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("start", pageindex + "");
        map.put("limit", limit + "");
        map.put("typeList", typeList);
        map.put("token", SPUtilHelper.getUserToken());

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMsgList("805305", StringUtils.getJsonToString(map));

        addCall(call);

        if (isShowDialog) {
            showLoadingDialog();
        }

        call.enqueue(new BaseResponseModelCallBack<MsgListModel>(mActivity) {
            @Override
            protected void onSuccess(MsgListModel data, String SucMessage) {

                mRefreshHelper.setData(data.getList(), "暂无数据", 0);

            }


            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }
}
