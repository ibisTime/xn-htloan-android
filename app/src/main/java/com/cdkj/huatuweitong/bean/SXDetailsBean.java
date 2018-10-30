package com.cdkj.huatuweitong.bean;

import java.util.List;

/**
 * @updateDts 2018/10/12
 */

public class SXDetailsBean {
    /**
     * code : 0000
     * data : {"dishonests":[{"label":"账号","name":"username","prompt":"用户名/邮箱","regex":"","required":"true","type":"text"},{"label":"密码","name":"password","prompt":"密码","regex":"","required":"true","type":"password"}]}
     * msg : 成功
     */

    private String code;
    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private List<DishonestsBean> dishonests;

        public List<DishonestsBean> getDishonests() {
            return dishonests;
        }

        public void setDishonests(List<DishonestsBean> dishonests) {
            this.dishonests = dishonests;
        }

        public static class DishonestsBean {

            private String age;//	年龄(个人)	string	@mock=50
            private String caseNo;//	案号	string	@mock=(2016)沪 0404 执 75 号
            private String corpLegalPerson;//	法人姓名	string	@mock=李明
            private String executed;//已履行	string	@mock=10002 元
            private String executiveArm;//做出执行依据 单位	string	@mock=上海市人民法院
            private String executiveBaiscNo;//	执行依据文号	string	@mock=上海初字第 01443 号民事判决书
            private String executiveCase;//	被执行人的履 行情况	string	@mock=部分履行
            private String executiveCourt;//	执行法院	string	@mock=上海市人民法院
            private String filingTime;//	立案时间	string	@mock=2016-09-05
            private String identityNo;//	身份证号码/组 织机构代码	string	@mock=310808196808234427
            private String legalObligation;//生效法律文书 确定的义务	string	@mock=偿还借款本金 106700 元
            private String name;//被执行人姓名/ 名称	string	@mock=李明
            private String no;//	序号	string	@mock=1
            private String province;//省份	string	@mock=上海
            private String releaseTime;//	发布时间	string	@mock=2016-09-05
            private String sex;//性别(个人)	string	@mock=男
            private String specificSituation;//	具体情形	string	@mock=规避执行
            private String unExecuted;//未履行	string	@mock=1234 元

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getCaseNo() {
                return caseNo;
            }

            public void setCaseNo(String caseNo) {
                this.caseNo = caseNo;
            }

            public String getCorpLegalPerson() {
                return corpLegalPerson;
            }

            public void setCorpLegalPerson(String corpLegalPerson) {
                this.corpLegalPerson = corpLegalPerson;
            }

            public String getExecuted() {
                return executed;
            }

            public void setExecuted(String executed) {
                this.executed = executed;
            }

            public String getExecutiveArm() {
                return executiveArm;
            }

            public void setExecutiveArm(String executiveArm) {
                this.executiveArm = executiveArm;
            }

            public String getExecutiveBaiscNo() {
                return executiveBaiscNo;
            }

            public void setExecutiveBaiscNo(String executiveBaiscNo) {
                this.executiveBaiscNo = executiveBaiscNo;
            }

            public String getExecutiveCase() {
                return executiveCase;
            }

            public void setExecutiveCase(String executiveCase) {
                this.executiveCase = executiveCase;
            }

            public String getExecutiveCourt() {
                return executiveCourt;
            }

            public void setExecutiveCourt(String executiveCourt) {
                this.executiveCourt = executiveCourt;
            }

            public String getFilingTime() {
                return filingTime;
            }

            public void setFilingTime(String filingTime) {
                this.filingTime = filingTime;
            }

            public String getIdentityNo() {
                return identityNo;
            }

            public void setIdentityNo(String identityNo) {
                this.identityNo = identityNo;
            }

            public String getLegalObligation() {
                return legalObligation;
            }

