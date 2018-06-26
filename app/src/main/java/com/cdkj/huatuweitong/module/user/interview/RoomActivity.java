package com.cdkj.huatuweitong.module.user.interview;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.baselibrary.utils.ToastUtil;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityRoomBinding;
import com.cdkj.huatuweitong.tencent.IRoomView;
import com.cdkj.huatuweitong.tencent.RoomHelper;

import static com.cdkj.baselibrary.appmanager.CdRouteHelper.DATASIGN;

/**
 * Created by cdkj on 2018/6/14.
 */

public class RoomActivity extends AbsBaseLoadActivity implements IRoomView {

    private RoomHelper helper;
    private ActivityRoomBinding mBinding;

    private int roomId;

    public static void open(Context context, int roomId) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, RoomActivity.class);
        intent.putExtra(DATASIGN, roomId);
        context.startActivity(intent);
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_room, null, false );

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        mBaseBinding.titleView.setMidTitle("面签");

        helper = new RoomHelper(this);
        // 设置渲染控件
        helper.setRootView(mBinding.avRootView);

        if (getIntent() == null || getIntent().getExtras() == null)
            return;

        roomId = getIntent().getIntExtra(DATASIGN, -1);

        if (roomId >= 1 && roomId <= 10000000)
            helper.createRoom(roomId);
        else
            ToastUtil.show(this,"请输正确的入房间号(1~10000000)");
    }

    @Override
    public void onEnterRoom() {
        LogUtil.E("onEnterRoom()  创建房间成功");
        ToastUtil.show(this,"创建房间成功");
    }

    @Override
    public void onEnterRoomFailed(String module, int errCode, String errMsg) {
        LogUtil.E("onEnterRoomFailed()  创建房间失败：" + errCode + "::::" + errMsg);
        ToastUtil.show(this,"创建房间失败：" + errCode + "::::" + errMsg);
    }

    @Override
    public void onQuitRoomSuccess() {
        LogUtil.E("onQuitRoomSuccess()  退出房间成功");
        ToastUtil.show(this,"退出房间成功");
    }

    @Override
    public void onQuitRoomFailed(String module, int errCode, String errMsg) {
        LogUtil.E("onQuitRoomFailed()  退出房间失败：" + errCode + "::::" + errMsg);
        ToastUtil.show(this,"退出房间失败：" + errCode + "::::" + errMsg);
    }

    @Override
    public void onRoomDisconnect(int errCode, String errMsg) {
        LogUtil.E("onRoomDisconnect()  连接断开：" + errCode + "::::" + errMsg);
        ToastUtil.show(this,"连接断开：" + errCode + "::::" + errMsg);
    }

    // 处理Activity事件
    public void onPause() {
        super.onPause();
        helper.onPause();
    }

    // 处理Activity事件
    public void onResume() {
        super.onResume();
        helper.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.quitRoom();
    }
}
