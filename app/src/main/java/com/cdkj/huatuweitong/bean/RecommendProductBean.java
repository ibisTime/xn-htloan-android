package com.cdkj.huatuweitong.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.List;

/**
 * 分期商品
 * Created by cdkj on 2018/5/17.
 */

public class RecommendProductBean {


    /**
     * code : CP201805062109137465648
     * category : 0
     * type : FL201805011531131116798
     * name : 胶囊咖啡机
     * slogan : 广告语
     * advPic : 广告图
     * saleStatus : 热销中
     * pic : pic1
     * description : 图文详情
     * originalPrice : 50
     * price : 10
     * creditScore : 10
     * status : 3
     * updater : 100
     * updateDatetime : May 6, 2018 9:09:13 PM
     * remark : remark
     * boughtCount : 0
     * productSpecsList : [{"code":"PS201805062109137596153","name":"1000","pic":"pic1","productCode":"CP201805062109137465648","originalPrice":1000,"price":1000,"sfRate":0.3,"periods":3,"bankRate":0.1,"quantity":10,"province":"浙江省","weight":10,"orderNo":1}]
     */

    private String code;
    private String category;
    private String type;
    private String name;
    private String slogan;
    private String advPic;
    private String saleStatus;
    private String pic;
    private String description;
    private BigDecimal originalPrice;
    private BigDecimal price;
    private int creditScore;
    private String status;
    private String updater;
    private String updateDatetime;
    private String remark;
    private int boughtCount;
    private List<ProductSpecsListBean> productSpecsList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
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

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
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

    public int getBoughtCount() {
        return boughtCount;
    }

    public void setBoughtCount(int boughtCount) {
        this.boughtCount = boughtCount;
    }

    public List<ProductSpecsListBean> getProductSpecsList() {
        return productSpecsList;
    }

    public void setProductSpecsList(List<ProductSpecsListBean> productSpecsList) {
        this.productSpecsList = productSpecsList;
    }

    public static class ProductSpecsListBean implements Parcelable {
        /**
         * code : PS201805062109137596153
         * name : 1000
         * pic : pic1
         * productCode : CP201805062109137465648
         * originalPrice : 1000
         * price : 1000
         * sfRate : 0.3
         * periods : 3
         * bankRate : 0.1
         * quantity : 10
         * province : 浙江省
         * weight : 10
         * orderNo : 1
         */

        private String code;
        private String name;
        private String pic;
        private String productCode;
        private int originalPrice;
        private int price;
        private double sfRate;
        private int periods;
        private double bankRate;
        private int quantity;
        private String province;
        private String weight;
        private int orderNo;
        private BigDecimal monthAmount;

        public BigDecimal getMonthAmount() {
            return monthAmount;
        }

        public void setMonthAmount(BigDecimal monthAmount) {
            this.monthAmount = monthAmount;
        }

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

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public int getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(int originalPrice) {
            this.originalPrice = originalPrice;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public double getSfRate() {
            return sfRate;
        }

        public void setSfRate(double sfRate) {
            this.sfRate = sfRate;
        }

        public int getPeriods() {
            return periods;
        }

        public void setPeriods(int periods) {
            this.periods = periods;
        }

        public double getBankRate() {
            return bankRate;
        }

        public void setBankRate(double bankRate) {
            this.bankRate = bankRate;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public int getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.code);
            dest.writeString(this.name);
            dest.writeString(this.pic);
            dest.writeString(this.productCode);
            dest.writeInt(this.originalPrice);
            dest.writeInt(this.price);
            dest.writeDouble(this.sfRate);
            dest.writeInt(this.periods);
            dest.writeDouble(this.bankRate);
            dest.writeInt(this.quantity);
            dest.writeString(this.province);
            dest.writeString(this.weight);
            dest.writeInt(this.orderNo);
            dest.writeSerializable(this.monthAmount);
        }

        public ProductSpecsListBean() {
        }

        protected ProductSpecsListBean(Parcel in) {
            this.code = in.readString();
            this.name = in.readString();
            this.pic = in.readString();
            this.productCode = in.readString();
            this.originalPrice = in.readInt();
            this.price = in.readInt();
            this.sfRate = in.readDouble();
            this.periods = in.readInt();
            this.bankRate = in.readDouble();
            this.quantity = in.readInt();
            this.province = in.readString();
            this.weight = in.readString();
            this.orderNo = in.readInt();
            this.monthAmount = (BigDecimal) in.readSerializable();
        }

        public static final Parcelable.Creator<ProductSpecsListBean> CREATOR = new Parcelable.Creator<ProductSpecsListBean>() {
            @Override
            public ProductSpecsListBean createFromParcel(Parcel source) {
                return new ProductSpecsListBean(source);
            }

            @Override
            public ProductSpecsListBean[] newArray(int size) {
                return new ProductSpecsListBean[size];
            }
        };
    }
}
