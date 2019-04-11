package com.cdkj.huatuweitong.bean;

/**
 * @updateDts 2019/3/14
 */
public class TvSelectBean {

    public TvSelectBean() {
    }




    private String name;
    private String value;
    private String startValue;
    private int pic;
    private boolean isSelect;

    public TvSelectBean(String name) {
        this.name = name;
    }
    public TvSelectBean(String name, String value,int pic) {
        this.name = name;
        this.value = value;
        this.pic = pic;
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

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
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
