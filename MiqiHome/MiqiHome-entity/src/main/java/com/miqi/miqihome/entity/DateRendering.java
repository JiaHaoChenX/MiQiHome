package com.miqi.miqihome.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 日期渲染bean
 */
public class DateRendering implements Serializable {

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;

    /**
     * 原价
     */
    private BigDecimal price;

    /**
     * 房屋总数
     */
    private int number;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public DateRendering(){}

    public DateRendering(Date date, BigDecimal price, int number) {
        this.date = date;
        this.price = price;
        this.number = number;
    }

    @Override
    public String toString() {
        return "DateRendering{" +
                "date=" + date +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
