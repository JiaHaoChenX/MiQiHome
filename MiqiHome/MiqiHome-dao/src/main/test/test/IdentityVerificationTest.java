import com.miqi.miqihome.dao.IIdentityActionDao;
import com.miqi.miqihome.dao.IIdentityverificationDao;
import com.miqi.miqihome.entity.Identityaction;
import com.miqi.miqihome.entity.Identityverification;
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
public class IdentityVerificationTest {

    @Autowired
    IIdentityverificationDao iIdentityverificationDao;

    @Test
    public void select_all_identityVerification(){
        Map<String,Object> objectMap=new HashMap<String, Object>();
        objectMap.put("uiId",2);
        List<Identityverification> identityverifications=iIdentityverificationDao.select_all_identityVerification(objectMap);
        for (Identityverification i:identityverifications){
            System.out.println(i);
        }
    }

    @Test
    public void insert_identityVerification(){
        Identityverification identityverification=new Identityverification();
        identityverification.setIvName("书店");
        identityverification.setIvUIDName("张三");
        identityverification.setIvUIDNo("123123123");
        identityverification.setIvUrl("int");
        identityverification.setHaiId(7);
        System.out.println(iIdentityverificationDao.insert_identityVerification(identityverification));
    }

    @Test
    public void update_identityVerification(){
        Identityverification identityverification=new Identityverification();
        identityverification.setIvName("书店");
        identityverification.setIvUIDName("张三");
        identityverification.setIvUIDNo("123123123");
        identityverification.setIvUrl("int");
        identityverification.setHaiId(6);
        int r=iIdentityverificationDao.update_identityVerification(identityverification);
        System.out.println(r);
    }

    @Test
    public void select_identityVerification(){
        Identityverification identityverification=new Identityverification();
        identityverification.setIvName("书店");
        identityverification.setIvUIDName("张三");
        identityverification.setIvUIDNo("123123123");
        identityverification.setIvUrl("int");
        identityverification.setHaiId(7);
        System.out.println(iIdentityverificationDao.select_identityVerification(identityverification));
    }

    @Test
    public void select_identityVerification_haiId(){
        System.out.println(iIdentityverificationDao.select_identityVerification_haiId("1"));
    }
    @Test
    public void select_identityVerification_haiId2(){
        System.out.println(iIdentityverificationDao.select_identityVerification_haiId2("7"));
    }
}