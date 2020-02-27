package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 房屋户型表
 */
public class Houseapartment implements Serializable {
    /**
     * 房屋户型编号
     */
    private int haId;

    /**
     * 卧室数量
     */
    private int haBedroom;

    /**
     * 卫生间数量
     */
    private int haBathroom;

    /**
     * 客厅数量
     */
    private int haLounage;

    /**
     * 厨房数量
     */
    private int haKitchen;

    /**
     * 书房数量
     */
    private int haBookStudy;

    /**
     * 阳台数量
     */
    private int haBalcony;

    public Houseapartment() {
    }

    public int getHaId() {
        return haId;
    }

    public void setHaId(int haId) {
        this.haId = haId;
    }

    public int getHaBedroom() {
        return haBedroom;
    }

    public void setHaBedroom(int haBedroom) {
        this.haBedroom = haBedroom;
    }

    public int getHaBathroom() {
        return haBathroom;
    }

    public void setHaBathroom(int haBathroom) {
        this.haBathroom = haBathroom;
    }

    public int getHaLounage() {
        return haLounage;
    }

    public void setHaLounage(int haLounage) {
        this.haLounage = haLounage;
    }

    public int getHaKitchen() {
        return haKitchen;
    }

    public void setHaKitchen(int haKitchen) {
        this.haKitchen = haKitchen;
    }

    public int getHaBookStudy() {
        return haBookStudy;
    }

    public void setHaBookStudy(int haBookStudy) {
        this.haBookStudy = haBookStudy;
    }

    public int getHaBalcony() {
        return haBalcony;
    }

    public void setHaBalcony(int haBalcony) {
        this.haBalcony = haBalcony;
    }

    @Override
    public String toString() {
        return "Houseapartment{" +
                "haId=" + haId +
                ", haBedroom=" + haBedroom +
                ", haBathroom=" + haBathroom +
                ", haLounage=" + haLounage +
                ", haKitchen=" + haKitchen +
                ", haBookStudy=" + haBookStudy +
                ", haBalcony=" + haBalcony +
                '}';
    }
}