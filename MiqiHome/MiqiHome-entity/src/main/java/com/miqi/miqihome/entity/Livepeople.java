package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 入住人信息（多个）
 */
public class Livepeople implements Serializable {
    /**
     * 入住人编号
     */
    private int lpId;

    /**
     * 入住人姓名
     */
    private String lpName;

    /**
     * 电话号码
     */
    private String lpPhone;

    /**
     * 入住人身份证号码
     */
    private String lpCardId;

    /**
     * 关联预定信息
     */
    private int rvId;
    Reserve reserve;

    public Livepeople() {
    }

    public int getLpId() {
        return lpId;
    }

    public void setLpId(int lpId) {
        this.lpId = lpId;
    }

    public String getLpName() {
        return lpName;
    }

    public void setLpName(String lpName) {
        this.lpName = lpName;
    }

    public String getLpPhone() {
        return lpPhone;
    }

    public void setLpPhone(String lpPhone) {
        this.lpPhone = lpPhone;
    }

    public String getLpCardId() {
        return lpCardId;
    }

    public void setLpCardId(String lpCardId) {
        this.lpCardId = lpCardId;
    }

    public int getRvId() {
        return rvId;
    }

    public void setRvId(int rvId) {
        this.rvId = rvId;
    }

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "Livepeople{" +
                "lpId=" + lpId +
                ", lpName='" + lpName + '\'' +
                ", lpPhone='" + lpPhone + '\'' +
                ", lpCardId='" + lpCardId + '\'' +
                ", rvId=" + rvId +
                ", reserve=" + reserve +
                '}';
    }
}