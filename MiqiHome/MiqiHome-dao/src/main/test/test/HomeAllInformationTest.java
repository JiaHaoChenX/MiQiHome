import com.miqi.miqihome.dao.IHomeAllInformationDao;
import com.miqi.miqihome.dao.IHomeRequirementReflectDao;
import com.miqi.miqihome.entity.Homeallinformation;
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

/**
 * 发布者：丁火钦
 * 房屋全部信息表（房源表）
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class HomeAllInformationTest {
    @Autowired
    IHomeAllInformationDao iHomeAllInformationDao;

    //根据id查询
    @Test
    public void select_HomeRequirementReflect_Test(){
        System.out.println(iHomeAllInformationDao.select_Homeallinformation("1"));
    }

    //查询多个
    @Test
    public void select_multi_HomeAllInformation_Test(){
        Map<String,Object> objectMap=new HashMap<String,Object>();
//        objectMap.put("haiId",1);
//        objectMap.put("htName","别墅");
//        objectMap.put("htdName",htdName);
//        objectMap.put("hsProvince",hsProvince);
       objectMap.put("hsCity","柳州");
//        objectMap.put("hsArea",hsArea);
//        objectMap.put("hdLiveNumber",hdLiveNumber);
//        objectMap.put("hSite",hSite);
//        objectMap.put("haBedroom",haBedroom);
       /* objectMap.put("hpPrice1",0);
        objectMap.put("hpPrice2",1000);*/
        objectMap.put("pages",0);
        objectMap.put("limit",5);
        /*objectMap.put("sort",2);*/
//        objectMap.put("hfdId",hfdId);
        System.out.println(iHomeAllInformationDao.select_multi_HomeAllInformation(objectMap));
    }

    //查询多个
    @Test
    public void select__HomeAllInformation_count_Test(){
        Map<String,Object> objectMap=new HashMap<String,Object>();
//        objectMap.put("haiId",1);
//        objectMap.put("htName","别墅");
//        objectMap.put("htdName",htdName);
//        objectMap.put("hsProvince",hsProvince);
        objectMap.put("hsCity","柳州");
//        objectMap.put("hsArea",hsArea);
//        objectMap.put("hdLiveNumber",hdLiveNumber);
//        objectMap.put("hSite",hSite);
//        objectMap.put("haBedroom",haBedroom);
       /* objectMap.put("hpPrice1",0);
        objectMap.put("hpPrice2",1000);*/
        /*objectMap.put("sort",2);*/
//        objectMap.put("hfdId",hfdId);
        System.out.println(iHomeAllInformationDao.select_HomeAllInformation_count(objectMap));
    }
    @Test
    public void select_multi_HomeAllInformation_order() {
        System.out.println(iHomeAllInformationDao.select_multi_HomeAllInformation_order(1, 1));
    }


    //添加房源
    @Test
    public void insert_HomeAllInformation() {
        Homeallinformation homeallinformation=new Homeallinformation();
        homeallinformation.setUiId(1);
        System.out.println(iHomeAllInformationDao.insert_HomeAllInformation(homeallinformation));
        System.out.println(homeallinformation.getHaiId());
    }
}