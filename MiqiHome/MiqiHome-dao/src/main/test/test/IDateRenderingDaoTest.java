import com.miqi.miqihome.dao.IDateRenderingDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IDateRenderingDaoTest {

    @Autowired
    IDateRenderingDao dao;
    @Test
    public void selectReserveDate() {
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        System.out.println(dao.selectReserveDate(1,"2019-06-02 00:00:00","2019-06-09 00:00:00"));
    }

    @Test
    public void selectReserve() {
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        System.out.println(dao.selectReserve(1,"2019-06-02 00:00:00","2019-06-10 00:00:00"));
    }
}