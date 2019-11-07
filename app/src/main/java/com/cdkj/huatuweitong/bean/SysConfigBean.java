package com.cdkj.huatuweitong.bean;

/**
 * @author : qianLei
 * @since : 2019/11/4 19:38
 */
public class SysConfigBean {


    /**
     * customerServicePhone : 400-8888-666
     * workDatetime : 9:00-24:00
     * serviceRange : 车辆使用，售后跟踪
     */

    private String customerServicePhone;
    private String workDatetime;
    private String serviceRange;

    public String getCustomerServicePhone() {
        return customerServicePhone;
    }

    public void setCustomerServicePhone(String customerServicePhone) {
        this.customerServicePhone = customerServicePhone;
    }

    public String getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(String workDatetime) {
        this.workDatetime = workDatetime;
    }

    public String getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(String serviceRange) {
        this.serviceRange = serviceRange;
    }
}
