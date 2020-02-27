package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 *  商圈
 */
public class Circles implements Serializable {

    String id;              //'编号',
    String province_name;   //'省',
    String city_name;       //'市'
    String area_name;       //'区',
    String name;            //'商圈',
    String lon;             //'经度',
    String lat;             //'纬度',

    @Override
    public String toString() {
        return "Circles{" +
                "id='" + id + '\'' +
                ", province_name='" + province_name + '\'' +
                ", city_name='" + city_name + '\'' +
                ", area_name='" + area_name + '\'' +
                ", name='" + name + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}