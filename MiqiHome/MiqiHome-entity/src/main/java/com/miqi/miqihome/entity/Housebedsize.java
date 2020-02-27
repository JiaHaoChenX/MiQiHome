package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 床型床宽高表
 */
public class Housebedsize implements Serializable {

    /**
     * 床型床宽高编号
     */
    private int hdsId;

    /**
     * 大小
     */
    private String hbsSize;

    /**
     * 关联床型床宽高表
     */
    private int hbtId;
    Housebedtype housebedtype;

    public Housebedsize() {
    }

    public int getHdsId() {
        return hdsId;
    }

    public void setHdsId(int hdsId) {
        this.hdsId = hdsId;
    }

    public String getHbsSize() {
        return hbsSize;
    }

    public void setHbsSize(String hbsSize) {
        this.hbsSize = hbsSize;
    }

    public int getHbtId() {
        return hbtId;
    }

    public void setHbtId(int hbtId) {
        this.hbtId = hbtId;
    }

    public Housebedtype getHousebedtype() {
        return housebedtype;
    }

    public void setHousebedtype(Housebedtype housebedtype) {
        this.housebedtype = housebedtype;
    }

    @Override
    public String toString() {
        return "Housebedsize{" +
                "hdsId=" + hdsId +
                ", hbsSize='" + hbsSize + '\'' +
                ", hbtId=" + hbtId +
                ", housebedtype=" + housebedtype +
                '}';
    }
}