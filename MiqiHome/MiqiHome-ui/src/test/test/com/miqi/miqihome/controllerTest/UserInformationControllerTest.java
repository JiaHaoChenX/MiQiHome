//package com.miqi.miqihome.controllerTest;
//
//import com.miqi.miqihome.Iservice.IUserInformationService;
//import com.miqi.miqihome.dao.IUserInformationDao;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.transaction.Transactional;
//
///*
//* 发布人：丁火钦
//* 测试：用户登录
//*
//* */
////指定bean注入的配置文件
//@ContextConfiguration({"classpath:applicationContext.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@Rollback()  //是否回滚
//public class UserInformationControllerTest {
//
//    @Autowired
//    IUserInformationService iUserInformationService;
//
//    @Test
//    public void sel_complaint_count(){
//        iUserInformationDao.select_userInformation_count("13192262812","123456");
//    }
//
//
//
//}