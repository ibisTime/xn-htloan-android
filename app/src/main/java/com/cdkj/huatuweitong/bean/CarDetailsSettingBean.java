package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2019/3/19
 */
public class CarDetailsSettingBean {


    /**
     * code : CCC201903192055539139744
     * carCode : C201903191540014947886
     * configCode : CC201903192054092006418
     * config : {"code":"CC201903192054092006418","name":"天窗","pic":"tu","updater":"admin","updateDatetime":"Mar 19, 2019 8:54:09 PM","remark":"0"}
     */

    private String code;
    private String carCode;
    private String configCode;
    private ConfigBean config;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public ConfigBean getConfig() {
        return config;
    }

    public void setConfig(ConfigBean config) {
        this.config = config;
    }

    public static class ConfigBean {
        /**
         * code : CC201903192054092006418
         * name : 天窗
         * pic : tu
         * updater : admin
         * updateDatetime : Mar 19, 2019 8:54:09 PM
         * remark : 0
         */

        private String code;
        private String name;
        private String pic;
        private String updater;
        private String updateDatetime;
        private String remark;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
