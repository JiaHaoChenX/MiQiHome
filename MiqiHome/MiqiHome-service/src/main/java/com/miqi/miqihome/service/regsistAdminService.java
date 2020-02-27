package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IRegsistAdminService;
import com.miqi.miqihome.Iservice.IUserInformationService;
import com.miqi.miqihome.dao.IRegsistAdminDao;
import com.miqi.miqihome.dao.IUserInformationDao;
import com.miqi.miqihome.entity.Regsistadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
* 发布人：张育威
* 管理员登录
*
* */
@Service
public class regsistAdminService implements IRegsistAdminService {

    @Autowired
    IRegsistAdminDao iRegsistAdminDao;

    //查询所有管理员
    public List<Regsistadmin> select_regsistAdmin(Map<String,Object> map) {
        return iRegsistAdminDao.select_regsistAdmin(map);
    }
    //查询管理员数量
    public int select_regsistAdmin_count(Map<String, Object> map) {
        return iRegsistAdminDao.select_regsistAdmin_count(map);
    }
    //管理员登录,账号密码登录
    public int login_regsistAdmin(String raPhone, String raPassword) {
        return iRegsistAdminDao.login_regsistAdmin(raPhone,raPassword);
    }
    //管理员添加
    public int insert_regsistAdmin(Regsistadmin regsistadmin) {
        return iRegsistAdminDao.insert_regsistAdmin(regsistadmin);
    }
    //管理员修改
    public int update_regsistAdmin(Regsistadmin regsistadmin) {
        return iRegsistAdminDao.update_regsistAdmin(regsistadmin);
    }
    //管理员注销与启用
    public int update_regsistAdmin_raState(int raState, int raId) {
        return iRegsistAdminDao.update_regsistAdmin_raState(raState,raId);
    }
    //密码重置
    public int update_regsistAdmin_RraPassword(int raId) {
        return iRegsistAdminDao.update_regsistAdmin_RraPassword(raId);
    }
    //密码修改
    public int update_regsist_raPassword(String raPassword, int raId, String raPhone) {
        return iRegsistAdminDao.update_regsist_raPassword(raPassword,raId,raPhone);
    }

    public Regsistadmin select_one_regsistAdmin(String raphone) {
        return iRegsistAdminDao.select_one_regsistAdmin(raphone);
    }
}
