import com.miqi.miqihome.dao.IHomeRequirementDao;
import com.miqi.miqihome.dao.IHomeRequirementReflectDao;
import com.miqi.miqihome.entity.Homerequirement;
import com.miqi.miqihome.entity.Homerequirementreflect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * 发布者：丁火钦
 * 入住规则表【对房客的要求表对应表(与房客要求表和入住规则表进行关联)】
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class HomeRequirementReflectTest {
    @Autowired
    IHomeRequirementReflectDao iHomeRequirementReflectDao;

    //查询
    @Test
    public void select_HomeRequirementReflect_Test(){
        Homerequirementreflect homerequirementreflect=new Homerequirementreflect();
        homerequirementreflect.setHrId(1);   //关联入住规则表
//        homerequirementreflect.setHreId(3);  //关联对房客的要求表
        System.out.println(iHomeRequirementReflectDao.select_Homerequirementreflect(homerequirementreflect));
    }
    //添加
    @Test
    public void insert_HomeRequirementReflect_Test(){
        Homerequirementreflect homerequirementreflect=new Homerequirementreflect();
        homerequirementreflect.setHrId(1);   //关联入住规则表
        homerequirementreflect.setHreId(3);  //关联对房客的要求表
        System.out.println(iHomeRequirementReflectDao.insert_Homerequirementreflect(homerequirementreflect));
    }



    //删除
    @Test
    public void delete_HomeRequirementReflect_Test(){
        Homerequirementreflect homerequirementreflect=new Homerequirementreflect();
        homerequirementreflect.setHrrId(1);   //关联入住规则表
        System.out.println(iHomeRequirementReflectDao.delete_Homerequirementreflect(homerequirementreflect));
    }
    //删除
    @Test
    public void delete_HomeRequirementReflect_hrId(){
        System.out.println(iHomeRequirementReflectDao.delete_HomeRequirementReflect_hrId("7"));
    }
}