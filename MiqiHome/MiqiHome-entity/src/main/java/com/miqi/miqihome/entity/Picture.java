package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 房屋图片表(各种类型至少一张，除了其他（如果设为了封面，那么在主页中便显示），图片数量在6-140张，不可上传同名图片)
 */
public class Picture implements Serializable {
    /**
     * 房屋图片表编号
     */
    private int pId;

    /**
     * 房屋图片表路径
     */
    private String pUrl;

    /**
     * 是否设为封面(0:否 1:是)
     */
    private int pPagePicture;

    /**
     * 关联房屋图片类型表
     */
    private int ptId;
    Picturetype picturetype;

    public Picture() {
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public int getpPagePicture() {
        return pPagePicture;
    }

    public void setpPagePicture(int pPagePicture) {
        this.pPagePicture = pPagePicture;
    }

    public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
    }

    public Picturetype getPicturetype() {
        return picturetype;
    }

    public void setPicturetype(Picturetype picturetype) {
        this.picturetype = picturetype;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pId=" + pId +
                ", pUrl='" + pUrl + '\'' +
                ", pPagePicture=" + pPagePicture +
                ", ptId=" + ptId +
                ", picturetype=" + picturetype +
                '}';
    }
}