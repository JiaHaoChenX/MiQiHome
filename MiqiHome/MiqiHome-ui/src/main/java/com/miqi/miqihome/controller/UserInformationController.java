package com.miqi.miqihome.controller;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.miqi.miqihome.Iservice.IUserInformationService;
import com.miqi.miqihome.common.utils.returnDataStandard;
import com.miqi.miqihome.entity.Userinformation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * 发布人：丁火钦
 * 用户登录
 * */
@RestController
@RequestMapping(value = "UserInformation")
public class UserInformationController {

    @Autowired
    IUserInformationService iUserInformationService;

    /**
     * 查询所有用户
     */
    @PostMapping(value = "/select_userInformation")
//    @ResponseBody
    public List<Userinformation> select_userInformation(@RequestBody List<Object> list, int limit, int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uPhone", list.get(0));  //手机号
        map.put("uEmail", list.get(1));  //邮箱
        map.put("uSex", list.get(2));    //性别
        map.put("date1", list.get(3));   //注册时间1
        map.put("date2", list.get(4));   //注册时间2
        map.put("uCardId", list.get(5)); //身份证
        map.put("limit", 0);
        map.put("page", 5);
        return iUserInformationService.select_userInformation(map);
    }

    /**
     * 查询用户数量
     */
    @PostMapping(value = "/select_userInformation_sum")
//    @ResponseBody
    public int select_userInformation_sum(@RequestBody List<Object> list) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uPhone", list.get(0));  //手机号
        map.put("uEmail", list.get(1));  //邮箱
        map.put("uSex", list.get(2));    //性别
        map.put("date1", list.get(3));   //注册时间1
        map.put("date2", list.get(4));   //注册时间2
        map.put("uCardId", list.get(5)); //身份证
        return iUserInformationService.select_userInformation_sum(map);
    }

    /**
     * 用户注册
     */
    @PostMapping("/insert_Userinformation")
//    @ResponseBody
    public int insert_Userinformation(HttpServletRequest request, @RequestBody Userinformation userinformation) {
        HttpSession session = request.getSession();
        session.setAttribute("uid", userinformation.getUiId());
        return iUserInformationService.insert_Userinformation(userinformation);
    }

    /**
     * 判断用户登录状态
     */
    @RequestMapping(value = "/logon_status", method = RequestMethod.GET)
    @ResponseBody
    public Userinformation logon_status(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("uid") != "" && session.getAttribute("uid") != null) {
            Userinformation userinformation = iUserInformationService.logon_status(session.getAttribute("uid").toString());
            //用户编号
            session.setAttribute("uiId", userinformation.getUiId());
            System.out.println("---------------------------------------------------------------");
            System.out.println(session.getAttribute("uiId"));
            return userinformation;
        }
        return null;
    }

    /**
     * 注销【退出登录】
     */
    @RequestMapping(value = "/write_off", method = RequestMethod.GET)
    @ResponseBody
    public int write_off(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("uid") != "" && session.getAttribute("uid") != null) {
            session.removeAttribute("uid");
            session.removeAttribute("uiId");
            return 1;
        }
        return 0;
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/users_login", method = RequestMethod.GET)
    @ResponseBody
    public int select_userInformation_count(String uPhone, String uPassword, HttpServletRequest request) {
        int i = iUserInformationService.select_userInformation_count(uPhone, uPassword);
        if (i > 0) {
            HttpSession session = request.getSession();
            //用户账号【手机号】
            session.setAttribute("uid", uPhone);
        }
        return i;
    }

    //修改用户信息
    @RequestMapping(value = "/update_Userinformation")
    @ResponseBody
    public int update_Userinformation(HttpServletRequest request, @RequestBody Userinformation userinformation) {
        HttpSession session = request.getSession();
        userinformation.setuPhone(session.getAttribute("uid").toString());
        return iUserInformationService.update_Userinformation(userinformation);
    }

    //修改密码
    @RequestMapping(value = "/update_Userinformation_pwd")
    @ResponseBody
    public int update_Userinformation_pwd(HttpServletRequest request, String pwd1, String pwd2) {
        HttpSession session = request.getSession();
        System.out.println(pwd1);
        System.out.println(pwd2);
//        if(iUserInformationService.select_userInformation_count(session.getAttribute("uid").toString(),pwd1)!=0){
//            iUserInformationService.update_Userinformation_pwd(session.getAttribute("uid").toString(),pwd2);
//        }
        return iUserInformationService.update_Userinformation_pwd(session.getAttribute("uid").toString(), pwd1, pwd2);
    }


    //用户登录(只根据手机号进行登录)
    @GetMapping("lect_userInformation_uPhone")
    public returnDataStandard select_userInformation_uPhone(String uPhone,HttpServletRequest request) {
        HttpSession session = request.getSession();
        //首先查询，如果账号存在则直接登录
        if (iUserInformationService.select_userInformation_uPhone(uPhone) == 1) {
            //用户账号【手机号】
            session.setAttribute("uid", uPhone);
            return returnDataStandard.ok("登录成功！");
        } else {
            //注册
            Userinformation userinformation = new Userinformation(uPhone, "000000");
            iUserInformationService.insert_Userinformation(userinformation);
            if (iUserInformationService.select_userInformation_uPhone(uPhone) == 1) {
                //用户账号【手机号】
                session.setAttribute("uid", uPhone);
                return returnDataStandard.ok("登录成功！");
            } else {
                //根据电话号码删除用户
                iUserInformationService.delete_userInformation_uPhone(uPhone);
                return returnDataStandard.error("登录失败！");
            }
        }
    }

    //短信验证码
    @GetMapping("/messageMouse")
    public returnDataStandard messageMouse(HttpServletRequest request) throws HTTPException, IOException {
        // 短信应用SDK AppID
        int appid = 1400159819; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "d399fed2be08d339d523d4e668f078af";
        // 需要发送短信的手机号码
        String uPhone = request.getParameter("uPhone");
        System.out.println(uPhone);
        String[] phoneNumbers = {uPhone};
        int templateId = 251945;
        String smsSign = "MUJI";
        // 指定模板ID单发短信
        /*
         * 1、验证码 2、参数。占位符
         * */
        String str = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str += random.nextInt(10);
        }
        String[] params = {str, "1"};
        SmsMultiSender msender = new SmsMultiSender(appid, appkey);
        SmsMultiSenderResult result = null;  // 签名参数未提供或者为空时，会使用默认签名发送短信
        try {
            result = msender.sendWithParam("86", phoneNumbers,
                    templateId, params, smsSign, "", "");
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(result);
        returnDataStandard returnDataStandard = new returnDataStandard();
        return returnDataStandard.put("data", str);
    }


}
