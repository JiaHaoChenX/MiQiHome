import com.miqi.miqihome.dao.IDatabaseBackupDao;
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
public class DatabaseBackupTest {
    @Autowired
    IDatabaseBackupDao iDatabaseBackupDao;
    //查询备份数据
    @Test
    public void select_databaseBackup(){
        System.out.println(iDatabaseBackupDao.select_databaseBackup(0,1));
    }
    //删除备份
    @Test
    public void delete_databaseBackup(){
        System.out.println(iDatabaseBackupDao.delete_databaseBackup(1));
    }
    //查询数量
    @Test
    public void select_databaseBackup_count(){
        System.out.println(iDatabaseBackupDao.select_databaseBackup_count());
    }
}