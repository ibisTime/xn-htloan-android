package com.cdkj.huatuweitong.tencent;

/**
 * Created by valexhuang on 2018/3/27.
 */

public interface IRoomView {
    // 进入房间成功
    void onEnterRoom();
    // 进房间失败
    void onEnterRoomFailed(String module, int errCode, String errMsg);

    // 退出房间成功
    void onQuitRoomSuccess();
    // 退出房间失败
    void onQuitRoomFailed(String module, int errCode, String errMsg);

    // 房间断开
    void onRoomDisconnect(int errCode, String errMsg);


}