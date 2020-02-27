package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IRegsistAdminService;
import com.miqi.miqihome.common.utils.MD5Utils;
import com.miqi.miqihome.common.utils.returnDataStandard;
import com.miqi.miqihome.entity.Regsistadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发布人： 张育威
 * 操作内容： 管理员管理，登录，注册
 * */


@RestController
@RequestMapping("regsistAdmin")
//@Transactional  //事务
//@Rollback()  //回滚
public class RegsistAdminController {
    @Autowired
    IRegsistAdminService iRegsistAdminService;

    public static Regsistadmin REGSISTADMIN=null;

    //查询所有管理员
    @PostMapping("/select_regsistAdmin")
    public returnDataStandard select_regsistAdmin(@RequestBody List<Object> regsistadminList){

        System.out.println(regsistadminList);

        //这种确实不够人性化，你应该全部判断好
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("raName",regsistadminList.get(0));//名字
        map.put("raPhone",regsistadminList.get(1));//电话号码
        map.put("raEmail",regsistadminList.get(2));//邮箱
        map.put("raRole",regsistadminList.get(3));//角色
        map.put("raState",regsistadminList.get(4));//状态
        int page=(int)regsistadminList.get(5);
        int limit=(int)regsistadminList.get(6);
        //String pages=((page-1)*limit);
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        returnDataStandard returnDataStandard=new returnDataStandard();
        /*return (List<Regsistadmin>) returnDataStandard.put("data",iRegsistAdminService.select_regsistAdmin(map));*/
        return returnDataStandard.put("data",iRegsistAdminService.select_regsistAdmin(map));
    }
    //查询管理员数量
    @PostMapping("/select_regsistAdmin_count")
    public returnDataStandard select_regsistAdmin_count(@RequestBody List<Object> regsistadminList){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("raName",regsistadminList.get(0));//名字
        map.put("raPhone",regsistadminList.get(1));//电话号码
        map.put("raEmail",regsistadminList.get(2));//邮箱
        map.put("raRole",regsistadminList.get(3));//角色
        map.put("raState",regsistadminList.get(4));//状态
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iRegsistAdminService.select_regsistAdmin_count(map));
    }
    //管理员登录,账号密码登录
    @GetMapping("/login_regsistAdmin")
    public returnDataStandard login_regsistAdmin(String raPhone, String raPassword,HttpServletRequest request){
        //登录需要知道账号，密码，状态（如果已注销不允许登录）
        //状态条件已经给好为1，要想登录成功需要保证账号，密码，状态正确
        int count=iRegsistAdminService.login_regsistAdmin(raPhone,raPassword);
        if(count==1){
            //将账号保存在session中
            request.getSession().setAttribute("raName",raPhone);

            REGSISTADMIN=iRegsistAdminService.select_one_regsistAdmin(raPhone);
            return returnDataStandard.ok("登录成功！");
        }else {
            return returnDataStandard.error("登录失败！");
        }
    }
    //管理员添加
    @PostMapping("/insert_regsistAdmin")
    public returnDataStandard insert_regsistAdmin(@RequestBody Regsistadmin regsistadmin){
        System.out.println(regsistadmin);
        int count=iRegsistAdminService.insert_regsistAdmin(regsistadmin);
        if(count==1){
            return returnDataStandard.ok("添加成功！");
        }else {
            return returnDataStandard.ok("添加失败！");
        }
    }
    //管理员修改
    @PutMapping("/update_regsistAdmin")
    public returnDataStandard update_regsistAdmin(@RequestBody Regsistadmin regsistadmin){
        int count=iRegsistAdminService.update_regsistAdmin(regsistadmin);
        if(count==1){
            return returnDataStandard.ok("修改成功！");
        }else {
            return returnDataStandard.ok("修改失败！");
        }

    }
    //管理员注销与启用
    @GetMapping("/update_regsistAdmin_raState")
    public returnDataStandard update_regsistAdmin_raState(int raState, int raId, HttpServletResponse response,HttpServletRequest request) throws IOException {
        //解决服务端乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        //知道管理员的编号与状态
        //如果状态为0，注销    如果状态为1，启用
        if(raState==0){
            //注销
            if(iRegsistAdminService.update_regsistAdmin_raState(raState,raId)==1){
                return returnDataStandard.ok("注销成功！");
            }else{
                return returnDataStandard.ok("注销失败！");
            }
        }else {
            //启用
            if (iRegsistAdminService.update_regsistAdmin_raState(raState, raId) == 1) {
                return returnDataStandard.ok("启用成功！");
            } else {
                return returnDataStandard.ok("启用失败！");
            }
        }
    }
    //密码重置
    @GetMapping("/update_regsistAdmin_RraPassword")
    public returnDataStandard update_regsistAdmin_RraPassword(int raId){
        if(iRegsistAdminService.update_regsistAdmin_RraPassword(raId)==1){
            return returnDataStandard.ok("重置成功！");
        }else{
            return returnDataStandard.ok("重置失败！");
        }
    }
    //修改密码
    @PutMapping("/update_regsist_raPassword")
    public returnDataStandard update_regsist_raPassword(String raPassword, int raId, String raPhone){
        if(iRegsistAdminService.update_regsist_raPassword(raPassword,raId,raPhone)==1){
            return returnDataStandard.ok("修改成功！");
        }else{
            return returnDataStandard.ok("修改失败！");
        }
    }
}
