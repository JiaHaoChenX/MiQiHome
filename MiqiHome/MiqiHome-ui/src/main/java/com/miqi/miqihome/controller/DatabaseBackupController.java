package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IDatabaseBackupService;
import com.miqi.miqihome.common.utils.returnDataStandard;
import com.miqi.miqihome.entity.DatabaseBackup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.miqi.miqihome.common.utils.MySQLDatabaseBackup.backup;

/**
 * 发布者：张育威
 * 操作：数据库备份controller
 * */
@RestController
@RequestMapping("databaseBackup")
public class DatabaseBackupController {
    @Autowired
    IDatabaseBackupService iDatabaseBackupService;
    //查询备份信息
    @GetMapping("/select_databaseBackup")
    public returnDataStandard select_databaseBackup(int page,int limit){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iDatabaseBackupService.select_databaseBackup(page,limit));
    }
    //数据库备份
    @PostMapping("/insert_databaseBackup")
    public returnDataStandard insert_databaseBackup(HttpServletRequest request) throws InterruptedException {
        //获取当前时间，给文件命名
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH时mm分ss秒");//设置日期格式
        String dftime=df.format(new Date());
        String hostIP="127.0.0.1";String userName="root";
        //获得本地路径
        String savePath=request.getSession().getServletContext().getRealPath("databaseBackup");
        String password=".asamu.654";
        String fileName=dftime+".sql";String databaseName="homedb";
        if (backup(hostIP,userName,password,savePath,fileName,databaseName)) {
            if(iDatabaseBackupService.insert_databaseBackup(savePath,new Date())>0){
                return returnDataStandard.ok("数据库备份成功!");
            }else {
                return returnDataStandard.error("数据库备份失败!");
            }
        } else {
            return returnDataStandard.error("数据库备份失败!");
        }
    }
    //备份数量
    @GetMapping("/select_databaseBackup_count")
    public returnDataStandard select_databaseBackup_count(){
        returnDataStandard returnDataStandard=new returnDataStandard();
        return returnDataStandard.put("data",iDatabaseBackupService.select_databaseBackup_count());
    }
    //删除备份
    @DeleteMapping("/delete_databaseBackup")
    public returnDataStandard delete_databaseBackup(int dpId){
        if(iDatabaseBackupService.delete_databaseBackup(dpId)==1){
            return returnDataStandard.ok("删除成功！");
        }else{
            return returnDataStandard.error("删除失败！");
        }
    }
}
