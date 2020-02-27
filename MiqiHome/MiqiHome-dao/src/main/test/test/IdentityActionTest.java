import com.miqi.miqihome.dao.IHouseDecriptionDao;
import com.miqi.miqihome.dao.IIdentityActionDao;
import com.miqi.miqihome.entity.Housedecription;
import com.miqi.miqihome.entity.Identityaction;
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
public class IdentityActionTest {

    @Autowired
    IIdentityActionDao iIdentityActionDao;

    @Test
    public void select_all_identityAction(){
        List<Identityaction> identityactionList=iIdentityActionDao.select_all_identityAction();
        for (Identityaction i:identityactionList){
            System.out.println(i);
        }
    }

    @Test
    public void select_identityAction_by_iaId(){
        Identityaction identityaction=iIdentityActionDao.select_identityAction_by_iaId(2);
        System.out.println(identityaction);
    }

    @Test
    public void insert_identityAction(){
        int i=iIdentityActionDao.insert_identityAction("abc");
        System.out.println(i);
    }

    @Test
    public void update_identityAction(){
        Map<String ,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("iaName","iaName");
        objectMap.put("iaId",1);
        int i=iIdentityActionDao.update_identityAction(objectMap);
        System.out.println(i);
    }
}