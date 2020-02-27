package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.ICollectionsService;
import com.miqi.miqihome.entity.Collections;
import com.miqi.miqihome.entity.Homeallinformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
    发布者：one
    房屋收藏表 增删改查
* */

@RestController
@RequestMapping("/collectionsController")
public class CollectionsController {

    @Autowired
    ICollectionsService collectionsService;

    /*
    * 查询
    * */
    @PostMapping(value = "/select_all_collection")
    List<Collections>select_all_collection(@RequestBody List<Object> objectList){
        Map<String,Object> objectMap=new HashMap<String, Object>();

        /*
        * 分页两个参数必填
        * */
        objectMap.put("pageno",0);
        objectMap.put("pagesize",2);
        return collectionsService.select_all_collection(objectMap);
    }




    /*
    * 修改
    * */
    @PostMapping(value = "/update_collection")
    int update_collection(@RequestBody List<Object> objectList){
        Map<String,Object> objectMap=new HashMap<String, Object>();
        int result = collectionsService.update_collection(objectMap);
        if(result>0){
            return result;
        }
        return -1;
    }

    /*
     * 删除
     * */
    @PostMapping(value = "/delete_collection")
    int delete_collection(HttpServletRequest request,String haiId){
        HttpSession session = request.getSession();
        return collectionsService.delete_collection(session.getAttribute("uiId").toString(),haiId);
    }


    /**
     *  发布人：丁火钦
     *  作用：根据用户id查询该用户是否收藏了该房间
     */
    @RequestMapping(value = "/select_ui_collection")
    @ResponseBody
    public int select_ui_collection(HttpServletRequest request,@Param("haiId") String haiId){
        HttpSession session = request.getSession();
        return collectionsService.select_ui_collection(session.getAttribute("uiId").toString(),haiId);
    }


    /**
     *  发布人：丁火钦
     *  作用：根据用户id查询该用户收藏的房间
     */
    @RequestMapping(value = "/select_ui_collection_list")
    @ResponseBody
    public List<Homeallinformation> select_ui_collection_list(HttpServletRequest request){
        HttpSession session = request.getSession();
        return collectionsService.select_ui_collection_list(session.getAttribute("uiId").toString());
    }

    /**
     * 收藏
     */
    @RequestMapping(value = "/add_collection")
    @ResponseBody
    public int add_collection(HttpServletRequest request,String haiId){
        HttpSession session = request.getSession();
        //判断是否收藏过
        if(collectionsService.select_ui_collection(session.getAttribute("uiId").toString(),haiId)>0){
            //删除
            return collectionsService.delete_collection(session.getAttribute("uiId").toString(),haiId);
        }else{
            //添加
            return collectionsService.insert_collection(session.getAttribute("uiId").toString(),haiId);
        }
    }





}
