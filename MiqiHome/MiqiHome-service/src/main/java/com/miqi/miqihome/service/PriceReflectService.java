package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHouseSiteService;
import com.miqi.miqihome.Iservice.IPriceReflectService;
import com.miqi.miqihome.dao.IPriceReflectDao;
import com.miqi.miqihome.entity.Housesite;
import com.miqi.miqihome.entity.Pricereflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 房屋多种价格对应表
* 发布人：xyz
* */
@Service
public class PriceReflectService implements IPriceReflectService {

    @Autowired
    IPriceReflectDao priceReflectDao;


    public int insertPricereflect(Pricereflect pricereflect) {
        return priceReflectDao.insertPricereflect(pricereflect);
    }


    public int insertPricereflects(List<Pricereflect> list) {
        return priceReflectDao.insertPricereflects(list);
    }

    public int updatePricereflect(Pricereflect pricereflect) {
        return priceReflectDao.updatePricereflect(pricereflect);
    }

    public int deletePricereflects(List list) {
        return priceReflectDao.deletePricereflects(list);
    }

    public List<Pricereflect> selectPricereflects(int haiId) {
        return priceReflectDao.selectPricereflects(haiId);
    }
}
