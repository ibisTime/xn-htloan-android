package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2018/10/24
 */

public class ZXIDCardBean {

    /**
     * code : 0000
     * msg : 成功
     * data : {"name":"短号","identityNo":"410621199605101018","resultCode":"R002","resultMsg":"不一致"}
     */

    private String code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 短号
         * identityNo : 410621199605101018
         * resultCode : R002
         * resultMsg : 不一致
         */

        private String name;
        private String identityNo;
        private String resultCode;
        private String resultMsg;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdentityNo() {
            return identityNo;
        }

        public void setIdentityNo(String identityNo) {
            this.identityNo = identityNo;
        }

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
    }
}
