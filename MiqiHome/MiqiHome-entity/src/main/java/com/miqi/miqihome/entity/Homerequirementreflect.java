package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 对房客的要求表对应表(与房客要求表和入住规则表进行关联)
 */
public class Homerequirementreflect implements Serializable {
    /**
     * 对房客的要求表对应表(编号)
     */
    private int hrrId;

    /**
     * 关联入住规则表
     */
    private int hrId;
    Homerules homerules;

    /**
     * 关联对房客的要求表
     */
    private int hreId;
    Homerequirement homerequirement;

    public Homerequirementreflect() {
    }

    public int getHrrId() {
        return hrrId;
    }

    public void setHrrId(int hrrId) {
        this.hrrId = hrrId;
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

    public int getHreId() {
        return hreId;
    }

    public void setHreId(int hreId) {
        this.hreId = hreId;
    }

    public Homerequirement getHomerequirement() {
        return homerequirement;
    }

    public void setHomerequirement(Homerequirement homerequirement) {
        this.homerequirement = homerequirement;
    }

    @Override
    public String toString() {
        return "Homerequirementreflect{" +
                "hrrId=" + hrrId +
                ", hrId=" + hrId +
                ", homerules=" + homerules +
                ", hreId=" + hreId +
                ", homerequirement=" + homerequirement +
                '}';
    }
}