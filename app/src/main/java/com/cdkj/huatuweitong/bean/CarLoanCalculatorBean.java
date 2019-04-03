package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2019/3/27
 */
public class CarLoanCalculatorBean {

    /**
     * saleAmount : 4000000   原价
     * sfAmount : 1200000   首付价
     * yjsfAmount : 1203600  预计首付价
     * dkAmount : 2800000   贷款金额
     * dkTotalAmount : 2800000   总贷款金额
     * procedureAmount : 0   手续费
     * monthReply : 233333   月供
     * extraAmount : 0  额外费用
     * totalAmount : 4003596  总花费
     * byhf : 1600   必要花费
     * sybx : 2000   商业保险
     */

    private long saleAmount;
    private long sfAmount;
    private long yjsfAmount;
    private long dkAmount;
    private long dkTotalAmount;
    private long procedureAmount;
    private long monthReply;
    private long extraAmount;
    private long totalAmount;
    private long byhf;
    private long sybx;

    public long getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(long saleAmount) {
        this.saleAmount = saleAmount;
    }

    public long getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(long sfAmount) {
        this.sfAmount = sfAmount;
    }

    public long getYjsfAmount() {
        return yjsfAmount;
    }

    public void setYjsfAmount(long yjsfAmount) {
        this.yjsfAmount = yjsfAmount;
    }

    public long getDkAmount() {
        return dkAmount;
    }

    public void setDkAmount(long dkAmount) {
        this.dkAmount = dkAmount;
    }

    public long getDkTotalAmount() {
        return dkTotalAmount;
    }

    public void setDkTotalAmount(long dkTotalAmount) {
        this.dkTotalAmount = dkTotalAmount;
    }

    public long getProcedureAmount() {
        return procedureAmount;
    }

    public void setProcedureAmount(long procedureAmount) {
        this.procedureAmount = procedureAmount;
    }

    public long getMonthReply() {
        return monthReply;
    }

    public void setMonthReply(long monthReply) {
        this.monthReply = monthReply;
    }

    public long getExtraAmount() {
        return extraAmount;
    }

    public void setExtraAmount(long extraAmount) {
        this.extraAmount = extraAmount;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getByhf() {
        return byhf;
    }

    public void setByhf(long byhf) {
        this.byhf = byhf;
    }

    public long getSybx() {
        return sybx;
    }

    public void setSybx(long sybx) {
        this.sybx = sybx;
    }
}
