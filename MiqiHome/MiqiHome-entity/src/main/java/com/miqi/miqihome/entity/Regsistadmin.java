package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员注册表
 */
public class Regsistadmin implements Serializable {
    /**
     * 管理员编号
     */
    private int raId;

    /**
     * 管理员名字
     */
    private String raName;

    /**
     * 手机
     */
    private String raPhone;

    /**
     * 邮箱
     */
    private String raEmail;

    /**
     * 管理员密码
     */
    private String raPassword;

    /**
     * 角色(超级管理员，普通管理员)
     */
    private String raRole;

    /**
     * 注册时间
     */
    private Date raBirthday;

    /**
     * 是否存在(0:不存在 1：存在)
     */
    private int raState;

    public Regsistadmin() {
    }

    public int getRaId() {
        return raId;
    }

    public void setRaId(int raId) {
        this.raId = raId;
    }

    public String getRaName() {
        return raName;
    }

    public void setRaName(String raName) {
        this.raName = raName;
    }

    public String getRaPhone() {
        return raPhone;
    }

    public void setRaPhone(String raPhone) {
        this.raPhone = raPhone;
    }

    public String getRaEmail() {
        return raEmail;
    }

    public void setRaEmail(String raEmail) {
        this.raEmail = raEmail;
    }

    public String getRaPassword() {
        return raPassword;
    }

    public void setRaPassword(String raPassword) {
        this.raPassword = raPassword;
    }

    public String getRaRole() {
        return raRole;
    }

    public void setRaRole(String raRole) {
        this.raRole = raRole;
    }

    public Date getRaBirthday() {
        return raBirthday;
    }

    public void setRaBirthday(Date raBirthday) {
        this.raBirthday = raBirthday;
    }

    public int getRaState() {
        return raState;
    }

    public void setRaState(int raState) {
        this.raState = raState;
    }

    @Override
    public String toString() {
        return "Regsistadmin{" +
                "raId=" + raId +
                ", raName='" + raName + '\'' +
                ", raPhone='" + raPhone + '\'' +
                ", raEmail='" + raEmail + '\'' +
                ", raPassword='" + raPassword + '\'' +
                ", raRole='" + raRole + '\'' +
                ", raBirthday=" + raBirthday +
                ", raState=" + raState +
                '}';
    }
}