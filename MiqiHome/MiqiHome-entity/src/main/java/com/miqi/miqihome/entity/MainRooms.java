package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 作者: xyz
 * 更新时间: 2019年3月8日10:17:18
 * 描述: 手机端 上房
 */
public class MainRooms implements Serializable {
    private int uiId;
    private int haiId;
    private int hsId;
    private int hdId;
    private int hdpId;
    private int hfrId;
    private int hrId;
    private int ptId;
    private int hpId;
    private int ivId;

    public int getUiId() {
        return uiId;
    }

    public void setUiId(int uiId) {
        this.uiId = uiId;
    }

    public int getHaiId() {
        return haiId;
    }

    public void setHaiId(int haiId) {
        this.haiId = haiId;
    }

    public int getHsId() {
        return hsId;
    }

    public void setHsId(int hsId) {
        this.hsId = hsId;
    }

    public int getHdId() {
        return hdId;
    }

    public void setHdId(int hdId) {
        this.hdId = hdId;
    }

    public int getHdpId() {
        return hdpId;
    }

    public void setHdpId(int hdpId) {
        this.hdpId = hdpId;
    }

    public int getHfrId() {
        return hfrId;
    }

    public void setHfrId(int hfrId) {
        this.hfrId = hfrId;
    }

    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
    }

    public int getHpId() {
        return hpId;
    }

    public void setHpId(int hpId) {
        this.hpId = hpId;
    }

    public int getIvId() {
        return ivId;
    }

    public void setIvId(int ivId) {
        this.ivId = ivId;
    }
    public MainRooms(){}
    public MainRooms(int uiId, int haiId, int hsId, int hdId, int hdpId, int hfrId, int hrId, int ptId, int hpId, int ivId) {
        this.uiId = uiId;
        this.haiId = haiId;
        this.hsId = hsId;
        this.hdId = hdId;
        this.hdpId = hdpId;
        this.hfrId = hfrId;
        this.hrId = hrId;
        this.ptId = ptId;
        this.hpId = hpId;
        this.ivId = ivId;
    }

    @Override
    public String toString() {
        return "MainRooms{" +
                "uiId=" + uiId +
                ", haiId=" + haiId +
                ", hsId=" + hsId +
                ", hdId=" + hdId +
                ", hdpId=" + hdpId +
                ", hfrId=" + hfrId +
                ", hrId=" + hrId +
                ", ptId=" + ptId +
                ", hpId=" + hpId +
                ", ivId=" + ivId +
                '}';
    }
}
