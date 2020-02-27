package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.ICollectionsService;
import com.miqi.miqihome.Iservice.IHomepriceService;
import com.miqi.miqihome.dao.ICollectionsDao;
import com.miqi.miqihome.dao.IHomePriceDao;
import com.miqi.miqihome.entity.Collections;
import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.Homeprice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
*
    发布者：丁火钦
    房源价格
* */
@Service
public class homepriceService implements IHomepriceService {

    @Autowired
    IHomePriceDao iHomePriceDao;
    //添加
    public int insert_homePrice(Homeprice homeprice) {
        return iHomePriceDao.insert_homePrice(homeprice);
    }
    //根据房源id查询信息
    public Homeprice select_homePrice_haiId(String haiId) {
        return iHomePriceDao.select_homePrice_haiId(haiId);
    }
    //修改
    public int update_homePrice(Homeprice homeprice) {
        return iHomePriceDao.update_homePrice(homeprice);
    }
    //添加连住折扣表
    public int insert_continuousDiscount(String cdDay, String cdDiscount, String hpId) {
        return iHomePriceDao.insert_continuousDiscount(cdDay,cdDiscount,hpId);
    }
    //根据房源id查询所有信息【包括折扣表】
    public Homeprice select_arr_homePrice_haiId(String haiId) {
        return iHomePriceDao.select_arr_homePrice_haiId(haiId);
    }
    //删除连住折扣表
    public int delete_continuousDiscount(String hpId) {
        return iHomePriceDao.delete_continuousDiscount(hpId);
    }
}
