import com.miqi.miqihome.dao.IHouseBedDao;
import com.miqi.miqihome.entity.Houseapartment;
import com.miqi.miqihome.entity.Housedetails;
import com.miqi.miqihome.entity.Housetypedetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
* 发布人：张育威
* 测试：管理员登录
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IHouseBedDaoTest {
    @Autowired
    IHouseBedDao iHouseBedDao;
    //对出租方式表的操作
    //查询
    @Test
    public void select_rentalMode(){
        System.out.println(iHouseBedDao.select_rentalMode());
    }
    //添加
    @Test
    public void insert_rentalMode(){
        System.out.println(iHouseBedDao.insert_rentalMode("33"));
    }
    //修改
    @Test
    public void update_rentalMode(){
        System.out.println(iHouseBedDao.update_rentalMode("ddd",1));
    }
    //对房屋类型表的操作
    //查询
    @Test
    public void select_houseType(){
        System.out.println(iHouseBedDao.select_houseType());
    }
    @Test
    //添加
    public void insert_houseType(){
        System.out.println(iHouseBedDao.insert_houseType("dd"));
    }
    @Test
    //修改
    public void update_houseType(){
        System.out.println(iHouseBedDao.update_houseType("dd",1));
    }
    //对房屋类型详细表(与房屋类型表之间是多对一的关系)的操作
    //查询全部
    @Test
    public void select_houseTypeDetails(){
        System.out.println(iHouseBedDao.select_houseTypeDetails());
    }
    //添加
    @Test
    public void insert_houseTypeDetails(){
        Housetypedetails housetypedetails=new Housetypedetails();
        housetypedetails.setHtdName("d");
        housetypedetails.setHtdDese("dd");
        housetypedetails.setHtId(1);
        System.out.println(iHouseBedDao.insert_houseTypeDetails(housetypedetails));
    }
    @Test
    //修改
    public void update_houseTypeDetails(){
        Housetypedetails housetypedetails=new Housetypedetails();
        housetypedetails.setHtdName("d");
        housetypedetails.setHtdDese("dd");
        housetypedetails.setHtId(1);
        housetypedetails.setHtdId(1);
        System.out.println(iHouseBedDao.update_houseTypeDetails(housetypedetails));
    }
    //对房屋景观表的操作
    //查询
    @Test
    public void select_houseScenery(){
        System.out.println(iHouseBedDao.select_houseScenery());
    }
    @Test
    //添加
    public void insert_houseScenery(){
        System.out.println(iHouseBedDao.insert_houseScenery("dd"));
    }
    @Test
    //修改
    public void update_houseScenery(){
        System.out.println(iHouseBedDao.update_houseScenery("dd",1));
    }
    //对房屋户型表的操作
    //查询
    @Test
    public void select_houseApartment(){
        System.out.println(iHouseBedDao.select_houseApartment("1"));
    }
    @Test
    //添加
    public void insert_houseApartment(){
        Houseapartment houseapartment=new Houseapartment();
        houseapartment.setHaBalcony(1);
        houseapartment.setHaBathroom(1);
        houseapartment.setHaBedroom(1);
        houseapartment.setHaBookStudy(1);
        houseapartment.setHaKitchen(1);
        houseapartment.setHaLounage(1);
        System.out.println(iHouseBedDao.insert_houseApartment(houseapartment));
        System.out.println(houseapartment.getHaId());
    }
    @Test
    //修改
    public void update_houseApartment(){
        Houseapartment houseapartment=new Houseapartment();
        houseapartment.setHaBalcony(1);
        houseapartment.setHaBathroom(1);
        houseapartment.setHaBedroom(1);
        houseapartment.setHaBookStudy(1);
        houseapartment.setHaKitchen(1);
        houseapartment.setHaLounage(1);
        houseapartment.setHaId(1);
        System.out.println(iHouseBedDao.update_houseApartment(houseapartment));
    }
    //对房屋详细表的操作
    //查询
    @Test
    public void selct_houseDetails(){
        Map<String,Object> map=new HashMap<String, Object>();
        //rmId htdId hcId haiId uiId
        map.put("rmId","");
        map.put("htdId","");
        map.put("hcId","");
        map.put("haiId","");
        map.put("uiId","1");
        System.out.println(iHouseBedDao.selct_houseDetails(map));
    }
    //添加
    @Test
    public void insert_houseDetails(){
        //hdArea,hdLiveNumber
        // ,hdHouseNumebr,rmId,htdId,hcId,haId,haiId
        Housedetails housedetails=new Housedetails();
        BigDecimal hdArea=new BigDecimal("23.4");
        housedetails.setHdArea(hdArea);
        housedetails.setHdLiveNumber(1);
        housedetails.setHdHouseNumebr(1);
        housedetails.setRmId(1);
        housedetails.setHtdId(1);
        housedetails.setHcId(1);
        housedetails.setHaId(1);
        housedetails.setHaiId(1);
        System.out.println(iHouseBedDao.insert_houseDetails(housedetails));
        System.out.println(housedetails.getHdId());
    }
    //修改
    @Test
    public void update_houseDetails(){
        //hdArea,hdLiveNumber
        // ,hdHouseNumebr,rmId,htdId,hcId,haId,haiId
        Housedetails housedetails=new Housedetails();
        BigDecimal hdArea=new BigDecimal("23.4");
        housedetails.setHdArea(hdArea);
        housedetails.setHdLiveNumber(1);
        housedetails.setHdHouseNumebr(1);
        housedetails.setRmId(1);
        housedetails.setHtdId(1);
        housedetails.setHcId(1);
        housedetails.setHaId(1);
        housedetails.setHaiId(1);
        housedetails.setHdId(1);
        System.out.println(iHouseBedDao.update_houseDetails(housedetails));
    }
    //对床型床类型表的操作
    //查询
    @Test
    public void select_houseBedType(){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("pageno",0);
        objectMap.put("pagesize",10);
        System.out.println(iHouseBedDao.select_houseBedType(objectMap));
    }
    //添加
    @Test
    public void insert_houseBedType(){
        System.out.println(iHouseBedDao.insert_houseBedType("1"));
    }
    //修改
    @Test
    public void update_houseBedType(){
        System.out.println(iHouseBedDao.update_houseBedType("3",1));
    }
    //对床型床宽高表的操作
    //zywds
    //查询床型床类型表
    @Test
    public void select_houseBedTypes(){
        System.out.println(iHouseBedDao.select_houseBedTypes());
    }
    //查询床型床类型对应宽高
    @Test
    public void select_houseBedSizes(){
        System.out.println(iHouseBedDao.select_houseBedSizes(1));
    }
    //查询总数
    @Test
    public void select_houseBedSize_count(){
        System.out.println(iHouseBedDao.select_houseBedSize_count());
    }
    //查询
    @Test
    public void select_houseBedSize(){
        Map<String ,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("pageno",0);
        objectMap.put("pagesize",100);
        System.out.println(iHouseBedDao.select_houseBedSize(objectMap));
    }
    //添加
    @Test
    public void insert_houseBedSize(){
        System.out.println(iHouseBedDao.insert_houseBedSize(1,"33"));
    }
    //修改
    @Test
    public void update_houseBedSize(){
        System.out.println(iHouseBedDao.update_houseBedSize(1,"d",1));
    }
    //对床型表(一个房子有多个床型),关联房屋详细表的操作
    //查询
    @Test
    public void select_houseBed(){
        Map<String,Object> map=new HashMap<String, Object>();
        //hdId hdsId rmId htdId hcId haiId uiId
        map.put("hdId","");
        map.put("hdsId","");
        map.put("rmId","");
        map.put("htdId","");
        map.put("hcId","");
        map.put("haiId","");
        map.put("uiId","1");
        System.out.println(iHouseBedDao.select_houseBed(map));
    }
    //添加
    @Test
    public void insert_houseBed(){
        System.out.println(iHouseBedDao.insert_houseBed(1,2,"3"));
    }
    //修改
    @Test
    public void update_houseBed(){
        System.out.println(iHouseBedDao.update_houseBed(1,1,"33",1));
    }

    //查询总数
    @Test
    public void select_count(){
        System.out.println(iHouseBedDao.select_houseBedTypeCount());
    }

    //根据房源id查询房屋详细
    @Test
    public void select_houseDetails(){
        System.out.println(iHouseBedDao.select_houseDetails("7"));
    }


    //根据房源id查询房屋详细
    @Test
    public void selct_houseDetails_haiId(){
        System.out.println(iHouseBedDao.selct_houseDetails_haiId("7"));
    }

    //根据房屋详细表id删除床型表
    @Test
    public void delete_houseBed(){
        System.out.println(iHouseBedDao.delete_houseBed(6));
    }
}