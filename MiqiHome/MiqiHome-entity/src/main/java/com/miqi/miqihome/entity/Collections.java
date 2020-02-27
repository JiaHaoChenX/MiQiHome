package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 房屋收藏表
 */
public class Collections implements Serializable {
    /**
     * 房屋收藏编号
     */
    private int cnId;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    /**
     * 关联用户注册表(获得联系人手机号码，当然可以修改，如果修改，则本身的手机号码也会修改)
     */
    private int uiId;
    Userinformation userinformation;

    public Collections() {
    }

    public int getCnId() {
        return cnId;
    }

    public void setCnId(int cnId) {
        this.cnId = cnId;
    }

    public int getHaiId() {
        return haiId;
    }

    public void setHaiId(int haiId) {
        this.haiId = haiId;
    }

    public int getUiId() {
        return uiId;
    }

    public void setUiId(int uiId) {
        this.uiId = uiId;
    }

    public Userinformation getUserinformation() {
        return userinformation;
    }

    public void setUserinformation(Userinformation userinformation) {
        this.userinformation = userinformation;
    }

    public Homeallinformation getHomeallinformation() {
        return homeallinformation;
    }

    public void setHomeallinformation(Homeallinformation homeallinformation) {
        this.homeallinformation = homeallinformation;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "cnId=" + cnId +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                ", uiId=" + uiId +
                ", userinformation=" + userinformation +
                '}';
    }
}