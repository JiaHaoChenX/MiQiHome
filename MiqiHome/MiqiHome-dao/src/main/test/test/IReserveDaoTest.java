import com.miqi.miqihome.dao.IReserveDao;
import com.miqi.miqihome.entity.Reserve;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IReserveDaoTest {

    @Autowired
    IReserveDao reserveDao;

    @Test
    public void insertReserve() {

    }

    @Test
    public void updateReserve() {
    }

    @Test
    public void selectReserves() {
        /*Reserve reserve = new Reserve();*/
        /*reserve.setRvHomeState(0);*/
        Map map = new HashMap();
        System.out.println(reserveDao.selectUserInformation(1));
    }
}