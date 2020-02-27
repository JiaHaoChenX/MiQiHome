package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.ICirclesService;
import com.miqi.miqihome.Iservice.ICollegeService;
import com.miqi.miqihome.dao.ICirclesDao;
import com.miqi.miqihome.dao.ICollegeDao;
import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
*
    发布者：丁火钦
    高校
* */
@Service
public class collegeService implements ICollegeService {

    @Autowired
    ICollegeDao iCollegeDao;

    public List<College> select_College(String City) {
        return iCollegeDao.select_College(City);
    }
}
