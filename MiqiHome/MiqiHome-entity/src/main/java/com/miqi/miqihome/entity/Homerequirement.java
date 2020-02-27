package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 对房客的要求表
 */
public class Homerequirement implements Serializable {
    /**
     * 对房客的要求表编号
     */
    private int hreId;

    /**
     * 对房客的要求名称
     */
    private String hreName;

    public Homerequirement() {
    }

    public int getHreId() {
        return hreId;
    }

    public String getHreName() {
        return hreName;
    }

    public void setHreId(int hreId) {
        this.hreId = hreId;
    }

    public void setHreName(String hreName) {
        this.hreName = hreName;
    }

    @Override
    public String toString() {
        return "Homerequirement{" +
                "hreId=" + hreId +
                ", hreName='" + hreName + '\'' +
                '}';
    }
}