package com.cdkj.huatuweitong.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/17
 * Created by lenovo on 2018/5/17.
 */

public class CarLoanDetailsActivityBean implements Serializable{


    /**
     * bankRate : 0.1
     * bizPrice : 2.0E8
     * blackHandleNote : 暂无
     * code : RB201805141639121408953
     * curOverdueCount : 0.0
     * cutLyDeposit : 0.0
     * firstRepayAmount : 5833330.0
     * firstRepayDatetime : Apr 20, 2019 12:00:00 AM
     * fxDeposit : 2.0E7
     * loanAmount : 1.4E8
     * loanBank : 中国建设银行
     * loanEndDatetime : Apr 29, 2020 12:00:00 AM
     * budgetOrder : {"bankCode":"ICBC","bankName":"中国工商银行","bankRate":0.1,"bankcardNumber":"6217002710000684874","carCode":"C201804231832234243414","carPrice":2.0E8,"code":"LO201805061345029723893","firstRepayAmount":5833330,"firstRepayDatetime":"Apr 20, 2019 12:00:00 AM","fkDatetime":"Apr 30, 2018 12:00:00 AM","fxDeposit":2.0E7,"gpsFee":3000000,"idKind":"1","idNo":"330281198908023311","loanAmount":1.4E8,"loanBank":"中国建设银行","loanEndDatetime":"Apr 29, 2020 12:00:00 AM","loanStartDatetime":"Apr 30, 2018 12:00:00 AM","lyDeposit":3.0E7,"mobile":"15268501481","monthAmount":5833330,"monthDatetime":20,"otherFee":4654,"periods":24,"realName":"郑海清","remark":"审核通过","repayBizCode":"RB201805142015418326578","sfAmount":6.0E7,"sfRate":0.3,"status":"3","subbranch":"海创园支行","updateDatetime":"May 14, 2018 8:15:41 PM","updater":"admin","userId":"U201805061611515474805"}
     * loanStartDatetime : Apr 30, 2018 12:00:00 AM
     * lyDeposit : 3.0E7
     * monthAmount : 5833330.0
     * monthDatetime : 20.0
     * overdueAmount : 0.0
     * periods : 24.0
     * refCode : LO201805061345029723893
     * refType : 0
     * remark : 审核通过
     * repayPlanList : [{"code":"RP201805141639121479814","curPeriods":1,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Apr 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121491844","curPeriods":10,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Jan 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121492292","curPeriods":9,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Dec 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121492311","curPeriods":7,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Oct 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121493801","curPeriods":12,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Mar 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121494206","curPeriods":5,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Aug 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121496009","curPeriods":3,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Jun 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121496697","curPeriods":2,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"May 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121497502","curPeriods":8,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Nov 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121497801","curPeriods":6,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Sep 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121498858","curPeriods":4,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Jul 20, 2019 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121499002","curPeriods":11,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Feb 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121501307","curPeriods":18,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Sep 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121501335","curPeriods":14,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"May 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121502068","curPeriods":20,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Nov 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121502579","curPeriods":19,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Oct 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121503877","curPeriods":21,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Dec 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121504105","curPeriods":24,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Mar 20, 2021 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121506388","curPeriods":13,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Apr 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121506471","curPeriods":22,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Jan 20, 2021 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121506598","curPeriods":16,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Jul 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121507520","curPeriods":23,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Feb 20, 2021 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121507657","curPeriods":15,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Jun 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"},{"code":"RP201805141639121509780","curPeriods":17,"overdueAmount":0,"overdueDeposit":0,"overplusAmount":0,"payedAmount":0,"payedFee":0,"periods":24,"remindCount":0,"repayBizCode":"RB201805141639121408953","repayCapital":5833330,"repayDatetime":"Aug 20, 2020 12:00:00 AM","repayInterest":0,"shouldDeposit":0,"status":"0","totalFee":0,"userId":"U201805061611515474805"}]
     * restAmount : 1.3416659E8
     * restPeriods : 24.0
     * restTotalCost : 0.0
     * sfAmount : 6.0E7
     * sfRate : 0.3
     * status : 0
     * totalInDeposit : 0.0
     * totalOverdueCount : 0.0
     * updateDatetime : May 14, 2018 4:39:12 PM
     * updater : admin
     * user : {"bankcardFlag":false,"blacklistFlag":false,"createDatetime":"May 6, 2018 4:11:51 PM","idKind":"1","idNo":"330281198908023311","identifyFlag":false,"kind":"C","loginName":"15268501481","loginPwdStrength":"1","mobile":"15268501481","nickname":"大黄","photo":"U12345678","realName":"郑海清","remark":"注销","status":"0","tradePwdStrength":"1","tradepwdFlag":false,"userId":"U201805061611515474805"}
     * userId : U201805061611515474805
     */

    private double bankRate;
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
    private LoanOrderBean budgetOrder;
    private MallOrderBean mallOrder;
    private String loanStartDatetime;
    private double lyDeposit;
    private double monthAmount;
    private double monthDatetime;
    private double overdueAmount;
    private double periods;
    private String refCode;
    private String refType;
    private String remark;
    private BigDecimal restAmount;
    private double restPeriods;
    private double restTotalCost;
    private double sfAmount;
    private double sfRate;
    private String status;
    private double totalInDeposit;
    private double totalOverdueCount;
    private String updateDatetime;
    private String updater;
    private UserBean user;
    private String userId;
    private List<RepayPlanListBean> repayPlanList;


