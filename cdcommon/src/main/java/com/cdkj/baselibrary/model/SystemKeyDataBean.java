package com.cdkj.baselibrary.model;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/8/28
 */

public class SystemKeyDataBean {


    /**
     * pageNO : 1.0
     * start : 0.0
     * pageSize : 20.0
     * totalCount : 3.0
     * totalPage : 1.0
     * list : [{"id":14,"type":"car_periods","ckey":"12","cvalue":"5.25","updater":"admin","updateDatetime":"Jun 12, 2018 12:24:21 PM","remark":"车贷期数管理的期数和利率"},{"id":15,"type":"car_periods","ckey":"24","cvalue":"1.10","updater":"U201806060410050085759","updateDatetime":"Jun 12, 2018 12:24:21 PM"},{"id":39,"type":"car_periods","ckey":"36","cvalue":"12.5","updater":"admin","updateDatetime":"Aug 15, 2018 5:33:30 PM","remark":"车贷期数管理的期数和利率"}]
     */

    private double pageNO;
    private double start;
    private double pageSize;
    private double totalCount;
    private double totalPage;
    private List<ListBean> list;

    public double getPageNO() {
        return pageNO;
    }

    public void setPageNO(double pageNO) {
        this.pageNO = pageNO;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getPageSize() {
        return pageSize;
    }

    public void setPageSize(double pageSize) {
        this.pageSize = pageSize;
    }

    public double getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(double totalCount) {
        this.totalCount = totalCount;
    }

    public double getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(double totalPage) {
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
         * id : 14.0
         * type : car_periods
         * ckey : 12
         * cvalue : 5.25
         * updater : admin
         * updateDatetime : Jun 12, 2018 12:24:21 PM
         * remark : 车贷期数管理的期数和利率
         */

        private double id;
        private String type;
        private String ckey;
        private String cvalue;
        private String updater;
        private String updateDatetime;
        private String remark;

        public double getId() {
            return id;
        }

        public void setId(double id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

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
