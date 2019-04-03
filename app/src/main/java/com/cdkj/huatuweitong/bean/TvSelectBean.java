package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2019/3/14
 */
public class TvSelectBean {

    public TvSelectBean() {
    }

    public TvSelectBean(String name) {
        this.name = name;
    }
    public TvSelectBean(String name, String value) {
        this.name = name;
        this.value = value;
    }
    public TvSelectBean(String name,String startvalue, String value) {
        this.name = name;
        this.value = value;
        this.startValue = startvalue;
    }
    public TvSelectBean(String name,String startvalue, String value,String pic) {
        this.name = name;
        this.value = value;
        this.startValue = startvalue;
        this.pic = pic;
    }



    private String name;
    private String value;
    private String startValue;
    private String pic;

    private boolean isSelect;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getStartValue() {
        return startValue;
    }

    public void setStartValue(String startValue) {
        this.startValue = startValue;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
