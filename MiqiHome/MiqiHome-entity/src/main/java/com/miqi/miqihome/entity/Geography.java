package com.miqi.miqihome.entity;


import java.io.Serializable;
import java.sql.Date;

/**
 *  丁火钦
 *  查询城市
 * */
public class Geography implements Serializable {

  int gid;          //'编号',
  String province;  //'省',
  String region;    //'市'

  public Geography() {
  }

  @Override
  public String toString() {
    return "Geography{" +
            "gid=" + gid +
            ", province='" + province + '\'' +
            ", region='" + region + '\'' +
            '}';
  }

  public int getGid() {
    return gid;
  }

  public void setGid(int gid) {
    this.gid = gid;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }
}
