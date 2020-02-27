package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.ICirclesService;
import com.miqi.miqihome.Iservice.ICollectionsService;
import com.miqi.miqihome.dao.ICirclesDao;
import com.miqi.miqihome.dao.ICollectionsDao;
import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
*
    发布者：丁火钦
    商圈
* */
@Service
public class circlesService implements ICirclesService {

    @Autowired
    ICirclesDao iCirclesDao;

    public List<Circles> select_Circles(String city_name) {
        return iCirclesDao.select_Circles(city_name);
    }
}
