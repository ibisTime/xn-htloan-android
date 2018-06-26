package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/18
 * Created by lenovo on 2018/5/18.
 */

public class CarLoanDetailsActivityMonthBean {


    /**
     * code : RP201805072244195466151
     * costList : [{"amount":"100","code":"COST201805091742457932108","item":"上门车费","payDatetime":"Jan 1, 2018 12:00:00 AM","payWay":"代","repayPlanCode":"RP201805072244195466151","repayWay":"现金"},{"amount":"100","code":"COST201805091743333774873","item":"上门车费","payDatetime":"Jan 1, 2018 12:00:00 AM","payWay":"代","repayPlanCode":"RP201805072244195466151","repayWay":"现金"},{"amount":"100","code":"COST201805091744421659365","item":"上门车费","payDatetime":"Jan 1, 2018 12:00:00 AM","payWay":"代","repayPlanCode":"RP201805072244195466151","repayWay":"现金"}]
     * curPeriods : 3.0
     * depositWay : 收款
     * overdueAmount : 0.0
     * overdueDeposit : 2000.0
     * overplusAmount : 0.0
     * payedAmount : 0.0
     * payedFee : 0.0
     * periods : 3.0
     * remindCount : 0.0
     * remindLogList : [{"code":"RL201805091056265534883","createDatetime":"May 9, 2018 10:56:26 AM","repayPlanCode":"RP201805072244195466151","toUser":"郑海清","way":"0"},{"code":"RL201805091059223011853","createDatetime":"May 9, 2018 10:59:03 AM","repayPlanCode":"RP201805072244195466151","toUser":"郑海清","way":"0"},{"code":"RL201805091104488981373","createDatetime":"May 9, 2018 11:04:48 AM","repayPlanCode":"RP201805072244195466151","toUser":"郑海清","way":"0"},{"code":"RL201805091105222828350","createDatetime":"May 9, 2018 11:05:22 AM","repayPlanCode":"RP201805072244195466151","toUser":"郑海清","way":"0"},{"code":"RL201805091106393488229","createDatetime":"May 9, 2018 11:06:39 AM","repayPlanCode":"RP201805072244195466151","toUser":"郑海清","way":"0"},{"code":"RL201805151807301541429","createDatetime":"May 15, 2018 6:07:30 PM","repayPlanCode":"RP201805072244195466151","toUser":"郑海清","way":"0"}]
     * repayBiz : {"bankRate":0.1,"bankcardCode":"BC201805071350259874774","bizPrice":1000,"blackHandleNote":"；拉入黑名单","code":"RB201805072244195224699","curOverdueCount":0,"cutLyDeposit":0,"firstRepayAmount":23,"firstRepayDatetime":"Jun 6, 2018 10:27:34 PM","fxDeposit":0,"loanAmount":700,"loanBank":"中国工商银行","loanEndDatetime":"Aug 7, 2018 10:44:19 PM","loanStartDatetime":"May 7, 2018 10:44:19 PM","lyDeposit":0,"monthAmount":23,"monthDatetime":6,"overdueAmount":0,"periods":3,"refCode":"DD201805062227341815574","refType":"1","remark":"无","restAmount":700,"restPeriods":3,"restTotalCost":0,"sfAmount":300,"sfRate":0.3,"status":"2","totalInDeposit":0,"totalOverdueCount":0,"updateDatetime":"May 8, 2018 9:34:40 PM","updater":"admin","userId":"U201805061611515474805"}
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
    private int periods;
    private double remindCount;
    private RepayBizBean repayBiz;
    private String repayBizCode;
    private double repayCapital;
    private String repayDatetime;
    private double repayInterest;
    private double shouldDeposit;
    private String curNodeCode;
    private double totalFee;
    private UserBean user;
    private String userId;
    private String bankcardNumber;
    private List<CostListBean> costList;
    private List<RemindLogListBean> remindLogList;

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
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

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public double getRemindCount() {
        return remindCount;
    }

    public void setRemindCount(double remindCount) {
        this.remindCount = remindCount;
    }

    public RepayBizBean getRepayBiz() {
        return repayBiz;
    }

    public void setRepayBiz(RepayBizBean repayBiz) {
        this.repayBiz = repayBiz;
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

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String status) {
        this.curNodeCode = status;
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

    public List<CostListBean> getCostList() {
        return costList;
    }

    public void setCostList(List<CostListBean> costList) {
        this.costList = costList;
    }

    public List<RemindLogListBean> getRemindLogList() {
        return remindLogList;
    }

    public void setRemindLogList(List<RemindLogListBean> remindLogList) {
        this.remindLogList = remindLogList;
    }

    public static class RepayBizBean {
        /**
         * bankRate : 0.1
         * bankcardCode : BC201805071350259874774
         * bizPrice : 1000.0
         * blackHandleNote : ；拉入黑名单
         * code : RB201805072244195224699
         * curOverdueCount : 0.0
         * cutLyDeposit : 0.0
         * firstRepayAmount : 23.0
         * firstRepayDatetime : Jun 6, 2018 10:27:34 PM
         * fxDeposit : 0.0
         * loanAmount : 700.0
         * loanBank : 中国工商银行
         * loanEndDatetime : Aug 7, 2018 10:44:19 PM
         * loanStartDatetime : May 7, 2018 10:44:19 PM
         * lyDeposit : 0.0
         * monthAmount : 23.0
         * monthDatetime : 6.0
         * overdueAmount : 0.0
         * periods : 3.0
         * refCode : DD201805062227341815574
         * refType : 1
         * remark : 无
         * restAmount : 700.0
         * restPeriods : 3.0
         * restTotalCost : 0.0
         * sfAmount : 300.0
         * sfRate : 0.3
         * status : 2
         * totalInDeposit : 0.0
         * totalOverdueCount : 0.0
         * updateDatetime : May 8, 2018 9:34:40 PM
         * updater : admin
         * userId : U201805061611515474805
         */

