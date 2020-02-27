package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 房屋景观表
 */
public class Housescenery implements Serializable {
    /**
     * 房屋景观编号
     */
    private int hcId;

    /**
     * 房屋景观名称
     */
    private String hcName;

    public Housescenery() {
    }

    public int getHcId() {
        return hcId;
    }

    public void setHcId(int hcId) {
        this.hcId = hcId;
    }

    public String getHcName() {
        return hcName;
    }

    public void setHcName(String hcName) {
        this.hcName = hcName;
    }

    @Override
    public String toString() {
        return "Housescenery{" +
                "hcId=" + hcId +
                ", hcName='" + hcName + '\'' +
                '}';
    }
}