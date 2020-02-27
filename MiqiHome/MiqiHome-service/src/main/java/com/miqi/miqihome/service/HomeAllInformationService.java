package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHomeAllInformationService;
import com.miqi.miqihome.Iservice.IHomeRequirementReflectService;
import com.miqi.miqihome.dao.IHomeAllInformationDao;
import com.miqi.miqihome.dao.IHomeRequirementReflectDao;
import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.Homerequirementreflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * * 发布者：丁火钦
 * 房屋全部信息表（房源表）
 */
@Service
public class HomeAllInformationService implements IHomeAllInformationService {

    @Autowired
    IHomeAllInformationDao iHomeAllInformationDao;

    //根据id查询
    public Homeallinformation select_Homeallinformation(String haiId) {
        return iHomeAllInformationDao.select_Homeallinformation(haiId);
    }
    //查询多个
    public List<Homeallinformation> select_multi_HomeAllInformation(Map<String, Object> objectMap) {
        return iHomeAllInformationDao.select_multi_HomeAllInformation(objectMap);
    }

    public List<Homeallinformation> select_multi_HomeAllInformation_order(int uiId, int haiId) {
        return iHomeAllInformationDao.select_multi_HomeAllInformation_order(uiId,haiId);
    }

    //查询数量
    public int select_HomeAllInformation_count(Map<String, Object> objectMap) {
        return iHomeAllInformationDao.select_HomeAllInformation_count(objectMap);
    }

    //根据用户id查询该用户发布的房源
    public List<Homeallinformation> select_ui_HomeAllInformation(String uiId) {
        return iHomeAllInformationDao.select_ui_HomeAllInformation(uiId);
    }

    //添加房源
    public int insert_HomeAllInformation(Homeallinformation uiId) {
        return iHomeAllInformationDao.insert_HomeAllInformation(uiId);
    }

    //
}
