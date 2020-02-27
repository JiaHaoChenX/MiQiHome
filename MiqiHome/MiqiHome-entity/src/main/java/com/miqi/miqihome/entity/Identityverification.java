package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Identityverification implements Serializable {
    /**
     * 身份验证编号
     */
    private int ivId;

    /**
     * 房东昵称/门店名称 客人可通过名称快速搜索到您的小家
     */
    private String ivName;

    /**
     * 房东头像/门店标志像
     */
    private String ivUrl;

    /*
    * 身份证姓名
    * */
    private  String ivUIDName;

    /*
    * 身份证编号
    * */
    private String ivUIDNo;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    public Identityverification() {
    }

    public String getIvUIDName() {
        return ivUIDName;
    }

    public void setIvUIDName(String ivUIDName) {
        this.ivUIDName = ivUIDName;
    }

    public String getIvUIDNo() {
        return ivUIDNo;
    }

    public void setIvUIDNo(String ivUIDNo) {
        ivUIDNo = ivUIDNo;
    }

    public int getIvId() {
        return ivId;
    }

    public void setIvId(int ivId) {
        this.ivId = ivId;
    }

    public String getIvName() {
        return ivName;
    }

    public void setIvName(String ivName) {
        this.ivName = ivName;
    }

    public String getIvUrl() {
        return ivUrl;
    }

    public void setIvUrl(String ivUrl) {
        this.ivUrl = ivUrl;
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
        return "Identityverification{" +
                "ivId=" + ivId +
                ", ivName='" + ivName + '\'' +
                ", ivUrl='" + ivUrl + '\'' +
                ", ivUIDName='" + ivUIDName + '\'' +
                ", IvUIDNo='" + ivUIDNo + '\'' +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                '}';
    }
}