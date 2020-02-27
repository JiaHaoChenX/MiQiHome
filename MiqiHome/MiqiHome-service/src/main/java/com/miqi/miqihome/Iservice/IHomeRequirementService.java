package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Homerequirement;

import java.util.List;
import java.util.Map;

/**
 * 发布人：丁火钦
 * 入住规则表【对房客的要求表】
 */
public interface IHomeRequirementService {
    //查询
    List<Homerequirement> select_Homerequirement(Homerequirement homerequirement);
    //添加
    int insert_Homerequirement(Homerequirement homerequirement);
    //修改
    int update_Homerequirement(Homerequirement homerequirement);
    //删除
    int delete_Homerequirement(Homerequirement homerequirement);

    /*
     * one 添加多两个方法
     * */
    int select_Homerequirement_count();
    List<Homerequirement>select_Homerequirement_byLimit(Map<String,Object> objectMap);
}
