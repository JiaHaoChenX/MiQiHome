import com.miqi.miqihome.dao.IPriceReflectDao;
import com.miqi.miqihome.entity.Pricereflect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IPriceReflectDaoTest {

    @Autowired
    IPriceReflectDao priceReflectDao;

    @Test
    public void insertPriceReflect() {
        /*BigDecimal bd=new BigDecimal("254");
        Pricereflect pricereflect = new Pricereflect(bd,new Date(),1);
        System.out.println(priceReflectDao.insertPricereflect(pricereflect));
        System.out.println(pricereflect);*/

        List<Pricereflect> list = new ArrayList<Pricereflect>();
        list.add(new Pricereflect(new BigDecimal("254"),new Date(),1));
        list.add(new Pricereflect(new BigDecimal("254"),new Date(),1));
        list.add(new Pricereflect(new BigDecimal("254"),new Date(),1));
        list.add(new Pricereflect(new BigDecimal("254"),new Date(),1));
        System.out.println(priceReflectDao.insertPricereflects(list));

    }

    @Test
    public void updatePriceReflect() {
        BigDecimal bd=new BigDecimal("254");
        Pricereflect pricereflect = new Pricereflect(bd,new Date(),1);
        pricereflect.setPrId(1);
        System.out.println(priceReflectDao.updatePricereflect(pricereflect));
    }

    @Test
    public void deletePriceReflects() {
        List list = new ArrayList();
        list.add(1);
        System.out.println(priceReflectDao.deletePricereflects(list));
    }

    @Test
    public void selectPricereflects() {
        System.out.println(priceReflectDao.selectPricereflects(1));
    }
}