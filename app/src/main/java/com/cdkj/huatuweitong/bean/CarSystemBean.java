package com.cdkj.huatuweitong.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @updateDts 2019/4/9
 */
public class CarSystemBean implements Serializable {

    /**
     * code : S201904171057485773969
     * type : 2
     * brandCode : B201904121416180175937
     * name : 奔驰GLA AMG
     * slogan : 驾乘乐趣，创新极限
     * advPic : Fqtqqf2R8ShoFWL4MOiXKELUeniA
     * picNumber : 1
     * price : 0
     * highest : 0
     * lowest : 0
     * level : 0
     * location : 1
     * orderNo : 1
     * status : 1
     * updater : USYS201800000000001
     * updateDatetime : May 8, 2019 3:51:24 PM
     * remark :
     */

    private String code;
    private String type;
    private String brandCode;
    private String name;
    private String slogan;
    private String advPic = "";
    private int picNumber;
    private int price;
    private BigDecimal highest;
    private BigDecimal lowest;
    private String level;
    private String location;
    private int orderNo;
    private String status;
    private String updater;
    private String updateDatetime;
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