    public double getBankRate() {
        return bankRate;
    }

    public void setBankRate(double bankRate) {
        this.bankRate = bankRate;
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

    public LoanOrderBean getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(LoanOrderBean budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public MallOrderBean getMallOrder() {
        return mallOrder;
    }

    public void setMallOrder(MallOrderBean mallOrder) {
        this.mallOrder = mallOrder;
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

    public BigDecimal getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(BigDecimal restAmount) {
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

    public List<RepayPlanListBean> getRepayPlanList() {
        return repayPlanList;
    }

    public void setRepayPlanList(List<RepayPlanListBean> repayPlanList) {
        this.repayPlanList = repayPlanList;
    }

    public static class MallOrderBean implements Serializable{


        /**
         * amount : 1000.0
         * applyDatetime : May 20, 2018 11:57:00 PM
         * applyUser : U201805181545538547345
         * bankRate : 0.1
         * bankcardCode : BC201805202047449389143
         * bankcardNumber : 123456789012345
         * code : DD201805202357001287068
         * loanAmount : 700.0
         * payAmount : 0.0
         * payDatetime : May 20, 2018 11:57:30 PM
         * periods : 3.0
         * productOrderList : [{"bankRate":0.1,"code":"CD201805202357001289656","orderCode":"DD201805202357001287068","periods":3,"price":1000,"product":{"advPic":"http://pic39.nipic.com/20140311/8821914_214422866000_2.jpg","name":"1000"},"productCode":"CP201805062109137465648","productSpecsCode":"PS201805062109137596153","productSpecsName":"1000","quantity":1,"sfRate":0.3}]
         * reAddress : 浙江省 杭州市 余杭区梦想小镇
         * reMobile : 18984955240
         * receiver : 雷黔
         * remark : 订单已成功支付
         * sfAmount : 300.0
         * sfRate : 0.3
         * status : 2
         * updateDatetime : May 20, 2018 11:57:00 PM
         * updater : U201805181545538547345
         * user : {"bankcardFlag":false,"blacklistFlag":false,"createDatetime":"May 18, 2018 3:45:53 PM","identifyFlag":false,"kind":"C","loginName":"18984955240","loginPwdStrength":"1","mobile":"18984955240","nickname":"？？我去。。","photo":"ANDROID_1526825442334_3120_4160.jpg","status":"0","tradePwdStrength":"1","tradepwdFlag":false,"userId":"U201805181545538547345"}
         * yunfei : 0.0
         */

        private double amount;
        private String applyDatetime;
        private String applyUser;
        private double bankRate;
        private String bankcardCode;
        private String bankcardNumber;
        private String code;
        private double loanAmount;
        private double payAmount;
        private String payDatetime;
        private double periods;
        private String reAddress;
        private String reMobile;
        private String receiver;
        private String remark;
        private double sfAmount;
        private double sfRate;
        private String status;
        private String updateDatetime;
        private String updater;
        private UserBean user;
        private double yunfei;

        private List<ProductOrderListBean> productOrderList;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getApplyDatetime() {
            return applyDatetime;
        }

        public void setApplyDatetime(String applyDatetime) {
            this.applyDatetime = applyDatetime;
        }

        public String getApplyUser() {
            return applyUser;
        }

        public void setApplyUser(String applyUser) {
            this.applyUser = applyUser;
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

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public double getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(double payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayDatetime() {
            return payDatetime;
        }

        public void setPayDatetime(String payDatetime) {
            this.payDatetime = payDatetime;
        }

        public double getPeriods() {
            return periods;
        }

        public void setPeriods(double periods) {
            this.periods = periods;
        }

        public String getReAddress() {
            return reAddress;
        }

        public void setReAddress(String reAddress) {
            this.reAddress = reAddress;
        }

        public String getReMobile() {
            return reMobile;
        }

        public void setReMobile(String reMobile) {
            this.reMobile = reMobile;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public double getYunfei() {
            return yunfei;
        }

        public void setYunfei(double yunfei) {
            this.yunfei = yunfei;
        }

        public List<ProductOrderListBean> getProductOrderList() {
            return productOrderList;
        }

        public void setProductOrderList(List<ProductOrderListBean> productOrderList) {
            this.productOrderList = productOrderList;
        }

        public static class UserBean implements Serializable{
            /**
             * bankcardFlag : false
             * blacklistFlag : false
             * createDatetime : May 18, 2018 3:45:53 PM
             * identifyFlag : false
             * kind : C
             * loginName : 18984955240
             * loginPwdStrength : 1
             * mobile : 18984955240
             * nickname : ？？我去。。
             * photo : ANDROID_1526825442334_3120_4160.jpg
             * status : 0
             * tradePwdStrength : 1
             * tradepwdFlag : false
             * userId : U201805181545538547345
             */

            private boolean bankcardFlag;
            private boolean blacklistFlag;
            private String createDatetime;
            private boolean identifyFlag;
            private String kind;
            private String loginName;
            private String loginPwdStrength;
            private String mobile;
            private String nickname;
            private String photo;
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

        public static class ProductOrderListBean implements Serializable{
            /**
             * bankRate : 0.1
             * code : CD201805202357001289656
             * orderCode : DD201805202357001287068
             * periods : 3.0
             * price : 1000.0
             * product : {"advPic":"http://pic39.nipic.com/20140311/8821914_214422866000_2.jpg","name":"1000"}
             * productCode : CP201805062109137465648
             * productSpecsCode : PS201805062109137596153
             * productSpecsName : 1000
             * quantity : 1.0
             * sfRate : 0.3
             */

            private double bankRate;
            private String code;
            private String orderCode;
            private double periods;
            private double price;
            private ProductBean product;
            private String productCode;
            private String productSpecsCode;
            private String productSpecsName;
            private double quantity;
            private double sfRate;
            private String productName;

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public double getBankRate() {
                return bankRate;
            }

            public void setBankRate(double bankRate) {
                this.bankRate = bankRate;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getOrderCode() {
                return orderCode;
            }

            public void setOrderCode(String orderCode) {
                this.orderCode = orderCode;
            }

            public double getPeriods() {
                return periods;
            }

            public void setPeriods(double periods) {
                this.periods = periods;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public ProductBean getProduct() {
                return product;
            }

            public void setProduct(ProductBean product) {
                this.product = product;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public String getProductSpecsCode() {
                return productSpecsCode;
            }

            public void setProductSpecsCode(String productSpecsCode) {
                this.productSpecsCode = productSpecsCode;
            }

            public String getProductSpecsName() {
                return productSpecsName;
            }

            public void setProductSpecsName(String productSpecsName) {
                this.productSpecsName = productSpecsName;
            }

            public double getQuantity() {
                return quantity;
            }

            public void setQuantity(double quantity) {
                this.quantity = quantity;
            }

            public double getSfRate() {
                return sfRate;
            }

            public void setSfRate(double sfRate) {
                this.sfRate = sfRate;
            }

            public static class ProductBean implements Serializable{
                /**
                 * advPic : http://pic39.nipic.com/20140311/8821914_214422866000_2.jpg
                 * name : 1000
                 */

                private String advPic;
                private String name;

                public String getAdvPic() {
                    return advPic;
                }

                public void setAdvPic(String advPic) {
                    this.advPic = advPic;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }

    public static class LoanOrderBean implements Serializable{


        /**
         * code : BO201806010742311246375
         * repayBizCode : RB201806010822188504250
         * loanProductCode : LP201806010719319062250
         * loanProductName : 贷款产品001
         * loanBank : BA201806010718324895638
         * gpsFee : 12000.0
         * authFee : 10000.0
         * fee : 11000.0
         * monthRate : 0.1
         * creditCode : C201806010735282463553
         * bizType : 0
         * loanPeriod : 24
         * invoiceCompany : 开票单位
         * carBrand : 品牌
         * originalPrice : 1.0E8
         * invoicePrice : 1.8E7
         * carColor : 吧
         * monthDeposit : 1.0E7
         * firstAmount : 1.0E7
         * firstRate : 10.0
         * loanAmount : 1.8E7
         * settleAddress : 落户地点
         * applyUserId : U201806010822188457818
         * applyUserName : 申请人信息
         * gender : 1
         * marryState : 2
         * nation : 汉
         * education : 1
         * idNo : 510521199404167983
         * familyNumber : 5
         * mobile : 15761663457
         * nowAddress : 申请人信息现居住地址
         * postCode1 : 15120
         * residenceAddress : 申请人信息户口所在地
         * postCode2 : 45312
         * familyMainAsset : 申请人信息家庭主要财产
         * mainAssetInclude : 主要财产包括
         * mainIncome : 1
         * workCompanyName : 申请人信息工作单位名称
         * workCompanyAddress : 申请人信息工作单位地址
         * selfCompanyArea : 5000
         * employeeQuantity : 500
         * enterpriseMonthOutput : 150000
         * position : 申请人信息职位
         * postTitle : 申请人信息职称
         * monthIncome : 18000
         * mateName : 配偶信息
         * mateMobile : 15761663457
         * mateIdNo : 510521199404167983
         * mateEducation : 1
         * mateCompanyName : 配偶信息工作单位名称
         * mateCompanyAddress : 配偶信息工作单位地址
         * mateCompanyContactNo : 15761663457
         * guaName : 担保人信息
         * guaMobile : 15761633457
         * guaIdNo : 510521199404167983
         * guaPhone : 500153
         * guaCompanyName : 担保人信息工作单位名称
         * guaCompanyAddress : 担保人信息工作单位地址
         * guaHouseAssetAddress : 担保人房产地址
         * emergencyName1 : 联系人1
         * emergencyRelation1 : 联系人1申请人关系
         * emergencyMobile1 : 15761663457
         * emergencyName2 : 联系人2
         * emergencyRelation2 : 联系人2申请人关系
         * emergencyMobile2 : 15761663457
         * jourDatetimeStart : Jun 1, 2018 12:00:00 AM
         * jourDatetimeEnd : Jun 2, 2018 12:00:00 AM
         * jourIncome : 100000.0
         * jourExpend : 5000.0
         * jourBalance : 1000000.0
         * jourMonthIncome : 150000.0
         * jourMonthExpend : 10000.0
         * jourRemark : 1201
         * houseContract : FuARN6YAubJ0umx1NPueecjwM0C4
         * housePicture : FuARN6YAubJ0umx1NPueecjwM0C4
         * isAdvanceFund : 1
         * interviewVideo : FkMaE_jJLB_1fAsrZ3cK_nqOMy3j
         * interviewContract : FjqbYdCYiK6Dkp0UqO8VPZrT6Ob7
         * advanceFundDatetime : Jun 1, 2018 12:00:00 AM
         * advanceFundAmount : 1.8E7
         * carSettleDatetime : Jun 2, 2018 12:00:00 AM
         * carNumber : 浙A123132
         * carInvoice : FuARN6YAubJ0umx1NPueecjwM0C4
         * carHgz : FuARN6YAubJ0umx1NPueecjwM0C4
         * carJqx : FuARN6YAubJ0umx1NPueecjwM0C4
         * carSyx : FuARN6YAubJ0umx1NPueecjwM0C4
         * carRegcerti : FuARN6YAubJ0umx1NPueecjwM0C4
         * carPd : FooyIpMic9O-rGcyaAqWy1vY4mLI
         * carKey : FooyIpMic9O-rGcyaAqWy1vY4mLI
         * carBigSmj : FooyIpMic9O-rGcyaAqWy1vY4mLI
         * bankCommitDatetime : Jun 1, 2018 12:00:00 AM
         * repayBankcardNumber : 612121313131313
         * repayBillDate : 15.0
         * repayBankDate : 15.0
         * repayFirstMonthAmount : 1.0E8
         * repayFirstMonthDatetime : Jun 2, 2018 12:00:00 AM
         * repayMonthAmount : 1.0E7
         * receiptBankCode : CMBC
         * receiptBankcardNumber : 61234567891324568
         * receiptPdf : FuARN6YAubJ0umx1NPueecjwM0C4
         * receiptRemark :
         * pledgeDatetime : Jun 1, 2018 12:00:00 AM
         * greenBigSmj : FooyIpMic9O-rGcyaAqWy1vY4mLI
         * pledgeBankCommitDatetime : Jun 1, 2018 12:00:00 AM
         * saleUserId : U201806010724286998427
         * companyCode : DP201800000000000000001
         * applyDatetime : Jun 1, 2018 7:42:31 AM
         * curNodeCode : 002_23
         * remark :
         * budgetOrderGpsList : [{"code":"GPSAZ201806010812307864013","gpsDevNo":"89787","gpsType":"0","azLocation":"上","azDatetime":"2018-06-01 00:00:00.0","azUser":"搜索","remark":"","budgetOrder":"BO201806010742311246375"}]
         * companyName : 乌鲁木齐华途威通汽车销售有限公司
         * saleUserName : 胡莎莎
         * loanBankName : 招商银行
         */

        private String code;
        private String repayBizCode;
        private String loanProductCode;
        private String loanProductName;
        private String loanBank;
        private double gpsFee;
        private double authFee;
        private double fee;
        private double monthRate;
        private String creditCode;
        private String bizType;
        private String loanPeriod;
        private String invoiceCompany;
        private String carBrand;
        private double originalPrice;
        private double invoicePrice;
        private String carColor;
        private double monthDeposit;
        private double firstAmount;
        private double firstRate;
        private double loanAmount;
        private String settleAddress;
        private String applyUserId;
        private String applyUserName;
        private String gender;
        private String marryState;
        private String nation;
        private String education;
        private String idNo;
        private String familyNumber;
        private String mobile;
        private String nowAddress;
        private String postCode1;
        private String residenceAddress;
        private String postCode2;
        private String familyMainAsset;
        private String mainAssetInclude;
        private String mainIncome;
        private String workCompanyName;
        private String workCompanyAddress;
        private String selfCompanyArea;
        private String employeeQuantity;
        private String enterpriseMonthOutput;
        private String position;
        private String postTitle;
        private String monthIncome;
        private String mateName;
        private String mateMobile;
        private String mateIdNo;
        private String mateEducation;
        private String mateCompanyName;
        private String mateCompanyAddress;
        private String mateCompanyContactNo;
        private String guaName;
        private String guaMobile;
        private String guaIdNo;
        private String guaPhone;
        private String guaCompanyName;
        private String guaCompanyAddress;
        private String guaHouseAssetAddress;
        private String emergencyName1;
        private String emergencyRelation1;
        private String emergencyMobile1;
        private String emergencyName2;
        private String emergencyRelation2;
        private String emergencyMobile2;
        private String jourDatetimeStart;
        private String jourDatetimeEnd;
        private double jourIncome;
        private double jourExpend;
        private double jourBalance;
        private double jourMonthIncome;
        private double jourMonthExpend;
        private String jourRemark;
        private String houseContract;
        private String housePicture;
        private String isAdvanceFund;
        private String interviewVideo;
        private String interviewContract;
        private String advanceFundDatetime;
        private double advanceFundAmount;
        private String carSettleDatetime;
        private String carNumber;
        private String carInvoice;
        private String carHgz;
        private String carJqx;
        private String carSyx;
        private String carRegcerti;
        private String carPd;
        private String carKey;
        private String carBigSmj;
        private String bankCommitDatetime;
        private String repayBankcardNumber;
        private double repayBillDate;
        private double repayBankDate;
        private double repayFirstMonthAmount;
        private String repayFirstMonthDatetime;
        private double repayMonthAmount;
        private String receiptBankCode;
        private String receiptBankcardNumber;
        private String receiptPdf;
        private String receiptRemark;
        private String pledgeDatetime;
        private String greenBigSmj;
        private String pledgeBankCommitDatetime;
        private String saleUserId;
        private String companyCode;
        private String applyDatetime;
        private String curNodeCode;
        private String remark;
        private String companyName;
        private String saleUserName;
        private String loanBankName;
        private List<BudgetOrderGpsListBean> budgetOrderGpsList;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getRepayBizCode() {
            return repayBizCode;
        }

        public void setRepayBizCode(String repayBizCode) {
            this.repayBizCode = repayBizCode;
        }

        public String getLoanProductCode() {
            return loanProductCode;
        }

        public void setLoanProductCode(String loanProductCode) {
            this.loanProductCode = loanProductCode;
        }

        public String getLoanProductName() {
            return loanProductName;
        }

        public void setLoanProductName(String loanProductName) {
            this.loanProductName = loanProductName;
        }

        public String getLoanBank() {
            return loanBank;
        }

        public void setLoanBank(String loanBank) {
            this.loanBank = loanBank;
        }

        public double getGpsFee() {
            return gpsFee;
        }

        public void setGpsFee(double gpsFee) {
            this.gpsFee = gpsFee;
        }

        public double getAuthFee() {
            return authFee;
        }

        public void setAuthFee(double authFee) {
            this.authFee = authFee;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        public double getMonthRate() {
            return monthRate;
        }

        public void setMonthRate(double monthRate) {
            this.monthRate = monthRate;
        }

        public String getCreditCode() {
            return creditCode;
        }

        public void setCreditCode(String creditCode) {
            this.creditCode = creditCode;
        }

        public String getBizType() {
            return bizType;
        }

        public void setBizType(String bizType) {
            this.bizType = bizType;
        }

        public String getLoanPeriod() {
            return loanPeriod;
        }

        public void setLoanPeriod(String loanPeriod) {
            this.loanPeriod = loanPeriod;
        }

        public String getInvoiceCompany() {
            return invoiceCompany;
        }

        public void setInvoiceCompany(String invoiceCompany) {
            this.invoiceCompany = invoiceCompany;
        }

        public String getCarBrand() {
            return carBrand;
        }

        public void setCarBrand(String carBrand) {
            this.carBrand = carBrand;
        }

        public double getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(double originalPrice) {
            this.originalPrice = originalPrice;
        }

        public double getInvoicePrice() {
            return invoicePrice;
        }

        public void setInvoicePrice(double invoicePrice) {
            this.invoicePrice = invoicePrice;
        }

        public String getCarColor() {
            return carColor;
        }

        public void setCarColor(String carColor) {
            this.carColor = carColor;
        }

        public double getMonthDeposit() {
            return monthDeposit;
        }

        public void setMonthDeposit(double monthDeposit) {
            this.monthDeposit = monthDeposit;
        }

        public double getFirstAmount() {
            return firstAmount;
        }

        public void setFirstAmount(double firstAmount) {
            this.firstAmount = firstAmount;
        }

        public double getFirstRate() {
            return firstRate;
        }

        public void setFirstRate(double firstRate) {
            this.firstRate = firstRate;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public String getSettleAddress() {
            return settleAddress;
        }

        public void setSettleAddress(String settleAddress) {
            this.settleAddress = settleAddress;
        }

        public String getApplyUserId() {
            return applyUserId;
        }

        public void setApplyUserId(String applyUserId) {
            this.applyUserId = applyUserId;
        }

        public String getApplyUserName() {
            return applyUserName;
        }

        public void setApplyUserName(String applyUserName) {
            this.applyUserName = applyUserName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMarryState() {
            return marryState;
        }

        public void setMarryState(String marryState) {
            this.marryState = marryState;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getFamilyNumber() {
            return familyNumber;
        }

        public void setFamilyNumber(String familyNumber) {
            this.familyNumber = familyNumber;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNowAddress() {
            return nowAddress;
        }

        public void setNowAddress(String nowAddress) {
            this.nowAddress = nowAddress;
        }

        public String getPostCode1() {
            return postCode1;
        }

        public void setPostCode1(String postCode1) {
            this.postCode1 = postCode1;
        }

        public String getResidenceAddress() {
            return residenceAddress;
        }

        public void setResidenceAddress(String residenceAddress) {
            this.residenceAddress = residenceAddress;
        }

        public String getPostCode2() {
            return postCode2;
        }

        public void setPostCode2(String postCode2) {
            this.postCode2 = postCode2;
        }

        public String getFamilyMainAsset() {
            return familyMainAsset;
        }

        public void setFamilyMainAsset(String familyMainAsset) {
            this.familyMainAsset = familyMainAsset;
        }

        public String getMainAssetInclude() {
            return mainAssetInclude;
        }

        public void setMainAssetInclude(String mainAssetInclude) {
            this.mainAssetInclude = mainAssetInclude;
        }

        public String getMainIncome() {
            return mainIncome;
        }

        public void setMainIncome(String mainIncome) {
            this.mainIncome = mainIncome;
        }

        public String getWorkCompanyName() {
            return workCompanyName;
        }

        public void setWorkCompanyName(String workCompanyName) {
            this.workCompanyName = workCompanyName;
        }

        public String getWorkCompanyAddress() {
            return workCompanyAddress;
        }

        public void setWorkCompanyAddress(String workCompanyAddress) {
            this.workCompanyAddress = workCompanyAddress;
        }

        public String getSelfCompanyArea() {
            return selfCompanyArea;
        }

        public void setSelfCompanyArea(String selfCompanyArea) {
            this.selfCompanyArea = selfCompanyArea;
        }

        public String getEmployeeQuantity() {
            return employeeQuantity;
        }

        public void setEmployeeQuantity(String employeeQuantity) {
            this.employeeQuantity = employeeQuantity;
        }

        public String getEnterpriseMonthOutput() {
            return enterpriseMonthOutput;
        }

        public void setEnterpriseMonthOutput(String enterpriseMonthOutput) {
            this.enterpriseMonthOutput = enterpriseMonthOutput;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getPostTitle() {
            return postTitle;
        }

        public void setPostTitle(String postTitle) {
            this.postTitle = postTitle;
        }

        public String getMonthIncome() {
            return monthIncome;
        }

        public void setMonthIncome(String monthIncome) {
            this.monthIncome = monthIncome;
        }

        public String getMateName() {
            return mateName;
        }

        public void setMateName(String mateName) {
            this.mateName = mateName;
        }

        public String getMateMobile() {
            return mateMobile;
        }

        public void setMateMobile(String mateMobile) {
            this.mateMobile = mateMobile;
        }

        public String getMateIdNo() {
            return mateIdNo;
        }

        public void setMateIdNo(String mateIdNo) {
            this.mateIdNo = mateIdNo;
        }

        public String getMateEducation() {
            return mateEducation;
        }

        public void setMateEducation(String mateEducation) {
            this.mateEducation = mateEducation;
        }

        public String getMateCompanyName() {
            return mateCompanyName;
        }

        public void setMateCompanyName(String mateCompanyName) {
            this.mateCompanyName = mateCompanyName;
        }

        public String getMateCompanyAddress() {
            return mateCompanyAddress;
        }

        public void setMateCompanyAddress(String mateCompanyAddress) {
            this.mateCompanyAddress = mateCompanyAddress;
        }

        public String getMateCompanyContactNo() {
            return mateCompanyContactNo;
        }

        public void setMateCompanyContactNo(String mateCompanyContactNo) {
            this.mateCompanyContactNo = mateCompanyContactNo;
        }

        public String getGuaName() {
            return guaName;
        }

        public void setGuaName(String guaName) {
            this.guaName = guaName;
        }

        public String getGuaMobile() {
            return guaMobile;
        }

        public void setGuaMobile(String guaMobile) {
            this.guaMobile = guaMobile;
        }

        public String getGuaIdNo() {
            return guaIdNo;
        }

        public void setGuaIdNo(String guaIdNo) {
            this.guaIdNo = guaIdNo;
        }

        public String getGuaPhone() {
            return guaPhone;
        }

        public void setGuaPhone(String guaPhone) {
            this.guaPhone = guaPhone;
        }

        public String getGuaCompanyName() {
            return guaCompanyName;
        }

        public void setGuaCompanyName(String guaCompanyName) {
            this.guaCompanyName = guaCompanyName;
        }

        public String getGuaCompanyAddress() {
            return guaCompanyAddress;
        }

        public void setGuaCompanyAddress(String guaCompanyAddress) {
            this.guaCompanyAddress = guaCompanyAddress;
        }

        public String getGuaHouseAssetAddress() {
            return guaHouseAssetAddress;
        }

        public void setGuaHouseAssetAddress(String guaHouseAssetAddress) {
            this.guaHouseAssetAddress = guaHouseAssetAddress;
        }

        public String getEmergencyName1() {
            return emergencyName1;
        }

        public void setEmergencyName1(String emergencyName1) {
            this.emergencyName1 = emergencyName1;
        }

        public String getEmergencyRelation1() {
            return emergencyRelation1;
        }

        public void setEmergencyRelation1(String emergencyRelation1) {
            this.emergencyRelation1 = emergencyRelation1;
        }

        public String getEmergencyMobile1() {
            return emergencyMobile1;
        }

        public void setEmergencyMobile1(String emergencyMobile1) {
            this.emergencyMobile1 = emergencyMobile1;
        }

        public String getEmergencyName2() {
            return emergencyName2;
        }

        public void setEmergencyName2(String emergencyName2) {
            this.emergencyName2 = emergencyName2;
        }

        public String getEmergencyRelation2() {
            return emergencyRelation2;
        }

        public void setEmergencyRelation2(String emergencyRelation2) {
            this.emergencyRelation2 = emergencyRelation2;
        }

        public String getEmergencyMobile2() {
            return emergencyMobile2;
        }

        public void setEmergencyMobile2(String emergencyMobile2) {
            this.emergencyMobile2 = emergencyMobile2;
        }

        public String getJourDatetimeStart() {
            return jourDatetimeStart;
        }

        public void setJourDatetimeStart(String jourDatetimeStart) {
            this.jourDatetimeStart = jourDatetimeStart;
        }

        public String getJourDatetimeEnd() {
            return jourDatetimeEnd;
        }

        public void setJourDatetimeEnd(String jourDatetimeEnd) {
            this.jourDatetimeEnd = jourDatetimeEnd;
        }

        public double getJourIncome() {
            return jourIncome;
        }

        public void setJourIncome(double jourIncome) {
            this.jourIncome = jourIncome;
        }

        public double getJourExpend() {
            return jourExpend;
        }

        public void setJourExpend(double jourExpend) {
            this.jourExpend = jourExpend;
        }

        public double getJourBalance() {
            return jourBalance;
        }

        public void setJourBalance(double jourBalance) {
            this.jourBalance = jourBalance;
        }

        public double getJourMonthIncome() {
            return jourMonthIncome;
        }

        public void setJourMonthIncome(double jourMonthIncome) {
            this.jourMonthIncome = jourMonthIncome;
        }

        public double getJourMonthExpend() {
            return jourMonthExpend;
        }

        public void setJourMonthExpend(double jourMonthExpend) {
            this.jourMonthExpend = jourMonthExpend;
        }

        public String getJourRemark() {
            return jourRemark;
        }

        public void setJourRemark(String jourRemark) {
            this.jourRemark = jourRemark;
        }

        public String getHouseContract() {
            return houseContract;
        }

        public void setHouseContract(String houseContract) {
            this.houseContract = houseContract;
        }

        public String getHousePicture() {
            return housePicture;
        }

        public void setHousePicture(String housePicture) {
            this.housePicture = housePicture;
        }

        public String getIsAdvanceFund() {
            return isAdvanceFund;
        }

        public void setIsAdvanceFund(String isAdvanceFund) {
            this.isAdvanceFund = isAdvanceFund;
        }

        public String getInterviewVideo() {
            return interviewVideo;
        }

        public void setInterviewVideo(String interviewVideo) {
            this.interviewVideo = interviewVideo;
        }

        public String getInterviewContract() {
            return interviewContract;
        }

        public void setInterviewContract(String interviewContract) {
            this.interviewContract = interviewContract;
        }

        public String getAdvanceFundDatetime() {
            return advanceFundDatetime;
        }

        public void setAdvanceFundDatetime(String advanceFundDatetime) {
            this.advanceFundDatetime = advanceFundDatetime;
        }

        public double getAdvanceFundAmount() {
            return advanceFundAmount;
        }

        public void setAdvanceFundAmount(double advanceFundAmount) {
            this.advanceFundAmount = advanceFundAmount;
        }

        public String getCarSettleDatetime() {
            return carSettleDatetime;
        }

        public void setCarSettleDatetime(String carSettleDatetime) {
            this.carSettleDatetime = carSettleDatetime;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }

        public String getCarInvoice() {
            return carInvoice;
        }

        public void setCarInvoice(String carInvoice) {
            this.carInvoice = carInvoice;
        }

        public String getCarHgz() {
            return carHgz;
        }

        public void setCarHgz(String carHgz) {
            this.carHgz = carHgz;
        }

        public String getCarJqx() {
            return carJqx;
        }

        public void setCarJqx(String carJqx) {
            this.carJqx = carJqx;
        }

        public String getCarSyx() {
            return carSyx;
        }

        public void setCarSyx(String carSyx) {
            this.carSyx = carSyx;
        }

        public String getCarRegcerti() {
            return carRegcerti;
        }

        public void setCarRegcerti(String carRegcerti) {
            this.carRegcerti = carRegcerti;
        }

        public String getCarPd() {
            return carPd;
        }

        public void setCarPd(String carPd) {
            this.carPd = carPd;
        }

        public String getCarKey() {
            return carKey;
        }

        public void setCarKey(String carKey) {
            this.carKey = carKey;
        }

        public String getCarBigSmj() {
            return carBigSmj;
        }

        public void setCarBigSmj(String carBigSmj) {
            this.carBigSmj = carBigSmj;
        }

        public String getBankCommitDatetime() {
            return bankCommitDatetime;
        }

        public void setBankCommitDatetime(String bankCommitDatetime) {
            this.bankCommitDatetime = bankCommitDatetime;
        }

        public String getRepayBankcardNumber() {
            return repayBankcardNumber;
        }

        public void setRepayBankcardNumber(String repayBankcardNumber) {
            this.repayBankcardNumber = repayBankcardNumber;
        }

        public double getRepayBillDate() {
            return repayBillDate;
        }

        public void setRepayBillDate(double repayBillDate) {
            this.repayBillDate = repayBillDate;
        }

        public double getRepayBankDate() {
            return repayBankDate;
        }

        public void setRepayBankDate(double repayBankDate) {
            this.repayBankDate = repayBankDate;
        }

        public double getRepayFirstMonthAmount() {
            return repayFirstMonthAmount;
        }

        public void setRepayFirstMonthAmount(double repayFirstMonthAmount) {
            this.repayFirstMonthAmount = repayFirstMonthAmount;
        }

        public String getRepayFirstMonthDatetime() {
            return repayFirstMonthDatetime;
        }

        public void setRepayFirstMonthDatetime(String repayFirstMonthDatetime) {
            this.repayFirstMonthDatetime = repayFirstMonthDatetime;
        }

        public double getRepayMonthAmount() {
            return repayMonthAmount;
        }

        public void setRepayMonthAmount(double repayMonthAmount) {
            this.repayMonthAmount = repayMonthAmount;
        }

        public String getReceiptBankCode() {
            return receiptBankCode;
        }

        public void setReceiptBankCode(String receiptBankCode) {
            this.receiptBankCode = receiptBankCode;
        }

        public String getReceiptBankcardNumber() {
            return receiptBankcardNumber;
        }

        public void setReceiptBankcardNumber(String receiptBankcardNumber) {
            this.receiptBankcardNumber = receiptBankcardNumber;
        }

        public String getReceiptPdf() {
            return receiptPdf;
        }

        public void setReceiptPdf(String receiptPdf) {
            this.receiptPdf = receiptPdf;
        }

        public String getReceiptRemark() {
            return receiptRemark;
        }

        public void setReceiptRemark(String receiptRemark) {
            this.receiptRemark = receiptRemark;
        }

        public String getPledgeDatetime() {
            return pledgeDatetime;
        }

        public void setPledgeDatetime(String pledgeDatetime) {
            this.pledgeDatetime = pledgeDatetime;
        }

        public String getGreenBigSmj() {
            return greenBigSmj;
        }

        public void setGreenBigSmj(String greenBigSmj) {
            this.greenBigSmj = greenBigSmj;
        }

        public String getPledgeBankCommitDatetime() {
            return pledgeBankCommitDatetime;
        }

        public void setPledgeBankCommitDatetime(String pledgeBankCommitDatetime) {
            this.pledgeBankCommitDatetime = pledgeBankCommitDatetime;
        }

        public String getSaleUserId() {
            return saleUserId;
        }

        public void setSaleUserId(String saleUserId) {
            this.saleUserId = saleUserId;
        }

        public String getCompanyCode() {
            return companyCode;
        }

        public void setCompanyCode(String companyCode) {
            this.companyCode = companyCode;
        }

        public String getApplyDatetime() {
            return applyDatetime;
        }

        public void setApplyDatetime(String applyDatetime) {
            this.applyDatetime = applyDatetime;
        }

        public String getCurNodeCode() {
            return curNodeCode;
        }

        public void setCurNodeCode(String curNodeCode) {
            this.curNodeCode = curNodeCode;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getSaleUserName() {
            return saleUserName;
        }

        public void setSaleUserName(String saleUserName) {
            this.saleUserName = saleUserName;
        }

        public String getLoanBankName() {
            return loanBankName;
        }

        public void setLoanBankName(String loanBankName) {
            this.loanBankName = loanBankName;
        }

        public List<BudgetOrderGpsListBean> getBudgetOrderGpsList() {
            return budgetOrderGpsList;
        }

        public void setBudgetOrderGpsList(List<BudgetOrderGpsListBean> budgetOrderGpsList) {
            this.budgetOrderGpsList = budgetOrderGpsList;
        }

        public static class BudgetOrderGpsListBean implements Serializable {
            /**
             * code : GPSAZ201806010812307864013
             * gpsDevNo : 89787
             * gpsType : 0
             * azLocation : 上
             * azDatetime : 2018-06-01 00:00:00.0
             * azUser : 搜索
             * remark :
             * budgetOrder : BO201806010742311246375
             */

            private String code;
            private String gpsDevNo;
            private String gpsType;
            private String azLocation;
            private String azDatetime;
            private String azUser;
            private String remark;
            private String budgetOrder;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getGpsDevNo() {
                return gpsDevNo;
            }

            public void setGpsDevNo(String gpsDevNo) {
                this.gpsDevNo = gpsDevNo;
            }

            public String getGpsType() {
                return gpsType;
            }

            public void setGpsType(String gpsType) {
                this.gpsType = gpsType;
            }

            public String getAzLocation() {
                return azLocation;
            }

            public void setAzLocation(String azLocation) {
                this.azLocation = azLocation;
            }

            public String getAzDatetime() {
                return azDatetime;
            }

            public void setAzDatetime(String azDatetime) {
                this.azDatetime = azDatetime;
            }

            public String getAzUser() {
                return azUser;
            }

            public void setAzUser(String azUser) {
                this.azUser = azUser;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getBudgetOrder() {
                return budgetOrder;
            }

            public void setBudgetOrder(String budgetOrder) {
                this.budgetOrder = budgetOrder;
            }
        }
    }

    public static class UserBean implements Serializable {
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

    public static class RepayPlanListBean implements Serializable {
        /**
         * code : RP201805141639121479814
         * curPeriods : 1.0
         * overdueAmount : 0.0
         * overdueDeposit : 0.0
         * overplusAmount : 0.0
         * payedAmount : 0.0
         * payedFee : 0.0
         * periods : 24.0
         * remindCount : 0.0
         * repayBizCode : RB201805141639121408953
         * repayCapital : 5833330.0
         * repayDatetime : Apr 20, 2019 12:00:00 AM
         * repayInterest : 0.0
         * shouldDeposit : 0.0
         * status : 0
         * totalFee : 0.0
         * userId : U201805061611515474805
         */

        private String code;
        private double curPeriods;
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
        private String userId;

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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
