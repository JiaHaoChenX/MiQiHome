package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IUserInformationService;
import com.miqi.miqihome.dao.IUserInformationDao;
import com.miqi.miqihome.entity.Userinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
* 发布人：丁火钦
* 用户登录
*
* */
@Service
public class userInformationService implements IUserInformationService{

    @Autowired
    IUserInformationDao iUserInformationDao;

    //查询所有用户
    public List<Userinformation> select_userInformation(Map<String, Object> map) {
        return iUserInformationDao.select_userInformation(map);
    }
    //查询用户数量
    public int select_userInformation_sum(Map<String, Object> map) {
        return iUserInformationDao.select_userInformation_sum(map);
    }
    //用户注册
    public int insert_Userinformation(Userinformation userinformation) {
        return iUserInformationDao.insert_Userinformation(userinformation);
    }
    //登录状态【判断session是否有值】
    public Userinformation logon_status(String uid) {
        return iUserInformationDao.logon_status(uid);
    }
    //用户登录
    public int select_userInformation_count(String uPhone, String uPassword) {
        return iUserInformationDao.select_userInformation_count(uPhone,uPassword);
    }
    //修改用户信息
    public int update_Userinformation(Userinformation userinformation) {
        return iUserInformationDao.update_Userinformation(userinformation);
    }
    //修改密码
    public int update_Userinformation_pwd(String uid, String pwd1, String pwd2) {
        return iUserInformationDao.update_Userinformation_pwd(uid,pwd1,pwd2);
    }

    public int select_userInformation_uPhone(String uPhone) {
        return iUserInformationDao.select_userInformation_uPhone(uPhone);
    }

    public int delete_userInformation_uPhone(String uPhone) {
        return iUserInformationDao.delete_userInformation_uPhone(uPhone);
    }

}
