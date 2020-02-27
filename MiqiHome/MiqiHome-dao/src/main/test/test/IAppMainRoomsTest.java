import com.miqi.miqihome.dao.IAppMainRoomsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * 作者: xyz
 * 更新时间: 2019年3月8日10:17:18
 * 描述: 手机端 上房
 */
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IAppMainRoomsTest {

    @Autowired
    IAppMainRoomsDao dao;

    @Test
    public void selectmainrooms() {
        System.out.println(dao.selectmainrooms(17));
    }
}