            public void setLegalObligation(String legalObligation) {
                this.legalObligation = legalObligation;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getReleaseTime() {
                return releaseTime;
            }

            public void setReleaseTime(String releaseTime) {
                this.releaseTime = releaseTime;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getSpecificSituation() {
                return specificSituation;
            }

            public void setSpecificSituation(String specificSituation) {
                this.specificSituation = specificSituation;
            }

            public String getUnExecuted() {
                return unExecuted;
            }

            public void setUnExecuted(String unExecuted) {
                this.unExecuted = unExecuted;
            }
        }
    }


//    private String code;
//    private String msg;
//    private DataBean data;
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public static class DataBean {
//
//
//
//        private String age;//	年龄(个人)	string	@mock=50
//        private String caseNo;//	案号	string	@mock=(2016)沪 0404 执 75 号
//        private String corpLegalPerson;//	法人姓名	string	@mock=李明
//        private String executed;//已履行	string	@mock=10002 元
//        private String executiveArm;//做出执行依据 单位	string	@mock=上海市人民法院
//        private String executiveBaiscNo;//	执行依据文号	string	@mock=上海初字第 01443 号民事判决书
//        private String executiveCase;//	被执行人的履 行情况	string	@mock=部分履行
//        private String executiveCourt;//	执行法院	string	@mock=上海市人民法院
//        private String filingTime;//	立案时间	string	@mock=2016-09-05
//        private String identityNo;//	身份证号码/组 织机构代码	string	@mock=310808196808234427
//        private String legalObligation;//生效法律文书 确定的义务	string	@mock=偿还借款本金 106700 元
//        private String name;//被执行人姓名/ 名称	string	@mock=李明
//        private String no;//	序号	string	@mock=1
//        private String province;//省份	string	@mock=上海
//        private String releaseTime;//	发布时间	string	@mock=2016-09-05
//        private String sex;//性别(个人)	string	@mock=男
//        private String specificSituation;//	具体情形	string	@mock=规避执行
//        private String unExecuted;//未履行	string	@mock=1234 元
//
//        public String getAge() {
//            return age;
//        }
//
//        public void setAge(String age) {
//            this.age = age;
//        }
//
//        public String getCaseNo() {
//            return caseNo;
//        }
//
//        public void setCaseNo(String caseNo) {
//            this.caseNo = caseNo;
//        }
//
//        public String getCorpLegalPerson() {
//            return corpLegalPerson;
//        }
//
//        public void setCorpLegalPerson(String corpLegalPerson) {
//            this.corpLegalPerson = corpLegalPerson;
//        }
//
//        public String getExecuted() {
//            return executed;
//        }
//
//        public void setExecuted(String executed) {
//            this.executed = executed;
//        }
//
//        public String getExecutiveArm() {
//            return executiveArm;
//        }
//
//        public void setExecutiveArm(String executiveArm) {
//            this.executiveArm = executiveArm;
//        }
//
//        public String getExecutiveBaiscNo() {
//            return executiveBaiscNo;
//        }
//
//        public void setExecutiveBaiscNo(String executiveBaiscNo) {
//            this.executiveBaiscNo = executiveBaiscNo;
//        }
//
//        public String getExecutiveCase() {
//            return executiveCase;
//        }
//
//        public void setExecutiveCase(String executiveCase) {
//            this.executiveCase = executiveCase;
//        }
//
//        public String getExecutiveCourt() {
//            return executiveCourt;
//        }
//
//        public void setExecutiveCourt(String executiveCourt) {
//            this.executiveCourt = executiveCourt;
//        }
//
//        public String getFilingTime() {
//            return filingTime;
//        }
//
//        public void setFilingTime(String filingTime) {
//            this.filingTime = filingTime;
//        }
//
//        public String getIdentityNo() {
//            return identityNo;
//        }
//
//        public void setIdentityNo(String identityNo) {
//            this.identityNo = identityNo;
//        }
//
//        public String getLegalObligation() {
//            return legalObligation;
//        }
//
//        public void setLegalObligation(String legalObligation) {
//            this.legalObligation = legalObligation;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getNo() {
//            return no;
//        }
//
//        public void setNo(String no) {
//            this.no = no;
//        }
//
//        public String getProvince() {
//            return province;
//        }
//
//        public void setProvince(String province) {
//            this.province = province;
//        }
//
//        public String getReleaseTime() {
//            return releaseTime;
//        }
//
//        public void setReleaseTime(String releaseTime) {
//            this.releaseTime = releaseTime;
//        }
//
//        public String getSex() {
//            return sex;
//        }
//
//        public void setSex(String sex) {
//            this.sex = sex;
//        }
//
//        public String getSpecificSituation() {
//            return specificSituation;
//        }
//
//        public void setSpecificSituation(String specificSituation) {
//            this.specificSituation = specificSituation;
//        }
//
//        public String getUnExecuted() {
//            return unExecuted;
//        }
//
//        public void setUnExecuted(String unExecuted) {
//            this.unExecuted = unExecuted;
//        }
//    }
}
