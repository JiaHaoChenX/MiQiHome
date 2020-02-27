package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHomeRequirementService;
import com.miqi.miqihome.Iservice.IReceptiontimeService;
import com.miqi.miqihome.entity.Homerequirement;
import com.miqi.miqihome.entity.Receptiontime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发布人：丁火钦
 * 入住规则表【对房客的要求表】
 */
@RestController
@RequestMapping(value = "HomeRequirement")
public class HomeRequirementController {

    @Autowired
    IHomeRequirementService iHomeRequirementService;

    //查询
    @PostMapping(value = "/select_Homerequirement")
    public List<Homerequirement> select_Homerequirement(@RequestBody Homerequirement homerequirement){
        return  iHomeRequirementService.select_Homerequirement(homerequirement);
    }
    //添加
    @PostMapping(value = "/insert_Homerequirement")
    public int insert_Homerequirement(@RequestBody Homerequirement homerequirement){



        return iHomeRequirementService.insert_Homerequirement(homerequirement);
    }
    //修改
    @PostMapping(value = "/update_Homerequirement")
    public int update_Homerequirement(@RequestBody Homerequirement homerequirement){
        return iHomeRequirementService.update_Homerequirement(homerequirement);
    }
    //删除
    @PostMapping(value = "/delete_Homerequirement")
    public int delete_Homerequirement(@RequestBody Homerequirement homerequirement){
        return iHomeRequirementService.delete_Homerequirement(homerequirement);
    }

    /*
     * one 添加多两个方法
     * */
    @GetMapping("/select_Homerequirement_count")
    public int select_Homerequirement_count(){
        return iHomeRequirementService.select_Homerequirement_count();
    }

    @PostMapping("/select_Homerequirement_byLimit")
    public List<Homerequirement>select_Homerequirement_byLimit(int no,int pagesize){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("pageno",(no-1)*pagesize);
        objectMap.put("pagesize",pagesize);
        return iHomeRequirementService.select_Homerequirement_byLimit(objectMap);
    }
}
