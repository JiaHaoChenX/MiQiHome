package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Scenic_spots;
import com.miqi.miqihome.entity.Userinformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
*   发布者：丁火钦
*   功能：根据城市名称查询该城市的景点
* */
public interface IScenic_spotsDao {

    //根据城市名称查询该城市的景点
    List<Scenic_spots> select_Scenic_spots(@Param("City") String City);

}
