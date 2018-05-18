package com.cdkj.huatuweitong.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

/**
 * 跳转到登录界面
 * Created by ckj on 2018/5/18.
 */

public class OrderSubmitIntentBean implements Parcelable {

    private String productName;

    private BigDecimal price;

    private String productPic;

    private RecommendProductBean.ProductSpecsListBean specBean;

    public OrderSubmitIntentBean(String productName, BigDecimal price, String productPic, RecommendProductBean.ProductSpecsListBean specBean) {
        this.productName = productName;
        this.price = price;
        this.productPic = productPic;
        this.specBean = specBean;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public RecommendProductBean.ProductSpecsListBean getSpecBean() {
        return specBean;
    }

    public void setSpecBean(RecommendProductBean.ProductSpecsListBean specBean) {
        this.specBean = specBean;
    }

    public OrderSubmitIntentBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.productName);
        dest.writeSerializable(this.price);
        dest.writeString(this.productPic);
        dest.writeParcelable(this.specBean, flags);
    }

    protected OrderSubmitIntentBean(Parcel in) {
        this.productName = in.readString();
        this.price = (BigDecimal) in.readSerializable();
        this.productPic = in.readString();
        this.specBean = in.readParcelable(RecommendProductBean.ProductSpecsListBean.class.getClassLoader());
    }

    public static final Creator<OrderSubmitIntentBean> CREATOR = new Creator<OrderSubmitIntentBean>() {
        @Override
        public OrderSubmitIntentBean createFromParcel(Parcel source) {
            return new OrderSubmitIntentBean(source);
        }

        @Override
        public OrderSubmitIntentBean[] newArray(int size) {
            return new OrderSubmitIntentBean[size];
        }
    };
}
