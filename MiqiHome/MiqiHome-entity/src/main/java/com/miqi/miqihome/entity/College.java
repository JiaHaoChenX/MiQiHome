package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 *  高校
 */
public class College implements Serializable {
    String coId;            //'高校编号',
    String coSchool;        //'学校',
    String coProvince;      //'省',
    String coCity;          //'市'

    @Override
    public String toString() {
        return "College{" +
                "coId='" + coId + '\'' +
                ", coSchool='" + coSchool + '\'' +
                ", coProvince='" + coProvince + '\'' +
                ", coCity='" + coCity + '\'' +
                '}';
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getCoSchool() {
        return coSchool;
    }

    public void setCoSchool(String coSchool) {
        this.coSchool = coSchool;
    }

    public String getCoProvince() {
        return coProvince;
    }

    public void setCoProvince(String coProvince) {
        this.coProvince = coProvince;
    }

    public String getCoCity() {
        return coCity;
    }

    public void setCoCity(String coCity) {
        this.coCity = coCity;
    }
}