package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.ICirclesService;
import com.miqi.miqihome.Iservice.IHomepriceService;
import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.Homeprice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    发布者：丁火钦
    房源价格
* */

@RestController
@RequestMapping("/Homeprice")
public class HomepriceController {

    @Autowired
    IHomepriceService iHomepriceService;

    //根据房源id查询信息
    @RequestMapping(value = "/select_homePrice_haiId")
    @ResponseBody
    public int select_homePrice_haiId(String haiId){
        if(iHomepriceService.select_homePrice_haiId(haiId)!=null){
            return iHomepriceService.select_homePrice_haiId(haiId).getHpId();
        }else{
            return 0;
        }
    }

    //根据房源id查询所有信息【包括折扣表】
    @RequestMapping(value = "/select_arr_homePrice_haiId")
    @ResponseBody
    public Homeprice select_arr_homePrice_haiId(String haiId){
        return  iHomepriceService.select_arr_homePrice_haiId(haiId);
    }
    //添加房源价格
    @RequestMapping(value = "/insert_homePrice")
    @ResponseBody
    public int insert_homePrice(@RequestBody Homeprice homeprice){
        iHomepriceService.insert_homePrice(homeprice);
        return homeprice.getHpId();
    }
    //修改
    @RequestMapping(value = "/update_homePrice")
    @ResponseBody
    public int update_homePrice(@RequestBody Homeprice homeprice){
        return iHomepriceService.update_homePrice(homeprice);
    }
    //添加连住折扣表
    @RequestMapping(value = "/insert_continuousDiscount")
    @ResponseBody
    public int insert_continuousDiscount(String cdDay,String cdDiscount,String hpId){
        return  iHomepriceService.insert_continuousDiscount(cdDay,cdDiscount,hpId);
    }
    //删除连住折扣表
    @RequestMapping(value = "/delete_continuousDiscount")
    @ResponseBody
    public int delete_continuousDiscount(String hpId){
        return  iHomepriceService.delete_continuousDiscount(hpId);
    }
}
