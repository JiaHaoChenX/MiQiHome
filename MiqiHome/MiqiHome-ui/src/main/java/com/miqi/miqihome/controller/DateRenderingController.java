package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IDateRenderingService;
import com.miqi.miqihome.Iservice.IReserveService;
import com.miqi.miqihome.entity.DateRendering;
import com.miqi.miqihome.entity.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 日期渲染
 * 发布者: xyz
 */
@Controller
@RequestMapping("/dateRendering")
public class DateRenderingController {

    @Autowired
    IDateRenderingService service;

    /**
     * 获取时间段房屋信息
     * @param haiId 房屋编号
     * @param startTime 开始时间 格式 yyyy-MM-dd
     * @param endTime 结束时间 格式 yyyy-MM-dd
     * @return
     */
    @RequestMapping(value = "/selectReserveDate")
    @ResponseBody
    public List<DateRendering> selectReserveDate(int haiId, String startTime, String endTime){
        return service.selectReserveDate(haiId,startTime,endTime);
    }

}
