package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2018/10/15
 */

public class ZXGSDBean {


    /**
     * code : 0000
     * msg : 成功
     * statusInfo :
     * data : {"province":"浙江","city":"杭州市","areaCode":"0571","type":"联通"}
     */

    private String code;
    private String msg;
    private String statusInfo;
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

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * province : 浙江
         * city : 杭州市
         * areaCode : 0571
         * type : 联通
         */

        private String province;
        private String city;
        private String areaCode;
        private String type;

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

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
