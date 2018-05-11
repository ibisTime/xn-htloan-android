package com.cdkj.huatuweitong.api;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.huatuweitong.bean.LoginBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/11
 * Created by lenovo on 2018/5/11.
 */

public interface MyApiServer {

    /**
     * 登录
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<LoginBean>> logIn(@Field("code") String code, @Field("json") String  json);

}
