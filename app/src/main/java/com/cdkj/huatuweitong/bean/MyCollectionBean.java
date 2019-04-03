package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @updateDts 2019/3/18
 */
public class MyCollectionBean {

    /**
     * pageNO : 1
     * start : 0
     * pageSize : 10
     * totalCount : 2
     * totalPage : 1
     * list : [{"code":"A201903271736245028110","type":"3","toType":"0","toCode":"C201903191540014947886","creater":"U201808091644004605371","createDatetime":"Mar 27, 2019 5:36:24 PM","car":{"code":"C201903191540014947886","isReferee":"1","name":"S400","seriesCode":"S201903071411292394034","seriesName":"S系列","brandCode":"B201806190344172014125","brandName":"奔驰","bankCode":"BA201806011006085041799","level":"0","version":"1","structure":"2","displacement":4.6,"fromPlace":"德国","procedure":"无手续","originalPrice":0,"salePrice":1000000,"sfAmount":300000,"fwAmount":600,"jsqByhf":"1000","jsqSybx":"2000","slogan":"广告标语","advPic":"1111","picNumber":2,"pic":"111","description":"11111","outsideColor":"黑","insideColor":"灰","status":"1","updater":"U201806131315524345485","updateDatetime":"Mar 19, 2019 3:40:01 PM","caonfigList":[{"code":"CCC201903221146384778562","carCode":"C201903191540014947886","configCode":"CC201903221054496692906","config":{"code":"CC201903221054496692906","name":"无人驾驶","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 10:54:49 AM","remark":"无"}},{"code":"CCC201903221146384887704","carCode":"C201903191540014947886","configCode":"CC201903221111133179887","config":{"code":"CC201903221111133179887","name":"全景天窗","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:11:13 AM","remark":"无"}},{"code":"CCC201903221146384981518","carCode":"C201903191540014947886","configCode":"CC201903221145164897415","config":{"code":"CC201903221145164897415","name":"胎压检测","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:45:16 AM","remark":"无"}},{"code":"CCC201903221146385083945","carCode":"C201903191540014947886","configCode":"CC201903221145518657226","config":{"code":"CC201903221145518657226","name":"定速巡航","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:45:51 AM","remark":"无"}},{"code":"CCC201903221146385192807","carCode":"C201903191540014947886","configCode":"CC201903221146270184052","config":{"code":"CC201903221146270184052","name":"无钥匙进入","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:46:27 AM","remark":"无"}}]}},{"code":"A201903271736291984275","type":"3","toType":"0","toCode":"C201903191540014947886","creater":"U201808091644004605371","createDatetime":"Mar 27, 2019 5:36:29 PM","car":{"code":"C201903191540014947886","isReferee":"1","name":"S400","seriesCode":"S201903071411292394034","seriesName":"S系列","brandCode":"B201806190344172014125","brandName":"奔驰","bankCode":"BA201806011006085041799","level":"0","version":"1","structure":"2","displacement":4.6,"fromPlace":"德国","procedure":"无手续","originalPrice":0,"salePrice":1000000,"sfAmount":300000,"fwAmount":600,"jsqByhf":"1000","jsqSybx":"2000","slogan":"广告标语","advPic":"1111","picNumber":2,"pic":"111","description":"11111","outsideColor":"黑","insideColor":"灰","status":"1","updater":"U201806131315524345485","updateDatetime":"Mar 19, 2019 3:40:01 PM","caonfigList":[{"code":"CCC201903221146384778562","carCode":"C201903191540014947886","configCode":"CC201903221054496692906","config":{"code":"CC201903221054496692906","name":"无人驾驶","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 10:54:49 AM","remark":"无"}},{"code":"CCC201903221146384887704","carCode":"C201903191540014947886","configCode":"CC201903221111133179887","config":{"code":"CC201903221111133179887","name":"全景天窗","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:11:13 AM","remark":"无"}},{"code":"CCC201903221146384981518","carCode":"C201903191540014947886","configCode":"CC201903221145164897415","config":{"code":"CC201903221145164897415","name":"胎压检测","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:45:16 AM","remark":"无"}},{"code":"CCC201903221146385083945","carCode":"C201903191540014947886","configCode":"CC201903221145518657226","config":{"code":"CC201903221145518657226","name":"定速巡航","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:45:51 AM","remark":"无"}},{"code":"CCC201903221146385192807","carCode":"C201903191540014947886","configCode":"CC201903221146270184052","config":{"code":"CC201903221146270184052","name":"无钥匙进入","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:46:27 AM","remark":"无"}}]}}]
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
         * code : A201903271736245028110
         * type : 3
         * toType : 0
         * toCode : C201903191540014947886
         * creater : U201808091644004605371
         * createDatetime : Mar 27, 2019 5:36:24 PM
         * car : {"code":"C201903191540014947886","isReferee":"1","name":"S400","seriesCode":"S201903071411292394034","seriesName":"S系列","brandCode":"B201806190344172014125","brandName":"奔驰","bankCode":"BA201806011006085041799","level":"0","version":"1","structure":"2","displacement":4.6,"fromPlace":"德国","procedure":"无手续","originalPrice":0,"salePrice":1000000,"sfAmount":300000,"fwAmount":600,"jsqByhf":"1000","jsqSybx":"2000","slogan":"广告标语","advPic":"1111","picNumber":2,"pic":"111","description":"11111","outsideColor":"黑","insideColor":"灰","status":"1","updater":"U201806131315524345485","updateDatetime":"Mar 19, 2019 3:40:01 PM","caonfigList":[{"code":"CCC201903221146384778562","carCode":"C201903191540014947886","configCode":"CC201903221054496692906","config":{"code":"CC201903221054496692906","name":"无人驾驶","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 10:54:49 AM","remark":"无"}},{"code":"CCC201903221146384887704","carCode":"C201903191540014947886","configCode":"CC201903221111133179887","config":{"code":"CC201903221111133179887","name":"全景天窗","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:11:13 AM","remark":"无"}},{"code":"CCC201903221146384981518","carCode":"C201903191540014947886","configCode":"CC201903221145164897415","config":{"code":"CC201903221145164897415","name":"胎压检测","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:45:16 AM","remark":"无"}},{"code":"CCC201903221146385083945","carCode":"C201903191540014947886","configCode":"CC201903221145518657226","config":{"code":"CC201903221145518657226","name":"定速巡航","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:45:51 AM","remark":"无"}},{"code":"CCC201903221146385192807","carCode":"C201903191540014947886","configCode":"CC201903221146270184052","config":{"code":"CC201903221146270184052","name":"无钥匙进入","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:46:27 AM","remark":"无"}}]}
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

        public static class CarBean {
            /**
             * code : C201903191540014947886
             * isReferee : 1
             * name : S400
             * seriesCode : S201903071411292394034
             * seriesName : S系列
             * brandCode : B201806190344172014125
             * brandName : 奔驰
             * bankCode : BA201806011006085041799
             * level : 0
             * version : 1
             * structure : 2
             * displacement : 4.6
             * fromPlace : 德国
             * procedure : 无手续
             * originalPrice : 0
             * salePrice : 1000000
             * sfAmount : 300000
             * fwAmount : 600
             * jsqByhf : 1000
             * jsqSybx : 2000
             * slogan : 广告标语
             * advPic : 1111
             * picNumber : 2
             * pic : 111
             * description : 11111
             * outsideColor : 黑
             * insideColor : 灰
             * status : 1
             * updater : U201806131315524345485
             * updateDatetime : Mar 19, 2019 3:40:01 PM
             * caonfigList : [{"code":"CCC201903221146384778562","carCode":"C201903191540014947886","configCode":"CC201903221054496692906","config":{"code":"CC201903221054496692906","name":"无人驾驶","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 10:54:49 AM","remark":"无"}},{"code":"CCC201903221146384887704","carCode":"C201903191540014947886","configCode":"CC201903221111133179887","config":{"code":"CC201903221111133179887","name":"全景天窗","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:11:13 AM","remark":"无"}},{"code":"CCC201903221146384981518","carCode":"C201903191540014947886","configCode":"CC201903221145164897415","config":{"code":"CC201903221145164897415","name":"胎压检测","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:45:16 AM","remark":"无"}},{"code":"CCC201903221146385083945","carCode":"C201903191540014947886","configCode":"CC201903221145518657226","config":{"code":"CC201903221145518657226","name":"定速巡航","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:45:51 AM","remark":"无"}},{"code":"CCC201903221146385192807","carCode":"C201903191540014947886","configCode":"CC201903221146270184052","config":{"code":"CC201903221146270184052","name":"无钥匙进入","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 11:46:27 AM","remark":"无"}}]
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
            private double displacement;
            private String fromPlace;
            private String procedure;
            private int originalPrice;
            private int salePrice;
            private int sfAmount;
            private int fwAmount;
            private String jsqByhf;
            private String jsqSybx;
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

            public double getDisplacement() {
                return displacement;
            }

            public void setDisplacement(double displacement) {
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

            public int getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(int originalPrice) {
                this.originalPrice = originalPrice;
            }

            public int getSalePrice() {
                return salePrice;
            }

            public void setSalePrice(int salePrice) {
                this.salePrice = salePrice;
            }

            public int getSfAmount() {
                return sfAmount;
            }

            public void setSfAmount(int sfAmount) {
                this.sfAmount = sfAmount;
            }

            public int getFwAmount() {
                return fwAmount;
            }

            public void setFwAmount(int fwAmount) {
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

            public List<CaonfigListBean> getCaonfigList() {
                return caonfigList;
            }

            public void setCaonfigList(List<CaonfigListBean> caonfigList) {
                this.caonfigList = caonfigList;
            }

            public static class CaonfigListBean {
                /**
                 * code : CCC201903221146384778562
                 * carCode : C201903191540014947886
                 * configCode : CC201903221054496692906
                 * config : {"code":"CC201903221054496692906","name":"无人驾驶","pic":"nobody","updater":"U201806131315524345485","updateDatetime":"Mar 22, 2019 10:54:49 AM","remark":"无"}
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
                     * code : CC201903221054496692906
                     * name : 无人驾驶
                     * pic : nobody
                     * updater : U201806131315524345485
                     * updateDatetime : Mar 22, 2019 10:54:49 AM
                     * remark : 无
                     */

                    private String code;
                    private String name;
                    private String pic;
                    private String updater;
                    private String updateDatetime;
                    private String remark;

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
                }
            }
        }
    }
}
