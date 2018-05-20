package com.cdkj.huatuweitong.bean;

/**
 *提前还款系统参数Bean
 */

public class SystemEarlyRepaymentBean {


    /**
     * ckey : repayment_fee
     * cvalue : 30
     * id : 18.0
     * remark : 提前还款服务费
     * type : basic_data
     * updateDatetime : May 16, 2018 9:05:13 AM
     * updater : admin
     */

    private String ckey;
    private String cvalue;
    private double id;
    private String remark;
    private String type;
    private String updateDatetime;
    private String updater;

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public String getCvalue() {
        return cvalue;
    }

    public void setCvalue(String cvalue) {
        this.cvalue = cvalue;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
