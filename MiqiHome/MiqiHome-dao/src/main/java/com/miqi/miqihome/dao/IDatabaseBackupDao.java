package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.DatabaseBackup;
import javafx.scene.chart.PieChart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 发布者：张育威
 * 操作：数据库备份接口
 * */
public interface IDatabaseBackupDao {
    //查询备份数据
    List<DatabaseBackup> select_databaseBackup(@Param("page") int page,@Param("limit") int limit);
    //备份数据库
    int insert_databaseBackup(@Param("dpPath") String dpPath, @Param("dpFTime") Date dpFTime);
    //查询数量
    int select_databaseBackup_count();
    //删除备份
    int delete_databaseBackup(int dpId);
}
