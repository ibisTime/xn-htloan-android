package com.cdkj.huatuweitong.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @updateDts 2019/3/14
 */
public class CarSystemListBean implements Serializable {


    /**
     * code : S201903071411292394034
     * brandCode : B201806190344172014125
     * name : S系列
     * slogan : 彰显大气
     * advPic : aaaa
     * price : 1400000
     * highest : 4000000
     * lowest : 1000000
     * level : 1
     * isReferee : 1
     * location : 1
     * orderNo : 1
     * status : 1
     * updater : U201806131315524345485
     * updateDatetime : Mar 7, 2019 2:15:23 PM
     * remark : 豪华车
     * cars : [{"code":"C201903191536172188197","name":"S650L","seriesCode":"S201903071411292394034","seriesName":"S系列","brandCode":"B201806190344172014125","brandName":"奔驰","bankCode":"BA201806011006085041799","level":"0","version":"2","structure":"2","displacement":5,"fromPlace":"德国","procedure":"无手续","originalPrice":0,"salePrice":4000000,"sfAmount":1200000,"fwAmount":600,"jsqByhf":"1000","jsqSybx":"2000","slogan":"广告标语","advPic":"1111","picNumber":2,"pic":"111","description":"11111","status":"1","updater":"admin","updateDatetime":"Mar 19, 2019 3:36:17 PM"}]
     * carNumber : 1
     */

    private String code;
    private String brandCode;
    private String name;
    private String slogan;
    private String advPic;
    private BigDecimal price;
    private BigDecimal highest;
    private BigDecimal lowest;
    private String level;
    private String isReferee;
    private int location;
    private int orderNo;
    private String status;
    private String updater;
    private String updateDatetime;
    private String remark;
    private int carNumber;
    private List<CarsBean> cars;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public String getIsReferee() {
        return isReferee;
    }

    public void setIsReferee(String isReferee) {
        this.isReferee = isReferee;
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

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public List<CarsBean> getCars() {
        return cars;
    }

    public void setCars(List<CarsBean> cars) {
        this.cars = cars;
    }

    public static class CarsBean implements Serializable{
        /**
         * code : C201903191536172188197
         * name : S650L
         * seriesCode : S201903071411292394034
         * seriesName : S系列
         * brandCode : B201806190344172014125
         * brandName : 奔驰
         * bankCode : BA201806011006085041799
         * level : 0
         * version : 2
         * structure : 2
         * displacement : 5
         * fromPlace : 德国
         * procedure : 无手续
         * originalPrice : 0
         * salePrice : 4000000
         * sfAmount : 1200000
         * fwAmount : 600
         * jsqByhf : 1000
         * jsqSybx : 2000
         * slogan : 广告标语
         * advPic : 1111
         * picNumber : 2
         * pic : 111
         * description : 11111
         * status : 1
         * updater : admin
         * updateDatetime : Mar 19, 2019 3:36:17 PM
         */

        private String code;
        private String name;
        private String seriesCode;
        private String seriesName;
        private String brandCode;
        private String brandName;
        private String bankCode;
        private String level;
        private String version;
        private String structure;
        private int displacement;
        private String fromPlace;
        private String procedure;
        private BigDecimal originalPrice;
        private BigDecimal salePrice;
        private BigDecimal sfAmount;
        private BigDecimal fwAmount;
        private String jsqByhf;
        private String jsqSybx;
        private String slogan;
        private String advPic;
        private int picNumber;
        private String pic;
        private String description;
        private String status;
        private String updater;
        private String updateDatetime;

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

        public String getSeriesCode() {
            return seriesCode;
        }

        public void setSeriesCode(String seriesCode) {
            this.seriesCode = seriesCode;
        }

        public String getSeriesName() {
            return seriesName;
        }

        public void setSeriesName(String seriesName) {
            this.seriesName = seriesName;
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

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getStructure() {
            return structure;
        }

        public void setStructure(String structure) {
            this.structure = structure;
        }

        public int getDisplacement() {
            return displacement;
        }

        public void setDisplacement(int displacement) {
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

        public BigDecimal getSfAmount() {
            return sfAmount;
        }

        public void setSfAmount(BigDecimal sfAmount) {
            this.sfAmount = sfAmount;
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
    }
}
