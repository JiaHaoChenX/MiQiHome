package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Userinformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 发布人：丁火钦
 * 用户登录功能
 */
public interface IUserInformationService {
    //查询所有用户
    List<Userinformation> select_userInformation(Map<String, Object> map);
    //查询用户数量
    int select_userInformation_sum(Map<String, Object> map);
    //用户注册
    int insert_Userinformation(Userinformation userinformation);
    //登录状态【判断session是否有值】
    Userinformation logon_status(String uid);
    //用户登录
    int select_userInformation_count(String uPhone, String uPassword);
    //修改用户信息
    int update_Userinformation(Userinformation userinformation);
    //修改密码
    int update_Userinformation_pwd(String uid, String pwd1, String pwd2);

    //用户登录(只根据手机号进行登录)
    int select_userInformation_uPhone(@Param("uPhone") String uPhone);
    //根据电话号码删除用户
    int delete_userInformation_uPhone(@Param("uPhone") String uPhone);
}
