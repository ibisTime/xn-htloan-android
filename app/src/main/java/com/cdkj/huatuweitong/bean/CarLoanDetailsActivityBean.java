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
     * loanOrder : {"bankCode":"ICBC","bankName":"中国工商银行","bankRate":0.1,"bankcardNumber":"6217002710000684874","carCode":"C201804231832234243414","carPrice":2.0E8,"code":"LO201805061345029723893","firstRepayAmount":5833330,"firstRepayDatetime":"Apr 20, 2019 12:00:00 AM","fkDatetime":"Apr 30, 2018 12:00:00 AM","fxDeposit":2.0E7,"gpsFee":3000000,"idKind":"1","idNo":"330281198908023311","loanAmount":1.4E8,"loanBank":"中国建设银行","loanEndDatetime":"Apr 29, 2020 12:00:00 AM","loanStartDatetime":"Apr 30, 2018 12:00:00 AM","lyDeposit":3.0E7,"mobile":"15268501481","monthAmount":5833330,"monthDatetime":20,"otherFee":4654,"periods":24,"realName":"郑海清","remark":"审核通过","repayBizCode":"RB201805142015418326578","sfAmount":6.0E7,"sfRate":0.3,"status":"3","subbranch":"海创园支行","updateDatetime":"May 14, 2018 8:15:41 PM","updater":"admin","userId":"U201805061611515474805"}
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
    private LoanOrderBean loanOrder;
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

    public LoanOrderBean getLoanOrder() {
        return loanOrder;
    }

    public void setLoanOrder(LoanOrderBean loanOrder) {
        this.loanOrder = loanOrder;
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
         * bankCode : ICBC
         * bankName : 中国工商银行
         * bankRate : 0.1
         * bankcardNumber : 6217002710000684874
         * carCode : C201804231832234243414
         * carPrice : 2.0E8
         * code : LO201805061345029723893
         * firstRepayAmount : 5833330.0
         * firstRepayDatetime : Apr 20, 2019 12:00:00 AM
         * fkDatetime : Apr 30, 2018 12:00:00 AM
         * fxDeposit : 2.0E7
         * gpsFee : 3000000.0
         * idKind : 1
         * idNo : 330281198908023311
         * loanAmount : 1.4E8
         * loanBank : 中国建设银行
         * loanEndDatetime : Apr 29, 2020 12:00:00 AM
         * loanStartDatetime : Apr 30, 2018 12:00:00 AM
         * lyDeposit : 3.0E7
         * mobile : 15268501481
         * monthAmount : 5833330.0
         * monthDatetime : 20.0
         * otherFee : 4654.0
         * periods : 24.0
         * realName : 郑海清
         * remark : 审核通过
         * repayBizCode : RB201805142015418326578
         * sfAmount : 6.0E7
         * sfRate : 0.3
         * status : 3
         * subbranch : 海创园支行
         * updateDatetime : May 14, 2018 8:15:41 PM
         * updater : admin
         * userId : U201805061611515474805
         */

        private String bankCode;
        private String bankName;
        private double bankRate;
        private String bankcardNumber;
        private String carCode;
        private double carPrice;
        private String code;
        private double firstRepayAmount;
        private String firstRepayDatetime;
        private String fkDatetime;
        private double fxDeposit;
        private double gpsFee;
        private String idKind;
        private String idNo;
        private double loanAmount;
        private String loanBank;
        private String loanEndDatetime;
        private String loanStartDatetime;
        private double lyDeposit;
        private String mobile;
        private double monthAmount;
        private double monthDatetime;
        private double otherFee;
        private double periods;
        private String realName;
        private String remark;
        private String repayBizCode;
        private double sfAmount;
        private double sfRate;
        private String status;
        private String subbranch;
        private String updateDatetime;
        private String updater;
        private String userId;
        private String carName;


        public String getCarName() {
            return carName;
        }

        public void setCarName(String carName) {
            this.carName = carName;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public double getBankRate() {
            return bankRate;
        }

        public void setBankRate(double bankRate) {
            this.bankRate = bankRate;
        }

        public String getBankcardNumber() {
            return bankcardNumber;
        }

        public void setBankcardNumber(String bankcardNumber) {
            this.bankcardNumber = bankcardNumber;
        }

        public String getCarCode() {
            return carCode;
        }

        public void setCarCode(String carCode) {
            this.carCode = carCode;
        }

        public double getCarPrice() {
            return carPrice;
        }

        public void setCarPrice(double carPrice) {
            this.carPrice = carPrice;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public String getFkDatetime() {
            return fkDatetime;
        }

        public void setFkDatetime(String fkDatetime) {
            this.fkDatetime = fkDatetime;
        }

        public double getFxDeposit() {
            return fxDeposit;
        }

        public void setFxDeposit(double fxDeposit) {
            this.fxDeposit = fxDeposit;
        }

        public double getGpsFee() {
            return gpsFee;
        }

        public void setGpsFee(double gpsFee) {
            this.gpsFee = gpsFee;
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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
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

        public double getOtherFee() {
            return otherFee;
        }

        public void setOtherFee(double otherFee) {
            this.otherFee = otherFee;
        }

        public double getPeriods() {
            return periods;
        }

        public void setPeriods(double periods) {
            this.periods = periods;
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

        public String getRepayBizCode() {
            return repayBizCode;
        }

        public void setRepayBizCode(String repayBizCode) {
            this.repayBizCode = repayBizCode;
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

        public String getSubbranch() {
            return subbranch;
        }

        public void setSubbranch(String subbranch) {
            this.subbranch = subbranch;
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
