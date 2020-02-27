package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Pricereflect;

import java.util.List;

/*
 * 房屋多种价格对应表
 * 发布人：xyz
 * */
public interface IPriceReflectDao {

    /**
     * 添加 房屋多种价格对应
     * @param pricereflect 房屋日期价格对象
     * @return
     */
    int insertPricereflect(Pricereflect pricereflect);

    /**
     * 多添加
     * @param list 集合 房屋多种价格对应表
     * @return 成功条数
     */
    int insertPricereflects(List<Pricereflect> list);

    /**
     * 修改 房屋多种价格对应
     * @param pricereflect 房屋日期价格对象
     * @return
     */
    int updatePricereflect(Pricereflect pricereflect);

    /**
     * 批量删除 房屋多种价格对应
     * @param list 房屋日期价格编号
     * @return
     */
    int deletePricereflects(List list);

    /**
     * 查询房屋日期价格
     * @param haiId 房屋编号
     * @return
     */
    List<Pricereflect> selectPricereflects(int haiId);

}
