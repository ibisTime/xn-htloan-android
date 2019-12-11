package com.cdkj.huatuweitong.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * @updateDts 2019/3/18
 */
public class MyCollectionBean {

    /**
     * pageNO : 1
     * start : 0
     * pageSize : 10
     * totalCount : 1
     * totalPage : 1
     * list : [{"code":"A201904101954412984851","type":"3","toType":"0","toCode":"C201904101450143071572","creater":"U201808091644004605371","createDatetime":"Apr 10, 2019 7:54:41 PM","car":{"code":"C201904101450143071572","isReferee":"1","name":"2019款 C 260 运动版","seriesCode":"S201904101435291727379","seriesName":"奔驰C级","brandCode":"B201904101423276439378","brandName":"奔驰","bankCode":"BA201809101215201166542","level":"1","version":"2","structure":"2","displacement":1.5,"fromPlace":"浙江金华","procedure":"5000","originalPrice":300000000,"salePrice":310000000,"sfAmount":60000000,"fwAmount":9000000,"jsqByhf":"1200000","jsqSybx":"9445","location":1,"orderNo":1,"slogan":"C级112121","advPic":"FtDGtW2nrJeDDu-ehn1YGurhTPIX","picNumber":1,"pic":"Fmu6MiUzFh89qxg99yvarRP6Y2mc","description":"发发发","outsideColor":"白色","insideColor":"黑色","status":"1","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 3:28:25 PM","caonfigList":[{"code":"CCC201904101450143122733","carCode":"C201904101450143071572","configCode":"CC201904101444390121461","config":{"code":"CC201904101444390121461","name":"中控","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:39 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101450143208337","carCode":"C201904101450143071572","configCode":"CC201904101444521577147","config":{"code":"CC201904101444521577147","name":"自动锁门","pic":"FnFApx0Ydoest7zuVNpALeKEPhMN","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:52 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101507043475540","carCode":"C201904101450143071572","configCode":"CC201904101444390121461","config":{"code":"CC201904101444390121461","name":"中控","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:39 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101507043524661","carCode":"C201904101450143071572","configCode":"CC201904101444521577147","config":{"code":"CC201904101444521577147","name":"自动锁门","pic":"FnFApx0Ydoest7zuVNpALeKEPhMN","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:52 PM","remark":"","isConfig":"0"}}]},"user":{"userId":"U201808091644004605371","produceType":"0","loginName":"13282838237","mobile":"13282838237","photo":"ANDROID_1542594772599_4000_3000.jpg","nickname":"464649","loginPwdStrength":"1","tradePwdStrength":"1","idNo":"410621199605101018","realName":"齐胜涛","status":"0","createDatetime":"Aug 9, 2018 4:44:00 PM","blacklistFlag":false,"identifyFlag":false,"bankcardFlag":false,"tradepwdFlag":false}}]
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
         * code : A201904101954412984851
         * type : 3
         * toType : 0
         * toCode : C201904101450143071572
         * creater : U201808091644004605371
         * createDatetime : Apr 10, 2019 7:54:41 PM
         * car : {"code":"C201904101450143071572","isReferee":"1","name":"2019款 C 260 运动版","seriesCode":"S201904101435291727379","seriesName":"奔驰C级","brandCode":"B201904101423276439378","brandName":"奔驰","bankCode":"BA201809101215201166542","level":"1","version":"2","structure":"2","displacement":1.5,"fromPlace":"浙江金华","procedure":"5000","originalPrice":300000000,"salePrice":310000000,"sfAmount":60000000,"fwAmount":9000000,"jsqByhf":"1200000","jsqSybx":"9445","location":1,"orderNo":1,"slogan":"C级112121","advPic":"FtDGtW2nrJeDDu-ehn1YGurhTPIX","picNumber":1,"pic":"Fmu6MiUzFh89qxg99yvarRP6Y2mc","description":"发发发","outsideColor":"白色","insideColor":"黑色","status":"1","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 3:28:25 PM","caonfigList":[{"code":"CCC201904101450143122733","carCode":"C201904101450143071572","configCode":"CC201904101444390121461","config":{"code":"CC201904101444390121461","name":"中控","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:39 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101450143208337","carCode":"C201904101450143071572","configCode":"CC201904101444521577147","config":{"code":"CC201904101444521577147","name":"自动锁门","pic":"FnFApx0Ydoest7zuVNpALeKEPhMN","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:52 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101507043475540","carCode":"C201904101450143071572","configCode":"CC201904101444390121461","config":{"code":"CC201904101444390121461","name":"中控","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:39 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101507043524661","carCode":"C201904101450143071572","configCode":"CC201904101444521577147","config":{"code":"CC201904101444521577147","name":"自动锁门","pic":"FnFApx0Ydoest7zuVNpALeKEPhMN","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:52 PM","remark":"","isConfig":"0"}}]}
         * user : {"userId":"U201808091644004605371","produceType":"0","loginName":"13282838237","mobile":"13282838237","photo":"ANDROID_1542594772599_4000_3000.jpg","nickname":"464649","loginPwdStrength":"1","tradePwdStrength":"1","idNo":"410621199605101018","realName":"齐胜涛","status":"0","createDatetime":"Aug 9, 2018 4:44:00 PM","blacklistFlag":false,"identifyFlag":false,"bankcardFlag":false,"tradepwdFlag":false}
         */

