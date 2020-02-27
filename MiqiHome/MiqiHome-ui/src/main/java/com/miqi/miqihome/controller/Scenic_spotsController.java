package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IScenic_spotsService;
import com.miqi.miqihome.Iservice.IUserInformationService;
import com.miqi.miqihome.entity.Scenic_spots;
import com.miqi.miqihome.entity.Userinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 发布人：丁火钦
* 功能：根据城市名称查询该城市的景点
* */
@RestController
@RequestMapping(value = "scenic_spots")
public class Scenic_spotsController {

    @Autowired
    IScenic_spotsService iScenic_spotsService;


    @GetMapping(value = "/select_Scenic_spots")
    public List<Scenic_spots> select_Scenic_spots(String City){
        System.out.println(City);
        return iScenic_spotsService.select_Scenic_spots(City);
    }

}
