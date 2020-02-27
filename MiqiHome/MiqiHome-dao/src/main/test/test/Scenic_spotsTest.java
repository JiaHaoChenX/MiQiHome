import com.miqi.miqihome.dao.ICollectionsDao;
import com.miqi.miqihome.dao.IScenic_spotsDao;
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
    发布者：one
    房屋收藏表 增删改查
* */

//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class Scenic_spotsTest {

    @Autowired
    IScenic_spotsDao iScenic_spotsDao;

    @Test
    public void select_Scenic_spots_test(){
        iScenic_spotsDao.select_Scenic_spots("北京");
    }
}