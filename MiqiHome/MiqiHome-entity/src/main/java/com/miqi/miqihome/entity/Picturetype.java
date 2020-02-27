package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 房屋图片类型表
 */
public class Picturetype implements Serializable {
    /**
     * 房屋图片表类型编号
     */
    private int ptId;

    /**
     * 房屋图片表类型名称
     */
    private String ptName;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    //房屋图片表
    List<Picture> pictures;
    public List<Picture> getPictures() {
        return pictures;
    }
    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Picturetype() {
    }

    public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
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
        return "Picturetype{" +
                "ptId=" + ptId +
                ", ptName='" + ptName + '\'' +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                ", pictures=" + pictures +
                '}';
    }
}