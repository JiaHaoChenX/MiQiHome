package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Homerequirementreflect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * * 发布者：丁火钦
 * * 入住规则表【对房客的要求表对应表(与房客要求表和入住规则表进行关联)】
 */
public interface IHomeRequirementReflectDao {
    //查询
    List<Homerequirementreflect> select_Homerequirementreflect(Homerequirementreflect homerequirementreflect);
    //添加
    int insert_Homerequirementreflect(Homerequirementreflect homerequirementreflect);
    //删除
    int delete_Homerequirementreflect(Homerequirementreflect homerequirementreflect);
    //根据id删除
    int delete_HomeRequirementReflect_hrId(@Param("hrId") String hrId);
}
