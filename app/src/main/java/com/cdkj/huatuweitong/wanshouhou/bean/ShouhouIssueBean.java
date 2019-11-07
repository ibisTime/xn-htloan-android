package com.cdkj.huatuweitong.wanshouhou.bean;

import java.util.List;

/**
 * @author : qianLei
 * @since : 2019/11/4 17:02
 */
public class ShouhouIssueBean {


    /**
     * pageNO : 1
     * start : 0
     * pageSize : 10
     * totalCount : 1
     * totalPage : 1
     * list : [{"code":"CQ201911011308453245412","type":"1","inquiry":"申请分期需要准备什么材料？","answer":"1.贷款人身份信息；2.贷款人资产证明；3.车辆信息","status":"2","inquirer":"U201907081023440007973","answerer":"U201907081023440007973","inquiryDatetime":"Nov 1, 2019 1:08:45 PM","answerDatetime":"Nov 1, 2019 1:22:52 PM"}]
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
         * code : CQ201911011308453245412
         * type : 1
         * inquiry : 申请分期需要准备什么材料？
         * answer : 1.贷款人身份信息；2.贷款人资产证明；3.车辆信息
         * status : 2
         * inquirer : U201907081023440007973
         * answerer : U201907081023440007973
         * inquiryDatetime : Nov 1, 2019 1:08:45 PM
         * answerDatetime : Nov 1, 2019 1:22:52 PM
         */

        private String code;
        private String type;
        private String inquiry;
        private String answer;
        private String status;
        private String inquirer;
        private String answerer;
        private String inquiryDatetime;
        private String answerDatetime;

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

        public String getInquiry() {
            return inquiry;
        }

        public void setInquiry(String inquiry) {
            this.inquiry = inquiry;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getInquirer() {
            return inquirer;
        }

        public void setInquirer(String inquirer) {
            this.inquirer = inquirer;
        }

        public String getAnswerer() {
            return answerer;
        }

        public void setAnswerer(String answerer) {
            this.answerer = answerer;
        }

        public String getInquiryDatetime() {
            return inquiryDatetime;
        }

        public void setInquiryDatetime(String inquiryDatetime) {
            this.inquiryDatetime = inquiryDatetime;
        }

        public String getAnswerDatetime() {
            return answerDatetime;
        }

        public void setAnswerDatetime(String answerDatetime) {
            this.answerDatetime = answerDatetime;
        }
    }
}
