package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2018/10/11
 * 通用成功类bean
 */

public class ZXSuccessBean {


    /**
     * code : 1013
     * msg : 身份证不合法
     * token : 6affafe4e4384124993bfda96126bb4f
     * data :
     */

    private String code;
    private String msg;
    private String token;
    private String data;
    private String resultCode;
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
