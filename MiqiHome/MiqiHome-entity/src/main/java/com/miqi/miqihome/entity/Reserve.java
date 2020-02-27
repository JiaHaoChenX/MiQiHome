package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 预定信息
 */
public class Reserve implements Serializable {
    /**
     * 预定编号
     */
    private int rvId;

    /**
     * 订单号
     */
    private String rvSerialNumber;

    /**
     * 预定日期
     */
    private Date rvBelowOrder;

    public String getRvSerialNumber() {
        return rvSerialNumber;
    }

    public void setRvSerialNumber(String rvSerialNumber) {
        this.rvSerialNumber = rvSerialNumber;
    }

    public Date getRvBelowOrder() {
        return rvBelowOrder;
    }

    public void setRvBelowOrder(Date rvBelowOrder) {
        this.rvBelowOrder = rvBelowOrder;
    }

    /**
     * 预定开始日期
     */
    private Date rvStartTime;

    /**
     * 预定结束日期
     */
    private Date rvEndTime;

    /**
     * 预定天数
     */
    private int rvTotalDay;

    /**
     * 预定房间套数
     */
    private int rvHouseNumeb;

    /**
     * 预定总额
     */
    private BigDecimal rvSumMoney;

    /**
     * 电话号码
     */
    private String rvPhone;

    public String getRvPhone() {
        return rvPhone;
    }

    public void setRvPhone(String rvPhone) {
        this.rvPhone = rvPhone;
    }

    /**
     * 关联用户注册表(获得联系人手机号码，当然可以修改，如果修改，则本身的手机号码也会修改)
     */
    private int uiId;

    /**
     * 是否需要发票 0:不需要 1:需要
     */
    private int rvInvoice;

    /**
     * 入住人数
     */
    private int rvLiveNumber;

    /**
     * 支付状态 0:待付款 1:已完成 2：已取消
     */
    private int rvPayState;

    /**
     * 客房预定状态 0：待支付1：待确认2：待入住3：已入住4：已离店5：已取消
     */
    private int rvHomeState;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;

    /**
     * 房屋描述表
     */
    private Housedecription houseDecription;

    public Housedecription getHouseDecription() {
        return houseDecription;
    }

    public void setHouseDecription(Housedecription houseDecription) {
        this.houseDecription = houseDecription;
    }

    private List<Livepeople> livepeopleList;

    public List<Livepeople> getLivepeopleList() {
        return livepeopleList;
    }

    public void setLivepeopleList(List<Livepeople> livepeopleList) {
        this.livepeopleList = livepeopleList;
    }

    public Reserve() {
    }

    public int getRvId() {
        return rvId;
    }

    public void setRvId(int rvId) {
        this.rvId = rvId;
    }

    public Date getRvStartTime() {
        return rvStartTime;
    }

    public void setRvStartTime(Date rvStartTime) {
        this.rvStartTime = rvStartTime;
    }

    public Date getRvEndTime() {
        return rvEndTime;
    }

    public void setRvEndTime(Date rvEndTime) {
        this.rvEndTime = rvEndTime;
    }

    public int getRvTotalDay() {
        return rvTotalDay;
    }

    public void setRvTotalDay(int rvTotalDay) {
        this.rvTotalDay = rvTotalDay;
    }

    public int getRvHouseNumeb() {
        return rvHouseNumeb;
    }

    public void setRvHouseNumeb(int rvHouseNumeb) {
        this.rvHouseNumeb = rvHouseNumeb;
    }

    public BigDecimal getRvSumMoney() {
        return rvSumMoney;
    }

    public void setRvSumMoney(BigDecimal rvSumMoney) {
        this.rvSumMoney = rvSumMoney;
    }

    public int getUiId() {
        return uiId;
    }

    public void setUiId(int uiId) {
        this.uiId = uiId;
    }

    public int getRvInvoice() {
        return rvInvoice;
    }

    public void setRvInvoice(int rvInvoice) {
        this.rvInvoice = rvInvoice;
    }

    public int getRvLiveNumber() {
        return rvLiveNumber;
    }

    public void setRvLiveNumber(int rvLiveNumber) {
        this.rvLiveNumber = rvLiveNumber;
    }

    public int getRvPayState() {
        return rvPayState;
    }

    public void setRvPayState(int rvPayState) {
        this.rvPayState = rvPayState;
    }

    public int getRvHomeState() {
        return rvHomeState;
    }

    public void setRvHomeState(int rvHomeState) {
        this.rvHomeState = rvHomeState;
    }

    public int getHaiId() {
        return haiId;
    }

    public void setHaiId(int haiId) {
        this.haiId = haiId;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "rvId=" + rvId +
                ", rvSerialNumber='" + rvSerialNumber + '\'' +
                ", rvBelowOrder=" + rvBelowOrder +
                ", rvStartTime=" + rvStartTime +
                ", rvEndTime=" + rvEndTime +
                ", rvTotalDay=" + rvTotalDay +
                ", rvHouseNumeb=" + rvHouseNumeb +
                ", rvSumMoney=" + rvSumMoney +
                ", rvPhone='" + rvPhone + '\'' +
                ", uiId=" + uiId +
                ", rvInvoice=" + rvInvoice +
                ", rvLiveNumber=" + rvLiveNumber +
                ", rvPayState=" + rvPayState +
                ", rvHomeState=" + rvHomeState +
                ", haiId=" + haiId +
                ", houseDecription=" + houseDecription +
                ", livepeopleList=" + livepeopleList +
                '}';
    }
}