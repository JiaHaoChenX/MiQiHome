package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 房屋详细表
 */
public class Housedetails implements Serializable {
    /**
     * 房屋详细表编号
     */
    private int hdId;


    /**
     * 房屋面积
     */

    private BigDecimal hdArea;

    /**
     * 居住人数
     */
    private int hdLiveNumber;

    /**
     * 同类房屋数量(套)(最终会以库存的数量显示)
     */
    private int hdHouseNumebr;

    /**
     * 关联出租方式表
     */
    private int rmId;
    Rentalmode rentalmode;
    /**
     * 关联房屋类型详细表
     */
    private int htdId;
    Housetypedetails housetypedetails;

    /**
     * 关联房屋景观表
     */
    private int hcId;
    Housescenery housescenery;

    /**
     * 关联房屋户型表
     */
    private int haId;
    Houseapartment houseapartment;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    public Housedetails() {
    }

    public int getHdId() {
        return hdId;
    }

    public void setHdId(int hdId) {
        this.hdId = hdId;
    }


    public BigDecimal getHdArea() {
        return hdArea;
    }

    public void setHdArea(BigDecimal hdArea) {
        this.hdArea = hdArea;
    }

    public int getHdLiveNumber() {
        return hdLiveNumber;
    }

    public void setHdLiveNumber(int hdLiveNumber) {
        this.hdLiveNumber = hdLiveNumber;
    }

    public int getHdHouseNumebr() {
        return hdHouseNumebr;
    }

    public void setHdHouseNumebr(int hdHouseNumebr) {
        this.hdHouseNumebr = hdHouseNumebr;
    }

    public int getRmId() {
        return rmId;
    }

    public void setRmId(int rmId) {
        this.rmId = rmId;
    }

    public Rentalmode getRentalmode() {
        return rentalmode;
    }

    public void setRentalmode(Rentalmode rentalmode) {
        this.rentalmode = rentalmode;
    }

    public int getHtdId() {
        return htdId;
    }

    public void setHtdId(int htdId) {
        this.htdId = htdId;
    }

    public Housetypedetails getHousetypedetails() {
        return housetypedetails;
    }

    public void setHousetypedetails(Housetypedetails housetypedetails) {
        this.housetypedetails = housetypedetails;
    }

    public int getHcId() {
        return hcId;
    }

    public void setHcId(int hcId) {
        this.hcId = hcId;
    }

    public Housescenery getHousescenery() {
        return housescenery;
    }

    public void setHousescenery(Housescenery housescenery) {
        this.housescenery = housescenery;
    }

    public int getHaId() {
        return haId;
    }

    public void setHaId(int haId) {
        this.haId = haId;
    }

    public Houseapartment getHouseapartment() {
        return houseapartment;
    }

    public void setHouseapartment(Houseapartment houseapartment) {
        this.houseapartment = houseapartment;
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
        return "Housedetails{" +
                "hdId=" + hdId +
                ", hdArea=" + hdArea +
                ", hdLiveNumber=" + hdLiveNumber +
                ", hdHouseNumebr=" + hdHouseNumebr +
                ", rmId=" + rmId +
                ", rentalmode=" + rentalmode +
                ", htdId=" + htdId +
                ", housetypedetails=" + housetypedetails +
                ", hcId=" + hcId +
                ", housescenery=" + housescenery +
                ", haId=" + haId +
                ", houseapartment=" + houseapartment +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                '}';
    }
}