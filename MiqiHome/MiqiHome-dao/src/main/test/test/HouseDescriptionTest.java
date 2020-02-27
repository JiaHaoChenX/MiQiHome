import com.miqi.miqihome.dao.IHouseDecriptionDao;
import com.miqi.miqihome.entity.Housedecription;
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

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class HouseDescriptionTest {

    @Autowired
    IHouseDecriptionDao houseDecriptionDao;

    @Test
    public  void select_all_houseDecription(){
        List<Housedecription> allhouse=houseDecriptionDao.select_all_houseDecription();
        for (Housedecription h:allhouse){
            System.out.println(h);
        }
    }

    @Test
    public  void select_houseDecription_by_hdpId(){
        Housedecription h=houseDecriptionDao.select_houseDecription_by_hdpId(2);
        System.out.println(h);
    }

    @Test
    public  void select_houseDecription_by_haiId(){
        Housedecription h=houseDecriptionDao.select_houseDecription_by_haiId(2);
        System.out.println(h);
    }

    /*
    * 插入测试
    * */
    @Test
    public void insert_houseDecription(){

        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("hdpName","123");
        objectMap.put("hdpCharacteristic","123");
        objectMap.put("haiId",1);

        int affetRows=houseDecriptionDao.insert_houseDecription(objectMap);
        System.out.println(affetRows);
    }

    /*
    * 修改测试
    * */
    @Test
    public void update_houseDecription(){

        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("hdpName","123");
        objectMap.put("hdpCharacteristic","123");
        objectMap.put("hdpTraffic","123");
        objectMap.put("hdpRound","123");
        objectMap.put("haiId",2);
        objectMap.put("hdpId",1);

        int affetRows=houseDecriptionDao.update_houseDecription(objectMap);
        System.out.println(affetRows);
    }

    @Test
    public void select_all_houseDecription_count(){
        System.out.println(houseDecriptionDao.select_all_houseDecription_count());
    }


    @Test
    public void select_houseDecription_haiId(){

        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("haiId",7);

        int affetRows=houseDecriptionDao.select_houseDecription_haiId(objectMap);
        System.out.println(affetRows);
    }
}
