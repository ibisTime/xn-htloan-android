package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2019/3/13
 */
public class BrandBean {
    public BrandBean() {
    }

    public BrandBean(String name, String letter) {
        this.name = name;
        this.letter = letter;
    }


    /**
     * code : B201903071325473442783
     * letter : B
     * logo : bmw
     * name : 宝马
     * description : 高端品牌宝马
     * status : 2
     * updater : tao
     * updateDatetime : Mar 7, 2019 1:27:17 PM
     * remark : test
     */

    private String code;
    private String letter;
    private String logo;
    private String name;
    private String description;
    private String status;
    private String updater;
    private String updateDatetime;
    private String remark;
    //    // 首字母
    private String sort = "";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

}
