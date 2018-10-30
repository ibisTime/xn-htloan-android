package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2018/10/21
 */

public class ZXTBqrBean {

    /**
     * code : 0006
     * msg : 等待输入信息
     * token : 0abc6c910ce342d2ad0a00a01fa0543c
     * input : {"type":"qr","value":"iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAIAAAAhotZpAAADdUlEQVR42u2bW3LkMAwD5/6X3j1AylMEQFlDqfGV2nJiWe2lwYc /9DP68MWAAkBCUgISAhIQEJAQkACEgISkBCQEJCAhICEgAQkBCQEJCAhIAEJAQltgfQp6 9vPf2Fp7 vrur7Op urKyw8oxAApIOybumvllPVz5tZQVw5QXKnxFIQNIhVULK94eph47KXepr 75C9RmBBKS3IHlGQ30JvNdFXT QgLQbUmLHe5W8ZEAC0g4LXv9QVz7gqt3vSo0Pz5OANKAsNPfni2p3QBrQqugy6PVwVy/dLtpuIAEptuD1Da1skHovFWS9zfECTiBdCSmxtnXTXG8r9Db9tgAD0mWQvHRVbS7UA5EaxLrKvgPcHZDGGwe1iJI3BpMxmHr59Sh3B6QfNQ5eu7q KfXgljQa6hhGujsgjYGkbmI9WHkjK0mo9MwRkIDUB2nF6Ig3rJKkCuMtOJDGWPDEZOcIuza6a4wZSEBaY8Hzj7BXkK1sq7rdSy0DkK6E5JVkeouY RYn7ccBFhxIwyB1FXWSVoiXtFb JS8dAQlISoirL713zCo/NuMVfIEEpB0WPBme8pp13iuVj2kCCUgZJDXl7LXISVvdS5lHtiqANLhVkWyTZ8G7XrKuewEJSG4ymye83hhwYkbqRd6Rh8iAdEhZyGtq5CPBKmBv/UAC0poQl7TX1iWYXlkoL4MBCUgZMLWhp5Zt8rKvemBtZBUcSGMgVVDVf1aLOutaFVvKrEC6DFJSTs3Nd9eaPaMBJCCtCW7elclgV3KgRW2XeNcACUgdQS/58HrtjLxV7xmKARYcSD8NKTnk1fXwKxLnjYdegHQlJNXCqgFNvYtaCuqyP0AC0rtF1STN9AYu85Crmg4gAWklPO/TrTYO1ICp3ve10AekKyHl//29tPdjSS0XjR/YB9KwikO9EaC2IZLN9Wz3FjBAuhhSV2D0UlfVZOcjLiOPvgBpAKRkSMO7Rh2090a0Dj fBKQBxqGrlNkVjjyTctTRFyCNLLDm4SIfLFkB4JA8CUhHQUqMcmLWvRGwemsGSEDaB6luytWGRd3UeIXdpQ0LIF0MKbnGC1xqqbSryDt47g5Ih5SF1o0eqkUmNYDnryCQgIReF5CAhIAEJAQkBCQgISAhIAEJAQlICEgISEBCQEJAAhICEgISkBCQgISAhOr6D6gnPpbaOBuuAAAAAElFTkSuQmCC","waitSeconds":""}
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
         * value : iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAIAAAAhotZpAAADdUlEQVR42u2bW3LkMAwD5/6X3j1AylMEQFlDqfGV2nJiWe2lwYc /9DP68MWAAkBCUgISAhIQEJAQkACEgISkBCQEJCAhICEgAQkBCQEJCAhIAEJAQltgfQp6 9vPf2Fp7 vrur7Op urKyw8oxAApIOybumvllPVz5tZQVw5QXKnxFIQNIhVULK94eph47KXepr 75C9RmBBKS3IHlGQ30JvNdFXT QgLQbUmLHe5W8ZEAC0g4LXv9QVz7gqt3vSo0Pz5OANKAsNPfni2p3QBrQqugy6PVwVy/dLtpuIAEptuD1Da1skHovFWS9zfECTiBdCSmxtnXTXG8r9Db9tgAD0mWQvHRVbS7UA5EaxLrKvgPcHZDGGwe1iJI3BpMxmHr59Sh3B6QfNQ5eu7q KfXgljQa6hhGujsgjYGkbmI9WHkjK0mo9MwRkIDUB2nF6Ig3rJKkCuMtOJDGWPDEZOcIuza6a4wZSEBaY8Hzj7BXkK1sq7rdSy0DkK6E5JVkeouY RYn7ccBFhxIwyB1FXWSVoiXtFb JS8dAQlISoirL713zCo/NuMVfIEEpB0WPBme8pp13iuVj2kCCUgZJDXl7LXISVvdS5lHtiqANLhVkWyTZ8G7XrKuewEJSG4ymye83hhwYkbqRd6Rh8iAdEhZyGtq5CPBKmBv/UAC0poQl7TX1iWYXlkoL4MBCUgZMLWhp5Zt8rKvemBtZBUcSGMgVVDVf1aLOutaFVvKrEC6DFJSTs3Nd9eaPaMBJCCtCW7elclgV3KgRW2XeNcACUgdQS/58HrtjLxV7xmKARYcSD8NKTnk1fXwKxLnjYdegHQlJNXCqgFNvYtaCuqyP0AC0rtF1STN9AYu85Crmg4gAWklPO/TrTYO1ICp3ve10AekKyHl//29tPdjSS0XjR/YB9KwikO9EaC2IZLN9Wz3FjBAuhhSV2D0UlfVZOcjLiOPvgBpAKRkSMO7Rh2090a0Dj fBKQBxqGrlNkVjjyTctTRFyCNLLDm4SIfLFkB4JA8CUhHQUqMcmLWvRGwemsGSEDaB6luytWGRd3UeIXdpQ0LIF0MKbnGC1xqqbSryDt47g5Ih5SF1o0eqkUmNYDnryCQgIReF5CAhIAEJAQkBCQgISAhIAEJAQlICEgISEBCQEJAAhICEgISkBCQgISAhOr6D6gnPpbaOBuuAAAAAElFTkSuQmCC
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
