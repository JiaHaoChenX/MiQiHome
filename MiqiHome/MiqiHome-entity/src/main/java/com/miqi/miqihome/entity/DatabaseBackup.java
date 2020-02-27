package com.miqi.miqihome.entity;

import java.util.Date;

/**
 * 数据库备份
 * */
public class DatabaseBackup {
    int dpId;//备份ID
    String dpPath;//备份路径
    Date dpBTime;//备份时间
    Date dpFTime;//还原时间
    public DatabaseBackup(){}
    public int getDpId() {
        return dpId;
    }

    public void setDpId(int dpId) {
        this.dpId = dpId;
    }

    public String getDpPath() {
        return dpPath;
    }

    public void setDpPath(String dpPath) {
        this.dpPath = dpPath;
    }

    public Date getDpBTime() {
        return dpBTime;
    }

    public void setDpBTime(Date dpBTime) {
        this.dpBTime = dpBTime;
    }

    public Date getDpFTime() {
        return dpFTime;
    }

    public void setDpFTime(Date dpFTime) {
        this.dpFTime = dpFTime;
    }

    @Override
    public String toString() {
        return "DatabaseBackup{" +
                "dpId=" + dpId +
                ", dpPath='" + dpPath + '\'' +
                ", dpBTime=" + dpBTime +
                ", dpFTime=" + dpFTime +
                '}';
    }
}
