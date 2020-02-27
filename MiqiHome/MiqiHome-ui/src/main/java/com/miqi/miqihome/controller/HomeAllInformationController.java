package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHomeAllInformationService;
import com.miqi.miqihome.Iservice.IHomeRequirementService;
import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.Homerequirement;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发布人：丁火钦
 * 房屋全部信息表（房源表）
 */
@RestController
@RequestMapping(value = "HomeAllInformation")
public class HomeAllInformationController {

    @Autowired
    IHomeAllInformationService iHomeAllInformationService;


    //查询多个
    @RequestMapping(value = "/select_multi_HomeAllInformation")
    @ResponseBody
    public List<Homeallinformation> select_multi_HomeAllInformation(
             String haiId           //房源编号
            ,String htName          //房屋类型【特色房型】
            ,String htdName         //房屋类型详细名称
            ,String hsProvince      //目的地【位置{省}】
            ,String hsCity          //目的地【位置{市}】
            ,String hsArea          //目的地【位置{区}】
            ,String hdLiveNumber    //入住人数
            ,String hSite           //地址、补充说明、标题、用户名
            ,String hsSite          //位置
            ,String haBedroom       //【户型】卧室数量
            ,String hpPrice1        //价格开始
            ,String hpPrice2        //价格结束
            ,String[] hfdId         //设施
             ,String sort           //排序！！！！！
             ,int page              //分页【开始】
             ,int limit             //分页【结束】
    ){
        int pages=(page-1)*limit;
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("haiId",haiId);
        objectMap.put("htName",htName);
        objectMap.put("htdName",htdName);
        objectMap.put("hsProvince",hsProvince);
        objectMap.put("hsCity",hsCity);
        objectMap.put("hsArea",hsArea);
        objectMap.put("hdLiveNumber",hdLiveNumber);
        objectMap.put("hSite",hSite);
        objectMap.put("hsSite",hsSite);
        objectMap.put("haBedroom",haBedroom);
        objectMap.put("hpPrice1",hpPrice1);
        objectMap.put("hpPrice2",hpPrice2);
        objectMap.put("hfdId",hfdId);
        objectMap.put("sort",sort);
        //分页
        objectMap.put("pages",pages);
        objectMap.put("limit",limit);
        return  iHomeAllInformationService.select_multi_HomeAllInformation(objectMap);
    }
    //查询数量
    @RequestMapping(value = "/select_HomeAllInformation_count")
    @ResponseBody
    public int select_HomeAllInformation_count(
            String haiId           //房源编号
            ,String htName          //房屋类型【特色房型】
            ,String htdName         //房屋类型详细名称
            ,String hsProvince      //目的地【位置{省}】
            ,String hsCity          //目的地【位置{市}】
            ,String hsArea          //目的地【位置{区}】
            ,String hdLiveNumber    //入住人数
            ,String hSite           //地址、补充说明、标题、用户名
            ,String hsSite          //位置
            ,String haBedroom       //【户型】卧室数量
            ,String hpPrice1        //价格开始
            ,String hpPrice2        //价格结束
            ,String[] hfdId         //设施
    ){
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("haiId",haiId);
        objectMap.put("htName",htName);
        objectMap.put("htdName",htdName);
        objectMap.put("hsProvince",hsProvince);
        objectMap.put("hsCity",hsCity);
        objectMap.put("hsArea",hsArea);
        objectMap.put("hdLiveNumber",hdLiveNumber);
        objectMap.put("hSite",hSite);
        objectMap.put("hsSite",hsSite);
        objectMap.put("haBedroom",haBedroom);
        objectMap.put("hpPrice1",hpPrice1);
        objectMap.put("hpPrice2",hpPrice2);
        objectMap.put("hfdId",hfdId);

        return  iHomeAllInformationService.select_HomeAllInformation_count(objectMap);
    }
    //根据id查询
    @RequestMapping(value = "/select_HomeAllInformation")
    @ResponseBody
    public Homeallinformation select_Homeallinformation(String haiId){
        return  iHomeAllInformationService.select_Homeallinformation(haiId);
    }

    //根据id查询
    @RequestMapping(value = "/select_multi_HomeAllInformation_order")
    @ResponseBody
    public List<Homeallinformation> select_multi_HomeAllInformation_order(int uiId,int haiId){
        return  iHomeAllInformationService.select_multi_HomeAllInformation_order(uiId,haiId);
    }


    //根据用户id查询该用户发布的房源
    @RequestMapping(value = "/select_ui_HomeAllInformation")
    @ResponseBody
    public List<Homeallinformation> select_ui_HomeAllInformation(HttpServletRequest request){
        HttpSession session = request.getSession();
        return  iHomeAllInformationService.select_ui_HomeAllInformation(session.getAttribute("uiId").toString());
    }

    //添加房源
    @RequestMapping(value = "/insert_HomeAllInformation")
    @ResponseBody
    public int insert_HomeAllInformation(HttpServletRequest request){
        HttpSession session = request.getSession();
        Homeallinformation homeallinformation=new Homeallinformation();
        homeallinformation.setUiId((int)session.getAttribute("uiId"));
        iHomeAllInformationService.insert_HomeAllInformation(homeallinformation);
        return  homeallinformation.getHaiId();
    }


}
