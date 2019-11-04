package com.cdkj.huatuweitong.bean;

/**
 * @author : qianLei
 * @since : 2019/9/4 18:54
 */
public class EventBean {

    private String tag;
    private String value;

    public String getTag() {
        return tag;
    }

    public EventBean setTag(String tag) {
        this.tag = tag;

        return this;
    }

    public String getValue() {
        return value;
    }

    public EventBean setValue(String value) {
        this.value = value;

        return this;
    }
}
