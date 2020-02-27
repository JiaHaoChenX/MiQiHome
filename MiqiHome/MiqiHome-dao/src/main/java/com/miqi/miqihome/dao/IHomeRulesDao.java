package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.Homerules;
import org.apache.ibatis.annotations.Param;

/**
 *
 * * 发布者：丁火钦
 * * 入住规则表
 */
public interface IHomeRulesDao {
    //查询
    Homerules select_HomeRules(@Param("hrId") String hrId);
    //添加
    int insert_HomeRules(Homerules homerules);
    //修改
    int update_HomeRules(Homerules homerules);
    //根据房源id查询入住规则
    Homeallinformation select_HomeRules_haiId(@Param("haiId") String haiId);
}
