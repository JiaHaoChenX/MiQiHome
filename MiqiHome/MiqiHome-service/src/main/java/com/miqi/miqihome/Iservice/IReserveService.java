package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Evaluate;
import com.miqi.miqihome.entity.Housesite;
import com.miqi.miqihome.entity.Reserve;

import java.util.List;
import java.util.Map;

/*
 * 预定信息表
 * 发布人：xyz
 * */
public interface IReserveService {
    /**
     * 添加 预定信息
     * @param reserve
     * @return
     */
    int insertReserve(Reserve reserve);

    /**
     * 修改 预定信息
     * @param reserve
     * @return
     */
    int updateReserve(Reserve reserve);

    /**
     * 综合查询
     * @param map
     * @return
     */
    Map selectReserves(Map map);


    /**
     * 查询房东各种状态数量
     * @param id 房东Id
     * @return
     */
    Map selectRegsistAdmin(int id);

}
