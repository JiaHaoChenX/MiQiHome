package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.DateRendering;
import com.miqi.miqihome.entity.Reserve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * 日期渲染
 * 发布人：xyz
 * */
public interface IDateRenderingDao {

    /**
     * 查询价格对应表预定房间
     * @param haiId
     * @param startTime
     * @param endTime
     * @return
     */
    List<DateRendering> selectReserveDate(@Param("haiId") int haiId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 查询预定订单
     * @param haiId
     * @param startTime
     * @param endTime
     * @return
     */
    List<Reserve> selectReserve (@Param("haiId") int haiId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 查询房屋信息
     * @param haiId 房屋编号
     * @return
     */
    DateRendering selectHouse(@Param("haiId") int haiId);
}
