import com.miqi.miqihome.dao.IHouseSiteDao;
import com.miqi.miqihome.entity.Housesite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;
/*
 * 发布人：xyz
 * 测试：房屋位置 添、删、改
 * 2019年2月19日10:13:41
 * */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IHouseSiteDaoTest {

    @Autowired
    IHouseSiteDao iHouseSiteDao;

    @Test
    public void insertHouseSite() {

        //String 转 BigDecimal
        //构造以字符串内容为值的BigDecimal类型的变量bd
        BigDecimal hsLongitude=new BigDecimal("39.93437");
        //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
        hsLongitude = hsLongitude.setScale(5, BigDecimal.ROUND_DOWN);
        BigDecimal hsLatitude=new BigDecimal("116.45");
        hsLatitude = hsLatitude.setScale(5, BigDecimal.ROUND_DOWN);
        System.out.println(hsLatitude);
        Housesite housesite = new Housesite(0,"中国大陆","北京市","北京","东城区","东中街"
                ,"","",hsLongitude,hsLatitude,1);

        System.out.println(iHouseSiteDao.insertHouseSite(housesite));
    }

    @Test
    public void updateHouseSite() {
        BigDecimal hsLongitude=new BigDecimal("39.934572");
        //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
        hsLongitude = hsLongitude.setScale(5, BigDecimal.ROUND_DOWN);
        BigDecimal hsLatitude=new BigDecimal("116.442993");
        hsLatitude = hsLatitude.setScale(5, BigDecimal.ROUND_DOWN);
        System.out.println(hsLatitude);
        Housesite housesite = new Housesite(1,"中国大陆","北京市","北京","东城区","东中街"
                ,"","",hsLongitude,hsLatitude,1);

        System.out.println(iHouseSiteDao.updateHouseSite(housesite));
    }

    @Test
    public void selectHouseSite() {


        /*//String 转 BigDecimal
        //构造以字符串内容为值的BigDecimal类型的变量bd
        BigDecimal bd=new BigDecimal("39.934");
        //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
        bd = bd.setScale(5, BigDecimal.ROUND_DOWN);
        System.out.println(bd.toString());*/

        System.out.println(iHouseSiteDao.selectHouseSite(1));
    }


    @Test
    public void select_geography_test() {
        iHouseSiteDao.select_geography("A");
    }


}