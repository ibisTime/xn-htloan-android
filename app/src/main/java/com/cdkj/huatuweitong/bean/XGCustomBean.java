package com.cdkj.huatuweitong.bean;

/**
 * Created by admin on 2017/2/13.
 */

public class XGCustomBean {

    /**
     * key1 : 1
     * key2 : XX201909021804157784661
     */

    // 打开方式 GG("1", "公告"), ZX("2", "资讯"), CAR_APPLY("3", "车辆申请单"),CAR("4", "发布车型");
    // 1 3 跳公告详情、2 跳资讯详情、4  跳车辆详情
    private String key1;
    private String key2;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }




}
