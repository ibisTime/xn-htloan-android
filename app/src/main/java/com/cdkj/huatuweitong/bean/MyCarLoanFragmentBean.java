package com.cdkj.huatuweitong.bean;

import java.math.BigDecimal;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/17
 * Created by lenovo on 2018/5/17.
 */

public class MyCarLoanFragmentBean {


    /**
     * code : COD201805210126399596314
     * userId : U201805181545538547345
     * userMobile : 18984955240
     * brandCode : B201805202300401026506
     * brandName : 奔驰
     * seriesCode : C201805210046402256592
     * seriesName : 奔驰E级
     * carCode : C201805210046402256592
     * carName : E300L
     * price : 490000000000
     * sfRate : 0.3
     * sfAmount : 147000000
     * periods : 3
     * createDatetime : May 21, 2018 1:26:39 AM
     * saleDesc : 1
     * status : 1
     * handler : USYS201800000000002
     * handleDatetime : May 21, 2018 1:46:10 AM
     * car : {"code":"C201805210046402256592","name":"E300L","seriesCode":"S201805210042389174973","seriesName":"奔驰E级","brandCode":"B201805202300401026506","brandName":"奔驰","originalPrice":490000000,"salePrice":490000000,"sfAmount":150000000,"location":0,"orderNo":1,"slogan":"<p>奔驰广告语<\/p>","advPic":"FjNURQeadTH1gpyys4Z2bew9qyiO","pic":"FjNURQeadTH1gpyys4Z2bew9qyiO","description":"<p>奔驰图文描述<\/p>","status":"1","updater":"admin","updateDatetime":"May 21, 2018 1:07:50 AM"}
     */

    private String code;
    private String userId;
    private String userMobile;
    private String brandCode;
    private String brandName;
    private String seriesCode;
    private String seriesName;
    private String carCode;
    private String carName;
    private BigDecimal price;
    private double sfRate;
    private BigDecimal sfAmount;
    private int periods;
    private String createDatetime;
    private String saleDesc;
    private String status;
    private String handler;
    private String handleDatetime;
    private CarBean car;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
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

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSfRate() {
        return sfRate;
    }

    public void setSfRate(double sfRate) {
        this.sfRate = sfRate;
    }

    public BigDecimal getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(BigDecimal sfAmount) {
        this.sfAmount = sfAmount;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getSaleDesc() {
        return saleDesc;
    }

    public void setSaleDesc(String saleDesc) {
        this.saleDesc = saleDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getHandleDatetime() {
        return handleDatetime;
    }

    public void setHandleDatetime(String handleDatetime) {
        this.handleDatetime = handleDatetime;
    }

    public CarBean getCar() {
        return car;
    }

    public void setCar(CarBean car) {
        this.car = car;
    }

    public static class CarBean {
        /**
         * code : C201805210046402256592
         * name : E300L
         * seriesCode : S201805210042389174973
         * seriesName : 奔驰E级
         * brandCode : B201805202300401026506
         * brandName : 奔驰
         * originalPrice : 490000000
         * salePrice : 490000000
         * sfAmount : 150000000
         * location : 0
         * orderNo : 1
         * slogan : <p>奔驰广告语</p>
         * advPic : FjNURQeadTH1gpyys4Z2bew9qyiO
         * pic : FjNURQeadTH1gpyys4Z2bew9qyiO
         * description : <p>奔驰图文描述</p>
         * status : 1
         * updater : admin
         * updateDatetime : May 21, 2018 1:07:50 AM
         */

        private String code;
        private String name;
        private String seriesCode;
        private String seriesName;
        private String brandCode;
        private String brandName;
        private int originalPrice;
        private int salePrice;
        private int sfAmount;
        private int location;
        private int orderNo;
        private String slogan;
        private String advPic;
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

        public int getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(int originalPrice) {
            this.originalPrice = originalPrice;
        }

        public int getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(int salePrice) {
            this.salePrice = salePrice;
        }

        public int getSfAmount() {
            return sfAmount;
        }

        public void setSfAmount(int sfAmount) {
            this.sfAmount = sfAmount;
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
