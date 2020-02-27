package com.miqi.miqihome.entity;

import java.io.Serializable;

/**
 * 房屋描述表
 */
public class Housedecription implements Serializable {

    /**
     * 房屋描述编号
     */
    private int hdpId;

    /**
     * 房屋名称(地标+特色/特点+户型)
     */
    private String hdpName;

    /**
     * 房屋特色(软装风格，家居配套，小区环境，物业管理)
     * */

    private String hdpCharacteristic;

    /**
     *交通位置
     * */

    private String hdpTraffic;

    /**
     *周边介绍
     * */

    private String hdpRound;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    public Housedecription() {
    }

    public int getHdpId() {
        return hdpId;
    }

    public void setHdpId(int hdpId) {
        this.hdpId = hdpId;
    }

    public String getHdpName() {
        return hdpName;
    }

    public void setHdpName(String hdpName) {
        this.hdpName = hdpName;
    }

    public String getHdpCharacteristic() {
        return hdpCharacteristic;
    }

    public void setHdpCharacteristic(String hdpCharacteristic) {
        this.hdpCharacteristic = hdpCharacteristic;
    }

    public String getHdpTraffic() {
        return hdpTraffic;
    }

    public void setHdpTraffic(String hdpTraffic) {
        this.hdpTraffic = hdpTraffic;
    }

    public String getHdpRound() {
        return hdpRound;
    }

    public void setHdpRound(String hdpRound) {
        this.hdpRound = hdpRound;
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
        return "Housedecription{" +
                "hdpId=" + hdpId +
                ", hdpName='" + hdpName + '\'' +
                ", hdpCharacteristic='" + hdpCharacteristic + '\'' +
                ", hdpTraffic='" + hdpTraffic + '\'' +
                ", hdpRound='" + hdpRound + '\'' +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                '}';
    }
}