package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 入住规则表
 */
public class Homerules implements Serializable {
    /**
     * 入住规则表编号
     */
    private int hrId;

    /**
     * 房客入住时间
     */
    private String hrCheckin;

    /**
     * 房客退房时间
     */
    private String hrCheckout;

    /**
     * 是否有前台（0：否 1：是）
     */
    private int hrproscenium;

    /**
     * 接待性别(0:不限  1:男  2:女)
     */
    private int hrSex;

    /**
     * 接待特殊年龄段(0:儿童（0-12）  1:老人（65岁以上）)
     */
    private int hrSpecialage;

    /**
     * 多久提供打扫卫生
     */
    private String hrHygiene;

    /**
     * 多久提供被单更换
     */
    private String hrSheets;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;
    /**
     * 入住提示
     */
    private String hrTip;

    //接待房客时间表(关联入住规则表)【一对多】
    List<Receptiontime> receptiontime;
    public List<Receptiontime> getReceptiontime() {
        return receptiontime;
    }
    public void setReceptiontime(List<Receptiontime> receptiontime) {
        this.receptiontime = receptiontime;
    }
    //#对房客的要求表对应表(与房客要求表和入住规则表进行关联)【一对多】
    List<Homerequirementreflect> homerequirementreflect;
    public List<Homerequirementreflect> getHomerequirementreflect() {
        return homerequirementreflect;
    }
    public void setHomerequirementreflect(List<Homerequirementreflect> homerequirementreflect) {
        this.homerequirementreflect = homerequirementreflect;
    }

    public Homerules() {
    }

    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public String getHrCheckin() {
        return hrCheckin;
    }

    public void setHrCheckin(String hrCheckin) {
        this.hrCheckin = hrCheckin;
    }

    public String getHrCheckout() {
        return hrCheckout;
    }

    public void setHrCheckout(String hrCheckout) {
        this.hrCheckout = hrCheckout;
    }

    public int getHrproscenium() {
        return hrproscenium;
    }

    public void setHrproscenium(int hrproscenium) {
        this.hrproscenium = hrproscenium;
    }

    public int getHrSex() {
        return hrSex;
    }

    public void setHrSex(int hrSex) {
        this.hrSex = hrSex;
    }

    public int getHrSpecialage() {
        return hrSpecialage;
    }

    public void setHrSpecialage(int hrSpecialage) {
        this.hrSpecialage = hrSpecialage;
    }

    public String getHrHygiene() {
        return hrHygiene;
    }

    public void setHrHygiene(String hrHygiene) {
        this.hrHygiene = hrHygiene;
    }

    public String getHrSheets() {
        return hrSheets;
    }

    public void setHrSheets(String hrSheets) {
        this.hrSheets = hrSheets;
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

    public String getHrTip() {
        return hrTip;
    }

    public void setHrTip(String hrTip) {
        this.hrTip = hrTip;
    }

    @Override
    public String toString() {
        return "Homerules{" +
                "hrId=" + hrId +
                ", hrCheckin='" + hrCheckin + '\'' +
                ", hrCheckout='" + hrCheckout + '\'' +
                ", hrproscenium=" + hrproscenium +
                ", hrSex=" + hrSex +
                ", hrSpecialage=" + hrSpecialage +
                ", hrHygiene='" + hrHygiene + '\'' +
                ", hrSheets='" + hrSheets + '\'' +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                ", hrTip='" + hrTip + '\'' +
                '}';
    }
}