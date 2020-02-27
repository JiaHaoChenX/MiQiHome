package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 房屋类型详细表(与房屋类型表之间是多对一的关系)
 */
public class Housetypedetails implements Serializable {
    /**
     * 房屋类型详细编号
     */
    private int htdId;

    /**
     * 房屋类型详细名称
     */
    private String htdName;

    /**
     * 备注
     */
    private String htdDese;

    /**
     * 关联房屋类型表
     */
    private int htId;
    Housetype housetype;

    public Housetypedetails() {
    }

    public int getHtdId() {
        return htdId;
    }

    public void setHtdId(int htdId) {
        this.htdId = htdId;
    }

    public String getHtdName() {
        return htdName;
    }

    public void setHtdName(String htdName) {
        this.htdName = htdName;
    }

    public String getHtdDese() {
        return htdDese;
    }

    public void setHtdDese(String htdDese) {
        this.htdDese = htdDese;
    }

    public int getHtId() {
        return htId;
    }

    public void setHtId(int htId) {
        this.htId = htId;
    }

    public Housetype getHousetype() {
        return housetype;
    }

    public void setHousetype(Housetype housetype) {
        this.housetype = housetype;
    }

    @Override
    public String toString() {
        return "Housetypedetails{" +
                "htdId=" + htdId +
                ", htdName='" + htdName + '\'' +
                ", htdDese='" + htdDese + '\'' +
                ", htId=" + htId +
                ", housetype=" + housetype +
                '}';
    }
}