package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHouseSiteService;
import com.miqi.miqihome.dao.IHouseSiteDao;
import com.miqi.miqihome.entity.Geography;
import com.miqi.miqihome.entity.Housesite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 发布人：xyz
* 房屋位置表
*
* */
@Service
public class HouseSiteService implements IHouseSiteService {

    @Autowired
    IHouseSiteDao houseSiteDao;

    public int insertHouseSite(Housesite housesite) {
        return houseSiteDao.insertHouseSite(housesite);
    }

    public int updateHouseSite(Housesite housesite) {
        return houseSiteDao.updateHouseSite(housesite);
    }

    public Housesite selectHouseSite(int haiId) {
        return houseSiteDao.selectHouseSite(haiId);
    }


    /**
     * 查询城市
     */
    public List<Geography> select_geography(String region) {
        return houseSiteDao.select_geography(region);
    }
}
