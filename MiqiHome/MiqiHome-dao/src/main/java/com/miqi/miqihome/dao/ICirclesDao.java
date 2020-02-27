package com.miqi.miqihome.dao;


import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.Collections;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
*
    发布者：丁火钦
    商圈
* */
public interface ICirclesDao {
    List<Circles> select_Circles(@Param("city_name") String city_name);
}
