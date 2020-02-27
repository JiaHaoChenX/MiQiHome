package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Evaluate;
import com.miqi.miqihome.entity.Reserve;
import com.miqi.miqihome.entity.Userinformation;

import java.util.List;
import java.util.Map;

/*
 * 预定信息表
 * 发布人：xyz
 * */
public interface IReserveDao {

    /**
     * 添加预定信息
     * @param reserve
     * @return
     */
    int insertReserve(Reserve reserve);

    /**
     * 修改预定信息
     * @param reserve
     * @return
     */
    int updateReserve(Reserve reserve);

    /**
     * 综合查询
     * @param map
     * @return
     */
    List<Reserve> selectReserves(Map map);

    /**
     * 获取综合查询数量
     * @param map
     * @return
     */
    int selectCount(Map map);

    /**
     * 查询房东各种状态数量
     * @param id 房东Id
     * @return
     */
    List<Reserve> selectStateCount(int id);

    /**
     *  房东总评分
     * @param id 房东Id
     * @return
     */
    Evaluate selectEvaluateSum(int id);

    /**
     * 根据房东编号查询房东
     * @param id 房东编号
     * @return
     */
    Userinformation selectUserInformation(int id);

}
