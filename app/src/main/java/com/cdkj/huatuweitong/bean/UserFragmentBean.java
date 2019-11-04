package com.cdkj.huatuweitong.bean;

import java.io.Serializable;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/18
 * Created by lenovo on 2018/5/18.
 */

public class UserFragmentBean implements Serializable {

    /**
     * userId : U201908081035371002602
     * produceType : 0
     * loginName : 13506537519
     * mobile : 13506537519
     * photo : IOS_1566205835572098_1125_1125.jpg
     * nickname : 昵称
     * loginPwdStrength : 1
     * idNo : 3303271999661616194
     * realName : 郑勤宝
     * province : 浙江省
     * city : 杭州市
     * area : 余杭区
     * address : 张艺兴
     * status : 0
     * deviceToken : af61da39ec68e43124cc00e725ec01f0b296b66a9cc93ffd06a34723eceb752c
     * createDatetime : Aug 8, 2019 10:35:37 AM
     * blacklistFlag : false
     * identifyFlag : true
     * bankcardFlag : false
     * tradepwdFlag : false
     */

    private String userId;
    private String produceType;
    private String loginName;
    private String mobile;
    private String photo = "";
    private String nickname;
    private String loginPwdStrength;
    private String idNo;
    private String realName;
    private String province = "";
    private String city = "";
    private String area = "";
    private String address;
    private String status;
    private String deviceToken;
    private String createDatetime;
    private boolean blacklistFlag;
    private boolean identifyFlag;
    private boolean bankcardFlag;
    private boolean tradepwdFlag;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProduceType() {
        return produceType;
    }

    public void setProduceType(String produceType) {
        this.produceType = produceType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginPwdStrength() {
        return loginPwdStrength;
    }

    public void setLoginPwdStrength(String loginPwdStrength) {
        this.loginPwdStrength = loginPwdStrength;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public boolean isBlacklistFlag() {
        return blacklistFlag;
    }

    public void setBlacklistFlag(boolean blacklistFlag) {
        this.blacklistFlag = blacklistFlag;
    }

    public boolean isIdentifyFlag() {
        return identifyFlag;
    }

    public void setIdentifyFlag(boolean identifyFlag) {
        this.identifyFlag = identifyFlag;
    }

    public boolean isBankcardFlag() {
        return bankcardFlag;
    }

    public void setBankcardFlag(boolean bankcardFlag) {
        this.bankcardFlag = bankcardFlag;
    }

    public boolean isTradepwdFlag() {
        return tradepwdFlag;
    }

    public void setTradepwdFlag(boolean tradepwdFlag) {
        this.tradepwdFlag = tradepwdFlag;
    }
}
