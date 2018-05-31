package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/19
 * Created by lenovo on 2018/5/19.
 */

public class MyCurrentActivityBean {


    private List<AccountListBean> accountList;

    public List<AccountListBean> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountListBean> accountList) {
        this.accountList = accountList;
    }

    public static class AccountListBean {
        /**
         * accountNumber : A201805212353212408731
         * addAmount : 0.0
         * amount : 0.0
         * createDatetime : May 21, 2018 11:53:21 PM
         * currency : JF
         * frozenAmount : 0.0
         * inAmount : 0.0
         * md5 : 4122cb13c7a474c1976c9706ae36521d
         * outAmount : 0.0
         * realName : 13282838237
         * status : 0
         * type : C
         * userId : U201805212353211648317
         */

        private String accountNumber;
        private double addAmount;
        private double amount;
        private String createDatetime;
        private String currency;
        private double frozenAmount;
        private double inAmount;
        private String md5;
        private double outAmount;
        private String realName;
        private String status;
        private String type;
        private String userId;

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public double getAddAmount() {
            return addAmount;
        }

        public void setAddAmount(double addAmount) {
            this.addAmount = addAmount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
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

        public double getFrozenAmount() {
            return frozenAmount;
        }

        public void setFrozenAmount(double frozenAmount) {
            this.frozenAmount = frozenAmount;
        }

        public double getInAmount() {
            return inAmount;
        }

        public void setInAmount(double inAmount) {
            this.inAmount = inAmount;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public double getOutAmount() {
            return outAmount;
        }

        public void setOutAmount(double outAmount) {
            this.outAmount = outAmount;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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
    }
}
