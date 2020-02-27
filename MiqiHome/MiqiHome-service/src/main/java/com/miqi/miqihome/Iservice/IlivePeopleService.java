package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Livepeople;

import java.util.List;
/**
 * 入住人信息表
 * 发布者：xyz
 */
public interface IlivePeopleService  {

    /**
     * 添加
     * @param entity
     * @return
     */
    int insert(Livepeople entity);

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
