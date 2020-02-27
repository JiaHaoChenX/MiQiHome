package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 发布人：丁火钦
 * 景点表
 */
public class Scenic_spots implements Serializable {
    String ssId ;           //'编号',
    String ssType ;         //'分类',
    String ssProvince ;     //'省份',
    String ssCity;          //'城市',
    String ssTitle;         //'标题',
    String ssRank ;         //'级别',
    String ssTemporary;     //'临时',
    String ssPrint ;        //'图片',
    String ssGrade ;        //'分数',
    String ssTickets ;      //'门票',
    String ssTime ;         //'开放时间',
    String ssSite ;         //'地址',
    String ssIntro ;        //'简介',
    String ssLongitude ;    //'经度',
    String ssLatitude ;     //'纬度'

    @Override
    public String toString() {
        return "Scenic_spots{" +
                "ssId='" + ssId + '\'' +
                ", ssType='" + ssType + '\'' +
                ", ssProvince='" + ssProvince + '\'' +
                ", ssCity='" + ssCity + '\'' +
                ", ssTitle='" + ssTitle + '\'' +
                ", ssRank='" + ssRank + '\'' +
                ", ssTemporary='" + ssTemporary + '\'' +
                ", ssPrint='" + ssPrint + '\'' +
                ", ssGrade='" + ssGrade + '\'' +
                ", ssTickets='" + ssTickets + '\'' +
                ", ssTime='" + ssTime + '\'' +
                ", ssSite='" + ssSite + '\'' +
                ", ssIntro='" + ssIntro + '\'' +
                ", ssLongitude='" + ssLongitude + '\'' +
                ", ssLatitude='" + ssLatitude + '\'' +
                '}';
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId;
    }

    public String getSsType() {
        return ssType;
    }

    public void setSsType(String ssType) {
        this.ssType = ssType;
    }

    public String getSsProvince() {
        return ssProvince;
    }

    public void setSsProvince(String ssProvince) {
        this.ssProvince = ssProvince;
    }

    public String getSsCity() {
        return ssCity;
    }

    public void setSsCity(String ssCity) {
        this.ssCity = ssCity;
    }

    public String getSsTitle() {
        return ssTitle;
    }

    public void setSsTitle(String ssTitle) {
        this.ssTitle = ssTitle;
    }

    public String getSsRank() {
        return ssRank;
    }

    public void setSsRank(String ssRank) {
        this.ssRank = ssRank;
    }

    public String getSsTemporary() {
        return ssTemporary;
    }

    public void setSsTemporary(String ssTemporary) {
        this.ssTemporary = ssTemporary;
    }

    public String getSsPrint() {
        return ssPrint;
    }

    public void setSsPrint(String ssPrint) {
        this.ssPrint = ssPrint;
    }

    public String getSsGrade() {
        return ssGrade;
    }

    public void setSsGrade(String ssGrade) {
        this.ssGrade = ssGrade;
    }

    public String getSsTickets() {
        return ssTickets;
    }

    public void setSsTickets(String ssTickets) {
        this.ssTickets = ssTickets;
    }

    public String getSsTime() {
        return ssTime;
    }

    public void setSsTime(String ssTime) {
        this.ssTime = ssTime;
    }

    public String getSsSite() {
        return ssSite;
    }

    public void setSsSite(String ssSite) {
        this.ssSite = ssSite;
    }

    public String getSsIntro() {
        return ssIntro;
    }

    public void setSsIntro(String ssIntro) {
        this.ssIntro = ssIntro;
    }

    public String getSsLongitude() {
        return ssLongitude;
    }

    public void setSsLongitude(String ssLongitude) {
        this.ssLongitude = ssLongitude;
    }

    public String getSsLatitude() {
        return ssLatitude;
    }

    public void setSsLatitude(String ssLatitude) {
        this.ssLatitude = ssLatitude;
    }
}