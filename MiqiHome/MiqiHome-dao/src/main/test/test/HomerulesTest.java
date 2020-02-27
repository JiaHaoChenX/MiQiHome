import com.miqi.miqihome.dao.IHomeRulesDao;
import com.miqi.miqihome.dao.IUserInformationDao;
import com.miqi.miqihome.entity.Homerules;
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
* 测试：入住规则
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class HomerulesTest {
    @Autowired
    IHomeRulesDao iHomeRulesDao;

    //查询
    @Test
    public void select_HomeRules_Test(){
        System.out.println(iHomeRulesDao.select_HomeRules("1"));
    }
    //添加
    @Test
    public void insert_HomeRules_Test(){
        Homerules homerules=new Homerules();
        homerules.setHrCheckin("12:00");       //房客入住时间
        homerules.setHrCheckout("22:00");      //房客退房时间
        homerules.setHrproscenium(1);    //是否有前台（0：否 1：是）
        homerules.setHrSex(2);           //接待性别(0:不限  1:男  2:女)
        homerules.setHrSpecialage(1);    //接待特殊年龄段(0:儿童（0-12）  1:老人（65岁以上）)
        homerules.setHrHygiene("1客1扫");       //多久提供打扫卫生
        homerules.setHrSheets("1客1换");        //多久提供被单更换
        homerules.setHrTip("水电燃气费、额外打扫费用、入住所需证件");           //入住提示
        homerules.setHaiId(1);           //关联房屋全部信息表
        System.out.println(iHomeRulesDao.insert_HomeRules(homerules));
        System.out.println(homerules.getHrId());
    }


    //添加
    @Test
    public void update_HomeRules_Test(){
        Homerules homerules=new Homerules();
        homerules.setHrId(1);       //房客入住时间
        homerules.setHrCheckin("12:00");       //房客入住时间
        homerules.setHrCheckout("22:00");      //房客退房时间
//        homerules.setHrproscenium(1);    //是否有前台（0：否 1：是）
//        homerules.setHrSex(2);           //接待性别(0:不限  1:男  2:女)
//        homerules.setHrSpecialage(1);    //接待特殊年龄段(0:儿童（0-12）  1:老人（65岁以上）)
//        homerules.setHrHygiene("1客1扫");       //多久提供打扫卫生
//        homerules.setHrSheets("1客1换");        //多久提供被单更换
//        homerules.setHrTip("水电燃气费、额外打扫费用、入住所需证件");           //入住提示
        homerules.setHaiId(1);           //关联房屋全部信息表
        System.out.println(iHomeRulesDao.update_HomeRules(homerules));
    }


    @Test
    public void select_HomeRules_haiId(){
        System.out.println(iHomeRulesDao.select_HomeRules_haiId("7"));
    }
}