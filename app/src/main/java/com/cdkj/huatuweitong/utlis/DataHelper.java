package com.cdkj.huatuweitong.utlis;

import android.content.Context;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.base.BaseActivity;
import com.cdkj.baselibrary.model.SystemKeyDataBean;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * @author qi
 * @updateDts 2018/8/28
 */

public class DataHelper {

    /**
     * 根据type 获取系统参数的结果
     */
    public static void getSystemType(Context context, String type, OnSystemKeyListener onSystemKeyListener) {

        Map<String, String> map = new HashMap<>(1);
//        map.put("key", key);
        map.put("type", type);
        map.put("limit", "20");
        map.put("start", "1");
        map.put("orderDir", "asc");
        Call<BaseResponseModel<SystemKeyDataBean>> systemKeyData = RetrofitUtils.getBaseAPiService().getSystemKeyData("630045", StringUtils.getJsonToString(map));
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).addCall(systemKeyData);
            ((BaseActivity) context).showLoadingDialog();
        }

        systemKeyData.enqueue(new BaseResponseModelCallBack<SystemKeyDataBean>(context) {
            @Override
            protected void onSuccess(SystemKeyDataBean data, String SucMessage) {
                if (onSystemKeyListener != null) {
                    onSystemKeyListener.systemKeyValue(data.getList());
                }
            }

            @Override
            protected void onFinish() {
                if (context instanceof BaseActivity) {
                    ((BaseActivity) context).disMissLoading();
                }
            }
        });
    }

    public static void getSystemKey(Context context, String key, OnSystemKeyListener onSystemKeyListener) {

        Map<String, String> map = new HashMap<>(1);
//        map.put("key", key);
        map.put("ckey", key);
        map.put("limit", "20");
        map.put("start", "1");
        map.put("orderDir", "asc");
        Call<BaseResponseModel<SystemKeyDataBean>> systemKeyData = RetrofitUtils.getBaseAPiService().getSystemKeyData("630045", StringUtils.getJsonToString(map));
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).addCall(systemKeyData);
            ((BaseActivity) context).showLoadingDialog();
        }

        systemKeyData.enqueue(new BaseResponseModelCallBack<SystemKeyDataBean>(context) {
            @Override
            protected void onSuccess(SystemKeyDataBean data, String SucMessage) {
                if (onSystemKeyListener != null) {
                    onSystemKeyListener.systemKeyValue(data.getList());
                }
            }

            @Override
            protected void onFinish() {
                if (context instanceof BaseActivity) {
                    ((BaseActivity) context).disMissLoading();
                }
            }
        });
    }
}

