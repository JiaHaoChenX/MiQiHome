package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHomeRequirementReflectService;
import com.miqi.miqihome.Iservice.IHomeRequirementService;
import com.miqi.miqihome.dao.IHomeRequirementDao;
import com.miqi.miqihome.dao.IHomeRequirementReflectDao;
import com.miqi.miqihome.entity.Homerequirement;
import com.miqi.miqihome.entity.Homerequirementreflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * * 发布者：丁火钦
 * * 入住规则表【对房客的要求表对应表(与房客要求表和入住规则表进行关联)】
 */
@Service
public class homeRequirementReflectService implements IHomeRequirementReflectService {

    @Autowired
    IHomeRequirementReflectDao iHomeRequirementReflectDao;

    //查询
    public List<Homerequirementreflect> select_Homerequirementreflect(Homerequirementreflect homerequirementreflect) {
        return iHomeRequirementReflectDao.select_Homerequirementreflect(homerequirementreflect);
    }
    //添加
    public int insert_Homerequirementreflect(Homerequirementreflect homerequirementreflect) {
        return iHomeRequirementReflectDao.insert_Homerequirementreflect(homerequirementreflect);
    }
    //删除
    public int delete_Homerequirementreflect(Homerequirementreflect homerequirementreflect) {
        return iHomeRequirementReflectDao.delete_Homerequirementreflect(homerequirementreflect);
    }
    //根据id删除
    public int delete_HomeRequirementReflect_hrId(String hrId) {
        return iHomeRequirementReflectDao.delete_HomeRequirementReflect_hrId(hrId);
    }
}
