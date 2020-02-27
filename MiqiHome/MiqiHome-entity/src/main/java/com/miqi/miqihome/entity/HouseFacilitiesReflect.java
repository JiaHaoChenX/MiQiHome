package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 设施服务表对应表
 */
public class HouseFacilitiesReflect implements Serializable {
    /**
     * 居家表对应表编号
     */
    private int hfrId;

    /**
     * 房屋设施类型表
     */
    private int hfdId;
    Housefacilitiesdetails housefacilitiesdetails;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    public HouseFacilitiesReflect() {
    }

    public int getHfrId() {
        return hfrId;
    }

    public void setHfrId(int hfrId) {
        this.hfrId = hfrId;
    }

    public int getHfdId() {
        return hfdId;
    }

    public void setHfdId(int hfdId) {
        this.hfdId = hfdId;
    }

    public Housefacilitiesdetails getHousefacilitiesdetails() {
        return housefacilitiesdetails;
    }

    public void setHousefacilitiesdetails(Housefacilitiesdetails housefacilitiesdetails) {
        this.housefacilitiesdetails = housefacilitiesdetails;
    }

    public int getHaiId() {
        return haiId;
    }

    public void setHaiId(int haiId) {
        this.haiId = haiId;
    }

    public Homeallinformation getHomeallinformation() {
        return homeallinformation;
    }

    public void setHomeallinformation(Homeallinformation homeallinformation) {
        this.homeallinformation = homeallinformation;
    }

    @Override
    public String toString() {
        return "HouseFacilitiesReflect{" +
                "hfrId=" + hfrId +
                ", hfdId=" + hfdId +
                ", housefacilitiesdetails=" + housefacilitiesdetails +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                '}';
    }
}