package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Livepeople;

import java.util.List;

/**
 * 入住人信息表
 *  发布者: xyz
 */
public interface IlivePeopleDao {

    /**
     * 添加
     * @param entity
     * @return
     */
    int insert(Livepeople entity);

    /**
     * 多添加
     * @param list 入住信息实体集合
     * @return 添加成功条数
     */
    int insertList(List<Livepeople> list);

    /**
     * 修改
     * @param entity
     * @return
     */
    int update(Livepeople entity);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 根据预定编号查询入住人信息
     * @param id 预定编号
     * @return
     */
    List<Livepeople> selectList(int id);

}
