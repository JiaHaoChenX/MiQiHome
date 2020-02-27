package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Homerules;
import com.miqi.miqihome.entity.Receptiontime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * * 发布者：丁火钦
 * * 入住规则表【接待房客时间表(关联入住规则表)】
 */
public interface IReceptiontimeDao {
    //根据homeRules【入住规则表ID】查询【接待房客时间表】
    List<Receptiontime> select_Receptiontime(@Param("hrId") String hrId);
    //添加
    int insert_Receptiontime(Receptiontime receptiontime);
    //修改
    int update_Receptiontime(Receptiontime receptiontime);
    //删除
    int delete_Receptiontime(Receptiontime receptiontime);
    //根据房源id删除
    int delete_Receptiontime_haiId(@Param("hrId") String hrId);
}
