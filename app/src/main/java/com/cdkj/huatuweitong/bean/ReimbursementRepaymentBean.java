package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/17
 * Created by lenovo on 2018/5/17.
 * 近期还款的bean
 */

public class ReimbursementRepaymentBean {


    /**
     * code : RB201805061611515783630
     * userId : U201805061611515474805
     * bankcardCode : BC201805071350259874774
     * refType : 0
     * refCode : LO201805061345029723893
     * bizPrice : 2.0E8
     * sfRate : 0.3
     * sfAmount : 6.0E7
     * loanBank : 中国建设银行
     * loanAmount : 1.4E8
     * periods : 24.0
     * restPeriods : 24.0
     * bankRate : 0.1
     * loanStartDatetime : Apr 30, 2018 12:00:00 AM
     * loanEndDatetime : Apr 29, 2020 12:00:00 AM
     * fxDeposit : 2.0E7
     * firstRepayDatetime : Apr 20, 2019 12:00:00 AM
     * firstRepayAmount : 5833330.0
     * monthDatetime : 20.0
     * monthAmount : 5833330.0
     * lyDeposit : 3.0E7
     * cutLyDeposit : 0.0
     * status : 1
     * restAmount : 1.3416659E8
     * restTotalCost : 0.0
     * totalInDeposit : 0.0
     * overdueAmount : 0.0
     * totalOverdueCount : 0.0
     * curOverdueCount : 0.0
     * blackHandleNote : 暂无
     * updater : admin
     * updateDatetime : May 7, 2018 1:50:27 PM
     * remark : 无
     * user : {"userId":"U201805061611515474805","kind":"C","loginName":"15268501481","mobile":"15268501481","photo":"U12345678","nickname":"大黄","loginPwdStrength":"1","tradePwdStrength":"1","idKind":"1","idNo":"330281198908023311","realName":"郑海清","status":"0","createDatetime":"May 6, 2018 4:11:51 PM","remark":"注销","blacklistFlag":false,"identifyFlag":false,"bankcardFlag":false,"tradepwdFlag":false}
     * loanOrder : {"code":"LO201805061345029723893","repayBizCode":"RB201805142015418326578","userId":"U201805061611515474805","mobile":"15268501481","idKind":"1","idNo":"330281198908023311","realName":"郑海清","bankCode":"ICBC","bankName":"中国工商银行","subbranch":"海创园支行","bankcardNumber":"6217002710000684874","carCode":"C201804231832234243414","carPrice":2.0E8,"sfRate":0.3,"sfAmount":6.0E7,"loanBank":"中国建设银行","loanAmount":1.4E8,"periods":24,"bankRate":0.1,"loanStartDatetime":"Apr 30, 2018 12:00:00 AM","loanEndDatetime":"Apr 29, 2020 12:00:00 AM","fkDatetime":"Apr 30, 2018 12:00:00 AM","fxDeposit":2.0E7,"otherFee":4654,"gpsFee":3000000,"firstRepayDatetime":"Apr 20, 2019 12:00:00 AM","firstRepayAmount":5833330,"monthDatetime":20,"monthAmount":5833330,"lyDeposit":3.0E7,"status":"3","updater":"admin","updateDatetime":"May 14, 2018 8:15:41 PM","remark":"审核通过"}
     * repayPlanList : [{"code":"RP201805061611515986297","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":1,"repayDatetime":"Apr 20, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516001145","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":3,"repayDatetime":"Jun 19, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516001975","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":5,"repayDatetime":"Aug 18, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516003040","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":7,"repayDatetime":"Oct 17, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516003327","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":4,"repayDatetime":"Jul 19, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516007271","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":2,"repayDatetime":"May 20, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516009676","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":6,"repayDatetime":"Sep 17, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516011033","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":12,"repayDatetime":"Mar 15, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516011321","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":13,"repayDatetime":"Apr 14, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516013450","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":15,"repayDatetime":"Jun 13, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516016334","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":14,"repayDatetime":"May 14, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516016662","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":11,"repayDatetime":"Feb 14, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516018116","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":10,"repayDatetime":"Jan 15, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516019336","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":8,"repayDatetime":"Nov 16, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516019943","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":9,"repayDatetime":"Dec 16, 2019 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516021963","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":19,"repayDatetime":"Oct 11, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516022510","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":18,"repayDatetime":"Sep 11, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516022897","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":22,"repayDatetime":"Jan 9, 2021 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516022903","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":21,"repayDatetime":"Dec 10, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516024447","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":16,"repayDatetime":"Jul 13, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516024543","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":23,"repayDatetime":"Feb 8, 2021 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516025905","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":20,"repayDatetime":"Nov 10, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516026862","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":17,"repayDatetime":"Aug 12, 2020 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0},{"code":"RP201805061611516029942","repayBizCode":"RB201805061611515783630","userId":"U201805061611515474805","periods":24,"curPeriods":24,"repayDatetime":"Mar 10, 2021 12:00:00 AM","repayCapital":5833330,"repayInterest":0,"payedAmount":5833330,"overplusAmount":0,"overdueAmount":0,"status":"1","totalFee":0,"payedFee":0,"overdueDeposit":0,"shouldDeposit":0,"remindCount":0}]
     */

