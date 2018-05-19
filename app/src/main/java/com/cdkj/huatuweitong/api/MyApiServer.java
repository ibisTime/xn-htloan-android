package com.cdkj.huatuweitong.api;

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.huatuweitong.bean.CarDetailsBean;
import com.cdkj.huatuweitong.bean.CarLoanCalculatorActivityDetailsBean;
import com.cdkj.huatuweitong.bean.CarLoanCalculatorSendBean;
import com.cdkj.huatuweitong.bean.ExhibitionCenterBean;
import com.cdkj.huatuweitong.bean.FirstPageBanner;
import com.cdkj.huatuweitong.bean.FirstPageCarRecommendBean;
import com.cdkj.huatuweitong.bean.IsSetPayPassWord;
import com.cdkj.huatuweitong.bean.LoginBean;
import com.cdkj.huatuweitong.bean.MyCarLoanFragmentBean;
import com.cdkj.huatuweitong.bean.OrderBean;
import com.cdkj.huatuweitong.bean.RecommendProductBean;

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
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<LoginBean>> logIn(@Field("code") String code, @Field("json") String json);

    /**
     * 是否设置过支付密码
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<IsSetPayPassWord>> isSetPayPassWord(@Field("code") String code, @Field("json") String json);

    /**
     * 获取用户订单列表
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<OrderBean>>> getOrderList(@Field("code") String code, @Field("json") String json);


    /**
     * 获取用户订单详情
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<OrderBean>> getOrderDetails(@Field("code") String code, @Field("json") String json);


    /**
     * 获取首页广告
     *
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<FirstPageBanner>> getFirstBanner(@Field("code") String code, @Field("json") String json);


    /**
     * 获取商品分期列表
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<RecommendProductBean>>> getRecommentdProductList(@Field("code") String code, @Field("json") String json);


    /**
     * 获取商品详情
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<RecommendProductBean>> getRecommentdProductDetails(@Field("code") String code, @Field("json") String json);


    /**
     * 首页的推荐车系
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<FirstPageCarRecommendBean>> getFirstPageCarRecommendCar(@Field("code") String code, @Field("json") String json);


    /**
     * 首页的推荐车点击跳转ExhibitionCenterActivity请求的数据接口
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<ExhibitionCenterBean>>> getExhibitionCenter(@Field("code") String code, @Field("json") String json);

    /**
     * c车辆详情数据
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarDetailsBean>> getCarDetails(@Field("code") String code, @Field("json") String json);

    /**
     * c车辆详情数据
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarLoanCalculatorSendBean>> sendCarLoanCalculator(@Field("code") String code, @Field("json") String json);


    /**
     * c车贷申请详情列表分页查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<MyCarLoanFragmentBean>>> getMyCarLoanFrgmentData(@Field("code") String code, @Field("json") String json);


    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarLoanCalculatorActivityDetailsBean>> getCarLoanCalculatorActivityDetails(@Field("code") String code, @Field("json") String json);

}
