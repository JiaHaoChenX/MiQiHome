package com.miqi.miqihome.entity;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
/**
 * 用户个人信息(注册)
 * */
public class Userinformation implements Serializable {
  //-- 共用
  private int uiId;//用户个人信息编号
  private String uPhone;//电话号码,也叫做账号
  private String uPassword;//密码
  private String uPicture;//头像
  private String uNickName;//用户昵称
  private String uEmail;//邮箱
  private Date uTime;//注册时间
  //房东
  private String uName;//真实姓名
  private String uSex;//性别 0:男 1:女
  private int uAge;//年龄
  private String uDocumentType;//证件类型（默认身份证）
  private String uCardId;//证件号码
  private String uNation;//民族
  private String uConstellation;//星座
  private String uBloodType;//血型
  private String uProvince;//省
  private String uCity;//市
  private String uOccupation;//职业
  private String uDesc;//备注(对自己的介绍。让房客能更好的认识你)
  private int uState;//是否存在0表示注销，1表示存在，2:封号

  public Userinformation() {
  }

  public Userinformation(String uPhone, String uPassword) {
    this.uPhone = uPhone;
    this.uPassword = uPassword;
  }

  public int getUiId() {
    return uiId;
  }

  public void setUiId(int uiId) {
    this.uiId = uiId;
  }

  public String getuPhone() {
    return uPhone;
  }

  public void setuPhone(String uPhone) {
    this.uPhone = uPhone;
  }

  public String getUpicture() {
    return uPicture;
  }

  public void setUpicture(String upicture) {
    this.uPicture = upicture;
  }
  public String getuPassword() {
    return uPassword;
  }

  public void setuPassword(String uPassword) {
    this.uPassword = uPassword;
  }

  public String getuNickName() {
    return uNickName;
  }

  public void setuNickName(String uNickName) {
    this.uNickName = uNickName;
  }

  public String getuEmail() {
    return uEmail;
  }

  public void setuEmail(String uEmail) {
    this.uEmail = uEmail;
  }

  public Date getuTime() {
    return uTime;
  }

  public void setuTime(Date uTime) {
    this.uTime = uTime;
  }

  public String getuName() {
    return uName;
  }

  public void setuName(String uName) {
    this.uName = uName;
  }

  public String getuSex() {
    return uSex;
  }

  public void setuSex(String uSex) {
    this.uSex = uSex;
  }

  public int getuAge() {
    return uAge;
  }

  public void setuAge(int uAge) {
    this.uAge = uAge;
  }

  public String getuDocumentType() {
    return uDocumentType;
  }

  public void setuDocumentType(String uDocumentType) {
    this.uDocumentType = uDocumentType;
  }

  public String getuCardId() {
    return uCardId;
  }

  public void setuCardId(String uCardId) {
    this.uCardId = uCardId;
  }

  public String getuNation() {
    return uNation;
  }

  public void setuNation(String uNation) {
    this.uNation = uNation;
  }

  public String getuConstellation() {
    return uConstellation;
  }

  public void setuConstellation(String uConstellation) {
    this.uConstellation = uConstellation;
  }

  public String getuBloodType() {
    return uBloodType;
  }

  public void setuBloodType(String uBloodType) {
    this.uBloodType = uBloodType;
  }

  public String getuProvince() {
    return uProvince;
  }

  public void setuProvince(String uProvince) {
    this.uProvince = uProvince;
  }

  public String getuCity() {
    return uCity;
  }

  public void setuCity(String uCity) {
    this.uCity = uCity;
  }

  public String getuOccupation() {
    return uOccupation;
  }

  public void setuOccupation(String uOccupation) {
    this.uOccupation = uOccupation;
  }

  public String getuDesc() {
    return uDesc;
  }

  public void setuDesc(String uDesc) {
    this.uDesc = uDesc;
  }

  public int getuState() {
    return uState;
  }

  public void setuState(int uState) {
    this.uState = uState;
  }

  @Override
  public String toString() {
    return "Userinformation{" +
            "uiId=" + uiId +
            ", uPhone='" + uPhone + '\'' +
            ", uPassword='" + uPassword + '\'' +
            ", uNickName='" + uNickName + '\'' +
            ", uEmail='" + uEmail + '\'' +
            ", uTime=" + uTime +
            ", uName='" + uName + '\'' +
            ", uSex=" + uSex +
            ", uAge=" + uAge +
            ", uDocumentType='" + uDocumentType + '\'' +
            ", uCardId='" + uCardId + '\'' +
            ", uNation='" + uNation + '\'' +
            ", uConstellation='" + uConstellation + '\'' +
            ", uBloodType='" + uBloodType + '\'' +
            ", uProvince='" + uProvince + '\'' +
            ", uCity='" + uCity + '\'' +
            ", uOccupation='" + uOccupation + '\'' +
            ", uDesc='" + uDesc + '\'' +
            ", uState=" + uState +
            '}';
  }
}
