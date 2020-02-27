package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHouseBedService;
import com.miqi.miqihome.common.utils.Logging;
import com.miqi.miqihome.common.utils.returnDataStandard;
import com.miqi.miqihome.entity.*;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("houseBed")
public class HouseBedController {
    @Autowired
    IHouseBedService iHouseBedService;
    /*
    * 获得对象
    * */
    Regsistadmin regsistadmin=null;
    /*
    *日志对象
    * */
    Logging logging=new Logging();

    //对出租方式表的操作
    //查询
    @GetMapping("/select_rentalMode")
    public returnDataStandard select_rentalMode(){
        /*
         * 获得对象
         * */
        regsistadmin=RegsistAdminController.REGSISTADMIN;
        long start = System.currentTimeMillis();
        returnDataStandard returnDataStandard=new returnDataStandard();
        List<Rentalmode> rentalmodeList=iHouseBedService.select_rentalMode();
        Long span = System.currentTimeMillis() - start;

        logging.setInfo("管理员："+regsistadmin.getRaName()+"，电话号码："+regsistadmin.getRaPhone()+
                "，执行了：select_rentalMode(查询出租方式)，耗时："+span+"毫秒，操作时间："+new Date().toLocaleString());
        return returnDataStandard.put("data",rentalmodeList);
    }
    //添加
    @PostMapping("/insert_rentalMode")
    public returnDataStandard insert_rentalMode(String rmName){
        regsistadmin=RegsistAdminController.REGSISTADMIN;
        long start = System.currentTimeMillis();
        if(iHouseBedService.insert_rentalMode(rmName)==1){
            Long span = System.currentTimeMillis() - start;

            logging.setInfo("管理员："+regsistadmin.getRaName()+"，电话号码："+regsistadmin.getRaPhone()+
                    "，执行了：insert_rentalMode(新增出租方式)，耗时："+span+"毫秒，操作时间："+new Date().toLocaleString());
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }

    //修改
    @PutMapping("/update_rentalMode")
    public returnDataStandard update_rentalMode(String rmName, int rmId) {
        regsistadmin=RegsistAdminController.REGSISTADMIN;
        long start = System.currentTimeMillis();
        if (iHouseBedService.update_rentalMode(rmName, rmId) == 1) {
            Long span = System.currentTimeMillis() - start;

           logging.setInfo("管理员："+regsistadmin.getRaName()+"，电话号码："+regsistadmin.getRaPhone()+
                    "，执行了：update_rentalMode(修改出租方式)，耗时："+span+"毫秒，操作时间："+new Date().toLocaleString());
            return returnDataStandard.ok("修改成功！");
        } else {
            return returnDataStandard.ok("修改失败！");
        }
    }
    //对房屋类型表的操作
    //查询类型
    @GetMapping("/select_houseType")
    public returnDataStandard select_houseType(){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseType());
    }

