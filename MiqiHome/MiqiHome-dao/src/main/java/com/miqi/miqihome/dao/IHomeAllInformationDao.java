package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.Homerequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * * 发布者：丁火钦
 * * 房屋全部信息表（房源表）
 */
public interface IHomeAllInformationDao {
    //根据查询
    Homeallinformation select_Homeallinformation(@Param("haiId") String haiId);

    //查询多个
    List<Homeallinformation> select_multi_HomeAllInformation(Map<String, Object> objectMap);
    //查询数量
    int select_HomeAllInformation_count(Map<String, Object> objectMap);

    //订单页面房屋信息查询
    List<Homeallinformation> select_multi_HomeAllInformation_order(@Param("uiId")int uiId,@Param("haiId")int haiId);

    /**
     *  发布人：丁火钦
     * */
    //根据用户id查询房源
    List<Homeallinformation> select_ui_HomeAllInformation(@Param("uiId") String uiId);

    //添加房源
    int insert_HomeAllInformation(Homeallinformation home);
}
