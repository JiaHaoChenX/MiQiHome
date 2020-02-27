package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.DateRendering;
import com.miqi.miqihome.entity.Reserve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * 日期渲染
 * 发布人：xyz
 * */
public interface IDateRenderingService {

    /**
     * 获取房屋某段时间内的价格与剩余房屋数
     */
    List<DateRendering> selectReserveDate(int haiId, String startTime, String endTime);

}
