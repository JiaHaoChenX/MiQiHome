import com.miqi.miqihome.dao.IPictureDao;
import com.miqi.miqihome.dao.IPictureTypeDao;
import com.miqi.miqihome.entity.Picture;
import com.miqi.miqihome.entity.Picturetype;
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
* 发布人：one
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class PictureDaoTest {

    @Autowired
    IPictureDao pictureDao;

    @Test
    public void select_all_picture(){
        List<Picture> pictures=pictureDao.select_all_picture();
        for (Picture picture:pictures){
            System.out.println(picture);
        }
    }

    @Test
    public void select_picture_by_pId(){
        List<Picture> pictures=pictureDao.select_picture_by_pId(2);
        for (Picture picture:pictures){
            System.out.println(picture);
        }
    }

    @Test
    public void select_all_img(){
        System.out.println(pictureDao.select_all_img("1"));

    }

    @Test
    public void select_picture_by_ptId(){
        List<Picture> pictures=pictureDao.select_picture_by_ptId(2);
        for (Picture picture:pictures){
            System.out.println(picture);
        }
    }

    @Test
    public void insert(){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("pId","");
        objectMap.put("pUrl","");
        objectMap.put("pPagePicture",1);
        objectMap.put("ptId",1);
        int r=pictureDao.insert_picture(objectMap);
        System.out.println("result:"+r);
        System.out.println("result:"+objectMap.get("pId"));
    }

    @Test
    public void update(){
        Map<String,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("pUrl","");
        objectMap.put("pPagePicture",1);
        objectMap.put("ptId",1);
        objectMap.put("pId",1);
        int r=pictureDao.update_picture(objectMap);
    }

    @Test
    public void delete_picture(){
        int r=pictureDao.delete_picture("2");
    }

}