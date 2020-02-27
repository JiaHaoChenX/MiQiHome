import com.miqi.miqihome.dao.ICirclesDao;
import com.miqi.miqihome.dao.ICollectionsDao;
import com.miqi.miqihome.entity.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class CirclesTest {

    @Autowired
    ICirclesDao iCirclesDao;

    @Test
    public void select_Circles_test(){
        iCirclesDao.select_Circles("北京");
    }

}