        private double bankRate;
        private String bankcardCode;
        private double bizPrice;
        private String blackHandleNote;
        private String code;
        private double curOverdueCount;
        private double cutLyDeposit;
        private double firstRepayAmount;
        private String firstRepayDatetime;
        private double fxDeposit;
        private double loanAmount;
        private String loanBank;
        private String loanEndDatetime;
        private String loanStartDatetime;
        private double lyDeposit;
        private double monthAmount;
        private double monthDatetime;
        private double overdueAmount;
        private double periods;
        private String refCode;
        private String refType;
        private String remark;
        private double restAmount;
        private double restPeriods;
        private CarLoanDetailsActivityBean.BudgetOrderBean budgetOrder;
        private double restTotalCost;
        private double sfAmount;
        private double sfRate;
        private String status;
        private double totalInDeposit;
        private double totalOverdueCount;
        private String updateDatetime;
        private String updater;
        private String userId;

        public CarLoanDetailsActivityBean.BudgetOrderBean getBudgetOrder() {
            return budgetOrder;
        }

        public void setBudgetOrder(CarLoanDetailsActivityBean.BudgetOrderBean budgetOrder) {
            this.budgetOrder = budgetOrder;
        }

        public double getBankRate() {
            return bankRate;
        }

        public void setBankRate(double bankRate) {
            this.bankRate = bankRate;
        }

        public String getBankcardCode() {
            return bankcardCode;
        }

        public void setBankcardCode(String bankcardCode) {
            this.bankcardCode = bankcardCode;
        }

        public double getBizPrice() {
            return bizPrice;
        }

        public void setBizPrice(double bizPrice) {
            this.bizPrice = bizPrice;
        }

        public String getBlackHandleNote() {
            return blackHandleNote;
        }

