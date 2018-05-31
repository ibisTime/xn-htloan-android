package com.cdkj.huatuweitong.bean;

import java.io.Serializable;

/**
 * @author qi
 * @updateDts 2018/5/29
 */

public class CarSystemActivityBean implements Serializable {

//    brandCode	品牌编号	string	@mock=B201804201324428875146
//    code	编号	string	@mock=S201804221647163458361
//    name	名称	string	@mock=2018款
//    price	价格

    private String brandCode;
    private String code;
    private String name;
    private String price;

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
