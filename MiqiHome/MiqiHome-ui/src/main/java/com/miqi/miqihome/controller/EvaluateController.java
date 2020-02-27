package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IEvaluateService;
import com.miqi.miqihome.entity.Evaluate;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * * 发布者：one
 * * 房屋评价表 增删改查
 */
@RestController
@RequestMapping("/evaluateController")
public class EvaluateController {

    @Autowired
    IEvaluateService evaluateService;

    /*
     * 查询全部
     * */
    @PostMapping("/select_all_evaluate")
    public List<Evaluate>select_all_evaluate(@RequestBody List<Object>objectList){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("haiId",objectList.get(0));
        objectMap.put("pageno",objectList.get(1));
        objectMap.put("pagesize",objectList.get(2));
        return evaluateService.select_all_evaluate(objectMap);
    }
    /**
     *  发布人：丁火钦
     *  根据房源id查询评论数量
     */
    @PostMapping("/select_evaluate_count")
    public int select_evaluate_count(@Param("haiId") int haiid){
        return evaluateService.select_evaluate_count(haiid);
    }


    /*
     * 新增
     * */
    @PostMapping("/insert_evaluate")
    public int insert_evaluate(@RequestBody List<Object>objectList){

        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("","");
        objectMap.put("","");
        int result=evaluateService.insert_evaluate(objectMap);
        if(result>0){
            return result;
        }
        return -1;
    }

    /*
     * 修改
     * */
    @PostMapping("/update_evaluate")
    public int update_evaluate(@RequestBody List<Object>objectList){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("","");
        objectMap.put("","");
        /*
         * eid ：必填
         * */
        objectMap.put("eid",1);
        int result=evaluateService.update_evaluate(objectMap);
        if(result>0){
            return result;
        }
        return -1;
    }

    /*
     * 删除
     * */
    @PostMapping("/delete_evaluate")
    public int delete_evaluate(HttpServletRequest request,String eid){
        if(eid!=""&&!eid.equals("")){
            return evaluateService.delete_evaluate(Integer.parseInt(eid));
        }
        return -1;
    }
}
