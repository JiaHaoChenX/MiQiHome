package com.miqi.miqihome.controller;


import com.miqi.miqihome.Iservice.IHouseDescriptionService;
import com.miqi.miqihome.entity.Housedecription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * * 发布者：one
 * * 房屋描述表的增、改、查 以及相关信息表的查询
 */

@RestController
@RequestMapping("/houseDescriptionController")
public class HouseDescriptionController {

    @Autowired
    IHouseDescriptionService houseDescriptionService;

    @PostMapping(value = "/select_all_houseDecription")
    public List<Housedecription>select_all_houseDecription(){
        return houseDescriptionService.select_all_houseDecription();
    }

    @PostMapping(value = "/select_houseDecription_by_haiId")
    public Housedecription select_houseDecription_by_haiId(String haiId){
        return houseDescriptionService.select_houseDecription_by_haiId(Integer.parseInt(haiId));
    }

    @PostMapping(value = "/select_houseDecription_by_hdpId")
    public Housedecription select_houseDecription_by_hdpId(HttpServletRequest request){
        String hdpId=request.getParameter("hdpId");
        if(hdpId!=""){
            return houseDescriptionService.select_houseDecription_by_hdpId(Integer.parseInt(hdpId));
        }
        return null;
    }


    //添加
    @RequestMapping(value = "/insert_houseDecription")
    @ResponseBody
    public int insert_houseDecription(@RequestBody List<Object> objectList){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("hdpName",objectList.get(0));
        objectMap.put("hdpCharacteristic",objectList.get(1));
        objectMap.put("hdpTraffic",objectList.get(2));
        objectMap.put("hdpRound",objectList.get(3));
        objectMap.put("haiId",objectList.get(4));
        if(houseDescriptionService.select_houseDecription_haiId(objectMap)>0){
            return houseDescriptionService.update_houseDecription(objectMap);
        }else{
            return houseDescriptionService.insert_houseDecription(objectMap);
        }


    }

    @PostMapping(value = "/update_houseDecription")
    public int update_houseDecription(@RequestBody List<Object> objectList){

        Map<String,Object>objectMap=new HashMap<String, Object>();

        /*
         * 括号后面的参数：根据实际前端请求情况 再填写
         * */
        objectMap.put("hdpName","");
        objectMap.put("hdpCharacteristic","");
        objectMap.put("hdpTraffic","");
        objectMap.put("hdpRound","");
        objectMap.put("haiId",0);
        objectMap.put("hdpId",0);
        return houseDescriptionService.update_houseDecription(objectMap);
    }

    @PostMapping(value = "/select_all_houseDecription_count")
    public int select_all_houseDecription_count(){
        return houseDescriptionService.select_all_houseDecription_count();
    }
}
