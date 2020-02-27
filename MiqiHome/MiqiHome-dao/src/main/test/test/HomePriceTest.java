import com.miqi.miqihome.dao.ICirclesDao;
import com.miqi.miqihome.dao.IHomePriceDao;
import com.miqi.miqihome.entity.Homeprice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

/*
*
    发布者：丁火钦
    房屋价格
* */

//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class HomePriceTest {

    @Autowired
    IHomePriceDao iHomePriceDao;

    //添加
    @Test
    public void insert_homePrice(){
        Homeprice homeprice=new Homeprice();
        homeprice.setHpPrice(BigDecimal.valueOf(299.00));//'售卖价格'
        homeprice.setCdLeastDay(3);//'最少起订天数'
        homeprice.setCdDeposit(BigDecimal.valueOf(299.00));//'收取住房押金'
        homeprice.setCdFullrefund(2);//'入住前几天全额退款'
        homeprice.setCdSomeRefund(BigDecimal.valueOf(0.2));//'除此之外，收取住房费百分之多少(50%)，在这里为0.5'
        homeprice.setHaiId(1);
        System.out.println(iHomePriceDao.insert_homePrice(homeprice));
        System.out.println(homeprice.getHpId());
    }
//    根据房源id查询信息
    @Test
    public void select_homePrice_haiId(){
        System.out.println(iHomePriceDao.select_homePrice_haiId("7"));
    }
    //修改
    @Test
    public void update_homePrice(){
        Homeprice homeprice=new Homeprice();
        homeprice.setHpPrice(BigDecimal.valueOf(300.00));//'售卖价格'
        homeprice.setCdLeastDay(3);//'最少起订天数'
        homeprice.setCdDeposit(BigDecimal.valueOf(299.00));//'收取住房押金'
        homeprice.setCdFullrefund(2);//'入住前几天全额退款'
        homeprice.setCdSomeRefund(BigDecimal.valueOf(0.2));//'除此之外，收取住房费百分之多少(50%)，在这里为0.5'
        homeprice.setHaiId(1);
        System.out.println(iHomePriceDao.update_homePrice(homeprice));
    }
    //添加连住折扣表
    @Test
    public void insert_continuousDiscount(){
        System.out.println(iHomePriceDao.insert_continuousDiscount("2","0.4","14"));
    }

    @Test
    public void select_arr_homePrice_haiId(){
        System.out.println(iHomePriceDao.select_arr_homePrice_haiId("7"));
    }

    @Test
    public void delete_continuousDiscount(){
        System.out.println(iHomePriceDao.delete_continuousDiscount("14"));
    }
}