package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IDatabaseBackupService;
import com.miqi.miqihome.dao.IDatabaseBackupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 发布者：张育威
 * 操作：数据库备份service
 * */
@Service
public class DatabaseBackup implements IDatabaseBackupService {
    @Autowired
    IDatabaseBackupDao iDatabaseBackupDao;


    public List<com.miqi.miqihome.entity.DatabaseBackup> select_databaseBackup(int page, int limit) {
        return iDatabaseBackupDao.select_databaseBackup(page,limit);
    }

    public int insert_databaseBackup(String dpPath, Date dpFTime) {
        return iDatabaseBackupDao.insert_databaseBackup(dpPath,dpFTime);
    }

    public int select_databaseBackup_count() {
        return iDatabaseBackupDao.select_databaseBackup_count();
    }

    public int delete_databaseBackup(int dpId) {
        return iDatabaseBackupDao.delete_databaseBackup(dpId);
    }
}
