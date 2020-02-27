package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHouseDescriptionService;
import com.miqi.miqihome.dao.IHouseDecriptionDao;
import com.miqi.miqihome.entity.Housedecription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * * 发布者：one
 * * 房屋描述表的增、改、查 以及相关信息表的查询
 */

@Service
public class houseDescriptionService  implements IHouseDescriptionService {

    @Autowired
    IHouseDecriptionDao houseDecriptionDao;

    public List<Housedecription> select_all_houseDecription() {
        return houseDecriptionDao.select_all_houseDecription();
    }

    public Housedecription select_houseDecription_by_hdpId(int hdpId) {
        return houseDecriptionDao.select_houseDecription_by_hdpId(hdpId);
    }

    public Housedecription select_houseDecription_by_haiId(int haiId) {
        return houseDecriptionDao.select_houseDecription_by_haiId(haiId);
    }

    public int insert_houseDecription(Map<String, Object> objectMap) {
        return houseDecriptionDao.insert_houseDecription(objectMap);
    }

    public int update_houseDecription(Map<String, Object> objectMap) {
        return houseDecriptionDao.update_houseDecription(objectMap);
    }

    public int select_all_houseDecription_count() {
        return houseDecriptionDao.select_all_houseDecription_count();
    }

    public int select_houseDecription_haiId(Map<String, Object> objectMap) {
        return houseDecriptionDao.select_houseDecription_haiId(objectMap);
    }
}
