package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 房屋多种价格对应表(一栋房子有多种不同的价格，在当天前的为无房，如果设置了价格那么价格就为设置的，否则价格为默认价格，即初始价格即可)，（多对一关系）
 */
public class Pricereflect implements Serializable {
    /**
     * 房屋多种价格对应表编号
     */
    private int prId;

    /**
     * 设置价格
     */
    private BigDecimal prPrice;

    /**
     * 房屋日期
     */
    private Date prTime;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    public Pricereflect() {
    }

    public Pricereflect(BigDecimal prPrice, Date prTime, int haiId) {
        this.prPrice = prPrice;
        this.prTime = prTime;
        this.haiId = haiId;
    }

    public int getPrId() {
        return prId;
    }

    public void setPrId(int prId) {
        this.prId = prId;
    }

    public BigDecimal getPrPrice() {
        return prPrice;
    }

    public void setPrPrice(BigDecimal prPrice) {
        this.prPrice = prPrice;
    }

    public Date getPrTime() {
        return prTime;
    }

    public void setPrTime(Date prTime) {
        this.prTime = prTime;
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
        return "Pricereflect{" +
                "prId=" + prId +
                ", prPrice=" + prPrice +
                ", prTime=" + prTime +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                '}';
    }
}