package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 房屋价格表
 */
public class Homeprice implements Serializable {
    /**
     * 房屋价格编号
     */
    private int hpId;

    /**
     * 售卖价格
     */
    private BigDecimal hpPrice;

    /**
     * 最少起订天数
     */
    private int cdLeastDay;

    /**
     * 收取住房押金
     */
    private BigDecimal cdDeposit;

    /**
     * 入住前几天全额退款
     */
    private int cdFullrefund;

    /**
     * 除此之外，收取住房费百分之多少(50%)，在这里为0.5
     */
    private BigDecimal cdSomeRefund;

    /**
     * 前三位房客提供折扣优惠(8.0),默认不打折
     */
    private BigDecimal cdThreeDiscount;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    //连住折扣表
    List<Continuousdiscount> continuousdiscount;
    public List<Continuousdiscount> getContinuousdiscount() {
        return continuousdiscount;
    }
    public void setContinuousdiscount(List<Continuousdiscount> continuousdiscount) {
        this.continuousdiscount = continuousdiscount;
    }

    public Homeprice() {
    }

    public int getHpId() {
        return hpId;
    }

    public void setHpId(int hpId) {
        this.hpId = hpId;
    }

    public BigDecimal getHpPrice() {
        return hpPrice;
    }

    public void setHpPrice(BigDecimal hpPrice) {
        this.hpPrice = hpPrice;
    }

    public int getCdLeastDay() {
        return cdLeastDay;
    }

    public void setCdLeastDay(int cdLeastDay) {
        this.cdLeastDay = cdLeastDay;
    }

    public BigDecimal getCdDeposit() {
        return cdDeposit;
    }

    public void setCdDeposit(BigDecimal cdDeposit) {
        this.cdDeposit = cdDeposit;
    }

    public int getCdFullrefund() {
        return cdFullrefund;
    }

    public void setCdFullrefund(int cdFullrefund) {
        this.cdFullrefund = cdFullrefund;
    }

    public BigDecimal getCdSomeRefund() {
        return cdSomeRefund;
    }

    public void setCdSomeRefund(BigDecimal cdSomeRefund) {
        this.cdSomeRefund = cdSomeRefund;
    }

    public BigDecimal getCdThreeDiscount() {
        return cdThreeDiscount;
    }

    public void setCdThreeDiscount(BigDecimal cdThreeDiscount) {
        this.cdThreeDiscount = cdThreeDiscount;
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
        return "Homeprice{" +
                "hpId=" + hpId +
                ", hpPrice=" + hpPrice +
                ", cdLeastDay=" + cdLeastDay +
                ", cdDeposit=" + cdDeposit +
                ", cdFullrefund=" + cdFullrefund +
                ", cdSomeRefund=" + cdSomeRefund +
                ", cdThreeDiscount=" + cdThreeDiscount +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                '}';
    }
}