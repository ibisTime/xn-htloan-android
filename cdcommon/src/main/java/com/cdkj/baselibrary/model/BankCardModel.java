package com.cdkj.baselibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dell1 on 2016/12/24.
 */

public class BankCardModel implements Parcelable {


    /**
     * code : BC201805181628070743963
     * userId : U201805151557468878485
     * realName : 2323
     * bankCode : CMB
     * bankName : 招商银行
     * subbranch : 232323
     * bankcardNumber : 23232323232323
     * bindMobile : 232323
     * createDatetime : May 18, 2018 4:28:07 PM
     * status : 0
     * updater : U201805151557468878485
     * updateDatetime : May 18, 2018 4:28:07 PM
     */

    private String code;
    private String userId;
    private String realName;
    private String bankCode;
    private String bankName;
    private String subbranch;
    private String bankcardNumber;
    private String bindMobile;
    private String createDatetime;
    private String status;
    private String updater;
    private String updateDatetime;




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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.userId);
        dest.writeString(this.realName);
        dest.writeString(this.bankCode);
        dest.writeString(this.bankName);
        dest.writeString(this.subbranch);
        dest.writeString(this.bankcardNumber);
        dest.writeString(this.bindMobile);
        dest.writeString(this.createDatetime);
        dest.writeString(this.status);
        dest.writeString(this.updater);
        dest.writeString(this.updateDatetime);
    }

    public BankCardModel() {
    }

    protected BankCardModel(Parcel in) {
        this.code = in.readString();
        this.userId = in.readString();
        this.realName = in.readString();
        this.bankCode = in.readString();
        this.bankName = in.readString();
        this.subbranch = in.readString();
        this.bankcardNumber = in.readString();
        this.bindMobile = in.readString();
        this.createDatetime = in.readString();
        this.status = in.readString();
        this.updater = in.readString();
        this.updateDatetime = in.readString();
    }

    public static final Creator<BankCardModel> CREATOR = new Creator<BankCardModel>() {
        @Override
        public BankCardModel createFromParcel(Parcel source) {
            return new BankCardModel(source);
        }

        @Override
        public BankCardModel[] newArray(int size) {
            return new BankCardModel[size];
        }
    };
}
