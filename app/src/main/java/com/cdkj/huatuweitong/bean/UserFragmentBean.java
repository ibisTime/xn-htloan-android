package com.cdkj.huatuweitong.bean;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/18
 * Created by lenovo on 2018/5/18.
 */

public class UserFragmentBean {


    /**
     * bankcardFlag : false
     * blacklistFlag : false
     * createDatetime : May 15, 2018 3:57:46 PM
     * identifyFlag : false
     * kind : C
     * loginName : 13282838237
     * loginPwdStrength : 1
     * mobile : 13282838237
     * nickname : 嘿嘿
     * photo : ANDROID_1526643458798_3120_4160.jpg
     * status : 0
     * tradepwdFlag : false
     * userId : U201805151557468878485
     */

    private boolean bankcardFlag;
    private boolean blacklistFlag;
    private String createDatetime;
    private boolean identifyFlag;
    private String kind;
    private String loginName;
    private String loginPwdStrength;
    private String mobile;
    private String nickname;
    private String photo;
    private String status;
    private boolean tradepwdFlag;
    private String userId;

    public boolean isBankcardFlag() {
        return bankcardFlag;
    }

    public void setBankcardFlag(boolean bankcardFlag) {
        this.bankcardFlag = bankcardFlag;
    }

    public boolean isBlacklistFlag() {
        return blacklistFlag;
    }

    public void setBlacklistFlag(boolean blacklistFlag) {
        this.blacklistFlag = blacklistFlag;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public boolean isIdentifyFlag() {
        return identifyFlag;
    }

    public void setIdentifyFlag(boolean identifyFlag) {
        this.identifyFlag = identifyFlag;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwdStrength() {
        return loginPwdStrength;
    }

    public void setLoginPwdStrength(String loginPwdStrength) {
        this.loginPwdStrength = loginPwdStrength;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTradepwdFlag() {
        return tradepwdFlag;
    }

    public void setTradepwdFlag(boolean tradepwdFlag) {
        this.tradepwdFlag = tradepwdFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
