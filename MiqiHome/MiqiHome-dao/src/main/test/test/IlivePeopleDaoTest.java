import com.miqi.miqihome.dao.IlivePeopleDao;
import com.miqi.miqihome.entity.Livepeople;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 发布人: 朱星宇
 * 测试: 入住人信息
 * 创建时间: 2019年3月4日16:18:09
 */
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IlivePeopleDaoTest {

    @Autowired
    IlivePeopleDao dao;

    @Test
    public void insert(){
        Livepeople livepeople = new Livepeople();
        livepeople.setLpName("朱先生11");
        livepeople.setLpCardId("999999999999999");
        livepeople.setRvId(2);
        livepeople.setLpId(1);
        System.out.println(dao.update(livepeople));

    }

}
