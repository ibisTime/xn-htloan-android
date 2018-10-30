package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2018/10/12
 */

public class SADetailsBean {

    private String code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String beigao;//	被告	string	@mock=
        private String beishangshuren;//被上诉人	string	@mock=某某
        private String court;//法院名称	string	@mock=北京市朝阳区人民法院
        private String court_type;//法院等级	string	@mock=
        private String danshiren;//当事人	string	@mock=
        private String identity_card;//当事人身份证	string	@mock=
        private String jcase;//案由	string	@mock=申请诉前财产保全
        private String jnum;//案号	string	@mock=（2016）京XXX财保XXX号
        private String jprocess;//	审理程序	string	@mock=
        private String jsummary;//案件摘要	string	@mock=北京市朝阳区人民法院民 事 裁 定 书（2016）京XXX财保XXX号之一申请人某某
        private String jtype;//案件类别	string	@mock=民事案件
        private String judge_date;//	审结时间	string	@mock=二〇一六年七月一日
        private String matchfit;//;//匹配度	string	@mock=2
        private String recordId;//详情 ID	string	@mock= CvbY0KxVxnWBNXbLX1HM
        private String result_str;//判决结果	string	@mock=查封担保人某某名下的xxx房屋本裁定送达后立即执行。
        private String shangshuren;//上诉人	string	@mock=某某
        private String title;//案件标题	string	@mock=李明申请诉前财产保全一案
        private String weitobianhuren;//委托辩护人	string	@mock= 某某(上诉人)
        private String yuangao;//原告	string	@mock=

        public String getBeigao() {
            return beigao;
        }

        public void setBeigao(String beigao) {
            this.beigao = beigao;
        }

        public String getBeishangshuren() {
            return beishangshuren;
        }

        public void setBeishangshuren(String beishangshuren) {
            this.beishangshuren = beishangshuren;
        }

        public String getCourt() {
            return court;
        }

        public void setCourt(String court) {
            this.court = court;
        }

        public String getCourt_type() {
            return court_type;
        }

        public void setCourt_type(String court_type) {
            this.court_type = court_type;
        }

        public String getDanshiren() {
            return danshiren;
        }

        public void setDanshiren(String danshiren) {
            this.danshiren = danshiren;
        }

        public String getIdentity_card() {
            return identity_card;
        }

        public void setIdentity_card(String identity_card) {
            this.identity_card = identity_card;
        }

        public String getJcase() {
            return jcase;
        }

        public void setJcase(String jcase) {
            this.jcase = jcase;
        }

        public String getJnum() {
            return jnum;
        }

        public void setJnum(String jnum) {
            this.jnum = jnum;
        }

        public String getJprocess() {
            return jprocess;
        }

        public void setJprocess(String jprocess) {
            this.jprocess = jprocess;
        }

        public String getJsummary() {
            return jsummary;
        }

        public void setJsummary(String jsummary) {
            this.jsummary = jsummary;
        }

        public String getJtype() {
            return jtype;
        }

        public void setJtype(String jtype) {
            this.jtype = jtype;
        }

        public String getJudge_date() {
            return judge_date;
        }

        public void setJudge_date(String judge_date) {
            this.judge_date = judge_date;
        }

        public String getMatchfit() {
            return matchfit;
        }

        public void setMatchfit(String matchfit) {
            this.matchfit = matchfit;
        }

        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }

        public String getResult_str() {
            return result_str;
        }

        public void setResult_str(String result_str) {
            this.result_str = result_str;
        }

        public String getShangshuren() {
            return shangshuren;
        }

        public void setShangshuren(String shangshuren) {
            this.shangshuren = shangshuren;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWeitobianhuren() {
            return weitobianhuren;
        }

        public void setWeitobianhuren(String weitobianhuren) {
            this.weitobianhuren = weitobianhuren;
        }

        public String getYuangao() {
            return yuangao;
        }

        public void setYuangao(String yuangao) {
            this.yuangao = yuangao;
        }
    }



}