    private String code;
    private String userId;
    private String bankcardCode;
    private String refType;
    private String refCode;
    private double bizPrice;
    private double sfRate;
    private double sfAmount;
    private String loanBank;
    private double loanAmount;
    private double periods;
    private double restPeriods;
    private double bankRate;
    private String loanStartDatetime;
    private String loanEndDatetime;
    private double fxDeposit;
    private String firstRepayDatetime;
    private double firstRepayAmount;
    private double monthDatetime;
    private double monthAmount;
    private double lyDeposit;
    private double cutLyDeposit;
    private String status;
    private double restAmount;
    private double restTotalCost;
    private double totalInDeposit;
    private double overdueAmount;
    private double totalOverdueCount;
    private double curOverdueCount;
    private String blackHandleNote;
    private String updater;
    private String updateDatetime;
    private String remark;
    private UserBean user;
    private LoanOrderBean loanOrder;
    private List<RepayPlanListBean> repayPlanList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public double getBizPrice() {
        return bizPrice;
    }

    public void setBizPrice(double bizPrice) {
        this.bizPrice = bizPrice;
    }

    public double getSfRate() {
        return sfRate;
    }

    public void setSfRate(double sfRate) {
        this.sfRate = sfRate;
    }

    public double getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(double sfAmount) {
        this.sfAmount = sfAmount;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getPeriods() {
        return periods;
    }

    public void setPeriods(double periods) {
        this.periods = periods;
    }

    public double getRestPeriods() {
        return restPeriods;
    }

    public void setRestPeriods(double restPeriods) {
        this.restPeriods = restPeriods;
    }

    public double getBankRate() {
        return bankRate;
    }

    public void setBankRate(double bankRate) {
        this.bankRate = bankRate;
    }

    public String getLoanStartDatetime() {
        return loanStartDatetime;
    }

    public void setLoanStartDatetime(String loanStartDatetime) {
        this.loanStartDatetime = loanStartDatetime;
    }

    public String getLoanEndDatetime() {
        return loanEndDatetime;
    }

    public void setLoanEndDatetime(String loanEndDatetime) {
        this.loanEndDatetime = loanEndDatetime;
    }

    public double getFxDeposit() {
        return fxDeposit;
    }

    public void setFxDeposit(double fxDeposit) {
        this.fxDeposit = fxDeposit;
    }

    public String getFirstRepayDatetime() {
        return firstRepayDatetime;
    }

    public void setFirstRepayDatetime(String firstRepayDatetime) {
        this.firstRepayDatetime = firstRepayDatetime;
    }

    public double getFirstRepayAmount() {
        return firstRepayAmount;
    }

    public void setFirstRepayAmount(double firstRepayAmount) {
        this.firstRepayAmount = firstRepayAmount;
    }

    public double getMonthDatetime() {
        return monthDatetime;
    }

    public void setMonthDatetime(double monthDatetime) {
        this.monthDatetime = monthDatetime;
    }

    public double getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(double monthAmount) {
        this.monthAmount = monthAmount;
    }

    public double getLyDeposit() {
        return lyDeposit;
    }

    public void setLyDeposit(double lyDeposit) {
        this.lyDeposit = lyDeposit;
    }

    public double getCutLyDeposit() {
        return cutLyDeposit;
    }

    public void setCutLyDeposit(double cutLyDeposit) {
        this.cutLyDeposit = cutLyDeposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(double restAmount) {
        this.restAmount = restAmount;
    }

    public double getRestTotalCost() {
        return restTotalCost;
    }

    public void setRestTotalCost(double restTotalCost) {
        this.restTotalCost = restTotalCost;
    }

    public double getTotalInDeposit() {
        return totalInDeposit;
    }

    public void setTotalInDeposit(double totalInDeposit) {
        this.totalInDeposit = totalInDeposit;
    }

    public double getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(double overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public double getTotalOverdueCount() {
        return totalOverdueCount;
    }

    public void setTotalOverdueCount(double totalOverdueCount) {
        this.totalOverdueCount = totalOverdueCount;
    }

    public double getCurOverdueCount() {
        return curOverdueCount;
    }

    public void setCurOverdueCount(double curOverdueCount) {
        this.curOverdueCount = curOverdueCount;
    }

    public String getBlackHandleNote() {
        return blackHandleNote;
    }

    public void setBlackHandleNote(String blackHandleNote) {
        this.blackHandleNote = blackHandleNote;
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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public LoanOrderBean getLoanOrder() {
        return loanOrder;
    }

    public void setLoanOrder(LoanOrderBean loanOrder) {
        this.loanOrder = loanOrder;
    }

    public List<RepayPlanListBean> getRepayPlanList() {
        return repayPlanList;
    }

    public void setRepayPlanList(List<RepayPlanListBean> repayPlanList) {
        this.repayPlanList = repayPlanList;
    }

    public static class UserBean {
        /**
         * userId : U201805061611515474805
         * kind : C
         * loginName : 15268501481
         * mobile : 15268501481
         * photo : U12345678
         * nickname : 大黄
         * loginPwdStrength : 1
         * tradePwdStrength : 1
         * idKind : 1
         * idNo : 330281198908023311
         * realName : 郑海清
         * status : 0
         * createDatetime : May 6, 2018 4:11:51 PM
         * remark : 注销
         * blacklistFlag : false
         * identifyFlag : false
         * bankcardFlag : false
         * tradepwdFlag : false
         */

        private String userId;
        private String kind;
        private String loginName;
        private String mobile;
        private String photo;
        private String nickname;
        private String loginPwdStrength;
        private String tradePwdStrength;
        private String idKind;
        private String idNo;
        private String realName;
        private String status;
        private String createDatetime;
        private String remark;
        private boolean blacklistFlag;
        private boolean identifyFlag;
        private boolean bankcardFlag;
        private boolean tradepwdFlag;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getLoginPwdStrength() {
            return loginPwdStrength;
        }

        public void setLoginPwdStrength(String loginPwdStrength) {
            this.loginPwdStrength = loginPwdStrength;
        }

        public String getTradePwdStrength() {
            return tradePwdStrength;
        }

        public void setTradePwdStrength(String tradePwdStrength) {
            this.tradePwdStrength = tradePwdStrength;
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

        public String getCreateDatetime() {
            return createDatetime;
        }

        public void setCreateDatetime(String createDatetime) {
            this.createDatetime = createDatetime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public boolean isBlacklistFlag() {
            return blacklistFlag;
        }

        public void setBlacklistFlag(boolean blacklistFlag) {
            this.blacklistFlag = blacklistFlag;
        }

        public boolean isIdentifyFlag() {
            return identifyFlag;
        }

        public void setIdentifyFlag(boolean identifyFlag) {
            this.identifyFlag = identifyFlag;
        }

        public boolean isBankcardFlag() {
            return bankcardFlag;
        }

        public void setBankcardFlag(boolean bankcardFlag) {
            this.bankcardFlag = bankcardFlag;
        }

        public boolean isTradepwdFlag() {
            return tradepwdFlag;
        }

        public void setTradepwdFlag(boolean tradepwdFlag) {
            this.tradepwdFlag = tradepwdFlag;
        }
    }

    public static class LoanOrderBean {
        /**
         * code : LO201805061345029723893
         * repayBizCode : RB201805142015418326578
         * userId : U201805061611515474805
         * mobile : 15268501481
         * idKind : 1
         * idNo : 330281198908023311
         * realName : 郑海清
         * bankCode : ICBC
         * bankName : 中国工商银行
         * subbranch : 海创园支行
         * bankcardNumber : 6217002710000684874
         * carCode : C201804231832234243414
         * carPrice : 2.0E8
         * sfRate : 0.3
         * sfAmount : 6.0E7
         * loanBank : 中国建设银行
         * loanAmount : 1.4E8
         * periods : 24.0
         * bankRate : 0.1
         * loanStartDatetime : Apr 30, 2018 12:00:00 AM
         * loanEndDatetime : Apr 29, 2020 12:00:00 AM
         * fkDatetime : Apr 30, 2018 12:00:00 AM
         * fxDeposit : 2.0E7
         * otherFee : 4654.0
         * gpsFee : 3000000.0
         * firstRepayDatetime : Apr 20, 2019 12:00:00 AM
         * firstRepayAmount : 5833330.0
         * monthDatetime : 20.0
         * monthAmount : 5833330.0
         * lyDeposit : 3.0E7
         * status : 3
         * updater : admin
         * updateDatetime : May 14, 2018 8:15:41 PM
         * remark : 审核通过
         */

        private String code;
        private String repayBizCode;
        private String userId;
        private String mobile;
        private String idKind;
        private String idNo;
        private String realName;
        private String bankCode;
        private String bankName;
        private String subbranch;
        private String bankcardNumber;
        private String carCode;
        private double carPrice;
        private double sfRate;
        private double sfAmount;
        private String loanBank;
        private double loanAmount;
        private double periods;
        private double bankRate;
        private String loanStartDatetime;
        private String loanEndDatetime;
        private String fkDatetime;
        private double fxDeposit;
        private double otherFee;
        private double gpsFee;
        private String firstRepayDatetime;
        private double firstRepayAmount;
        private double monthDatetime;
        private double monthAmount;
        private double lyDeposit;
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

        public String getRepayBizCode() {
            return repayBizCode;
        }

        public void setRepayBizCode(String repayBizCode) {
            this.repayBizCode = repayBizCode;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
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

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
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

        public String getSubbranch() {
            return subbranch;
        }

        public void setSubbranch(String subbranch) {
            this.subbranch = subbranch;
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

        public double getSfRate() {
            return sfRate;
        }

        public void setSfRate(double sfRate) {
            this.sfRate = sfRate;
        }

        public double getSfAmount() {
            return sfAmount;
        }

        public void setSfAmount(double sfAmount) {
            this.sfAmount = sfAmount;
        }

        public String getLoanBank() {
            return loanBank;
        }

        public void setLoanBank(String loanBank) {
            this.loanBank = loanBank;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public double getPeriods() {
            return periods;
        }

        public void setPeriods(double periods) {
            this.periods = periods;
        }

        public double getBankRate() {
            return bankRate;
        }

        public void setBankRate(double bankRate) {
            this.bankRate = bankRate;
        }

        public String getLoanStartDatetime() {
            return loanStartDatetime;
        }

        public void setLoanStartDatetime(String loanStartDatetime) {
            this.loanStartDatetime = loanStartDatetime;
        }

        public String getLoanEndDatetime() {
            return loanEndDatetime;
        }

        public void setLoanEndDatetime(String loanEndDatetime) {
            this.loanEndDatetime = loanEndDatetime;
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

        public double getOtherFee() {
            return otherFee;
        }

        public void setOtherFee(double otherFee) {
            this.otherFee = otherFee;
        }

        public double getGpsFee() {
            return gpsFee;
        }

        public void setGpsFee(double gpsFee) {
            this.gpsFee = gpsFee;
        }

        public String getFirstRepayDatetime() {
            return firstRepayDatetime;
        }

        public void setFirstRepayDatetime(String firstRepayDatetime) {
            this.firstRepayDatetime = firstRepayDatetime;
        }

        public double getFirstRepayAmount() {
            return firstRepayAmount;
        }

        public void setFirstRepayAmount(double firstRepayAmount) {
            this.firstRepayAmount = firstRepayAmount;
        }

        public double getMonthDatetime() {
            return monthDatetime;
        }

        public void setMonthDatetime(double monthDatetime) {
            this.monthDatetime = monthDatetime;
        }

        public double getMonthAmount() {
            return monthAmount;
        }

        public void setMonthAmount(double monthAmount) {
            this.monthAmount = monthAmount;
        }

        public double getLyDeposit() {
            return lyDeposit;
        }

        public void setLyDeposit(double lyDeposit) {
            this.lyDeposit = lyDeposit;
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

    public static class RepayPlanListBean {
        /**
         * code : RP201805061611515986297
         * repayBizCode : RB201805061611515783630
         * userId : U201805061611515474805
         * periods : 24.0
         * curPeriods : 1.0
         * repayDatetime : Apr 20, 2019 12:00:00 AM
         * repayCapital : 5833330.0
         * repayInterest : 0.0
         * payedAmount : 5833330.0
         * overplusAmount : 0.0
         * overdueAmount : 0.0
         * status : 1
         * totalFee : 0.0
         * payedFee : 0.0
         * overdueDeposit : 0.0
         * shouldDeposit : 0.0
         * remindCount : 0.0
         */

        private String code;
        private String repayBizCode;
        private String userId;
        private double periods;
        private double curPeriods;
        private String repayDatetime;
        private double repayCapital;
        private double repayInterest;
        private double payedAmount;
        private double overplusAmount;
        private double overdueAmount;
        private String status;
        private double totalFee;
        private double payedFee;
        private double overdueDeposit;
        private double shouldDeposit;
        private double remindCount;

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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public double getPeriods() {
            return periods;
        }

        public void setPeriods(double periods) {
            this.periods = periods;
        }

        public double getCurPeriods() {
            return curPeriods;
        }

        public void setCurPeriods(double curPeriods) {
            this.curPeriods = curPeriods;
        }

        public String getRepayDatetime() {
            return repayDatetime;
        }

        public void setRepayDatetime(String repayDatetime) {
            this.repayDatetime = repayDatetime;
        }

        public double getRepayCapital() {
            return repayCapital;
        }

        public void setRepayCapital(double repayCapital) {
            this.repayCapital = repayCapital;
        }

        public double getRepayInterest() {
            return repayInterest;
        }

        public void setRepayInterest(double repayInterest) {
            this.repayInterest = repayInterest;
        }

        public double getPayedAmount() {
            return payedAmount;
        }

        public void setPayedAmount(double payedAmount) {
            this.payedAmount = payedAmount;
        }

        public double getOverplusAmount() {
            return overplusAmount;
        }

        public void setOverplusAmount(double overplusAmount) {
            this.overplusAmount = overplusAmount;
        }

        public double getOverdueAmount() {
            return overdueAmount;
        }

        public void setOverdueAmount(double overdueAmount) {
            this.overdueAmount = overdueAmount;
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

        public double getPayedFee() {
            return payedFee;
        }

        public void setPayedFee(double payedFee) {
            this.payedFee = payedFee;
        }

        public double getOverdueDeposit() {
            return overdueDeposit;
        }

        public void setOverdueDeposit(double overdueDeposit) {
            this.overdueDeposit = overdueDeposit;
        }

        public double getShouldDeposit() {
            return shouldDeposit;
        }

        public void setShouldDeposit(double shouldDeposit) {
            this.shouldDeposit = shouldDeposit;
        }

        public double getRemindCount() {
            return remindCount;
        }

        public void setRemindCount(double remindCount) {
            this.remindCount = remindCount;
        }
    }
}
