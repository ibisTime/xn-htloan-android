package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class BrandPageBean {


    /**
     * pageNO : 1
     * start : 0
     * pageSize : 100
     * totalCount : 4
     * totalPage : 1
     * list : [{"code":"B201904131247298315740","type":"2","letter":"B","logo":"FgBpGy7NjrSMi4wj26Zz167OPBwG","name":"宝马","description":"宝马系列","location":"0","orderNo":5,"status":"1","updater":"USYS201800000000001","updateDatetime":"Apr 22, 2019 1:19:37 PM","remark":""},{"code":"B201904121416180175937","type":"2","letter":"B","logo":"FoXtAXrvApxYp5RT_ZxWS73AWobu","name":"奔驰","description":"梅赛德斯奔驰","location":"0","orderNo":6,"status":"1","updater":"USYS201800000000001","updateDatetime":"Apr 22, 2019 1:19:16 PM","remark":""},{"code":"B201904151212118543871","type":"2","letter":"L","logo":"FrgI2HeoIywE8rmBkFRAbjSM6Q6x","name":"路虎","description":"路虎品牌","location":"0","orderNo":7,"status":"1","updater":"USYS201800000000001","updateDatetime":"Apr 22, 2019 1:19:02 PM","remark":""},{"code":"B201904131301113784867","type":"2","letter":"F","logo":"FuKWDcGrY-qrwGbl7-mjIvxZG5WD","name":"丰田","description":"丰田汽车","location":"0","orderNo":8,"status":"1","updater":"USYS201800000000001","updateDatetime":"Apr 22, 2019 1:18:45 PM","remark":""}]
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
         * code : B201904131247298315740
         * type : 2
         * letter : B
         * logo : FgBpGy7NjrSMi4wj26Zz167OPBwG
         * name : 宝马
         * description : 宝马系列
         * location : 0
         * orderNo : 5
         * status : 1
         * updater : USYS201800000000001
         * updateDatetime : Apr 22, 2019 1:19:37 PM
         * remark :
         */

        private String code;
        private String type;
        private String letter;
        private String logo;
        private String name;
        private String description;
        private String location;
        private int orderNo;
        private String status;
        private String updater;
        private String updateDatetime;
        private String remark;

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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
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
    }
}
