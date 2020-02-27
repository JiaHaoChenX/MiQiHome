package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHouseFacilitiesReflectService;
import com.miqi.miqihome.dao.IHouseFacilitiesReflectDao;
import com.miqi.miqihome.entity.HouseFacilities;
import com.miqi.miqihome.entity.HouseFacilitiesReflect;
import com.miqi.miqihome.entity.Housefacilitiesdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 发布者: 张育威
 * 操作： 房屋设施服务对应表服务层实现
 * */


@Service
public class houseFacilitiesReflectService implements IHouseFacilitiesReflectService {
    @Autowired
    IHouseFacilitiesReflectDao iHouseFacilitiesReflectDao;
    //查询设施服务表
    public List<HouseFacilities> select_houseFacilities() {
        return iHouseFacilitiesReflectDao.select_houseFacilities();
    }

    //对设施服务表进行的操作
    //添加
    public int insert_houseFacilities(String hfName) {
        return iHouseFacilitiesReflectDao.insert_houseFacilities(hfName);
    }
    //修改
    public int update_houseFacilities(String hfName, int hfId) {
        return iHouseFacilitiesReflectDao.update_houseFacilities(hfName,hfId);
    }
    //对设施服务详细表进行操作
    //添加
    public int insert_housefacilitiesdetails(int hfId, String hfdName) {
        return iHouseFacilitiesReflectDao.insert_housefacilitiesdetails(hfId,hfdName);
    }
    //修改
    public int update_housefacilitiesdetails(String hfdName, int hfId, int hfdId) {
        return iHouseFacilitiesReflectDao.update_housefacilitiesdetails(hfdName,hfId,hfdId);
    }
    //查询设施服务表与设施服务详细表
    public List<Housefacilitiesdetails> select_housefacilitiesdetails(String hfId,int page,int limit) {
        return iHouseFacilitiesReflectDao.select_housefacilitiesdetails(hfId,page,limit);
    }
    //查询设施服务表对应表（里面包括用户信息，房屋信息，设施所有信息）
    public List<HouseFacilitiesReflect> select_houseFacilitiesReflect(Map<String, Object> map) {
        return iHouseFacilitiesReflectDao.select_houseFacilitiesReflect(map);
    }
    //添加设施服务表对应表
    public int insert_houseFacilitiesReflect(int haiId, int hfdId) {
        return iHouseFacilitiesReflectDao.insert_houseFacilitiesReflect(haiId,hfdId);
    }
    //修改设施服务对应表
    public int update_houseFacilitiesReflect(int haiId, int hfdId, int hfrId) {
        return iHouseFacilitiesReflectDao.update_houseFacilitiesReflect(haiId,hfdId,hfrId);
    }
    //删除设施服务对应表信息
    public int delete_houseFacilitiesReflect(String haiId) {
        return iHouseFacilitiesReflectDao.delete_houseFacilitiesReflect(haiId);
    }
    //根据房源id查询设施服务
    public List<HouseFacilitiesReflect> select_HouseFacilitiesDetails_haiId(String haiId) {
        return iHouseFacilitiesReflectDao.select_HouseFacilitiesDetails_haiId(haiId);
    }
}
