package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IIdentityVerificationService;
import com.miqi.miqihome.dao.IIdentityverificationDao;
import com.miqi.miqihome.entity.Identityverification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * 发布人：one
 * 资质认证 增改查
 *
 * */

@Service
public class identityVerificationService implements IIdentityVerificationService {


    @Autowired
    IIdentityverificationDao iIdentityverificationDao;

    public List<Identityverification> select_all_identityVerification(Map<String, Object> objectMap) {
        return iIdentityverificationDao.select_all_identityVerification(objectMap);
    }

    public int update_identityVerification(Identityverification identityverification) {
        return iIdentityverificationDao.update_identityVerification(identityverification);
    }

    public int insert_identityVerification(Identityverification identityverification) {
        return iIdentityverificationDao.insert_identityVerification(identityverification);
    }

    public int select_identityVerification(Identityverification identityverification) {
        return iIdentityverificationDao.select_identityVerification(identityverification);
    }

    public int  select_identityVerification_haiId(String haiId) {
        return iIdentityverificationDao.select_identityVerification_haiId(haiId);
    }

    public Identityverification select_identityVerification_haiId2(String haiId) {
        return iIdentityverificationDao.select_identityVerification_haiId2(haiId);
    }
}