        private String code;
        private String type;
        private String toType;
        private String toCode;
        private String creater;
        private String createDatetime;
        boolean isSelect;
        boolean isShowSelect;
        private CarBean car;
        private UserBean user;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public boolean isShowSelect() {
            return isShowSelect;
        }

        public void setShowSelect(boolean showSelect) {
            isShowSelect = showSelect;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getToType() {
            return toType;
        }

        public void setToType(String toType) {
            this.toType = toType;
        }

        public String getToCode() {
            return toCode;
        }

        public void setToCode(String toCode) {
            this.toCode = toCode;
        }

        public String getCreater() {
            return creater;
        }

        public void setCreater(String creater) {
            this.creater = creater;
        }

        public String getCreateDatetime() {
            return createDatetime;
        }

        public void setCreateDatetime(String createDatetime) {
            this.createDatetime = createDatetime;
        }

        public CarBean getCar() {
            return car;
        }

        public void setCar(CarBean car) {
            this.car = car;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class CarBean {
            /**
             * code : C201904101450143071572
             * isReferee : 1
             * name : 2019款 C 260 运动版
             * seriesCode : S201904101435291727379
             * seriesName : 奔驰C级
             * brandCode : B201904101423276439378
             * brandName : 奔驰
             * bankCode : BA201809101215201166542
             * level : 1
             * version : 2
             * structure : 2
             * displacement : 1.5
             * fromPlace : 浙江金华
             * procedure : 5000
             * originalPrice : 300000000
             * salePrice : 310000000
             * sfAmount : 60000000
             * fwAmount : 9000000
             * jsqByhf : 1200000
             * jsqSybx : 9445
             * location : 1
             * orderNo : 1
             * slogan : C级112121
             * advPic : FtDGtW2nrJeDDu-ehn1YGurhTPIX
             * picNumber : 1
             * pic : Fmu6MiUzFh89qxg99yvarRP6Y2mc
             * description : 发发发
             * outsideColor : 白色
             * insideColor : 黑色
             * status : 1
             * updater : U201812281020387737131
             * updateDatetime : Apr 10, 2019 3:28:25 PM
             * caonfigList : [{"code":"CCC201904101450143122733","carCode":"C201904101450143071572","configCode":"CC201904101444390121461","config":{"code":"CC201904101444390121461","name":"中控","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:39 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101450143208337","carCode":"C201904101450143071572","configCode":"CC201904101444521577147","config":{"code":"CC201904101444521577147","name":"自动锁门","pic":"FnFApx0Ydoest7zuVNpALeKEPhMN","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:52 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101507043475540","carCode":"C201904101450143071572","configCode":"CC201904101444390121461","config":{"code":"CC201904101444390121461","name":"中控","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:39 PM","remark":"","isConfig":"0"}},{"code":"CCC201904101507043524661","carCode":"C201904101450143071572","configCode":"CC201904101444521577147","config":{"code":"CC201904101444521577147","name":"自动锁门","pic":"FnFApx0Ydoest7zuVNpALeKEPhMN","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:52 PM","remark":"","isConfig":"0"}}]
             */

            private String code;
            private String isReferee;
            private String name;
            private String seriesCode;
            private String seriesName;
            private String brandCode;
            private String brandName;
            private String bankCode;
            private String level;
            private String version;
            private String structure;
            private String displacement;
            private String fromPlace;
            private String procedure;
            private BigDecimal originalPrice;
            private BigDecimal salePrice;
            private BigDecimal sfAmount;
            private BigDecimal fwAmount;
            private String jsqByhf;
            private String jsqSybx;
            private int location;
            private int orderNo;
            private String slogan;
            private String advPic;
            private int picNumber;
            private String pic;
            private String description;
            private String outsideColor;
            private String insideColor;
            private String status;
            private String updater;
            private String updateDatetime;
            private String configName;
            private List<CaonfigListBean> caonfigList;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getIsReferee() {
                return isReferee;
            }

            public void setIsReferee(String isReferee) {
                this.isReferee = isReferee;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSeriesCode() {
                return seriesCode;
            }

            public void setSeriesCode(String seriesCode) {
                this.seriesCode = seriesCode;
            }

            public String getSeriesName() {
                return seriesName;
            }

            public void setSeriesName(String seriesName) {
                this.seriesName = seriesName;
            }

            public String getBrandCode() {
                return brandCode;
            }

            public void setBrandCode(String brandCode) {
                this.brandCode = brandCode;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public String getBankCode() {
                return bankCode;
            }

            public void setBankCode(String bankCode) {
                this.bankCode = bankCode;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getStructure() {
                return structure;
            }

            public void setStructure(String structure) {
                this.structure = structure;
            }

            public String getDisplacement() {
                return displacement;
            }

            public void setDisplacement(String displacement) {
                this.displacement = displacement;
            }

            public String getFromPlace() {
                return fromPlace;
            }

            public void setFromPlace(String fromPlace) {
                this.fromPlace = fromPlace;
            }

            public String getProcedure() {
                return procedure;
            }

            public void setProcedure(String procedure) {
                this.procedure = procedure;
            }

            public BigDecimal getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(BigDecimal originalPrice) {
                this.originalPrice = originalPrice;
            }

            public BigDecimal getSalePrice() {
                return salePrice;
            }

            public void setSalePrice(BigDecimal salePrice) {
                this.salePrice = salePrice;
            }

            public BigDecimal getSfAmount() {
                return sfAmount;
            }

            public void setSfAmount(BigDecimal sfAmount) {
                this.sfAmount = sfAmount;
            }

            public BigDecimal getFwAmount() {
                return fwAmount;
            }

            public void setFwAmount(BigDecimal fwAmount) {
                this.fwAmount = fwAmount;
            }

            public String getJsqByhf() {
                return jsqByhf;
            }

            public void setJsqByhf(String jsqByhf) {
                this.jsqByhf = jsqByhf;
            }

            public String getJsqSybx() {
                return jsqSybx;
            }

            public void setJsqSybx(String jsqSybx) {
                this.jsqSybx = jsqSybx;
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

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getOutsideColor() {
                return outsideColor;
            }

            public void setOutsideColor(String outsideColor) {
                this.outsideColor = outsideColor;
            }

            public String getInsideColor() {
                return insideColor;
            }

            public void setInsideColor(String insideColor) {
                this.insideColor = insideColor;
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

            public String getConfigName() {
                return configName;
            }

            public void setConfigName(String configName) {
                this.configName = configName;
            }

            public List<CaonfigListBean> getCaonfigList() {
                return caonfigList;
            }

            public void setCaonfigList(List<CaonfigListBean> caonfigList) {
                this.caonfigList = caonfigList;
            }

            public static class CaonfigListBean {
                /**
                 * code : CCC201904101450143122733
                 * carCode : C201904101450143071572
                 * configCode : CC201904101444390121461
                 * config : {"code":"CC201904101444390121461","name":"中控","pic":"Fvn5aof2QJ2U8RRLl7LN9E2iRDcq","updater":"U201812281020387737131","updateDatetime":"Apr 10, 2019 2:44:39 PM","remark":"","isConfig":"0"}
                 */

                private String code;
                private String carCode;
                private String configCode;
                private ConfigBean config;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getCarCode() {
                    return carCode;
                }

                public void setCarCode(String carCode) {
                    this.carCode = carCode;
                }

                public String getConfigCode() {
                    return configCode;
                }

                public void setConfigCode(String configCode) {
                    this.configCode = configCode;
                }

                public ConfigBean getConfig() {
                    return config;
                }

                public void setConfig(ConfigBean config) {
                    this.config = config;
                }

                public static class ConfigBean {
                    /**
                     * code : CC201904101444390121461
                     * name : 中控
                     * pic : Fvn5aof2QJ2U8RRLl7LN9E2iRDcq
                     * updater : U201812281020387737131
                     * updateDatetime : Apr 10, 2019 2:44:39 PM
                     * remark :
                     * isConfig : 0
                     */

                    private String code;
                    private String name;
                    private String pic;
                    private String updater;
                    private String updateDatetime;
                    private String remark;
                    private String isConfig;

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

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
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

                    public String getIsConfig() {
                        return isConfig;
                    }

                    public void setIsConfig(String isConfig) {
                        this.isConfig = isConfig;
                    }
                }
            }
        }

        public static class UserBean {
            /**
             * userId : U201808091644004605371
             * produceType : 0
             * loginName : 13282838237
             * mobile : 13282838237
             * photo : ANDROID_1542594772599_4000_3000.jpg
             * nickname : 464649
             * loginPwdStrength : 1
             * tradePwdStrength : 1
             * idNo : 410621199605101018
             * realName : 齐胜涛
             * status : 0
             * createDatetime : Aug 9, 2018 4:44:00 PM
             * blacklistFlag : false
             * identifyFlag : false
             * bankcardFlag : false
             * tradepwdFlag : false
             */

            private String userId;
            private String produceType;
            private String loginName;
            private String mobile;
            private String photo;
            private String nickname;
            private String loginPwdStrength;
            private String tradePwdStrength;
            private String idNo;
            private String realName;
            private String status;
            private String createDatetime;
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

            public String getProduceType() {
                return produceType;
            }

            public void setProduceType(String produceType) {
                this.produceType = produceType;
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
    }
}
