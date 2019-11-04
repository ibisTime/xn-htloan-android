package com.cdkj.huatuweitong.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author : qianLei
 * @since : 2019/8/29 15:07
 */
public class CarBean implements Serializable {


    /**
     * code : 1210306
     * isReferee : 1
     * seriesId : 506
     * modelId : 1210306
     * type : 1
     * name : 2011款 拓陆者 S 2.8L 至尊版 柴油 129马力 两驱 双排皮卡
     * seriesCode : 三菱
     * brandCode : 39
     * brandName : 福田
     * version : 1
     * displacement : 2.8
     * fromPlace : 北京
     * procedure : 0
     * originalPrice : 100000
     * salePrice : 138600000
     * modelYear : 2011
     * minRegYear : 2010
     * maxRegYear : 2013
     * liter : 2.8L
     * gearType : 手动
     * dischargeStandard : 国4
     * seatNumber : 5
     * sfAmount : 100000
     * monthAmount : 100000
     * fwAmount : 10000
     * jsqByhf : 10000
     * jsqSybx : 10000
     * location : 1
     * orderNo : 340
     * slogan : 白色
     * advPic : Fs4jiWBG_O36ADjUONv45CdKhLsy
     * picNumber : 1
     * pic : FrLh-zbku8RLBn0Uf2FOmRLgZKoD
     * description : rmk
     * outsideColor : 白色
     * insideColor : baise
     * status : 0
     * updater : USYS201800000000001
     * updateDatetime : Aug 29, 2019 3:02:33 PM
     * updaterName : admin
     * caonfigList : [{"code":"CCC201908291502333028508","carCode":"1210306","configCode":"CC201904121426272621096","config":{"code":"CC201904121426272621096","name":"自动巡航","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"USYS201800000000001","updateDatetime":"Apr 12, 2019 2:26:27 PM","remark":"","isConfig":"0"},"configName":"自动巡航"},{"code":"CCC201908291502333057000","carCode":"1210306","configCode":"CC201904121426433498772","config":{"code":"CC201904121426433498772","name":"自动锁门","pic":"","updater":"USYS201800000000001","updateDatetime":"Apr 12, 2019 2:26:43 PM","remark":"","isConfig":"0"},"configName":"自动锁门"}]
     * collectNumber : 0
     * configs : [{"code":"CC201904121426272621096","name":"自动巡航","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"USYS201800000000001","updateDatetime":"Apr 12, 2019 2:26:27 PM","remark":"","isConfig":"1"},{"code":"CC201904121426433498772","name":"自动锁门","pic":"","updater":"USYS201800000000001","updateDatetime":"Apr 12, 2019 2:26:43 PM","remark":"","isConfig":"1"},{"code":"CC201904121427469309634","name":"三厢","pic":"","updater":"USYS201800000000001","updateDatetime":"Apr 12, 2019 2:27:46 PM","remark":"","isConfig":"0"},{"code":"CC201904221430472434649","name":"11","pic":"Ft_1T4gYHKajcrN4xIRSLLIPsNyZ","updater":"USYS201800000000001","updateDatetime":"Apr 22, 2019 2:30:47 PM","remark":"","isConfig":"0"},{"code":"CC201905051044424577987","name":"单差","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 10:44:42 AM","remark":"","isConfig":"0"},{"code":"CC201905051045060396059","name":"蠕动系统","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 10:45:06 AM","remark":"","isConfig":"0"},{"code":"CC201905051045392546119","name":"胎压监测","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 10:45:39 AM","remark":"","isConfig":"0"},{"code":"CC201905051046008966332","name":"定速巡航","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 10:46:00 AM","remark":"","isConfig":"0"},{"code":"CC201905051218413027648","name":"氙灯","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:18:41 PM","remark":"","isConfig":"0"},{"code":"CC201905051218560906108","name":"LED流水转向灯","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:18:56 PM","remark":"","isConfig":"0"},{"code":"CC201905051219510746283","name":"主驾驶电动座椅","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:19:51 PM","remark":"","isConfig":"0"},{"code":"CC201905051220035558709","name":"桃木方向盘","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:20:03 PM","remark":"","isConfig":"0"},{"code":"CC201905051220186935008","name":"桃木内饰","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:20:18 PM","remark":"","isConfig":"0"},{"code":"CC201905051222110494493","name":"多功能方向盘","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:22:11 PM","remark":"","isConfig":"0"},{"code":"CC201905051222441886312","name":"智能卡","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:22:44 PM","remark":"","isConfig":"0"},{"code":"CC201905051222593387120","name":"一键启动","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:22:59 PM","remark":"","isConfig":"0"},{"code":"CC201905051234135837297","name":"拖钩","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:34:13 PM","remark":"","isConfig":"0"},{"code":"CC201905051235095256682","name":"冰箱","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:35:09 PM","remark":"","isConfig":"0"},{"code":"CC201905051235222408057","name":"彩条","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:35:22 PM","remark":"","isConfig":"0"},{"code":"CC201905051235389417559","name":"17铝合金轮毂","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:35:38 PM","remark":"","isConfig":"0"},{"code":"CC201905051235525864897","name":"流水灯","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 12:35:52 PM","remark":"","isConfig":"0"},{"code":"CC201905051543296298660","name":"上下坡道辅助","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:43:29 PM","remark":"","isConfig":"0"},{"code":"CC201905051543495429553","name":"卤素大灯","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:43:49 PM","remark":"","isConfig":"0"},{"code":"CC201905051544062789497","name":"自动头灯","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:44:06 PM","remark":"","isConfig":"0"},{"code":"CC201905051544224134957","name":"大灯高度可调","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:44:22 PM","remark":"","isConfig":"0"},{"code":"CC201905051544406224168","name":"自动空调","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:44:40 PM","remark":"","isConfig":"0"},{"code":"CC201905051545057574302","name":"单碟CD","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:45:05 PM","remark":"","isConfig":"0"},{"code":"CC201905051545230369635","name":"5门7座","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:45:23 PM","remark":"","isConfig":"0"},{"code":"CC201905051545398151036","name":"5副21寸轮","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:45:39 PM","remark":"","isConfig":"0"},{"code":"CC201905051545549414714","name":"360环影","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:45:54 PM","remark":"","isConfig":"0"},{"code":"CC201905051546087825698","name":"电眼","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:46:08 PM","remark":"","isConfig":"0"},{"code":"CC201905051546207727749","name":"抬头显示","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:46:20 PM","remark":"","isConfig":"0"},{"code":"CC201905051546346379294","name":"底盘升降","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:46:34 PM","remark":"","isConfig":"0"},{"code":"CC201905051548071739921","name":"无钥匙进入","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:48:07 PM","remark":"","isConfig":"0"},{"code":"CC201905051548174237354","name":"电吸门","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:48:17 PM","remark":"","isConfig":"0"},{"code":"CC201905051548275583686","name":"拨片换挡","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:48:27 PM","remark":"","isConfig":"0"},{"code":"CC201905051548389416152","name":"行李架","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:48:38 PM","remark":"","isConfig":"0"},{"code":"CC201905051548508033007","name":"橡胶铝合金踏板 ","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:48:50 PM","remark":"","isConfig":"0"},{"code":"CC201905051549061247272","name":"LED大灯","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:49:06 PM","remark":"","isConfig":"0"},{"code":"CC201905051549235881114","name":"自动尾箱","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:49:23 PM","remark":"","isConfig":"0"},{"code":"CC201905051549364962756","name":"后扰流板","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:49:36 PM","remark":"","isConfig":"0"},{"code":"CC201905051549526871251","name":" 前真皮电动加热+腰撑 ","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:49:52 PM","remark":"","isConfig":"0"},{"code":"CC201905051550042307522","name":"真皮座椅","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:50:04 PM","remark":"","isConfig":"0"},{"code":"CC201905051550145656527","name":"真皮实木多功能方向盘","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:50:14 PM","remark":"","isConfig":"0"},{"code":"CC201905051550243742928","name":"全景天窗","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:50:24 PM","remark":"","isConfig":"0"},{"code":"CC201905051550377915707","name":"电动+防炫目后视镜","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:50:37 PM","remark":"","isConfig":"0"},{"code":"CC201905051550556714981","name":"真皮仪表盘及内饰","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:50:55 PM","remark":"","isConfig":"0"},{"code":"CC201905051551073474706","name":"哈曼卡顿音响 ","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:51:07 PM","remark":"","isConfig":"0"},{"code":"CC201905051551313268270","name":"地毯","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:51:31 PM","remark":"","isConfig":"0"},{"code":"CC201905051551417325280","name":"第三排座椅可移","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:51:41 PM","remark":"","isConfig":"0"},{"code":"CC201905051551522366552","name":"备胎","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:51:52 PM","remark":"","isConfig":"0"},{"code":"CC201905051552020807966","name":"隐私玻璃","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:52:02 PM","remark":"","isConfig":"0"},{"code":"CC201905051552138536713","name":"二排电动","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:52:13 PM","remark":"","isConfig":"0"},{"code":"CC201905051552245578681","name":"AMG外观套件","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:52:24 PM","remark":"","isConfig":"0"},{"code":"CC201905051552349264616","name":"增强版自适应减震系统","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:52:34 PM","remark":"","isConfig":"0"},{"code":"CC201905051552469084528","name":"AMG运动包围","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:52:46 PM","remark":"","isConfig":"0"},{"code":"CC201905051558492998853","name":"丝绒手动座椅","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:58:49 PM","remark":"","isConfig":"0"},{"code":"CC201905051559062225651","name":"蓝牙","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:59:06 PM","remark":"","isConfig":"0"},{"code":"CC201905051559241726407","name":"MP3","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:59:24 PM","remark":"","isConfig":"0"},{"code":"CC201905051559489534259","name":"电子恒温三区空调","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 3:59:48 PM","remark":"","isConfig":"0"},{"code":"CC201905051600033328580","name":"2气囊","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:00:03 PM","remark":"","isConfig":"0"},{"code":"CC201905051600145713041","name":"大屏+倒车影像","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:00:14 PM","remark":"","isConfig":"0"},{"code":"CC201905051600268703671","name":"泊车感应器（前2后4）","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:00:26 PM","remark":"","isConfig":"0"},{"code":"CC201905051600378522854","name":"新款18寸轮毂","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:00:37 PM","remark":"","isConfig":"0"},{"code":"CC201905051600485955812","name":"265/60R18","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:00:48 PM","remark":"","isConfig":"0"},{"code":"CC201905051601019374999","name":"胎压报警","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:01:01 PM","remark":"","isConfig":"0"},{"code":"CC201905051601144846178","name":"滑动可开启天窗","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:01:14 PM","remark":"","isConfig":"0"},{"code":"CC201905051601246687231","name":"8气囊","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:01:24 PM","remark":"","isConfig":"0"},{"code":"CC201905051601349943648","name":"后挂备胎","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:01:34 PM","remark":"","isConfig":"0"},{"code":"CC201905051601463238585","name":"5速变速箱带运动模式","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:01:46 PM","remark":"","isConfig":"0"},{"code":"CC201905051602031718670","name":"超选4驱模式","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:02:03 PM","remark":"","isConfig":"0"},{"code":"CC201905051602141167582","name":"18寸铝合金轮毂","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:02:14 PM","remark":"","isConfig":"0"},{"code":"CC201905051602248037882","name":"双差速锁","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:02:24 PM","remark":"","isConfig":"0"},{"code":"CC201905051602396901549","name":"高位刹车灯","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:02:39 PM","remark":"","isConfig":"0"},{"code":"CC201905051602533315346","name":"主副驾驶电动座椅","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:02:53 PM","remark":"","isConfig":"0"},{"code":"CC201905051603111547009","name":"腰部支撑","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:03:11 PM","remark":"","isConfig":"0"},{"code":"CC201905051603223159621","name":"车身防蹭条","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:03:22 PM","remark":"","isConfig":"0"},{"code":"CC201905051603327959918","name":"镀铬外后视镜电动折叠","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:03:32 PM","remark":"","isConfig":"0"},{"code":"CC201905051603500039288","name":"后排出风口","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:03:50 PM","remark":"","isConfig":"0"},{"code":"CC201905051604028131165","name":"镀铬门把手","pic":"","updater":"USYS201800000000001","updateDatetime":"May 5, 2019 4:04:02 PM","remark":"","isConfig":"0"},{"code":"CC201905101306089616413","name":"方向盘电动调节","pic":"","updater":"USYS201800000000001","updateDatetime":"May 10, 2019 1:06:08 PM","remark":"","isConfig":"0"},{"code":"CC201905101306245665668","name":"倒车雷达","pic":"","updater":"USYS201800000000001","updateDatetime":"May 10, 2019 1:06:24 PM","remark":"","isConfig":"0"},{"code":"CC201905101306511397364","name":"五种越野模式","pic":"","updater":"USYS201800000000001","updateDatetime":"May 10, 2019 1:06:51 PM","remark":"","isConfig":"0"},{"code":"CC201905101321222065990","name":"哈曼卡顿环绕音响系统","pic":"","updater":"USYS201800000000001","updateDatetime":"May 10, 2019 1:21:22 PM","remark":"","isConfig":"0"},{"code":"CC201905101321348705331","name":"前排座椅通风","pic":"","updater":"USYS201800000000001","updateDatetime":"May 10, 2019 1:21:34 PM","remark":"","isConfig":"0"},{"code":"CC201905101321533078854","name":"镀铬车行李架","pic":"","updater":"USYS201800000000001","updateDatetime":"May 10, 2019 1:21:53 PM","remark":"","isConfig":"0"},{"code":"CC201905101322069265511","name":"远程遥控启动","pic":"","updater":"USYS201800000000001","updateDatetime":"May 10, 2019 1:22:06 PM","remark":"","isConfig":"0"},{"code":"CC201905101322194267090","name":"前6后4雷达","pic":"","updater":"USYS201800000000001","updateDatetime":"May 10, 2019 1:22:19 PM","remark":"","isConfig":"0"},{"code":"CC201905281242370831530","name":"电尾门","pic":"","updater":"USYS201800000000001","updateDatetime":"May 28, 2019 12:42:37 PM","remark":"","isConfig":"0"},{"code":"CC201905281242559677548","name":"19寸轮毅","pic":"","updater":"USYS201800000000001","updateDatetime":"May 28, 2019 12:42:55 PM","remark":"","isConfig":"0"},{"code":"CC201905281243157999098","name":"皮布双拼座椅","pic":"","updater":"USYS201800000000001","updateDatetime":"May 28, 2019 12:43:15 PM","remark":"","isConfig":"0"},{"code":"CC201905281243415421708","name":"数字仪表盘","pic":"","updater":"USYS201800000000001","updateDatetime":"May 28, 2019 12:43:41 PM","remark":"","isConfig":"0"},{"code":"CC201907121421247346029","name":"配置1","updater":"USYS201800000000001","updateDatetime":"Jul 12, 2019 2:21:24 PM","remark":"","isConfig":"0"},{"code":"CC201908281955250153822","name":"摄像头管理","updater":"USYS201800000000001","updateDatetime":"Aug 28, 2019 7:55:25 PM","remark":"rmk","isConfig":"0"},{"code":"CC201908281955253371523","name":"摄像头管理","updater":"USYS201800000000001","updateDatetime":"Aug 28, 2019 7:55:25 PM","remark":"rmk","isConfig":"0"},{"code":"CC201908281955254967132","name":"摄像头管理","updater":"USYS201800000000001","updateDatetime":"Aug 28, 2019 7:55:25 PM","remark":"rmk","isConfig":"0"},{"code":"CC201908281955256574670","name":"摄像头管理","updater":"USYS201800000000001","updateDatetime":"Aug 28, 2019 7:55:25 PM","remark":"rmk","isConfig":"0"},{"code":"CC201908281955258363531","name":"摄像头管理","updater":"USYS201800000000001","updateDatetime":"Aug 28, 2019 7:55:25 PM","remark":"rmk","isConfig":"0"},{"code":"CC201908281955260043161","name":"摄像头管理","updater":"USYS201800000000001","updateDatetime":"Aug 28, 2019 7:55:26 PM","remark":"rmk","isConfig":"0"},{"code":"CC201908282141238692166","name":"摄像头管理","updater":"U201908282032010175594","updateDatetime":"Aug 28, 2019 9:41:23 PM","remark":"12","isConfig":"0"},{"code":"CC201908282141240452266","name":"摄像头管理","updater":"U201908282032010175594","updateDatetime":"Aug 28, 2019 9:41:24 PM","remark":"12","isConfig":"0"},{"code":"CC201908282141242351431","name":"摄像头管理","updater":"U201908282032010175594","updateDatetime":"Aug 28, 2019 9:41:24 PM","remark":"12","isConfig":"0"},{"code":"CC201908282141244416269","name":"摄像头管理","updater":"U201908282032010175594","updateDatetime":"Aug 28, 2019 9:41:24 PM","remark":"12","isConfig":"0"},{"code":"CC201908282141246345013","name":"摄像头管理","updater":"U201908282032010175594","updateDatetime":"Aug 28, 2019 9:41:24 PM","remark":"12","isConfig":"0"},{"code":"CC201908282141248354436","name":"摄像头管理","updater":"U201908282032010175594","updateDatetime":"Aug 28, 2019 9:41:24 PM","remark":"12","isConfig":"0"},{"code":"CC201908282142581187628","name":"kaka","updater":"U201908282032010175594","updateDatetime":"Aug 28, 2019 9:42:58 PM","remark":"ninini","isConfig":"0"},{"code":"CC201908291456436209722","name":"摄像头管理","updater":"USYS201800000000001","updateDatetime":"Aug 29, 2019 2:56:43 PM","remark":"ad","isConfig":"0"}]
     */

