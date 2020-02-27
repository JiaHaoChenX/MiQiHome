package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHomeRulesService;
import com.miqi.miqihome.Iservice.IUserInformationService;
import com.miqi.miqihome.dao.IHomeRulesDao;
import com.miqi.miqihome.dao.IUserInformationDao;
import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.Homerules;
import com.miqi.miqihome.entity.Userinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* 发布人：丁火钦
* 入住规则
* */
@Service
public class homeRulesService implements IHomeRulesService{

    @Autowired
    IHomeRulesDao iHomeRulesDao;
    //查询
    public Homerules select_HomeRules(String uid) {
        return iHomeRulesDao.select_HomeRules(uid);
    }
    //添加
    public int insert_HomeRules(Homerules homerules) {
        return iHomeRulesDao.insert_HomeRules(homerules);
    }
    //修改
    public int update_HomeRules(Homerules homerules) {
        return iHomeRulesDao.update_HomeRules(homerules);
    }
    //根据房源id查询入住规则
    public Homeallinformation select_HomeRules_haiId(String haiId) {
        return iHomeRulesDao.select_HomeRules_haiId(haiId);
    }
}
