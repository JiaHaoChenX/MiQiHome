package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHouseFacilitiesReflectService;
import com.miqi.miqihome.common.utils.returnDataStandard;
import com.miqi.miqihome.entity.HouseFacilitiesReflect;
import com.miqi.miqihome.entity.Housefacilitiesdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 发布者：张育威
 * 操作：  房屋设施对应表控制层
 * */
@RestController
@RequestMapping("houseFacilitiesReflect")
public class HouseFacilitiesReflectController {
    @Autowired
    IHouseFacilitiesReflectService iHouseFacilitiesReflectService;
    //对设施服务表进行的操作
    //查询设施服务表
    @GetMapping("/select_houseFacilities")
    public returnDataStandard select_houseFacilities(){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseFacilitiesReflectService.select_houseFacilities());
    }
    //添加
    @PostMapping("/insert_houseFacilities")
    public returnDataStandard insert_houseFacilities(String hfName, HttpServletResponse response) throws IOException {
        //解决服务端乱码（如果发生乱码请加上）
        if(iHouseFacilitiesReflectService.insert_houseFacilities(hfName)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }
    //修改
    @PutMapping("/update_houseFacilities")
    public returnDataStandard update_houseFacilities(String hfName, int hfId,HttpServletResponse response){
        if(iHouseFacilitiesReflectService.update_houseFacilities(hfName,hfId)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
    //对设施服务详细表进行操作
    //添加
    @PostMapping("/insert_housefacilitiesdetails")
    public returnDataStandard insert_housefacilitiesdetails(int hfId, String hfdName,HttpServletResponse response){
        if(iHouseFacilitiesReflectService.insert_housefacilitiesdetails(hfId,hfdName)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }
    //修改
    @PutMapping("/update_housefacilitiesdetails")
    public returnDataStandard update_housefacilitiesdetails(String hfdName, int hfId, int hfdId,HttpServletResponse response){
        if(iHouseFacilitiesReflectService.update_housefacilitiesdetails(hfdName,hfId,hfdId)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
    //查询设施服务表与设施服务详细表
    @GetMapping("/select_housefacilitiesdetails")
    public returnDataStandard select_housefacilitiesdetails(String hfId,int page,int limit){
        int pages=(page-1)*limit;
        int limits=limit;
        //可以根据设施服务表的编号查询，有就写上，没有就空(查全部)
        returnDataStandard returnDataStandard=new returnDataStandard();
        return  returnDataStandard.put("data",iHouseFacilitiesReflectService.select_housefacilitiesdetails(hfId,pages,limits));
    }
    //查询设施服务表与设施服务详细表数量
    @GetMapping("/select_housefacilitiesdetails_count")
    public returnDataStandard select_housefacilitiesdetails_count(String hfId){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("msg",iHouseFacilitiesReflectService.select_housefacilitiesdetails(hfId,0,99999).size());
    }
    //查询设施服务表对应表（里面包括用户信息，房屋信息，设施所有信息）
    @GetMapping("/select_houseFacilitiesReflect")
    public returnDataStandard select_houseFacilitiesReflect(HttpServletRequest request){
        //通过request获得值
        //列如我现在获得一个
        //可以选择不同的条件进行查询
        Map<String,Object> map=new HashMap<String, Object>();
        if(request.getParameter("haiId")!=null) {
            String haiId=request.getParameter("haiId");
            map.put("haiId", haiId);
        }if(request.getParameter("hfId")!=null) {
            String hfId=request.getParameter("hfId");
            map.put("hfId", hfId);
        }if(request.getParameter("hfdId")!=null) {
            String hfdId=request.getParameter("hfdId");
            map.put("hfdId", hfdId);
        }if(request.getParameter("hfrId")!=null) {
            String hfrId=request.getParameter("hfrId");
            map.put("hfrId", hfrId);
        }if(request.getParameter("uiId")!=null) {
            String uiId=request.getParameter("uiId");
            map.put("uiId", uiId);
        }
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseFacilitiesReflectService.select_houseFacilitiesReflect(map));
    }

    //根据房源id查询设施服务
    @RequestMapping(value = "/select_HouseFacilitiesDetails_haiId")
    @ResponseBody
    public List<HouseFacilitiesReflect> select_HouseFacilitiesDetails_haiId(String  haiId){
        return iHouseFacilitiesReflectService.select_HouseFacilitiesDetails_haiId(haiId);
    }
    //添加设施服务表对应表
    @PostMapping("/insert_houseFacilitiesReflect")
    public returnDataStandard insert_houseFacilitiesReflect(int haiId, int hfdId,HttpServletResponse response){
        if(iHouseFacilitiesReflectService.insert_houseFacilitiesReflect(haiId,hfdId)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }
    //修改设施服务对应表
    @PutMapping("/update_houseFacilitiesReflect")
    public returnDataStandard update_houseFacilitiesReflect(int haiId, int hfdId, int hfrId,HttpServletResponse response){
        if(iHouseFacilitiesReflectService.update_houseFacilitiesReflect(haiId,hfdId,hfrId)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
    //删除设施服务对应表信息
    @GetMapping("/delete_houseFacilitiesReflect")
    public int delete_houseFacilitiesReflect(String haiId){
        return iHouseFacilitiesReflectService.delete_houseFacilitiesReflect(haiId);
    }
}
