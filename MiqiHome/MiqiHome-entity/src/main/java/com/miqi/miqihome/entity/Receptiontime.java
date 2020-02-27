package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 接待房客时间表(关联入住规则表)
 */
public class Receptiontime implements Serializable {
    /**
     * 接待房客时间表编号
     */
    private int rtId;

    /**
     * 接待开始时间
     */
    private String rtStartTime;

    /**
     * 接待结束时间
     */
    private String rtEndTime;

    /**
     * 关联入住规则表
     */
    private int hrId;
    Homerules homerules;

    public Receptiontime() {
    }

    public int getRtId() {
        return rtId;
    }

    public void setRtId(int rtId) {
        this.rtId = rtId;
    }

    public String getRtStartTime() {
        return rtStartTime;
    }

    public void setRtStartTime(String rtStartTime) {
        this.rtStartTime = rtStartTime;
    }

    public String getRtEndTime() {
        return rtEndTime;
    }

    public void setRtEndTime(String rtEndTime) {
        this.rtEndTime = rtEndTime;
    }

    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public Homerules getHomerules() {
        return homerules;
    }

    public void setHomerules(Homerules homerules) {
        this.homerules = homerules;
    }

    @Override
    public String toString() {
        return "Receptiontime{" +
                "rtId=" + rtId +
                ", rtStartTime='" + rtStartTime + '\'' +
                ", rtEndTime='" + rtEndTime + '\'' +
                ", hrId=" + hrId +
                ", homerules=" + homerules +
                '}';
    }
}