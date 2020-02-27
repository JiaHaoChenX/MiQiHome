package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 房屋设施类型表
 */
public class Housefacilitiesdetails implements Serializable {
    /**
     * 房屋设施详细编号
     */
    private int hfdId;

    /**
     * 房屋设施详细类型名称
     */
    private String hfdName;

    /**
     * 关联设施服务表
     */
    private int hfId;
    HouseFacilities houseFacilities;

    public Housefacilitiesdetails() {
    }

    public int getHfdId() {
        return hfdId;
    }

    public void setHfdId(int hfdId) {
        this.hfdId = hfdId;
    }

    public String getHfdName() {
        return hfdName;
    }

    public void setHfdName(String hfdName) {
        this.hfdName = hfdName;
    }

    public int getHfId() {
        return hfId;
    }

    public void setHfId(int hfId) {
        this.hfId = hfId;
    }

    public HouseFacilities getHouseFacilities() {
        return houseFacilities;
    }

    public void setHouseFacilities(HouseFacilities houseFacilities) {
        this.houseFacilities = houseFacilities;
    }

    @Override
    public String toString() {
        return "Housefacilitiesdetails{" +
                "hfdId=" + hfdId +
                ", hfdName='" + hfdName + '\'' +
                ", hfId=" + hfId +
                ", houseFacilities=" + houseFacilities +
                '}';
    }
}