    //修改类型
    @PostMapping("/update_houseType")
    public returnDataStandard update_houseType(String htName,int htId ){
        if(iHouseBedService.update_houseType(htName,htId)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }

    //新增类型
    @PostMapping("/insert_houseType")
    public returnDataStandard insert_houseType(String htName){
        if(iHouseBedService.insert_houseType(htName)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }

    //查询详细
    @GetMapping("/select_houseTypeDetails")
    public returnDataStandard select_houseTypeDetails(){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseTypeDetails());
    }
    //添加
    @PostMapping("/insert_houseTypeDetails")
    public returnDataStandard insert_houseTypeDetails(Housetypedetails housetypedetails){
        if(iHouseBedService.insert_houseTypeDetails(housetypedetails)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }
    //修改
    @PutMapping("/update_houseTypeDetails")
    public returnDataStandard update_houseTypeDetails(Housetypedetails housetypedetails){
        if(iHouseBedService.update_houseTypeDetails(housetypedetails)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
    //对房屋景观表的操作
    //查询
    @GetMapping("/select_houseScenery")
    public returnDataStandard select_houseScenery(){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseScenery());
    }
    //添加
    @PostMapping("/insert_houseScenery")
    public returnDataStandard insert_houseScenery(String hcName){
        if(iHouseBedService.insert_houseScenery(hcName)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }
    //修改
    @PutMapping("/update_houseScenery")
    public returnDataStandard update_houseScenery(String hcName,int hcId){

        if(iHouseBedService.update_houseScenery(hcName,hcId)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
    //对房屋户型表的操作
    //查询
    @GetMapping("/select_houseApartment")
    public returnDataStandard select_houseApartment(String haiid){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseApartment(haiid));
    }
    //添加户型
    @PostMapping("/insert_houseApartment")
    public int insert_houseApartment(@RequestBody Houseapartment houseapartment){
        iHouseBedService.insert_houseApartment(houseapartment);
        return houseapartment.getHaId();
    }
    //修改
    @PutMapping("/update_houseApartment")
    public returnDataStandard update_houseApartment(@RequestBody Houseapartment houseapartment){
        if(iHouseBedService.update_houseApartment(houseapartment)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
    //对房屋详细表的操作
    //查询
    @GetMapping("/selct_houseDetails")
    public returnDataStandard selct_houseDetails(HttpServletRequest request){
        //rmId htdId hcId haiId uiId
        Map<String,Object> map=new HashMap<String, Object>();
        if(request.getParameter("rmId")!=null) {
            map.put("rmId",request.getParameter("rmId"));
        }if(request.getParameter("htdId")!=null) {
            map.put("htdId",request.getParameter("htdId"));
        }if(request.getParameter("hcId")!=null) {
            map.put("hcId",request.getParameter("hcId"));
        }if(request.getParameter("haiId")!=null) {
            map.put("haiId",request.getParameter("haiId"));
        }if(request.getParameter("uiId")!=null) {
            map.put("uiId",request.getParameter("uiId"));
        }
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.selct_houseDetails(map));
    }

    //根据房屋id查询houseDetails表是否存在
    @GetMapping("/selct_houseDetails_haiId")
    public Housedetails selct_houseDetails_haiId(String haiId){
        return iHouseBedService.selct_houseDetails_haiId(haiId);
    }
    //添加
    @PostMapping("/insert_houseDetails")
    public int insert_houseDetails(@RequestBody Housedetails housedetails){
        iHouseBedService.insert_houseDetails(housedetails);
        return housedetails.getHdId();
//        if(iHouseBedService.insert_houseDetails(housedetails)==1){
//            return returnDataStandard.ok("添加成功！");
//        }else{
//            return returnDataStandard.ok("添加失败！");
//        }
    }
    //修改
    @PutMapping("/update_houseDetails")
    public returnDataStandard update_houseDetails(@RequestBody Housedetails housedetails){
        if(iHouseBedService.update_houseDetails(housedetails)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }

    //对床型床类型表的操作
    //查询总数
    @GetMapping("/select_houseBedTypeCount")
    public int select_houseBedTypeCount(){
        return iHouseBedService.select_houseBedTypeCount();
    }

    //查询
    @GetMapping("/select_houseBedType")
    public returnDataStandard select_houseBedType(int no,int pagesize){
        Map<String,Object> objectMap=new HashMap<>();

        //分页操作
        int pageno=(no-1)*pagesize;

        objectMap.put("pageno",pageno);
        objectMap.put("pagesize",pagesize);
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseBedType(objectMap));
    }
    //添加
    @PostMapping("/insert_houseBedType")
    public returnDataStandard insert_houseBedType(String hbtName){
        if(iHouseBedService.insert_houseBedType(hbtName)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }
    //修改
    @PutMapping("/update_houseBedType")
    public returnDataStandard update_houseBedType(String hbtName,int hbtId){
        if(iHouseBedService.update_houseBedType(hbtName,hbtId)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
    //对床型床宽高表的操作
    //zywds
    //查询床型床类型表
    @GetMapping("/select_houseBedTypes")
    public returnDataStandard select_houseBedTypes(){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseBedTypes());
    }
    //查询床型床类型对应宽高
    @GetMapping("/select_houseBedSizes")
    public returnDataStandard select_houseBedSizes(int hbtId){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseBedSizes(hbtId));
    }
    //查询
    @GetMapping("/select_houseBedSize_count")
    public int select_houseBedSize_count(){
        return iHouseBedService.select_houseBedSize_count();
    }

    //查询
    @GetMapping("/select_houseBedSize")
    public returnDataStandard select_houseBedSize(int no,int pagesize){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("pageno",(no-1)*pagesize);
        objectMap.put("pagesize",pagesize);
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseBedSize(objectMap));
    }
    //添加
    @PostMapping("/insert_houseBedSize")
    public returnDataStandard insert_houseBedSize(int hbtId,String hbsSize){
        if(iHouseBedService.insert_houseBedSize(hbtId,hbsSize)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }
    //修改
    @PutMapping("/update_houseBedSize")
    public returnDataStandard update_houseBedSize(int hbtId,String hbsSize,int hdsId){
        System.out.println("hbtId:"+hbtId+",hbsSize:"+hbsSize+",hdsId:"+hdsId);
        if(iHouseBedService.update_houseBedSize(hbtId,hbsSize,hdsId)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
    //对床型表(一个房子有多个床型),关联房屋详细表的操作
    //查询
    @GetMapping("/select_houseBed")
    public returnDataStandard select_houseBed(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        //hdId hdsId rmId htdId hcId haiId uiId
        if(request.getParameter("hdId")!=null) {
            map.put("hdId",request.getParameter("hdId"));
        }if(request.getParameter("hdsId")!=null) {
            map.put("hdsId",request.getParameter("hdsId"));
        }if(request.getParameter("rmId")!=null) {
            map.put("rmId",request.getParameter("rmId"));
        }if(request.getParameter("htdId")!=null) {
            map.put("htdId",request.getParameter("htdId"));
        }if(request.getParameter("hcId")!=null) {
            map.put("hcId",request.getParameter("hcId"));
        }if(request.getParameter("haiId")!=null) {
            map.put("haiId",request.getParameter("haiId"));
        }if(request.getParameter("uiId")!=null) {
            map.put("uiId",request.getParameter("uiId"));
        }
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iHouseBedService.select_houseBed(map));
    }
    //添加
    @PostMapping("/insert_houseBed")
    public returnDataStandard insert_houseBed(int hdId,int hdsId,String hbtNumber){
        if(iHouseBedService.insert_houseBed(hdId,hdsId,hbtNumber)==1){
            return returnDataStandard.ok("添加成功！");
        }else{
            return returnDataStandard.ok("添加失败！");
        }
    }
    //修改
    @PutMapping("/update_houseBed")
    public returnDataStandard update_houseBed(int hdId,int hdsId,String hbtNumber,int hbId){
        if(iHouseBedService.update_houseBed(hdId,hdsId,hbtNumber,hbId)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }

    //根据房屋详细表id删除
    @RequestMapping(value = "/delete_houseBed")
    @ResponseBody
    public returnDataStandard delete_houseBed(int hdId){
        if(iHouseBedService.delete_houseBed(hdId)>0){
            return returnDataStandard.ok("删除成功！");
        }else{
            return returnDataStandard.ok("删除失败！");
        }
    }


    //根据房源id查询房屋详细
    @GetMapping("/select_houseDetails")
    public Homeallinformation select_houseDetails(String haiId){
        return iHouseBedService.select_houseDetails(haiId);
    }

}
