package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IScenic_spotsService;
import com.miqi.miqihome.Iservice.IUserInformationService;
import com.miqi.miqihome.dao.IScenic_spotsDao;
import com.miqi.miqihome.dao.IUserInformationDao;
import com.miqi.miqihome.entity.Scenic_spots;
import com.miqi.miqihome.entity.Userinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
* 发布人：丁火钦
 * 功能：根据城市名称查询该城市的景点
* */
@Service
public class scenic_spotsService implements IScenic_spotsService{

    @Autowired
    IScenic_spotsDao iScenic_spotsDao;

    //查询
    public List<Scenic_spots> select_Scenic_spots(String City) {
        return iScenic_spotsDao.select_Scenic_spots(City);
    }
}
