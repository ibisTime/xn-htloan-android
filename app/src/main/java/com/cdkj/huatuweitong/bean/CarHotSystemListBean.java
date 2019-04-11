package com.cdkj.huatuweitong.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @updateDts 2019/3/14
 */
public class CarHotSystemListBean implements Serializable {


    /**
     * code : S201903071411292394034
     * brandCode : B201806190344172014125
     * name : S系列
     * slogan : 彰显大气
     * advPic : aaaa
     * picNumber : 2
     * price : 1400000
     * highest : 15000000
     * lowest : 1000000
     * level : 1
     * location : 1
     * orderNo : 1
     * status : 1
     * updater : U201806131315524345485
     * updateDatetime : Mar 7, 2019 2:15:23 PM
     * remark : 豪华车
     * updaterName : 洪仁飞
     */

    private String code;
    private String brandCode;
    private String name;
    private String slogan;
    private String advPic;
    private int picNumber;
    private int price;
    private BigDecimal highest;
    private BigDecimal lowest;
    private String level;
    private int location;
    private int orderNo;
    private String status;
    private String updater;
    private String updateDatetime;
    private String remark;
    private String updaterName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BigDecimal getHighest() {
        return highest;
    }

    public void setHighest(BigDecimal highest) {
        this.highest = highest;
    }

    public BigDecimal getLowest() {
        return lowest;
    }

    public void setLowest(BigDecimal lowest) {
        this.lowest = lowest;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }
}
