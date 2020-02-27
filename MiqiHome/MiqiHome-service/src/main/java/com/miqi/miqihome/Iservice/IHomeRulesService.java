package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.Homerules;

/**
 * 发布人：丁火钦
 * 入住规则
 */
public interface IHomeRulesService {
    //查询
    Homerules select_HomeRules(String uid);
    //添加
    int insert_HomeRules(Homerules homerules);
    //修改
    int update_HomeRules(Homerules homerules);
    //根据房源id查询入住规则
    Homeallinformation select_HomeRules_haiId(String haiId);
}
