package com.cdkj.huatuweitong.bean;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/17
 * Created by lenovo on 2018/5/17.
 * 近期还款的bean
 */

public class ReimbursementRepaymentMonthBean {


    /**
     * code : RP201805072244195466151
     * curPeriods : 3.0
     * depositWay : 收款
     * overdueAmount : 0.0
     * overdueDeposit : 2000.0
     * overplusAmount : 0.0
     * payedAmount : 0.0
     * payedFee : 0.0
     * periods : 3.0
     * remindCount : 0.0
     * repayBizCode : RB201805072244195224699
     * repayCapital : 23.0
     * repayDatetime : May 18, 2018 10:27:34 PM
     * repayInterest : 0.0
     * shouldDeposit : 0.0
     * status : 5
     * totalFee : 0.0
     * user : {"bankcardFlag":false,"blacklistFlag":false,"createDatetime":"May 6, 2018 4:11:51 PM","idKind":"1","idNo":"330281198908023311","identifyFlag":false,"kind":"C","loginName":"15268501481","loginPwdStrength":"1","mobile":"15268501481","nickname":"大黄","photo":"U12345678","realName":"郑海清","remark":"注销","status":"0","tradePwdStrength":"1","tradepwdFlag":false,"userId":"U201805061611515474805"}
     * userId : U201805061611515474805
     */

    private String code;
    private double curPeriods;
    private String depositWay;
    private double overdueAmount;
    private double overdueDeposit;
    private double overplusAmount;
    private double payedAmount;
    private double payedFee;
    private double periods;
    private double remindCount;
    private String repayBizCode;
    private double repayCapital;
    private String repayDatetime;
    private double repayInterest;
    private double shouldDeposit;
    private String status;
    private double totalFee;
    private UserBean user;
    private RepayBiz repayBiz;
    private String userId;
    private double monthRepayAmount;


    public static class RepayBiz {
        private String refType="0";
        private String  monthDatetime="2018-12-12";

        public String getRefType() {
            return refType;
        }

        public void setMonthDatetime(String monthDatetime) {
            this.monthDatetime = monthDatetime;
        }
        public String getMonthDatetime() {
            return refType;
        }

        public void setRefType(String refType) {
            this.refType = refType;
        }

    }

    public RepayBiz getRepayBiz() {
        return repayBiz;
    }

    public void setRepayBiz(RepayBiz repayBiz) {
        this.repayBiz = repayBiz;
    }



    public double getMonthRepayAmount() {
        return monthRepayAmount;
    }

    public void setMonthRepayAmount(double monthRepayAmount) {
        this.monthRepayAmount = monthRepayAmount;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCurPeriods() {
        return curPeriods;
    }

    public void setCurPeriods(double curPeriods) {
        this.curPeriods = curPeriods;
    }

    public String getDepositWay() {
        return depositWay;
    }

    public void setDepositWay(String depositWay) {
        this.depositWay = depositWay;
    }

    public double getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(double overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public double getOverdueDeposit() {
        return overdueDeposit;
    }

    public void setOverdueDeposit(double overdueDeposit) {
        this.overdueDeposit = overdueDeposit;
    }

    public double getOverplusAmount() {
        return overplusAmount;
    }

    public void setOverplusAmount(double overplusAmount) {
        this.overplusAmount = overplusAmount;
    }

    public double getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(double payedAmount) {
        this.payedAmount = payedAmount;
    }

    public double getPayedFee() {
        return payedFee;
    }

    public void setPayedFee(double payedFee) {
        this.payedFee = payedFee;
    }

    public double getPeriods() {
        return periods;
    }

    public void setPeriods(double periods) {
        this.periods = periods;
    }

    public double getRemindCount() {
        return remindCount;
    }

    public void setRemindCount(double remindCount) {
        this.remindCount = remindCount;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public double getRepayCapital() {
        return repayCapital;
    }

    public void setRepayCapital(double repayCapital) {
        this.repayCapital = repayCapital;
    }

    public String getRepayDatetime() {
        return repayDatetime;
    }

    public void setRepayDatetime(String repayDatetime) {
        this.repayDatetime = repayDatetime;
    }

    public double getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(double repayInterest) {
        this.repayInterest = repayInterest;
    }

    public double getShouldDeposit() {
        return shouldDeposit;
    }

    public void setShouldDeposit(double shouldDeposit) {
        this.shouldDeposit = shouldDeposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class UserBean {
        /**
         * bankcardFlag : false
         * blacklistFlag : false
         * createDatetime : May 6, 2018 4:11:51 PM
         * idKind : 1
         * idNo : 330281198908023311
         * identifyFlag : false
         * kind : C
         * loginName : 15268501481
         * loginPwdStrength : 1
         * mobile : 15268501481
         * nickname : 大黄
         * photo : U12345678
         * realName : 郑海清
         * remark : 注销
         * status : 0
         * tradePwdStrength : 1
         * tradepwdFlag : false
         * userId : U201805061611515474805
         */

        private boolean bankcardFlag;
        private boolean blacklistFlag;
        private String createDatetime;
        private String idKind;
        private String idNo;
        private boolean identifyFlag;
        private String kind;
        private String loginName;
        private String loginPwdStrength;
        private String mobile;
        private String nickname;
        private String photo;
        private String realName;
        private String remark;
        private String status;
        private String tradePwdStrength;
        private boolean tradepwdFlag;
        private String userId;

        public boolean isBankcardFlag() {
            return bankcardFlag;
        }

        public void setBankcardFlag(boolean bankcardFlag) {
            this.bankcardFlag = bankcardFlag;
        }

        public boolean isBlacklistFlag() {
            return blacklistFlag;
        }

        public void setBlacklistFlag(boolean blacklistFlag) {
            this.blacklistFlag = blacklistFlag;
        }

        public String getCreateDatetime() {
            return createDatetime;
        }

        public void setCreateDatetime(String createDatetime) {
            this.createDatetime = createDatetime;
        }

        public String getIdKind() {
            return idKind;
        }

        public void setIdKind(String idKind) {
            this.idKind = idKind;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public boolean isIdentifyFlag() {
            return identifyFlag;
        }

        public void setIdentifyFlag(boolean identifyFlag) {
            this.identifyFlag = identifyFlag;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getLoginPwdStrength() {
            return loginPwdStrength;
        }

        public void setLoginPwdStrength(String loginPwdStrength) {
            this.loginPwdStrength = loginPwdStrength;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
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

        public String getTradePwdStrength() {
            return tradePwdStrength;
        }

        public void setTradePwdStrength(String tradePwdStrength) {
            this.tradePwdStrength = tradePwdStrength;
        }

        public boolean isTradepwdFlag() {
            return tradepwdFlag;
        }

        public void setTradepwdFlag(boolean tradepwdFlag) {
            this.tradepwdFlag = tradepwdFlag;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