    private String code;
    private String isReferee;
    private String seriesId;
    private String modelId;
    private String type;
    private String name;
    private String seriesCode;
    private String brandCode;
    private String brandName;
    private String seriesName;
    private String version;
    private String displacement;
    private String fromPlace;
    private String procedure;
    private BigDecimal originalPrice;
    private BigDecimal salePrice;
    private String modelYear;
    private String minRegYear;
    private String maxRegYear;
    private String liter;
    private String gearType;
    private String dischargeStandard;
    private String seatNumber;
    private BigDecimal sfAmount;
    private BigDecimal monthAmount;
    private BigDecimal fwAmount;
    private String jsqByhf;
    private String jsqSybx;
    private String location;
    private int orderNo;
    private String slogan;
    private String advPic;
    private int picNumber;
    private String pic;
    private String description;
    private String outsideColor;
    private String insideColor;
    private String status;
    private String updater;
    private String updateDatetime;
    private String updaterName;
    private String isCollect;
    private String level;
    private String configName;
    private int collectNumber;
    private List<CaonfigListBean> caonfigList;
    private List<ConfigsBean> configs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsReferee() {
        return isReferee;
    }

    public void setIsReferee(String isReferee) {
        this.isReferee = isReferee;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getMinRegYear() {
        return minRegYear;
    }

    public void setMinRegYear(String minRegYear) {
        this.minRegYear = minRegYear;
    }

    public String getMaxRegYear() {
        return maxRegYear;
    }

    public void setMaxRegYear(String maxRegYear) {
        this.maxRegYear = maxRegYear;
    }

    public String getLiter() {
        return liter;
    }

    public void setLiter(String liter) {
        this.liter = liter;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getDischargeStandard() {
        return dischargeStandard;
    }

    public void setDischargeStandard(String dischargeStandard) {
        this.dischargeStandard = dischargeStandard;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(BigDecimal sfAmount) {
        this.sfAmount = sfAmount;
    }

    public BigDecimal getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(BigDecimal monthAmount) {
        this.monthAmount = monthAmount;
    }

    public BigDecimal getFwAmount() {
        return fwAmount;
    }

    public void setFwAmount(BigDecimal fwAmount) {
        this.fwAmount = fwAmount;
    }

    public String getJsqByhf() {
        return jsqByhf;
    }

    public void setJsqByhf(String jsqByhf) {
        this.jsqByhf = jsqByhf;
    }

    public String getJsqSybx() {
        return jsqSybx;
    }

    public void setJsqSybx(String jsqSybx) {
        this.jsqSybx = jsqSybx;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public int getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(int picNumber) {
        this.picNumber = picNumber;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOutsideColor() {
        return outsideColor;
    }

    public void setOutsideColor(String outsideColor) {
        this.outsideColor = outsideColor;
    }

    public String getInsideColor() {
        return insideColor;
    }

    public void setInsideColor(String insideColor) {
        this.insideColor = insideColor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public String getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(String isCollect) {
        this.isCollect = isCollect;
    }

    public int getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(int collectNumber) {
        this.collectNumber = collectNumber;
    }

    public List<CaonfigListBean> getCaonfigList() {
        return caonfigList;
    }

    public void setCaonfigList(List<CaonfigListBean> caonfigList) {
        this.caonfigList = caonfigList;
    }

    public List<ConfigsBean> getConfigs() {
        return configs;
    }

    public void setConfigs(List<ConfigsBean> configs) {
        this.configs = configs;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public static class CaonfigListBean implements Serializable {

        /**
         * code : CCC201908291502333028508
         * carCode : 1210306
         * configCode : CC201904121426272621096
         * config : {"code":"CC201904121426272621096","name":"自动巡航","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"USYS201800000000001","updateDatetime":"Apr 12, 2019 2:26:27 PM","remark":"","isConfig":"0"}
         * configName : 自动巡航
         */

        private String code;
        private String carCode;
        private String configCode;
        private ConfigBean config;
        private String configName;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCarCode() {
            return carCode;
        }

        public void setCarCode(String carCode) {
            this.carCode = carCode;
        }

        public String getConfigCode() {
            return configCode;
        }

        public void setConfigCode(String configCode) {
            this.configCode = configCode;
        }

        public ConfigBean getConfig() {
            return config;
        }

        public void setConfig(ConfigBean config) {
            this.config = config;
        }

        public String getConfigName() {
            return configName;
        }

        public void setConfigName(String configName) {
            this.configName = configName;
        }

        public static class ConfigBean implements Serializable {

            /**
             * code : CC201904121426272621096
             * name : 自动巡航
             * pic : Fvn5aof2QJ2U8RRLl7LN9E2iRDcq
             * updater : USYS201800000000001
             * updateDatetime : Apr 12, 2019 2:26:27 PM
             * remark :
             * isConfig : 0
             */

            private String code;
            private String name;
            private String pic;
            private String updater;
            private String updateDatetime;
            private String remark;
            private String isConfig;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getUpdater() {
                return updater;
            }

            public void setUpdater(String updater) {
                this.updater = updater;
            }

            public String getUpdateDatetime() {
                return updateDatetime;
            }

            public void setUpdateDatetime(String updateDatetime) {
                this.updateDatetime = updateDatetime;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getIsConfig() {
                return isConfig;
            }

            public void setIsConfig(String isConfig) {
                this.isConfig = isConfig;
            }
        }
    }

    public static class ConfigsBean implements Serializable {

        /**
         * code : CC201904121426272621096
         * name : 自动巡航
         * pic : Fvn5aof2QJ2U8RRLl7LN9E2iRDcq
         * updater : USYS201800000000001
         * updateDatetime : Apr 12, 2019 2:26:27 PM
         * remark :
         * isConfig : 1
         */

        private String code;
        private String name;
        private String pic;
        private String updater;
        private String updateDatetime;
        private String remark;
        private String isConfig;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getUpdater() {
            return updater;
        }

        public void setUpdater(String updater) {
            this.updater = updater;
        }

        public String getUpdateDatetime() {
            return updateDatetime;
        }

        public void setUpdateDatetime(String updateDatetime) {
            this.updateDatetime = updateDatetime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getIsConfig() {
            return isConfig;
        }

        public void setIsConfig(String isConfig) {
            this.isConfig = isConfig;
        }
    }
}
