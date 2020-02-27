package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHomeRequirementService;
import com.miqi.miqihome.dao.IHomeRequirementDao;
import com.miqi.miqihome.entity.Homerequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 发布人：丁火钦
 * 入住规则表【对房客的要求表】
 */
@Service
public class homeRequirementService implements IHomeRequirementService{

    @Autowired
    IHomeRequirementDao iHomeRequirementDao;

    public List<Homerequirement> select_Homerequirement(Homerequirement homerequirement) {
        return iHomeRequirementDao.select_Homerequirement(homerequirement);
    }

    public int insert_Homerequirement(Homerequirement homerequirement) {
        return iHomeRequirementDao.insert_Homerequirement(homerequirement);
    }

    public int update_Homerequirement(Homerequirement homerequirement) {
        return iHomeRequirementDao.update_Homerequirement(homerequirement);
    }

    public int delete_Homerequirement(Homerequirement homerequirement) {
        return iHomeRequirementDao.delete_Homerequirement(homerequirement);
    }

    public int select_Homerequirement_count() {
        return iHomeRequirementDao.select_Homerequirement_count();
    }

    public List<Homerequirement> select_Homerequirement_byLimit(Map<String, Object> objectMap) {
        return iHomeRequirementDao.select_Homerequirement_byLimit(objectMap);
    }
}