        public void setBlackHandleNote(String blackHandleNote) {
            this.blackHandleNote = blackHandleNote;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public double getCurOverdueCount() {
            return curOverdueCount;
        }

        public void setCurOverdueCount(double curOverdueCount) {
            this.curOverdueCount = curOverdueCount;
        }

        public double getCutLyDeposit() {
            return cutLyDeposit;
        }

        public void setCutLyDeposit(double cutLyDeposit) {
            this.cutLyDeposit = cutLyDeposit;
        }

        public double getFirstRepayAmount() {
            return firstRepayAmount;
        }

        public void setFirstRepayAmount(double firstRepayAmount) {
            this.firstRepayAmount = firstRepayAmount;
        }

        public String getFirstRepayDatetime() {
            return firstRepayDatetime;
        }

        public void setFirstRepayDatetime(String firstRepayDatetime) {
            this.firstRepayDatetime = firstRepayDatetime;
        }

        public double getFxDeposit() {
            return fxDeposit;
        }

        public void setFxDeposit(double fxDeposit) {
            this.fxDeposit = fxDeposit;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public String getLoanBank() {
            return loanBank;
        }

        public void setLoanBank(String loanBank) {
            this.loanBank = loanBank;
        }

        public String getLoanEndDatetime() {
            return loanEndDatetime;
        }

        public void setLoanEndDatetime(String loanEndDatetime) {
            this.loanEndDatetime = loanEndDatetime;
        }

        public String getLoanStartDatetime() {
            return loanStartDatetime;
        }

        public void setLoanStartDatetime(String loanStartDatetime) {
            this.loanStartDatetime = loanStartDatetime;
        }

        public double getLyDeposit() {
            return lyDeposit;
        }

        public void setLyDeposit(double lyDeposit) {
            this.lyDeposit = lyDeposit;
        }

        public double getMonthAmount() {
            return monthAmount;
        }

        public void setMonthAmount(double monthAmount) {
            this.monthAmount = monthAmount;
        }

        public double getMonthDatetime() {
            return monthDatetime;
        }

        public void setMonthDatetime(double monthDatetime) {
            this.monthDatetime = monthDatetime;
        }

        public double getOverdueAmount() {
            return overdueAmount;
        }

        public void setOverdueAmount(double overdueAmount) {
            this.overdueAmount = overdueAmount;
        }

        public double getPeriods() {
            return periods;
        }

        public void setPeriods(double periods) {
            this.periods = periods;
        }

        public String getRefCode() {
            return refCode;
        }

        public void setRefCode(String refCode) {
            this.refCode = refCode;
        }

        public String getRefType() {
            return refType;
        }

        public void setRefType(String refType) {
            this.refType = refType;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public double getRestAmount() {
            return restAmount;
        }

        public void setRestAmount(double restAmount) {
            this.restAmount = restAmount;
        }

        public double getRestPeriods() {
            return restPeriods;
        }

        public void setRestPeriods(double restPeriods) {
            this.restPeriods = restPeriods;
        }

        public double getRestTotalCost() {
            return restTotalCost;
        }

        public void setRestTotalCost(double restTotalCost) {
            this.restTotalCost = restTotalCost;
        }

        public double getSfAmount() {
            return sfAmount;
        }

        public void setSfAmount(double sfAmount) {
            this.sfAmount = sfAmount;
        }

        public double getSfRate() {
            return sfRate;
        }

        public void setSfRate(double sfRate) {
            this.sfRate = sfRate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public double getTotalInDeposit() {
            return totalInDeposit;
        }

        public void setTotalInDeposit(double totalInDeposit) {
            this.totalInDeposit = totalInDeposit;
        }

        public double getTotalOverdueCount() {
            return totalOverdueCount;
        }

        public void setTotalOverdueCount(double totalOverdueCount) {
            this.totalOverdueCount = totalOverdueCount;
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
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

    public static class CostListBean {
        /**
         * amount : 100
         * code : COST201805091742457932108
         * item : 上门车费
         * payDatetime : Jan 1, 2018 12:00:00 AM
         * payWay : 代
         * repayPlanCode : RP201805072244195466151
         * repayWay : 现金
         */

        private String amount;
        private String code;
        private String item;
        private String payDatetime;
        private String payWay;
        private String repayPlanCode;
        private String repayWay;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getPayDatetime() {
            return payDatetime;
        }

        public void setPayDatetime(String payDatetime) {
            this.payDatetime = payDatetime;
        }

        public String getPayWay() {
            return payWay;
        }

        public void setPayWay(String payWay) {
            this.payWay = payWay;
        }

        public String getRepayPlanCode() {
            return repayPlanCode;
        }

        public void setRepayPlanCode(String repayPlanCode) {
            this.repayPlanCode = repayPlanCode;
        }

        public String getRepayWay() {
            return repayWay;
        }

        public void setRepayWay(String repayWay) {
            this.repayWay = repayWay;
        }
    }

    public static class RemindLogListBean {
        /**
         * code : RL201805091056265534883
         * createDatetime : May 9, 2018 10:56:26 AM
         * repayPlanCode : RP201805072244195466151
         * toUser : 郑海清
         * way : 0
         */

        private String code;
        private String createDatetime;
        private String repayPlanCode;
        private String toUser;
        private String way;

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

        public String getRepayPlanCode() {
            return repayPlanCode;
        }

        public void setRepayPlanCode(String repayPlanCode) {
            this.repayPlanCode = repayPlanCode;
        }

        public String getToUser() {
            return toUser;
        }

        public void setToUser(String toUser) {
            this.toUser = toUser;
        }

        public String getWay() {
            return way;
        }

        public void setWay(String way) {
            this.way = way;
        }
    }
}
