import com.miqi.miqihome.dao.IHomeRequirementDao;
import com.miqi.miqihome.dao.IReceptiontimeDao;
import com.miqi.miqihome.entity.Homerequirement;
import com.miqi.miqihome.entity.Receptiontime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/*
* 发布人：丁火钦
* 测试：入住规则表【对房客的要求表】
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class HomeRequirementTest {
    @Autowired
    IHomeRequirementDao iHomeRequirementDao;

    //查询
    @Test
    public void select_HomeRequirement_Test(){
        Homerequirement homerequirement=new Homerequirement();
        homerequirement.setHreId(2);
        homerequirement.setHreName("带");
        System.out.println(iHomeRequirementDao.select_Homerequirement(homerequirement));
    }
    //添加
    @Test
    public void insert_HomeRequirement_Test(){
        Homerequirement homerequirement=new Homerequirement();
        homerequirement.setHreName("新添加");
        System.out.println(iHomeRequirementDao.insert_Homerequirement(homerequirement));
    }


    //修改
    @Test
    public void update_HomeRequirement_Test(){
        Homerequirement homerequirement=new Homerequirement();
        homerequirement.setHreId(1);
        homerequirement.setHreName("新修改");
        System.out.println(iHomeRequirementDao.update_Homerequirement(homerequirement));
    }


    //删除
    @Test
    public void delete_HomeRequirement_Test(){
        Homerequirement homerequirement=new Homerequirement();
        homerequirement.setHreId(9);
        System.out.println(iHomeRequirementDao.delete_Homerequirement(homerequirement));
    }
}