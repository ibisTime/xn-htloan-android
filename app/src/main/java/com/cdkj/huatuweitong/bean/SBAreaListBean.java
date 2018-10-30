package com.cdkj.huatuweitong.bean;

import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * @updateDts 2018/10/12
 * 社保地区列表查询
 */

public class SBAreaListBean implements IPickerViewData {

    /**
     * areaCode : 1100
     * areaName : 北京市
     * sortLetter : BeiJingShi
     * status : 1
     */

    private String areaCode;
    private String areaName;
    private String sortLetter;
    private String status;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSortLetter() {
        return sortLetter;
    }

    public void setSortLetter(String sortLetter) {
        this.sortLetter = sortLetter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String getPickerViewText() {
        return areaName;
    }
}
