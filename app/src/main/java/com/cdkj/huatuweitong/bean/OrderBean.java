package com.cdkj.huatuweitong.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by cdkj on 2018/5/18.
 */

public class OrderBean {


    /**
     * amount : 3900
     * applyDatetime : Aug 30, 2017 2:38:24 PM
     * applyNote : 下单测试
     * applyUser : U201708291904059537401
     * code : DD2017083014382469958574
     * payAmount : 3900
     * productOrderList : [{"code":"CD2017083014382470015397","orderCode":"DD2017083014382469958574","price":3900,"product":{"advPic":"图层-50@2x_1503994670694.png","name":"Canon/佳能 EOS 200D 2"},"productCode":"CP2017082916192119211445","productSpecsCode":"PS2017083009544493280194","productSpecsName":"黑色","quantity":1}]
     * promptTimes : 0
     * reAddress : 浙江省杭州市
     * reMobile : 15158110100
     * receiver : 郑海清
     * remark : 现场发货
     * status : 4
     * updateDatetime : Aug 30, 2017 2:40:47 PM
     * updater : admin
     * user : {"identityFlag":"0","level":"1","loginName":"15761663457","mobile":"15761663457","nickname":"59537401","userId":"U201708291904059537401"}
     * yunfei : 0
     */

    private BigDecimal amount;
    private String applyDatetime;
    private String applyNote;
    private String applyUser;
    private String code;
    private int payAmount;
    private int promptTimes;
    private String reAddress;
    private String reMobile;
    private String receiver;
    private String remark;
    private String status;
    private String updateDatetime;
    private String updater;
    private UserBean user;
    private int yunfei;
    private List<ProductOrderListBean> productOrderList;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(String applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public int getPromptTimes() {
        return promptTimes;
    }

    public void setPromptTimes(int promptTimes) {
        this.promptTimes = promptTimes;
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

    public int getYunfei() {
        return yunfei;
    }

    public void setYunfei(int yunfei) {
        this.yunfei = yunfei;
    }

    public List<ProductOrderListBean> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrderListBean> productOrderList) {
        this.productOrderList = productOrderList;
    }

    public static class UserBean {
        /**
         * identityFlag : 0
         * level : 1
         * loginName : 15761663457
         * mobile : 15761663457
         * nickname : 59537401
         * userId : U201708291904059537401
         */

        private String identityFlag;
        private String level;
        private String loginName;
        private String mobile;
        private String nickname;
        private String userId;

        public String getIdentityFlag() {
            return identityFlag;
        }

        public void setIdentityFlag(String identityFlag) {
            this.identityFlag = identityFlag;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    public static class ProductOrderListBean {
        /**
         * code : CD2017083014382470015397
         * orderCode : DD2017083014382469958574
         * price : 3900
         * product : {"advPic":"图层-50@2x_1503994670694.png","name":"Canon/佳能 EOS 200D 2"}
         * productCode : CP2017082916192119211445
         * productSpecsCode : PS2017083009544493280194
         * productSpecsName : 黑色
         * quantity : 1
         */

        private String code;
        private String orderCode;
        private BigDecimal price;
        private ProductBean product;
        private String productCode;
        private String productSpecsCode;
        private String productSpecsName;
        private int quantity;

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

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
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

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public static class ProductBean {
            /**
             * advPic : 图层-50@2x_1503994670694.png
             * name : Canon/佳能 EOS 200D 2
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
