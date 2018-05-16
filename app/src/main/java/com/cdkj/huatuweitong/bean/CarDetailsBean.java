package com.cdkj.huatuweitong.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/16
 * Created by lenovo on 2018/5/16.
 */

public class CarDetailsBean implements Serializable{


    /**
     * advPic : http://pic39.nipic.com/20140311/8821914_214422866000_2.jpg|http://img1.imgtn.bdimg.com/it/u=451498917,2941248106&fm=27&gp=0.jpg|http://pic39.nipic.com/20140311/8821914_214422866000_2.jpg|http://img1.imgtn.bdimg.com/it/u=451498917,2941248106&fm=27&gp=0.jpg
     * brandCode : B201804231828088143064
     * brandName : name
     * code : C201804231833236114056
     * description : 4567
     * location : 0.0
     * name : A630
     * orderNo : 1.0
     * originalPrice : 20000.0
     * pic : http://pic39.nipic.com/20140311/8821914_214422866000_2.jpg
     * salePrice : 30000.0
     * seriesName : 2018款
     * sfAmount : 3.0
     * slogan : 1234
     * status : 1
     * updateDatetime : Apr 28, 2018 3:40:04 PM
     * updater : admin
     */

    private String advPic;
    private String brandCode;
    private String brandName;
    private String code;
    private String description;
    private double location;
    private String name;
    private double orderNo;
    private BigDecimal originalPrice;
    private String pic;
    private BigDecimal salePrice;
    private String seriesName;
    private BigDecimal sfAmount;//首付
    private String slogan;
    private String status;
    private String updateDatetime;
    private String updater;

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLocation() {
        return location;
    }

    public void setLocation(double location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(double orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public BigDecimal getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(BigDecimal sfAmount) {
        this.sfAmount = sfAmount;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
