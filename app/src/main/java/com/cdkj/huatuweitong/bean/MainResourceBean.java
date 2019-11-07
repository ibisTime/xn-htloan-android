package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @author : qianLei
 * @since : 2019/11/4 15:03
 */
public class MainResourceBean {


    /**
     * pageNO : 1
     * start : 0
     * pageSize : 10
     * totalCount : 1
     * totalPage : 1
     * list : [{"code":"VP201911011105596459617","bizCode":"RT201911011052313086637","name":"新车视频","url":"ltRc65IOy2glJ6O4TpIIzAuI5qtC","kind":"1","location":"0","orderNo":"1","status":"1","visitNumber":2,"pushUser":"U201907081023440007973","pushDatetime":"Nov 1, 2019 11:16:59 AM","pushUserName":"柴运来"}]
     */

    private int pageNO;
    private int start;
    private int pageSize;
    private int totalCount;
    private int totalPage;
    private List<ListBean> list;

    public int getPageNO() {
        return pageNO;
    }

    public void setPageNO(int pageNO) {
        this.pageNO = pageNO;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {

        /**
         * code : VP201911011105596459617
         * bizCode : RT201911011052313086637
         * name : 新车视频
         * url : ltRc65IOy2glJ6O4TpIIzAuI5qtC
         * kind : 1
         * location : 0
         * orderNo : 1
         * status : 1
         * visitNumber : 2
         * pushUser : U201907081023440007973
         * pushDatetime : Nov 1, 2019 11:16:59 AM
         * pushUserName : 柴运来
         */

        private String code;
        private String bizCode;
        private String name;
        private String synopsis;
        private String url;
        private String kind;
        private String location;
        private String orderNo;
        private String status;
        private int visitNumber;
        private String pushUser;
        private String pushDatetime;
        private String pushUserName;
        private String thumbnail;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getBizCode() {
            return bizCode;
        }

        public void setBizCode(String bizCode) {
            this.bizCode = bizCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSynopsis() {
            return synopsis;
        }

        public void setSynopsis(String synopsis) {
            this.synopsis = synopsis;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getVisitNumber() {
            return visitNumber;
        }

        public void setVisitNumber(int visitNumber) {
            this.visitNumber = visitNumber;
        }

        public String getPushUser() {
            return pushUser;
        }

        public void setPushUser(String pushUser) {
            this.pushUser = pushUser;
        }

        public String getPushDatetime() {
            return pushDatetime;
        }

        public void setPushDatetime(String pushDatetime) {
            this.pushDatetime = pushDatetime;
        }

        public String getPushUserName() {
            return pushUserName;
        }

        public void setPushUserName(String pushUserName) {
            this.pushUserName = pushUserName;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }
}
