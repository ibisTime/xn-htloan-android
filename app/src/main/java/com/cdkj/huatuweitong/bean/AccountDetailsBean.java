package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/31
 */

public class AccountDetailsBean {


    /**
     * list : [{"accountNumber":"A201805212353212771760","bizNote":"注册获取初始信用分","channelType":"0","code":"AJ201805212353213875922","createDatetime":"May 21, 2018 11:53:21 PM","currency":"XYF","kind":"0","realName":"13282838237","refNo":"U201805212353211648317","remark":"记得对账哦","status":"1","transAmountString":"30","type":"C","userId":"U201805212353211648317","workDate":"20180521"}]
     * pageNO : 1.0
     * pageSize : 10.0
     * start : 0.0
     * totalCount : 1.0
     * totalPage : 1.0
     */

    private double pageNO;
    private double pageSize;
    private double start;
    private double totalCount;
    private double totalPage;
    private List<ListBean> list;

    public double getPageNO() {
        return pageNO;
    }

    public void setPageNO(double pageNO) {
        this.pageNO = pageNO;
    }

    public double getPageSize() {
        return pageSize;
    }

    public void setPageSize(double pageSize) {
        this.pageSize = pageSize;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
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
         * accountNumber : A201805212353212771760
         * bizNote : 注册获取初始信用分
         * channelType : 0
         * code : AJ201805212353213875922
         * createDatetime : May 21, 2018 11:53:21 PM
         * currency : XYF
         * kind : 0
         * realName : 13282838237
         * refNo : U201805212353211648317
         * remark : 记得对账哦
         * status : 1
         * transAmountString : 30
         * type : C
         * userId : U201805212353211648317
         * workDate : 20180521
         */

        private String accountNumber;
        private String bizNote;
        private String channelType;
        private String code;
        private String createDatetime;
        private String currency;
        private String kind;
        private String realName;
        private String refNo;
        private String remark;
        private String status;
        private String transAmountString;
        private String type;
        private String userId;
        private String workDate;

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getBizNote() {
            return bizNote;
        }

        public void setBizNote(String bizNote) {
            this.bizNote = bizNote;
        }

        public String getChannelType() {
            return channelType;
        }

        public void setChannelType(String channelType) {
            this.channelType = channelType;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCreateDatetime() {
            return createDatetime;
        }

        public void setCreateDatetime(String createDatetime) {
            this.createDatetime = createDatetime;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getRefNo() {
            return refNo;
        }

        public void setRefNo(String refNo) {
            this.refNo = refNo;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTransAmountString() {
            return transAmountString;
        }

        public void setTransAmountString(String transAmountString) {
            this.transAmountString = transAmountString;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getWorkDate() {
            return workDate;
        }

        public void setWorkDate(String workDate) {
            this.workDate = workDate;
        }
    }
}
