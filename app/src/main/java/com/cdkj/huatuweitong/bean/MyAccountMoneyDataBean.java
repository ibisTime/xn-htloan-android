package com.cdkj.huatuweitong.bean;

import java.math.BigDecimal;

/**
 * @author qi
 * @updateDts 2018/6/1
 */

public class MyAccountMoneyDataBean {

    /**
     * totalCharge : 0
     * totalWithdraw : 0
     * totalConsume : 0
     */

    private BigDecimal totalCharge;
    private BigDecimal totalWithdraw;
    private BigDecimal totalConsume;

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getTotalWithdraw() {
        return totalWithdraw;
    }

    public void setTotalWithdraw(BigDecimal totalWithdraw) {
        this.totalWithdraw = totalWithdraw;
    }

    public BigDecimal getTotalConsume() {
        return totalConsume;
    }

    public void setTotalConsume(BigDecimal totalConsume) {
        this.totalConsume = totalConsume;
    }
}
