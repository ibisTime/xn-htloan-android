package com.cdkj.huatuweitong.bean;

import java.math.BigDecimal;

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

    private BigDecimal saleAmount;
    private BigDecimal sfAmount;
    private BigDecimal yjsfAmount;
    private BigDecimal dkAmount;
    private BigDecimal dkTotalAmount;
    private BigDecimal procedureAmount;
    private BigDecimal monthReply;
    private BigDecimal extraAmount;
    private BigDecimal totalAmount;
    private BigDecimal byhf;
    private BigDecimal sybx;

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public BigDecimal getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(BigDecimal sfAmount) {
        this.sfAmount = sfAmount;
    }

    public BigDecimal getYjsfAmount() {
        return yjsfAmount;
    }

    public void setYjsfAmount(BigDecimal yjsfAmount) {
        this.yjsfAmount = yjsfAmount;
    }

    public BigDecimal getDkAmount() {
        return dkAmount;
    }

    public void setDkAmount(BigDecimal dkAmount) {
        this.dkAmount = dkAmount;
    }

    public BigDecimal getDkTotalAmount() {
        return dkTotalAmount;
    }

    public void setDkTotalAmount(BigDecimal dkTotalAmount) {
        this.dkTotalAmount = dkTotalAmount;
    }

    public BigDecimal getProcedureAmount() {
        return procedureAmount;
    }

    public void setProcedureAmount(BigDecimal procedureAmount) {
        this.procedureAmount = procedureAmount;
    }

    public BigDecimal getMonthReply() {
        return monthReply;
    }

    public void setMonthReply(BigDecimal monthReply) {
        this.monthReply = monthReply;
    }

    public BigDecimal getExtraAmount() {
        return extraAmount;
    }

    public void setExtraAmount(BigDecimal extraAmount) {
        this.extraAmount = extraAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getByhf() {
        return byhf;
    }

    public void setByhf(BigDecimal byhf) {
        this.byhf = byhf;
    }

    public BigDecimal getSybx() {
        return sybx;
    }

    public void setSybx(BigDecimal sybx) {
        this.sybx = sybx;
    }
}
