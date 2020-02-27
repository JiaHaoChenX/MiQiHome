import com.miqi.miqihome.dao.IPictureTypeDao;
import com.miqi.miqihome.dao.IRegsistAdminDao;
import com.miqi.miqihome.entity.Picturetype;
import com.miqi.miqihome.entity.Regsistadmin;
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
* 发布人：张育威
* 测试：管理员登录
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class PictureTypeDaoTest {

    @Autowired
    IPictureTypeDao pictureTypeDao;

    @Test
    public void select_pictureType_by_ptId(){
        Picturetype p=pictureTypeDao.select_pictureType_by_ptId(2);
        System.out.println(p);
    }

    @Test
    public void select_pictureType_by_haiId(){
        List<Picturetype> picturetypeList=pictureTypeDao.select_pictureType_by_haiId(1);
        for (Picturetype p:picturetypeList){
            System.out.println(p);
        }
    }


    /*
    * 新增
    * */
    @Test
    public void update_pictureType(){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("ptName","123");
        objectMap.put("haiId",1);
        objectMap.put("ptId",1);

        int r=pictureTypeDao.update_pictureType(objectMap);
        System.out.println(r);
    }

    /*
    * 修改
    * */
    @Test
    public void insert_pictureType(){
        Picturetype picturetype =new Picturetype();
        picturetype.setPtName("卧室");
        picturetype.setHaiId(1);
        System.out.println(pictureTypeDao.insert_pictureType(picturetype));
        System.out.println(picturetype.getPtId());
    }
    @Test
    public void select_pictureType_haiId_ptName(){
        Picturetype picturetype =new Picturetype();
        picturetype.setPtName("卧室");
        picturetype.setHaiId(1);
        System.out.println(pictureTypeDao.select_pictureType_haiId_ptName(picturetype));
    }
    @Test
    public void select_pictureType(){
        Picturetype picturetype =new Picturetype();
        picturetype.setPtName("卧室");
        picturetype.setHaiId(1);
        System.out.println(pictureTypeDao.select_pictureType(picturetype));
    }
}