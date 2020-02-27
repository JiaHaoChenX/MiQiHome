import com.miqi.miqihome.dao.IHomeRulesDao;
import com.miqi.miqihome.dao.IReceptiontimeDao;
import com.miqi.miqihome.entity.Homerules;
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
* 测试：入住规则表【接待房客时间表(关联入住规则表)】
*
* */
//指定bean注入的配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class ReceptiontimeTest {
    @Autowired
    IReceptiontimeDao iReceptiontimeDao;

    //查询
    @Test
    public void select_Receptiontime_Test(){
        System.out.println(iReceptiontimeDao.select_Receptiontime("1"));
    }
    //添加
    @Test
    public void insert_Receptiontime_Test(){
        Receptiontime receptiontime=new Receptiontime();
        receptiontime.setRtStartTime("08:00");
        receptiontime.setRtEndTime("10:00");
        receptiontime.setHrId(1);
        System.out.println(iReceptiontimeDao.insert_Receptiontime(receptiontime));
    }


    //修改
    @Test
    public void update_Receptiontime_Test(){
        Receptiontime receptiontime=new Receptiontime();
        receptiontime.setRtId(1);
        receptiontime.setRtStartTime("08:00");
        receptiontime.setRtEndTime("10:00");
        System.out.println(iReceptiontimeDao.update_Receptiontime(receptiontime));
    }

    //删除
    @Test
    public void delete_Receptiontime_Test(){
        Receptiontime receptiontime=new Receptiontime();
        receptiontime.setRtId(1);
        System.out.println(iReceptiontimeDao.delete_Receptiontime(receptiontime));
    }

    //根据id删除
    @Test
    public void delete_Receptiontime_haiId(){
        System.out.println(iReceptiontimeDao.delete_Receptiontime_haiId("7"));
    }

}