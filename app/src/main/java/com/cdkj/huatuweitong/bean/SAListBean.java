package com.cdkj.huatuweitong.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @updateDts 2018/10/12
 */

public class SAListBean {
    private String code;
    private String msg;
    private List<SAListBean.DataBean> data;

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

    public List<SAListBean.DataBean> getData() {
        return data;
    }

    public void setData(List<SAListBean.DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {


        private String dangshiren;//当事人
        private String jsummary;//案件摘要
        private String matchfit;//匹配度
        private String recordId;//详情 ID
        private String title;//案件标题

        public String getDangshiren() {
            return dangshiren;
        }

        public void setDangshiren(String dangshiren) {
            this.dangshiren = dangshiren;
        }

        public String getJsummary() {
            return jsummary;
        }

        public void setJsummary(String jsummary) {
            this.jsummary = jsummary;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
