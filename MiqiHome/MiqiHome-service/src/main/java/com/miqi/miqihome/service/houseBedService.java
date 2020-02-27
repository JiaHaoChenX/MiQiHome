package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHouseBedService;
import com.miqi.miqihome.dao.IHouseBedDao;
import com.miqi.miqihome.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 发布者
 * 操作 房屋详细服务层实现
 * */
@Service
public class houseBedService implements IHouseBedService {
    @Autowired
    IHouseBedDao iHouseBedDao;
    public List<Rentalmode> select_rentalMode() {
        return iHouseBedDao.select_rentalMode();
    }

    public int insert_rentalMode(String rmName) {
        return iHouseBedDao.insert_rentalMode(rmName);
    }

    public int update_rentalMode(String rmName, int rmId) {
        return iHouseBedDao.update_rentalMode(rmName,rmId);
    }

    public List<Housetype> select_houseType() {
        return iHouseBedDao.select_houseType();
    }

    public int insert_houseType(String htName) {
        return iHouseBedDao.insert_houseType(htName);
    }

    public int update_houseType(String htName, int htId) {
        return iHouseBedDao.update_houseType(htName,htId);
    }

    public List<Housetypedetails> select_houseTypeDetails() {
        return iHouseBedDao.select_houseTypeDetails();
    }

    public int insert_houseTypeDetails(Housetypedetails housetypedetails) {
        return iHouseBedDao.insert_houseTypeDetails(housetypedetails);
    }

    public int update_houseTypeDetails(Housetypedetails housetypedetails) {
        return iHouseBedDao.update_houseTypeDetails(housetypedetails);
    }

    public List<Housescenery> select_houseScenery() {
        return iHouseBedDao.select_houseScenery();
    }

    public int insert_houseScenery(String hcName) {
        return iHouseBedDao.insert_houseScenery(hcName);
    }

    public int update_houseScenery(String hcName, int hcId) {
        return iHouseBedDao.update_houseScenery(hcName,hcId);
    }

    public Houseapartment select_houseApartment(String haiid) {
        return iHouseBedDao.select_houseApartment(haiid);
    }

    public int insert_houseApartment(Houseapartment houseapartment) {
        return iHouseBedDao.insert_houseApartment(houseapartment);
    }

    public int update_houseApartment(Houseapartment houseapartment) {
        return iHouseBedDao.update_houseApartment(houseapartment);
    }

    public List<Housedetails> selct_houseDetails(Map<String, Object> map) {
        return iHouseBedDao.selct_houseDetails(map);
    }

    public int insert_houseDetails(Housedetails housedetails) {
        return iHouseBedDao.insert_houseDetails(housedetails);
    }

    public int update_houseDetails(Housedetails housedetails) {
        return iHouseBedDao.update_houseDetails(housedetails);
    }

    public int select_houseBedTypeCount() {
        return iHouseBedDao.select_houseBedTypeCount();
    }

    public List<Housebedtype> select_houseBedType(Map<String,Object>objectMap) {
        return iHouseBedDao.select_houseBedType(objectMap);
    }

    public int insert_houseBedType(String hbtName) {
        return iHouseBedDao.insert_houseBedType(hbtName);
    }

    public int update_houseBedType(String hbtName, int hbtId) {
        return iHouseBedDao.update_houseBedType(hbtName,hbtId);
    }

    public List<Housebedtype> select_houseBedTypes() {
        return iHouseBedDao.select_houseBedTypes();
    }

    public List<Housebedsize> select_houseBedSizes(int hbtId) {
        return iHouseBedDao.select_houseBedSizes(hbtId);
    }

    public int select_houseBedSize_count() {
        return iHouseBedDao.select_houseBedSize_count();
    }

    public List<Housebedsize> select_houseBedSize(Map<String,Object>objectMap) {
        return iHouseBedDao.select_houseBedSize(objectMap);
    }

    public int insert_houseBedSize(int hbtId, String hbsSize) {
        return iHouseBedDao.insert_houseBedSize(hbtId,hbsSize);
    }

    public int update_houseBedSize(int hbtId, String hbsSize, int hdsId) {
        return iHouseBedDao.update_houseBedSize(hbtId,hbsSize,hdsId);
    }

    public List<Housebed> select_houseBed(Map<String, Object> map) {
        return iHouseBedDao.select_houseBed(map);
    }

    public int insert_houseBed(int hdId, int hdsId, String hbtNumber) {
        return iHouseBedDao.insert_houseBed(hdId,hdsId,hbtNumber);
    }

    public int update_houseBed(int hdId, int hdsId, String hbtNumber, int hbId) {
        return iHouseBedDao.update_houseBed(hdId,hdsId,hbtNumber,hbId);
    }

    //根据房源id查询房屋详细
    public Homeallinformation select_houseDetails(String haiId) {
        return iHouseBedDao.select_houseDetails(haiId);
    }

    //根据房屋id查询houseDetails表是否存在
    public Housedetails selct_houseDetails_haiId(String haiId) {
        return iHouseBedDao.selct_houseDetails_haiId(haiId);
    }
    //根据房屋详细表id删除
    public int delete_houseBed(int hdId) {
        return iHouseBedDao.delete_houseBed(hdId);
    }
}
