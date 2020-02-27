package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 房屋全部信息表（房源表）
 */
public class Homeallinformation implements Serializable {
    /**
     * 房屋全部信息表编号
     */
    private int haiId;

    /**
     * //关联用户信息表
     */
    private int uiId;



    //用户信息表
    Userinformation userinformation;
    public Userinformation getUserinformation() {
        return userinformation;
    }
    public void setUserinformation(Userinformation userinformation) {
        this.userinformation = userinformation;
    }
    //房屋位置表
    Housesite housesite;
    public Housesite getHousesite() {return housesite;}
    public void setHousesite(Housesite housesite) {this.housesite = housesite;}
    //房屋详细表
    Housedetails housedetails;
    public Housedetails getHousedetails() {
        return housedetails;
    }
    public void setHousedetails(Housedetails housedetails) {
        this.housedetails = housedetails;
    }
    //床型表(一个房子有多个床型),关联房屋详细表
    List<Housebed> housebed;
    public List<Housebed> getHousebed() {
        return housebed;
    }
    public void setHousebed(List<Housebed> housebed) {
        this.housebed = housebed;
    }
    //房屋描述
    Housedecription housedecription;
    public Housedecription getHousedecription() {
        return housedecription;
    }
    public void setHousedecription(Housedecription housedecription) {
        this.housedecription = housedecription;
    }

    //设施服务表对应表
    List<HouseFacilities> houseFacilities;

    public List<HouseFacilities> getHouseFacilities() {
        return houseFacilities;
    }

    public void setHouseFacilities(List<HouseFacilities> houseFacilities) {
        this.houseFacilities = houseFacilities;
    }

    //入住规则
    Homerules homerules;
    public Homerules getHomerules() {
        return homerules;
    }
    public void setHomerules(Homerules homerules) {
        this.homerules = homerules;
    }
    //房屋照片
    //房屋图片类型表
    List<Picturetype> picturetype;
    public List<Picturetype> getPicturetype() {
        return picturetype;
    }
    public void setPicturetype(List<Picturetype> picturetype) {
        this.picturetype = picturetype;
    }

    //房屋价格表
    Homeprice homeprice;
    public Homeprice getHomeprice() {
        return homeprice;
    }
    public void setHomeprice(Homeprice homeprice) {
        this.homeprice = homeprice;
    }
    //身份验真
    Identityverification identityverification;
    public Identityverification getIdentityverification() {
        return identityverification;
    }
    public void setIdentityverification(Identityverification identityverification) {
        this.identityverification = identityverification;
    }

    public Homeallinformation() {
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

    @Override
    public String toString() {
        return "Homeallinformation{" +
                "haiId=" + haiId +
                ", uiId=" + uiId +
                ", userinformation=" + userinformation +
                '}';
    }
}