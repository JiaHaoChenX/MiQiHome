package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Scenic_spots;
import com.miqi.miqihome.entity.Userinformation;

import java.util.List;
import java.util.Map;

/**
 * 发布人：丁火钦
 * 功能：根据城市名称查询该城市的景点
 */
public interface IScenic_spotsService {
    //查询
    List<Scenic_spots> select_Scenic_spots(String City);
}
