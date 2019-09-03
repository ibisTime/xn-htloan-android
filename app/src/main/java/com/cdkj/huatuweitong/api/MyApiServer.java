package com.cdkj.huatuweitong.api;

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.huatuweitong.bean.*;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author 齐胜涛  接口文件接口
 * @des ${TODO}
 * @updateDts 2018/5/11
 * Created by lenovo on 2018/5/11.
 */

public interface MyApiServer {

    /**
     * 获取腾讯用户签名
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<TencentSignModel>> getTencentSign(@Field("code") String code, @Field("json") String json);

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
    Call<BaseResponseModel<CarBean>> getCarDetails(@Field("code") String code, @Field("json") String json);

    /**
     * c车辆详情数据
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarDetailsBean2>> getCarDetails2(@Field("code") String code, @Field("json") String json);

    /**
     * c车辆详情数据
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<CarDetailsSettingBean>> getCarDetailsSetting(@Field("code") String code, @Field("json") String json);

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

    /**
     * 获取消息列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<MsgListModel.ListBean>> getMsgDetail(@Field("code") String code, @Field("json") String json);


    /**
     * 获取节列表
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<NodeModel>> getNodeDataList(@Field("code") String code, @Field("json") String json);

    /**
     * 省份证验证
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ZXSuccessIDBean>> getZXID(@Field("code") String code, @Field("json") String json);

    /**
     * 银行卡四要素认证
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<String>> getZXBank4(@Field("code") String code, @Field("json") String json);

    /**
     * 大数据认证
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ZXSuccessIDBean>> getZXRZ(@Field("code") String code, @Field("json") String json);

    /**
     * 大数据认证
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<String>> getZXRZ2(@Field("code") String code, @Field("json") String json);

    /**
     * 大数据认证 电商的详情查
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<String>> getZXDSDetails(@Field("code") String code, @Field("json") String json);

    /**
     * 获取社保地区查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<SBAreaListBean>> getZXSBArea(@Field("code") String code, @Field("json") String json);

    /**
     * 获取涉案详情
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<String>> getZXSADetails(@Field("code") String code, @Field("json") String json);

    /**
     * 征信状态查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ZXTypeBean>> getZXType(@Field("code") String code, @Field("json") String json);

    /**
     * 检查房间id
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<Integer>> checkRoomId(@Field("code") String code, @Field("json") String json);

    /**
     * 检查房间id
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<ZXSuccessIDBean>> upDataHKimg(@Field("code") String code, @Field("json") String json);

    /**
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<BrandBean>> getBrandData(@Field("code") String code, @Field("json") String json);

    /**
     * 车系查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<CarSystemListBean>> getCarSystemlListDatas(@Field("code") String code, @Field("json") String json);

    /**
     * 热门车系查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<CarSystemListBean>> getCarHotSystemlListDatas(@Field("code") String code, @Field("json") String json);

    /**
     * 新车系查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarSelectPageBean>> getCarTypePage(@Field("code") String code, @Field("json") String json);

    /**
     * 检查房间id
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<InformationListBean>> getInformationList(@Field("code") String code, @Field("json") String json);

    /**
     * 检查房间id
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<InformationListBean.ListBean>> getInformation(@Field("code") String code, @Field("json") String json);

    /**
     * 获取车贷计算器数据
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarLoanCalculatorBean>> getCarLoanCalculator(@Field("code") String code, @Field("json") String json);

    /**
     * 收藏
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CollectionBean>> collection(@Field("code") String code, @Field("json") String json);

    /**
     * 获取收藏
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<MyCollectionBean>> getCollection(@Field("code") String code, @Field("json") String json);

    /**
     * 获取收藏
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<DeleteCollectionBean>> deleteCollection(@Field("code") String code, @Field("json") String json);

    /**
     * 获取收藏
     *
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CommonSuccerBean>> requerstPrice(@Field("code") String code, @Field("json") String json);


    /**
     * 获取车系数据
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarSystemBean>> getCarList(@Field("code") String code, @Field("json") String json);

    /**
     * 数据字典
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseListModel<DataDictionaryBean>> getDataDictionary(@Field("code") String code, @Field("json") String json);


    /**
     * @param code
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<BrandPageBean>> getBrandPage(@Field("code") String code, @Field("json") String json);

    /**
     * 热门车系查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<CarSystemPageBean>> getCarSystemPage(@Field("code") String code, @Field("json") String json);

    /**
     * 新车系查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<MerchantPageBean>> getMerchantPage(@Field("code") String code, @Field("json") String json);

    /**
     * 新车系查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<MerchantBean>> getMerchant(@Field("code") String code, @Field("json") String json);

    /**
     * 新车系查询
     *
     * @param code
     * @param json
     * @return
     */
    @FormUrlEncoded
    @POST("api")
    Call<BaseResponseModel<Integer>> getUnreadCount(@Field("code") String code, @Field("json") String json);
}
