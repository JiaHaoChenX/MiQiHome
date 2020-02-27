package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 床型表(一个房子有多个床型),关联房屋详细表
 */
public class Housebed implements Serializable {
    /**
     * 床型编号
     */
    private int hbId;

    /**
     * 关联床型床类型表
     */
    private int hdsId;
    Housebedsize housebedsize;
    /**
     * 床数量
     */
    private int hbtNumber;

    /**
     * 关联房屋详细表
     */
    private int hdId;
    Housedetails housedetails;

    public Housebed() {
    }

    public int getHbId() {
        return hbId;
    }

    public void setHbId(int hbId) {
        this.hbId = hbId;
    }

    public int getHdsId() {
        return hdsId;
    }

    public void setHdsId(int hdsId) {
        this.hdsId = hdsId;
    }

    public Housebedsize getHousebedsize() {
        return housebedsize;
    }

    public void setHousebedsize(Housebedsize housebedsize) {
        this.housebedsize = housebedsize;
    }

    public int getHbtNumber() {
        return hbtNumber;
    }

    public void setHbtNumber(int hbtNumber) {
        this.hbtNumber = hbtNumber;
    }

    public int getHdId() {
        return hdId;
    }

    public void setHdId(int hdId) {
        this.hdId = hdId;
    }

    public Housedetails getHousedetails() {
        return housedetails;
    }

    public void setHousedetails(Housedetails housedetails) {
        this.housedetails = housedetails;
    }

    @Override
    public String toString() {
        return "Housebed{" +
                "hbId=" + hbId +
                ", hdsId=" + hdsId +
                ", housebedsize=" + housebedsize +
                ", hbtNumber=" + hbtNumber +
                ", hdId=" + hdId +
                ", housedetails=" + housedetails +
                '}';
    }
}