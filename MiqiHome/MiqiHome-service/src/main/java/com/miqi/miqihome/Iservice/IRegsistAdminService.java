package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Regsistadmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IRegsistAdminService {
    //查询所有管理员
    List<Regsistadmin> select_regsistAdmin(Map<String, Object> map);
    //查询管理员数量
    int select_regsistAdmin_count(Map<String, Object> map);
    //管理员登录,账号密码登录
    int login_regsistAdmin(@Param("raPhone") String raPhone, @Param("raPassword") String raPassword);
    //管理员添加
    int insert_regsistAdmin(Regsistadmin regsistadmin);
    //管理员修改
    int update_regsistAdmin(Regsistadmin regsistadmin);
    //管理员注销与启用
    int update_regsistAdmin_raState(@Param("raState") int raState, @Param("raId") int raId);
    //密码重置
    int update_regsistAdmin_RraPassword(int raId);
    //密码修改
    int update_regsist_raPassword(@Param("raPassword") String raPassword, @Param("raId") int raId, @Param("raPhone") String raPhone);

    /*
     * one 新增的方法
     * */
    Regsistadmin select_one_regsistAdmin(@Param("raPhone")String raphone);
}
