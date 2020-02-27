package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 连住折扣表
 */
public class Continuousdiscount implements Serializable {
    /**
     * 连住折扣编号
     */
    private int cdId;

    /**
     * 连住折扣天数
     */
    private int cdDay;

    /**
     * 折扣设置
     */
    private BigDecimal cdDiscount;

    /**
     * 关联房屋价格表
     */
    private int hpId;
    Homeprice homeprice;

    public Continuousdiscount() {
    }

    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    public int getCdDay() {
        return cdDay;
    }

    public void setCdDay(int cdDay) {
        this.cdDay = cdDay;
    }

    public BigDecimal getCdDiscount() {
        return cdDiscount;
    }

    public void setCdDiscount(BigDecimal cdDiscount) {
        this.cdDiscount = cdDiscount;
    }

    public int getHpId() {
        return hpId;
    }

    public void setHpId(int hpId) {
        this.hpId = hpId;
    }

    public Homeprice getHomeprice() {
        return homeprice;
    }

    public void setHomeprice(Homeprice homeprice) {
        this.homeprice = homeprice;
    }

    @Override
    public String toString() {
        return "Continuousdiscount{" +
                "cdId=" + cdId +
                ", cdDay=" + cdDay +
                ", cdDiscount=" + cdDiscount +
                ", hpId=" + hpId +
                ", homeprice=" + homeprice +
                '}';
    }
}