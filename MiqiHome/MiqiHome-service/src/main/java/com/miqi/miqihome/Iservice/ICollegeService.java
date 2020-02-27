package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.College;

import java.util.List;

/*
*
    发布者：丁火钦
    高校
* */
public interface ICollegeService {
    List<College> select_College(String City);
}
