package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IIdentityActionService;
import com.miqi.miqihome.Iservice.IPictureService;
import com.miqi.miqihome.dao.IIdentityActionDao;
import com.miqi.miqihome.dao.IPictureDao;
import com.miqi.miqihome.entity.Identityaction;
import com.miqi.miqihome.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * 发布人：one
 * 认证方式 增改查
 *
 * */

@Service
public class identityActionService implements IIdentityActionService {


    @Autowired
    IIdentityActionDao iIdentityActionDao;

    public List<Identityaction> select_all_identityAction() {
        return iIdentityActionDao.select_all_identityAction();
    }

    public Identityaction select_identityAction_by_iaId(int iaId) {
        return iIdentityActionDao.select_identityAction_by_iaId(iaId);
    }

    public int insert_identityAction(String iaName) {
        return iIdentityActionDao.insert_identityAction(iaName);
    }

    public int update_identityAction(Map<String, Object> objectMap) {
        return iIdentityActionDao.update_identityAction(objectMap);
    }
}
