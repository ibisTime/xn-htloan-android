package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @updateDts 2019/4/9
 */
public class CarSystemBean {

    /**
     * pageNO : 1
     * start : 0
     * pageSize : 10
     * totalCount : 9
     * totalPage : 1
     * list : [{"code":"S201904031228038127628","brandCode":"B201904022005049517769","name":"详情","slogan":"发数字货币红包、查收发记录和提现11","advPic":"FuxG5qzcqCz44VCm5T4-XwyVrH9N","picNumber":11,"price":0,"highest":15000000,"lowest":0,"level":"1","location":1,"orderNo":1,"status":"1","updater":"USYS201800000000001","updateDatetime":"Apr 3, 2019 12:28:14 PM","remark":"提币管理","updaterName":"admin"},{"code":"S201903281357297913608","brandCode":"B201903071325473442783","name":"详情","slogan":"真帅11","advPic":"Fuzu-48sSyLQY1pqmXhIiM4R1VbL","picNumber":12,"price":0,"highest":0,"lowest":0,"level":"2","location":0,"orderNo":1,"status":"1","updater":"USYS201800000000001","updateDatetime":"Apr 2, 2019 10:50:13 PM","updaterName":"admin"},{"code":"S201903271702152179072","brandCode":"B201903071325473442783","name":"兰博基里1","slogan":"真帅","advPic":"Fuzu-48sSyLQY1pqmXhIiM4R1VbL","picNumber":22,"price":0,"highest":0,"lowest":0,"level":"2","location":0,"orderNo":1,"status":"1","updater":"USYS201800000000001","updateDatetime":"Mar 27, 2019 5:16:47 PM","updaterName":"admin"},{"code":"S201903191144294055209","brandCode":"B201806190344172014125","name":"房车","slogan":"\b标语","advPic":"dddd","picNumber":2,"price":0,"highest":0,"lowest":0,"level":"5","location":0,"orderNo":3,"status":"1","updater":"USYS201800000000001","updateDatetime":"Apr 2, 2019 10:42:38 PM","updaterName":"admin"},{"code":"S201903191143551349548","brandCode":"B201806190344172014125","name":"大G","slogan":"\b标语","advPic":"dddd","picNumber":2,"price":0,"highest":15000000,"lowest":0,"level":"0","status":"1","updater":"U201806131315524345485","updateDatetime":"Mar 19, 2019 11:43:55 AM","updaterName":"洪仁飞"},{"code":"S201903151141307242014","brandCode":"B201903071325473442783","name":"小皮卡","slogan":"小皮卡真便宜","advPic":"123","picNumber":3,"price":0,"highest":0,"lowest":0,"level":"4","status":"1","updater":"U201806131315524345485","updateDatetime":"Mar 15, 2019 11:41:30 AM","remark":"小皮卡真棒","updaterName":"洪仁飞"},{"code":"S201903151051128753828","brandCode":"B201903071325473442783","name":"小皮卡","slogan":"小皮卡真便宜","advPic":"123","picNumber":3,"price":0,"highest":123131000,"lowest":0,"level":"4","status":"1","updater":"U201806131315524345485","updateDatetime":"Mar 15, 2019 10:51:12 AM","remark":"小皮卡真棒","updaterName":"洪仁飞"},{"code":"S201903151050315532078","brandCode":"B201903071325473442783","name":"高级房车","slogan":"真便宜","advPic":"123","picNumber":2,"price":0,"highest":15000000,"lowest":0,"level":"5","status":"1","updater":"U201806131315524345485","updateDatetime":"Mar 15, 2019 10:50:31 AM","remark":"真棒","updaterName":"洪仁飞"},{"code":"S201903071411292394034","brandCode":"B201806190344172014125","name":"S系列","slogan":"彰显大气","advPic":"aaaa","picNumber":2,"price":1400000,"highest":15000000,"lowest":1000000,"level":"1","location":1,"orderNo":1,"status":"1","updater":"U201806131315524345485","updateDatetime":"Mar 7, 2019 2:15:23 PM","remark":"豪华车","updaterName":"洪仁飞"}]
     */

    private int pageNO;
    private int start;
    private int pageSize;
    private int totalCount;
    private int totalPage;
    private List<ListBean> list;

    public int getPageNO() {
        return pageNO;
    }

    public void setPageNO(int pageNO) {
        this.pageNO = pageNO;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * code : S201904031228038127628
         * brandCode : B201904022005049517769
         * name : 详情
         * slogan : 发数字货币红包、查收发记录和提现11
         * advPic : FuxG5qzcqCz44VCm5T4-XwyVrH9N
         * picNumber : 11
         * price : 0
         * highest : 15000000
         * lowest : 0
         * level : 1
         * location : 1
         * orderNo : 1
         * status : 1
         * updater : USYS201800000000001
         * updateDatetime : Apr 3, 2019 12:28:14 PM
         * remark : 提币管理
         * updaterName : admin
         */

        private String code;
        private String brandCode;
        private String name;
        private String slogan;
        private String advPic;
        private int picNumber;
        private int price;
        private int highest;
        private int lowest;
        private String level;
        private int location;
        private int orderNo;
        private String status;
        private String updater;
        private String updateDatetime;
        private String remark;
        private String updaterName;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getBrandCode() {
            return brandCode;
        }

        public void setBrandCode(String brandCode) {
            this.brandCode = brandCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getAdvPic() {
            return advPic;
        }

        public void setAdvPic(String advPic) {
            this.advPic = advPic;
        }

        public int getPicNumber() {
            return picNumber;
        }

        public void setPicNumber(int picNumber) {
            this.picNumber = picNumber;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getHighest() {
            return highest;
        }

        public void setHighest(int highest) {
            this.highest = highest;
        }

        public int getLowest() {
            return lowest;
        }

        public void setLowest(int lowest) {
            this.lowest = lowest;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public int getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
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

        public String getUpdaterName() {
            return updaterName;
        }

        public void setUpdaterName(String updaterName) {
            this.updaterName = updaterName;
        }
    }
}
