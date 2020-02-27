import com.miqi.miqihome.dao.IEvaluateDao;
import com.miqi.miqihome.entity.Evaluate;
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

/**
 *
 * * 发布者：one
 * * 房屋评价表 增删改查
 */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class EvaluateTest {

    @Autowired
    IEvaluateDao evaluateDao;

    @Test
    public void select_all_evaluate(){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("uiId",2);
        objectMap.put("pageno",0);
        objectMap.put("pagesize",100);
        List<Evaluate> evaluates=evaluateDao.select_all_evaluate(objectMap);
        for (Evaluate e:evaluates){
            System.out.println(e);
        }
    }

    @Test
    public void insert_evaluate(){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("eHygiene","2");
        objectMap.put("eCostPerformance","2");
        int result=evaluateDao.insert_evaluate(objectMap);
        System.out.println(result);
    }

    @Test
    public void update_evaluate(){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("eHygiene","2");
        objectMap.put("eCostPerformance","2");
        objectMap.put("eid",1);
        int result=evaluateDao.update_evaluate(objectMap);
        System.out.println(result);
    }

    @Test
    public void delete_evaluate(){
        int result=evaluateDao.delete_evaluate(1);
        System.out.println(result);
    }
}
