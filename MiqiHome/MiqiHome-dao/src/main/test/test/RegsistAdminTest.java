import com.miqi.miqihome.dao.IRegsistAdminDao;
import com.miqi.miqihome.dao.IUserInformationDao;
import com.miqi.miqihome.entity.Regsistadmin;
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
* 发布人：张育威
* 测试：管理员登录
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class RegsistAdminTest {
    @Autowired
    IRegsistAdminDao iRegsistAdminDao;
    //查询所有管理员
    @Test
    public void select_regsistAdmin(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("raName","");//名字
        map.put("raPhone","");//电话号码
        map.put("raEmail","");//邮箱
        map.put("raRole","");//角色
        map.put("raState","");//状态
        map.put("limit",5);
        map.put("page",0);
        System.out.println(iRegsistAdminDao.select_regsistAdmin(map));
    }
    //查询管理员数量
    @Test
    public void select_regsistAdmin_count(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("raName","老张");//名字
        map.put("raPhone","16565465654");//电话号码
        map.put("raEmail","736375819@qq.com");//邮箱
        map.put("raRole","超级管理员");//角色
        map.put("raState","1");//状态
        System.out.println(iRegsistAdminDao.select_regsistAdmin_count(map));
    }
    //管理员登录,账号密码登录
    @Test
    public void login_regsistAdmin(){
        System.out.println(iRegsistAdminDao.login_regsistAdmin("16565465654","123456"));
    }
    //管理员添加
    @Test
    public void insert_regsistAdmin(){
        Regsistadmin regsistadmin=new Regsistadmin();
        regsistadmin.setRaName("老将");
        regsistadmin.setRaPhone("15647676567");
        regsistadmin.setRaEmail("5645656@qq.com");
        regsistadmin.setRaRole("普通管理员");
        System.out.println(iRegsistAdminDao.insert_regsistAdmin(regsistadmin));
    }
    //管理员修改
    @Test
    public void update_regsistAdmin(){
        Regsistadmin regsistadmin=new Regsistadmin();
        regsistadmin.setRaName("老将");
        regsistadmin.setRaPhone("15647676567");
        regsistadmin.setRaEmail("5645656@qq.com");
        regsistadmin.setRaPassword("123456");
        regsistadmin.setRaRole("普通管理员");
        regsistadmin.setRaId(1);
        System.out.println(iRegsistAdminDao.update_regsistAdmin(regsistadmin));
    }
    //管理员注销与启用
    @Test
    public void update_regsistAdmin_raState(){
        System.out.println(iRegsistAdminDao.update_regsistAdmin_raState(0,1));
    }
    //密码重置
    @Test
    public void update_regsistAdmin_RraPassword(){
        System.out.println(iRegsistAdminDao.update_regsistAdmin_RraPassword(1));
    }
    //密码修改
    @Test
    public void update_regsist_raPassword(){
        System.out.println(iRegsistAdminDao.update_regsist_raPassword("111111",1,"16565465654"));
    }
}