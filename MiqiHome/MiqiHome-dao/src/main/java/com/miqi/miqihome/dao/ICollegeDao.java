package com.miqi.miqihome.dao;


import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.College;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
*
    发布者：丁火钦
    高校
* */
public interface ICollegeDao {

    List<College> select_College(@Param("City") String City);
}
