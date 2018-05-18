package com.cdkj.baselibrary.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * 收货地址
 * Created by cdkj on 2017/6/17.
 */

public class AddressModel implements Parcelable {

    private String code;
    private String userId;
    private String addressee;
    private String mobile;
    private String province;
    private String city;
    private String area;
    private String detail;
    private String isDefault = "0";

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

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public Boolean isDefaultAddress() {
        return TextUtils.equals("1", isDefault);
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public AddressModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.userId);
        dest.writeString(this.addressee);
        dest.writeString(this.mobile);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.area);
        dest.writeString(this.detail);
        dest.writeString(this.isDefault);
    }

    protected AddressModel(Parcel in) {
        this.code = in.readString();
        this.userId = in.readString();
        this.addressee = in.readString();
        this.mobile = in.readString();
        this.province = in.readString();
        this.city = in.readString();
        this.area = in.readString();
        this.detail = in.readString();
        this.isDefault = in.readString();
    }

    public static final Creator<AddressModel> CREATOR = new Creator<AddressModel>() {
        @Override
        public AddressModel createFromParcel(Parcel source) {
            return new AddressModel(source);
        }

        @Override
        public AddressModel[] newArray(int size) {
            return new AddressModel[size];
        }
    };
}
