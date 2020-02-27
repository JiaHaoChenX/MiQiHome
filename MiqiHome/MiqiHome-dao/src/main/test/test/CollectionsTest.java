import com.miqi.miqihome.dao.ICollectionsDao;
import com.miqi.miqihome.dao.IHomeRequirementReflectDao;
import com.miqi.miqihome.entity.Collections;
import com.miqi.miqihome.entity.Homerequirementreflect;
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
public class CollectionsTest {

    @Autowired
    ICollectionsDao collectionsDao;

    @Test
    public void select_all_collection(){
        Map<String,Object>objectMap=new HashMap<String, Object>();

        objectMap.put("pageno",0);
        objectMap.put("pagesize",2);
        List<Collections> collections=collectionsDao.select_all_collection(objectMap);
        for (Collections c:collections){
            System.out.println(c);
        }
    }


    @Test
    public void update_collection(){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("haiId",1);
        objectMap.put("cnId",1);
        int result=collectionsDao.update_collection(objectMap);
        System.out.println(result);
    }

    /**
     *  发布人：丁火钦
     *  作用  ：根据用户id查询该用户收藏的房间
     */
    @Test
    public void select_ui_collection_list_test(){
        collectionsDao.select_ui_collection_list("1");
    }
}