package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 床型床类型表
 */
public class Housebedtype implements Serializable {
    /**
     * 床型床类型编号
     */
    private int hbtId;

    /**
     * 床型床类型名称
     */
    private String hbtName;

    public Housebedtype() {
    }

    public int getHbtId() {
        return hbtId;
    }

    public void setHbtId(int hbtId) {
        this.hbtId = hbtId;
    }

    public String getHbtName() {
        return hbtName;
    }

    public void setHbtName(String hbtName) {
        this.hbtName = hbtName;
    }

    @Override
    public String toString() {
        return "Housebedtype{" +
                "hbtId=" + hbtId +
                ", hbtName='" + hbtName + '\'' +
                '}';
    }
}