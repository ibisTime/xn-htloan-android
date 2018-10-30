package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2018/10/21
 */

public class ZXDSBean {

    /**
     * code : 0006
     * msg : 等待输入信息
     * token : 70c6665e4179494bb819eded74c3ad88
     * input : {"type":"qr","value":"iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAIAAAAhotZpAAADfElEQVR42u2bW3KjUAxEvf9NzywgFaofugTh018uxwGs4xJSS3z ocfrQwiAhIAEJAQkBCQgISAhIAEJAQlICEgISEBCQEJAAhICEgISkBCQgISAhP4E0kfW9RF vv55fPeqfnt9fcbr/8q I5CA5IQj 8z1l/ztr0qwsvMq72RxABKQnMRyHSw96FNXolybknL17wgkIN0FSb8hZ59UAOgJFkhAejYkHZtbCrvK0jWQgPR3JXhWKLvJSmm672wzgASkaVto7 sv8u6AtGBU4VqcblAUi1ZvbF8yqgDSmnmSbnq6A4UsBbmDD92KPZrigPTFkLLQu7aNO1bQW ZmdLK4cADSYltICZzbMF6Hyf1BuKXK0aQHpC D1ARFTyZuaDJ47thwZeEApEdDasZ0zdjCtWLdQYOOYUF1B6Q1JXgzgHDLDT3hZMuazWAeSECaGFU0iSsbaetnaVaO1/dJQFrTzDY30qm1LDegmdkKJCDdm 70plJ/P0tKWVizJTUgAekkNj3QmQk0lbIyO3jlPAlIywzW3qzsTVJ3QaVP2kAC0rTBOmsOZcX9lFH72lEFkJaV4FlZ0TzQov ksjMCCUhnILkrUW4Q3SK P7vb3gIJSNMluF4guEZRhjD7kU2dC0hAmk53vX157tEX3eR9yZN QHoQJL31yx7pmno4smmub370DEhfDMltS90jT4Uss4XcdhhIQJoD1phAPexsaaspeYAEpOkhRdbqZqWEXmrPWqsr yQgrYHU3ORnh 79qKKxuIAEpDlIWVGeLYK5Q4rmevRiHUhAmksg2YLuiVTpHj8rfIAEpGmDtTdk9XTX2FR6Ka/btUAC0pzN2jeVWcrNbJ6mUAISkE6mu2Y4fe6G7y5tudcAJCCdhOcucOnLX00o 3XlNfckIC1rZvWwnjNkMxMoW30BEpDOFN/Zkkbz Epv7bjHX1yCA2lZ4eAWFP3Q/fqYmfHqHh9IQJouGZq20T1mFvRszPHCR1 A9NDCobEymzF8VlCcOD6QgHSmEHDTRV C661rk34XjyqA9BJIU Zpk0Iz8/S2dRQgAcmEpCQ0xXDq17KaQvzl6Q5IjyvB3QbZDXFTnjQ/ICAB6V5b6HQacZfxZy1gIAEJPUxAAhICEpAQkBCQgISAhIAEJAQkICEgISABCQEJAQlICEgISEBCQAISAhLS9R8gYA7GGHEyXQAAAABJRU5ErkJggg==","waitSeconds":""}
     */

    private String code;
    private String msg;
    private String token;
    private InputBean input;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public InputBean getInput() {
        return input;
    }

    public void setInput(InputBean input) {
        this.input = input;
    }

    public static class InputBean {
        /**
         * type : qr
         * value : iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAIAAAAhotZpAAADfElEQVR42u2bW3KjUAxEvf9NzywgFaofugTh018uxwGs4xJSS3z ocfrQwiAhIAEJAQkBCQgISAhIAEJAQlICEgISEBCQEJAAhICEgISkBCQgISAhP4E0kfW9RF vv55fPeqfnt9fcbr/8q I5CA5IQj 8z1l/ztr0qwsvMq72RxABKQnMRyHSw96FNXolybknL17wgkIN0FSb8hZ59UAOgJFkhAejYkHZtbCrvK0jWQgPR3JXhWKLvJSmm672wzgASkaVto7 sv8u6AtGBU4VqcblAUi1ZvbF8yqgDSmnmSbnq6A4UsBbmDD92KPZrigPTFkLLQu7aNO1bQW ZmdLK4cADSYltICZzbMF6Hyf1BuKXK0aQHpC D1ARFTyZuaDJ47thwZeEApEdDasZ0zdjCtWLdQYOOYUF1B6Q1JXgzgHDLDT3hZMuazWAeSECaGFU0iSsbaetnaVaO1/dJQFrTzDY30qm1LDegmdkKJCDdm 70plJ/P0tKWVizJTUgAekkNj3QmQk0lbIyO3jlPAlIywzW3qzsTVJ3QaVP2kAC0rTBOmsOZcX9lFH72lEFkJaV4FlZ0TzQov ksjMCCUhnILkrUW4Q3SK P7vb3gIJSNMluF4guEZRhjD7kU2dC0hAmk53vX157tEX3eR9yZN QHoQJL31yx7pmno4smmub370DEhfDMltS90jT4Uss4XcdhhIQJoD1phAPexsaaspeYAEpOkhRdbqZqWEXmrPWqsr yQgrYHU3ORnh 79qKKxuIAEpDlIWVGeLYK5Q4rmevRiHUhAmksg2YLuiVTpHj8rfIAEpGmDtTdk9XTX2FR6Ka/btUAC0pzN2jeVWcrNbJ6mUAISkE6mu2Y4fe6G7y5tudcAJCCdhOcucOnLX00o 3XlNfckIC1rZvWwnjNkMxMoW30BEpDOFN/Zkkbz Epv7bjHX1yCA2lZ4eAWFP3Q/fqYmfHqHh9IQJouGZq20T1mFvRszPHCR1 A9NDCobEymzF8VlCcOD6QgHSmEHDTRV C661rk34XjyqA9BJIU Zpk0Iz8/S2dRQgAcmEpCQ0xXDq17KaQvzl6Q5IjyvB3QbZDXFTnjQ/ICAB6V5b6HQacZfxZy1gIAEJPUxAAhICEpAQkBCQgISAhIAEJAQkICEgISABCQEJAQlICEgISEBCQAISAhLS9R8gYA7GGHEyXQAAAABJRU5ErkJggg==
         * waitSeconds :
         */

        private String type;
        private String value;
        private String waitSeconds;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getWaitSeconds() {
            return waitSeconds;
        }

        public void setWaitSeconds(String waitSeconds) {
            this.waitSeconds = waitSeconds;
        }
    }
}
