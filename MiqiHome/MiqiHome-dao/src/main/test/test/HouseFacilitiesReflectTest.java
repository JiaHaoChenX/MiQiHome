import com.miqi.miqihome.dao.IHouseDecriptionDao;
import com.miqi.miqihome.dao.IHouseFacilitiesReflectDao;
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

/***
 * 发布者：张育威
 * 操作：  房屋设施对应表测试类
 * */
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class HouseFacilitiesReflectTest {

    @Autowired
    IHouseFacilitiesReflectDao iHouseFacilitiesReflectDao;

    //对设施服务表进行的操作
    //查询设施服务表
    @Test
    public void select_houseFacilities(){
        System.out.println(iHouseFacilitiesReflectDao.select_houseFacilities());
    }
    //添加
    @Test
    public void insert_houseFacilities(){
        System.out.println(iHouseFacilitiesReflectDao.insert_houseFacilities("设施"));
    }
    //修改
    @Test
    public void update_houseFacilities(){
        System.out.println(iHouseFacilitiesReflectDao.update_houseFacilities("居家",1));
    }
    //对设施服务详细表进行操作
    //添加
    @Test
    public void insert_housefacilitiesdetails(){
        System.out.println(iHouseFacilitiesReflectDao.insert_housefacilitiesdetails(1,"人数"));
    }
    //修改
    @Test
    public void update_housefacilitiesdetails(){
        System.out.println(iHouseFacilitiesReflectDao.update_housefacilitiesdetails("人数",1,1));
    }
    //查询设施服务表与设施服务详细表
    @Test
    public void select_housefacilitiesdetails(){
        System.out.println(iHouseFacilitiesReflectDao.select_housefacilitiesdetails("",0,10));
    }
    //查询总数
    /*@Test
    public void select_housefacilitiesdetails_count(){
        System.out.println(iHouseFacilitiesReflectDao.select_housefacilitiesdetails_count("",0,10));
    }*/
    //查询设施服务表对应表（里面包括用户信息，房屋信息，设施所有信息）
    @Test
    public void select_houseFacilitiesReflect(){
        //可以选择不同的条件进行查询
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("haiId","");
        map.put("hfId","");
        map.put("hfdId","");
        map.put("hfrId","");
        map.put("uiId","1");
        System.out.println(iHouseFacilitiesReflectDao.select_houseFacilitiesReflect(map));
    }
    //添加设施服务表对应表
    @Test
    public void insert_houseFacilitiesReflect(){
        System.out.println(iHouseFacilitiesReflectDao.insert_houseFacilitiesReflect(1,1));
    }
    //修改设施服务对应表
    @Test
    public void update_houseFacilitiesReflect(){
        System.out.println(iHouseFacilitiesReflectDao.update_houseFacilitiesReflect(1,2,1));
    }
    //删除设施服务对应表信息
    @Test
    public void delete_houseFacilitiesReflect(){
        System.out.println(iHouseFacilitiesReflectDao.delete_houseFacilitiesReflect("7"));
    }

    //删除设施服务对应表信息
    @Test
    public void select_HouseFacilitiesDetails_haiId(){
        System.out.println(iHouseFacilitiesReflectDao.select_HouseFacilitiesDetails_haiId("7"));
    }

}
