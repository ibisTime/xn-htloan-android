package com.cdkj.huatuweitong.bean;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/11
 * Created by lenovo on 2018/5/11.
 */

public class LoginBean  {
    /**
     * errorCode : 3
     * errorBizCode : 3
     * errorInfo : 登录名不存在
     * data :
     */

    private String errorCode;
    private String errorBizCode;
    private String errorInfo;
    private String data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorBizCode() {
        return errorBizCode;
    }

    public void setErrorBizCode(String errorBizCode) {
        this.errorBizCode = errorBizCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
