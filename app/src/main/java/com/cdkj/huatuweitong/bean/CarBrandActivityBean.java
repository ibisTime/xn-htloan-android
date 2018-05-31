package com.cdkj.huatuweitong.bean;

import java.io.Serializable;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class CarBrandActivityBean implements Serializable {


    /**
     * code : B201805291316412824786
     * description : 路虎
     * letter : 16
     * logo : FqWuk0HsYoBeKTJngeTDJP7luZkX
     * name : 路虎
     * status : 1
     * updateDatetime : May 29, 2018 1:16:51 PM
     * updater : admin
     */

    private String code;
    private String description;
    private String letter;
    private String logo;
    private String name;
    private String status;
    private String updateDatetime;
    private String updater;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
