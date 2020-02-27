package com.miqi.miqihome.controller;


import com.miqi.miqihome.Iservice.IPictureTypeService;
import com.miqi.miqihome.entity.Picturetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * * 发布者：one
 * * 房屋图片类型的增、改、查 以及相关信息表的查询
 */


@RestController
@RequestMapping(value = "/pictureTypeController")
public class PictureTypeController {

    @Autowired
    IPictureTypeService pictureTypeService;

    @PostMapping(value = "/select_all_pictureType")
    public List<Picturetype> select_all_pictureType(){
        return pictureTypeService.select_all_pictureType();
    }

    @PostMapping(value = "/select_pictureType_by_ptId")
    public Picturetype select_pictureType_by_ptId(String ptid){
        if(ptid!=""&&!ptid.equals("")) {
            return pictureTypeService.select_pictureType_by_ptId(Integer.parseInt(ptid));
        }
        return null;
    }

    @RequestMapping(value = "/select_pictureType_by_haiId")
    @ResponseBody
    public List<Picturetype> select_pictureType_by_haiId(String haild){
        if(haild!=""&&!haild.equals("")) {
            return pictureTypeService.select_pictureType_by_haiId(Integer.parseInt(haild));
        }
        return null;
    }

    @RequestMapping(value = "/insert_pictureType")
    @ResponseBody
    public int insert_pictureType(@RequestBody List<Object> objectList){

        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("ptName",objectList.get(0));
        objectMap.put("haiId",objectList.get(1));


        Picturetype picturetype=new Picturetype();
        picturetype.setPtName(objectList.get(0).toString());
        picturetype.setHaiId(Integer.parseInt(objectList.get(1).toString()));
//        return 0;
        //判断是否存在
        if(pictureTypeService.select_pictureType_haiId_ptName(picturetype)>0){
            //存在
            return pictureTypeService.select_pictureType(picturetype).getPtId();
        }else{
            //不存在执行添加语句
            pictureTypeService.insert_pictureType(picturetype);
            return picturetype.getPtId();
        }
    }

    @PostMapping(value = "/update_pictureType")
    public int update_pictureType(@RequestBody List<Object> objectList){
        /*
         * 括号后面的参数：根据实际前端请求情况 再填写
         * */
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("ptName","");
        objectMap.put("haiId","");
        objectMap.put("ptId","");
        return pictureTypeService.update_pictureType(objectMap);
    }
}
