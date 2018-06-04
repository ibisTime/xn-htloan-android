package com.cdkj.huatuweitong.api;

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.huatuweitong.bean.AccountDetailsBean;
import com.cdkj.huatuweitong.bean.AccountListModel;
import com.cdkj.huatuweitong.bean.AdvanceDetailsActivityBean;
import com.cdkj.huatuweitong.bean.CarBrandActivityBean;
import com.cdkj.huatuweitong.bean.CarDetailsBean;
import com.cdkj.huatuweitong.bean.CarLoanCalculatorActivityDetailsBean;
import com.cdkj.huatuweitong.bean.CarLoanCalculatorSendBean;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityBean;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityMonthBean;
import com.cdkj.huatuweitong.bean.CarModelActivityBean;
import com.cdkj.huatuweitong.bean.CarSystemActivityBean;
import com.cdkj.huatuweitong.bean.ExhibitionCenterBean;
import com.cdkj.huatuweitong.bean.FirstPageBanner;
import com.cdkj.huatuweitong.bean.FirstPageCarRecommendBean;
import com.cdkj.huatuweitong.bean.IsSetPayPassWord;
import com.cdkj.huatuweitong.bean.LoginBean;
import com.cdkj.huatuweitong.bean.MsgListModel;
import com.cdkj.huatuweitong.bean.MyAccountBean;
import com.cdkj.huatuweitong.bean.MyAccountMoneyDataBean;
import com.cdkj.huatuweitong.bean.MyCarLoanFragmentBean;
import com.cdkj.huatuweitong.bean.MyCurrentActivityBean;
import com.cdkj.huatuweitong.bean.MyMessageAFBean;
import com.cdkj.huatuweitong.bean.OrderBean;
import com.cdkj.huatuweitong.bean.RecommendProductBean;
import com.cdkj.huatuweitong.bean.ReimbursementRepaymentBean;
import com.cdkj.huatuweitong.bean.ReimbursementRepaymentMonthBean;
import com.cdkj.huatuweitong.bean.SystemEarlyRepaymentBean;
import com.cdkj.huatuweitong.bean.TextBean;
import com.cdkj.huatuweitong.bean.UserFragmentBean;
import com.cdkj.huatuweitong.bean.WithdrawTipModel;

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
     * 获取首页广告
     *
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<FirstPageBanner>> getFirstBanner(@Field("code") String code, @Field("json") String json);

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

    /**
     * 我的车贷申请  点击里面的条目进行的详情查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarLoanCalculatorActivityDetailsBean>> getCarLoanCalculatorActivityDetails(@Field("code") String code, @Field("json") String json);

    /**
     * 所有贷款
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<ReimbursementRepaymentBean>>> getReimbursementRepaymentData(@Field("code") String code, @Field("json") String json);

    /**
     * 近期还款列表
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<ReimbursementRepaymentMonthBean>>> getReimbursementRepaymentMonthData(@Field("code") String code, @Field("json") String json);


    /**
     * 单款详情   从还款列表点击跳转到这里
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarLoanDetailsActivityBean>> getCarLoanDetailsActivity(@Field("code") String code, @Field("json") String json);

    /**
     * 本月应还贷款 从还款列表点击跳转到这里
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarLoanDetailsActivityMonthBean>> getCarLoanDetailsMonthActivity(@Field("code") String code, @Field("json") String json);

    /**
     * 本月应还贷款 从还款列表点击跳转到这里
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<UserFragmentBean>> getUserDetails(@Field("code") String code, @Field("json") String json);


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
     * 我的消息
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<MyMessageAFBean>>> getMyMessage(@Field("code") String code, @Field("json") String json);

    /**
     * 获取提前还款的  系统参数  服务费     cvalue字段就是服务费
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<SystemEarlyRepaymentBean>> getSystemEarlyRepayment(@Field("code") String code, @Field("json") String json);


    /**
     * 获取提前还款的  系统参数  服务费     cvalue字段就是服务费
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<AdvanceDetailsActivityBean>> getAdvanceDetailsActivityBean(@Field("code") String code, @Field("json") String json);


    /**
     * 获取提前还款的  系统参数  服务费     cvalue字段就是服务费
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<TextBean>> requestEarlyRepaymentCurrent(@Field("code") String code, @Field("json") String json);


    /**
     * 获取账户列表
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<AccountListModel>> getAccount(@Field("code") String code, @Field("json") String json);

    /**
     * 车系(品牌)分页查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<CarBrandActivityBean>>> getCarBrandDatas(@Field("code") String code, @Field("json") String json);

    /**
     * 车系分页查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ResponseInListModel<CarSystemActivityBean>>> getCarSystemlDatas(@Field("code") String code, @Field("json") String json);

    /**
     * 车型分页查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<CarModelActivityBean>> getCarModelDatas(@Field("code") String code, @Field("json") String json);

    /**
     * 我的账户人民币金额
     *
     * @param code 802503
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<MyAccountBean>> getAccountMoney(@Field("code") String code, @Field("json") String json);

    /**
     * 我的账户积分
     *
     * @param code 802503
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<MyCurrentActivityBean>> getAccountMoneyJF(@Field("code") String code, @Field("json") String json);

    /**
     * 我的账户详情  流水
     *
     * @param code 802503
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<AccountDetailsBean>> getAccountMoneyList(@Field("code") String code, @Field("json") String json);


    /**
     * 我的账户详情  流水
     *
     * @param code 802503
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<AccountDetailsBean>> getAccountList(@Field("code") String code, @Field("json") String json);

    /**
     * 获取提现提示
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<WithdrawTipModel>> getWithdrawTip(@Field("code") String code, @Field("json") String json);


    /**
     * 我的账户统计金额
     *
     * @param code 802503
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<MyAccountMoneyDataBean>> getMyAccountMoney(@Field("code") String code, @Field("json") String json);

    /**
     * 获取消息列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<MsgListModel>> getMsgList(@Field("code") String code, @Field("json") String json);

}
