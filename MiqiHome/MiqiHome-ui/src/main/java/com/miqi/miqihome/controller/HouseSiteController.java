package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHouseSiteService;
import com.miqi.miqihome.entity.Geography;
import com.miqi.miqihome.entity.Housesite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 房屋位置
 * 发布者: xyz
 */
@Controller
@RequestMapping("/houseSite")
public class HouseSiteController {

    @Autowired
    IHouseSiteService service;

    /**
     * 查询城市
     */
    @RequestMapping(value = "/select_geography")
    @ResponseBody
    public List<Geography> select_geography(String region){
        return service.select_geography(region);
    }


    /*
     * 房屋位置 添加
     * */
    @RequestMapping(value = "/insertHouseSite")
    @ResponseBody
    public int insertHouseSite(@RequestBody Housesite housesite){
        return service.insertHouseSite(housesite);
    }

    /*
     * 房屋位置 修改
     * */
    @RequestMapping(value = "/updateHouseSite", method = RequestMethod.POST)
    @ResponseBody
    public int updateHouseSite(@RequestBody Housesite housesite){
        return service.updateHouseSite(housesite);
    }

    /*
     * 房屋位置 查询
     * */
    @RequestMapping(value = "/selectHouseSite")
    @ResponseBody
    public Housesite selectHouseSite(int haiId){
        return service.selectHouseSite(haiId);
    }
}
