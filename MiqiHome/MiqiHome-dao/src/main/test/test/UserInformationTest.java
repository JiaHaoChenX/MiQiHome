import com.miqi.miqihome.dao.IUserInformationDao;
import com.miqi.miqihome.entity.Userinformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/*
* 发布人：丁火钦
* 测试：用户登录
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class UserInformationTest {
    @Autowired
    IUserInformationDao iUserInformationDao;

    //查询所有用户
    @Test
    public void select_regsistAdmin_test(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("uPhone","123456");//手机号
        map.put("uEmail","2608428799@qq.com");//邮箱
        map.put("uSex","0");//性别
        map.put("date1","2019-02-18");//注册时间1
        map.put("date2","2019-02-20");//注册时间2
        map.put("uCardId","360428199110201114");//身份证
        map.put("limit",0);
        map.put("page",5);
        System.out.println(iUserInformationDao.select_userInformation(map));
    }

    //查询用户数量
    @Test
    public void select_userInformation_count_test(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("uPhone","123456");//手机号
        map.put("uEmail","2608428799@qq.com");//邮箱
        map.put("uSex","0");//性别
        map.put("date1","2019-02-18");//注册时间1
        map.put("date2","2019-02-20");//注册时间2
        map.put("uCardId","360428199110201114");//身份证
        System.out.println(iUserInformationDao.select_userInformation_sum(map));
    }
    //用户注册
    @Test
    public void insert_Userinformation_Test(){
        Userinformation userinformation=new Userinformation("13437536684","123456");
        System.out.println(iUserInformationDao.insert_Userinformation(userinformation));
    }

    //修改用户信息
    @Test
    public void update_Userinformation_uNickName_Test(){
        //修改用户信息
        Userinformation userinformation=new Userinformation();


        //修改用户名
        userinformation.setuPassword("123123");
        userinformation.setuPhone("123456");

//        userinformation.setuNickName("李四");
//        userinformation.setuPhone("123456");
//        userinformation.setuSex(20);
//        userinformation.setuAge(1);
//        userinformation.setuState(1);
//        userinformation.setuEmail("870427500@qq.com");


        //修改密码
//        userinformation.setuPassword("123123");
//        userinformation.setuPhone("123456");

        //用户注销与启用uState
//        userinformation.setuState(1);
//        userinformation.setuPhone("123456");
        System.out.println(iUserInformationDao.update_Userinformation(userinformation));
    }

    //用户登录状态测试
    @Test
    public void logon_statusTest(){
        System.out.println(iUserInformationDao.logon_status("123456"));
    }


    //用户登录测试
    @Test
    public void sel_complaint_count(){
        iUserInformationDao.select_userInformation_count("13192262812","123456");
    }

    //MP5加密
    @Test
    public void mp5(){
    }

}