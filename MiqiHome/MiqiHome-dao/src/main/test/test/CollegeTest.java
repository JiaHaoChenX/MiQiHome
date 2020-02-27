import com.miqi.miqihome.dao.ICirclesDao;
import com.miqi.miqihome.dao.ICollegeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/*
*
    发布者：丁火钦
    商圈
* */

//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class CollegeTest {

    @Autowired
    ICollegeDao iCollegeDao;

    @Test
    public void select_Circles_test(){
        iCollegeDao.select_College("北京");
    }

}