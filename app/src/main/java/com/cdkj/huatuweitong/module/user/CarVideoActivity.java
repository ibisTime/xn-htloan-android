package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import cn.jzvd.Jzvd;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.MainActivity;
import com.cdkj.huatuweitong.adapters.CarVideoAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MainResourceBean;
import retrofit2.Call;

import java.util.List;
import java.util.Map;


/**
 * @author : qianLei
 * @since : 2019/11/5 21:47
 */
public class CarVideoActivity extends AbsRefreshListActivity {

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, CarVideoActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        CarVideoAdapter mAdapter = new CarVideoAdapter(listData);

        return mAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        Map<String, String> map = RetrofitUtils.getRequestMap();
        map.put("kind", "1");
        map.put("status", "1");
        map.put("start", pageindex + "");
        map.put("limit", limit + "");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMainResource("630585", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<MainResourceBean>(this) {

            @Override
            protected void onSuccess(MainResourceBean data, String SucMessage) {

                mRefreshHelper.setData(data.getList(), "暂无视频", 0);

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        mBaseBinding.titleView.setMidTitle("玩车视频");

        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}
