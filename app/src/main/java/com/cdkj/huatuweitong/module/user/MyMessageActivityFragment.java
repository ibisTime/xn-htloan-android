package com.cdkj.huatuweitong.module.user;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.huatuweitong.adapters.MyMessageAFAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyMessageActivityFragment extends AbsRefreshListFragment {


    private String type;

    public static Fragment getInstance(String type) {

        MyMessageActivityFragment fragment = new MyMessageActivityFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    protected void afterCreate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getString("type");
        }
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        MyMessageAFAdapter adapter = new MyMessageAFAdapter(0, listData);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case 0:
                        break;
                }
            }
        });
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {

        initDatas(pageindex,limit,isShowDialog);

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }
   public void initDatas(int pageindex, int limit, boolean isShowDialog){


        if (isShowDialog){
//            showLoadingDialog();
        }

//       Map<String,String> map = new HashMap<>();
//
//
//       Call call =RetrofitUtils.createApi(MyApiServer.class).getMyMessage("", StringUtils.getJsonToString(map));
//       addCall(call);
//       call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<MyMessageAFBean>>(mActivity) {
//           @Override
//           protected void onSuccess(ResponseInListModel data, String SucMessage) {
//
//               data.getList().add(null);
//               data.getList().add(null);
//               data.getList().add(null);
//               data.getList().add(null);
//               data.getList().add(null);
//               data.getList().add(null);
//               mRefreshHelper.setData(data.getList(),"暂无消息",0);
//           }
//
//           @Override
//           protected void onReqFailure(String errorCode, String errorMessage) {
//               super.onReqFailure(errorCode, errorMessage);
//               UITipDialog.showFall(mActivity,errorMessage);
//           }
//
//           @Override
//           protected void onFinish() {
//               disMissLoading();
//
//           }
//       });
   }
}
