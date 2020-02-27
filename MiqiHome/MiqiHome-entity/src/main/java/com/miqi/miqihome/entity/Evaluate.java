package com.miqi.miqihome.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 房屋评价表
 */
public class Evaluate implements Serializable {
    /**
     * 评价编号
     */
    private int eId;

    /**
     * 卫生评价星
     */
    private int eHygiene;

    /**
     * 交通位置评价星
     */
    private int eTraffic;

    /**
     * 设施环境评价星
     */
    private int eEnvironmental;

    /**
     * 房东服务评价星
     */
    private int eService;

    /**
     * 性价比评价星
     */
    private int eCostPerformance;

    /**
     *评价内容
     * */

    private String eEvaluateContent;

    /**
     *待回复内容
     * */

    private String eAnswerContent;

    /**
     * 评价时间
     */
    private Date eEvaluateTime;

    /**
     * 评价状态（0：待回复 1：待评价 2:未通过审核）
     */
    private int eState;

    /**
     * 关联房屋全部信息表
     */
    private int haiId;
    Homeallinformation homeallinformation;

    /**
     * 关联用户注册表(获得联系人手机号码，当然可以修改，如果修改，则本身的手机号码也会修改)
     */
    private int uiId;
    Userinformation userinformation;

    public Evaluate() {
    }

    public Homeallinformation getHomeallinformation() {
        return homeallinformation;
    }

    public void setHomeallinformation(Homeallinformation homeallinformation) {
        this.homeallinformation = homeallinformation;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public int geteHygiene() {
        return eHygiene;
    }

    public void seteHygiene(int eHygiene) {
        this.eHygiene = eHygiene;
    }

    public int geteTraffic() {
        return eTraffic;
    }

    public void seteTraffic(int eTraffic) {
        this.eTraffic = eTraffic;
    }

    public int geteEnvironmental() {
        return eEnvironmental;
    }

    public void seteEnvironmental(int eEnvironmental) {
        this.eEnvironmental = eEnvironmental;
    }

    public int geteService() {
        return eService;
    }

    public void seteService(int eService) {
        this.eService = eService;
    }

    public int geteCostPerformance() {
        return eCostPerformance;
    }

    public void seteCostPerformance(int eCostPerformance) {
        this.eCostPerformance = eCostPerformance;
    }

    public String geteEvaluateContent() {
        return eEvaluateContent;
    }

    public void seteEvaluateContent(String eEvaluateContent) {
        this.eEvaluateContent = eEvaluateContent;
    }

    public String geteAnswerContent() {
        return eAnswerContent;
    }

    public void seteAnswerContent(String eAnswerContent) {
        this.eAnswerContent = eAnswerContent;
    }

    public Date geteEvaluateTime() {
        return eEvaluateTime;
    }

    public void seteEvaluateTime(Date eEvaluateTime) {
        this.eEvaluateTime = eEvaluateTime;
    }

    public int geteState() {
        return eState;
    }

    public void seteState(int eState) {
        this.eState = eState;
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

    public Userinformation getUserinformation() {
        return userinformation;
    }

    public void setUserinformation(Userinformation userinformation) {
        this.userinformation = userinformation;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "eId=" + eId +
                ", eHygiene=" + eHygiene +
                ", eTraffic=" + eTraffic +
                ", eEnvironmental=" + eEnvironmental +
                ", eService=" + eService +
                ", eCostPerformance=" + eCostPerformance +
                ", eEvaluateContent='" + eEvaluateContent + '\'' +
                ", eAnswerContent='" + eAnswerContent + '\'' +
                ", eEvaluateTime=" + eEvaluateTime +
                ", eState=" + eState +
                ", haiId=" + haiId +
                ", homeallinformation=" + homeallinformation +
                ", uiId=" + uiId +
                ", userinformation=" + userinformation +
                '}';
    }
}