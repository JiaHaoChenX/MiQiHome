package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * * 发布者：one
 * * 房屋评价表 增删改查
 */
public interface IEvaluateDao {

    /*
     * 查询
     * */
    List<Evaluate>select_all_evaluate(Map<String,Object>objectMap);

    /*
     * 新增
     * */
    int insert_evaluate(Map<String ,Object>objectMap);

    /*
     * 修改
     * */
    int update_evaluate(Map<String,Object>objectMap);

    /*
     * 删除
     * */
    int delete_evaluate(@Param("eId")int eid);

    /**
     * 根据房源id查询评论数量
     * @param eid
     * @return
     */
    int select_evaluate_count(@Param("eId") int eid);
}
