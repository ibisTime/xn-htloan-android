package com.cdkj.huatuweitong.module.user.message.bean;

/**
 * @author : qianLei
 * @since : 2019/10/29 16:13
 */
public class UserMessageBean {

    /**
     * code : XX201812182205565342898
     * type : 1
     * title : 123
     * content : 456<p>fs</p>
     * status : 1
     * createDatetime : Dec 18, 2018 10:05:56 PM
     * updater : U201806141609052491026
     * updateDatetime : Feb 7, 2019 12:13:15 PM
     * remark :
     */

    private String code;
    private String type;
    private String title;
    private String content;
    private String status;
    private String createDatetime;
    private String updater;
    private String updateDatetime;
    private String remark;

    private String readStatus;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
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

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }
}
