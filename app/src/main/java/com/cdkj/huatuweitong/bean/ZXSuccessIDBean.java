package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2018/10/28
 */

public class ZXSuccessIDBean {

    /**
     * result : {"code":"0000","msg":"成功","data":{"name":"齐胜涛","identityNo":"410621199605101018","resultCode":"R001","resultMsg":"一致"}}
     * id : 56
     */

    private String result;
    private String id;
    private int status;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
