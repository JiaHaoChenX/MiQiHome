package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IAppMainRoomsService;
import com.miqi.miqihome.Iservice.ICirclesService;
import com.miqi.miqihome.Iservice.IHomeAllInformationService;
import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.MainRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作者: xyz
 * 更新时间: 2019年3月8日10:17:18
 * 描述: 手机端 上房
 */
@RestController
@RequestMapping("/appMainRooms")
public class AppMainRoomsController {

    @Autowired
    IAppMainRoomsService service;

    /**
     * 获取用户未完成上房
     * @param request
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public MainRooms selectmainrooms(HttpServletRequest request){
        int id = (int)request.getSession().getAttribute("uiId");
        return service.selectmainrooms(id);
    }

}
