package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 出租方式表
 */
public class Rentalmode implements Serializable {
    /**
     * 出租方式编号
     */
    private int rmId;

    /**
     * 出租方式名称
     */
    private String rmName;

    public Rentalmode() {
    }

    public int getRmId() {
        return rmId;
    }

    public void setRmId(int rmId) {
        this.rmId = rmId;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    @Override
    public String toString() {
        return "Rentalmode{" +
                "rmId=" + rmId +
                ", rmName='" + rmName + '\'' +
                '}';
    }
}