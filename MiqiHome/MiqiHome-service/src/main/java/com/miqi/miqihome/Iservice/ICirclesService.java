package com.miqi.miqihome.Iservice;

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
public interface ICirclesService {
    List<Circles> select_Circles(String city_name);
}
