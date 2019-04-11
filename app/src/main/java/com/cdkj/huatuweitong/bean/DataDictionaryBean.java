package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2019/4/10
 */
public class DataDictionaryBean {


    /**
     * id : 977
     * type : 1
     * parentKey : car_version
     * dkey : 2
     * dvalue : 美规
     * updater : admin
     * updateDatetime : Apr 1, 2019 5:26:57 AM
     * remark :
     */

    private int id;
    private String type;
    private String parentKey;
    private String dkey;
    private String dvalue;
    private String updater;
    private String updateDatetime;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getDkey() {
        return dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }

    public String getDvalue() {
        return dvalue;
    }

    public void setDvalue(String dvalue) {
        this.dvalue = dvalue;
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
