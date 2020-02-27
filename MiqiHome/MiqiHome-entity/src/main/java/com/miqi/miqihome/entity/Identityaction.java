package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 认证方式
 */
public class Identityaction implements Serializable {
    /**
     * 认证方式
     */
    private int iaId;

    /**
     * 认证名称(身份证、护照、营业执照)
     */
    private String iaName;

    public Identityaction() {
    }

    public int getIaId() {
        return iaId;
    }

    public void setIaId(int iaId) {
        this.iaId = iaId;
    }

    public String getIaName() {
        return iaName;
    }

    public void setIaName(String iaName) {
        this.iaName = iaName;
    }

    @Override
    public String toString() {
        return "Identityaction{" +
                "iaId=" + iaId +
                ", iaName='" + iaName + '\'' +
                '}';
    }
}