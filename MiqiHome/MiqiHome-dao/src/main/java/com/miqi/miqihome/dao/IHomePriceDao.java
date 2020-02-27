package com.miqi.miqihome.dao;


import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.Homeprice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
*
    发布者：丁火钦
    房屋价格表
* */
public interface IHomePriceDao {
    //添加
    int insert_homePrice(Homeprice homeprice);
    //根据房源id查询信息
    Homeprice select_homePrice_haiId(@Param("haiId") String haiId);
    //修改
    int update_homePrice(Homeprice homeprice);
    //添加连住折扣表
    int insert_continuousDiscount(@Param("cdDay") String cdDay,@Param("cdDiscount")  String cdDiscount,@Param("hpId")  String hpId);
    //根据房源id查询所有信息【包括折扣表】
    Homeprice select_arr_homePrice_haiId(@Param("haiId") String haiId);
    //删除连住折扣表
    int delete_continuousDiscount(@Param("hpId") String hpId);
}
