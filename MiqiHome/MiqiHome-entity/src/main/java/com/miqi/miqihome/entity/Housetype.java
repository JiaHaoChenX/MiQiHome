package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 房屋类型表
 */
public class Housetype implements Serializable {
    /**
     * 房屋类型编号
     */
    private int htId;

    /**
     * 房屋类型名称
     */
    private String htName;

    public Housetype() {
    }

    public int getHtId() {
        return htId;
    }

    public void setHtId(int htId) {
        this.htId = htId;
    }

    public String getHtName() {
        return htName;
    }

    public void setHtName(String htName) {
        this.htName = htName;
    }

    @Override
    public String toString() {
        return "Housetype{" +
                "htId=" + htId +
                ", htName='" + htName + '\'' +
                '}';
    }
}