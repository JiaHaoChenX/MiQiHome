package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 房屋位置表
 */
public class Housesite implements Serializable {
    /**
     * 房屋信息编号
     */
    private int hsId;

    /**
     * 房屋所属国家
     */
    private String hsCountry;

    /**
     * 省
     */
    private String hsProvince;

    /**
     * 市
     */
    private String hsCity;

    /**
     * 区
     */
    private String hsArea;

    /**
     * 房屋详细地址
     */
    private String hsSite;

    /**
     * 补充信息(不可与房屋的详细地址重复)
     */
    private String hsSupplementary;

    /**
     * 门牌号(客户预定成功后才会显示)
     */
    private String hsHousenumber;

    /**
     * 经度
     */
    private BigDecimal hsLongitude;

    /**
     * 纬度
     */
    private BigDecimal hsLatitude;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    public Housesite() {
    }

    public Housesite(int hsId, String hsCountry, String hsProvince, String hsCity, String hsArea, String hsSite, String hsSupplementary, String hsHousenumber, BigDecimal hsLongitude, BigDecimal hsLatitude, int haiId) {
        this.hsId = hsId;
        this.hsCountry = hsCountry;
        this.hsProvince = hsProvince;
        this.hsCity = hsCity;
        this.hsArea = hsArea;
        this.hsSite = hsSite;
        this.hsSupplementary = hsSupplementary;
        this.hsHousenumber = hsHousenumber;
        this.hsLongitude = hsLongitude;
        this.hsLatitude = hsLatitude;
        this.haiId = haiId;
    }

    public int getHsId() {
        return hsId;
    }

    public void setHsId(int hsId) {
        this.hsId = hsId;
    }

    public String getHsCountry() {
        return hsCountry;
    }

    public void setHsCountry(String hsCountry) {
        this.hsCountry = hsCountry;
    }

    public String getHsProvince() {
        return hsProvince;
    }

    public void setHsProvince(String hsProvince) {
        this.hsProvince = hsProvince;
    }

    public String getHsCity() {
        return hsCity;
    }

    public void setHsCity(String hsCity) {
        this.hsCity = hsCity;
    }

    public String getHsArea() {
        return hsArea;
    }

    public void setHsArea(String hsArea) {
        this.hsArea = hsArea;
    }

    public String getHsSite() {
        return hsSite;
    }

    public void setHsSite(String hsSite) {
        this.hsSite = hsSite;
    }

    public String getHsSupplementary() {
        return hsSupplementary;
    }

    public void setHsSupplementary(String hsSupplementary) {
        this.hsSupplementary = hsSupplementary;
    }

    public String getHsHousenumber() {
        return hsHousenumber;
    }

    public void setHsHousenumber(String hsHousenumber) {
        this.hsHousenumber = hsHousenumber;
    }

    public BigDecimal getHsLongitude() {
        return hsLongitude;
    }

    public void setHsLongitude(BigDecimal hsLongitude) {
        this.hsLongitude = hsLongitude;
    }

    public BigDecimal getHsLatitude() {
        return hsLatitude;
    }

    public void setHsLatitude(BigDecimal hsLatitude) {
        this.hsLatitude = hsLatitude;
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
        return "Housesite{" +
                "hsId=" + hsId +
                ", hsCountry='" + hsCountry + '\'' +
                ", hsProvince='" + hsProvince + '\'' +
                ", hsCity='" + hsCity + '\'' +
                ", hsArea='" + hsArea + '\'' +
                ", hsSite='" + hsSite + '\'' +
                ", hsSupplementary='" + hsSupplementary + '\'' +
                ", hsHousenumber='" + hsHousenumber + '\'' +
                ", hsLongitude=" + hsLongitude +
                ", hsLatitude=" + hsLatitude +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                '}';
    }
}