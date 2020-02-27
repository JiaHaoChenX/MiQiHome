package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 设施服务表
 */
public class HouseFacilities implements Serializable {
    /**
     * 居家编号
     */
    private int hfId;
    /**
     * 类型名称
     */
    private String hfName;

    /**
     * 关联类型详细信息
     */
    List<Housefacilitiesdetails> housefacilitiesdetails;

    public List<Housefacilitiesdetails> getHousefacilitiesdetails() {
        return housefacilitiesdetails;
    }

    public void setHousefacilitiesdetails(List<Housefacilitiesdetails> housefacilitiesdetails) {
        this.housefacilitiesdetails = housefacilitiesdetails;
    }

    public HouseFacilities() {
    }

    public int getHfId() {
        return hfId;
    }

    public void setHfId(int hfId) {
        this.hfId = hfId;
    }

    public String getHfName() {
        return hfName;
    }

    public void setHfName(String hfName) {
        this.hfName = hfName;
    }

    @Override
    public String toString() {
        return "HouseFacilities{" +
                "hfId=" + hfId +
                ", hfName='" + hfName + '\'' +
                '}';
    }
}