package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Identityverification;

import java.util.List;
import java.util.Map;

/*
 * 发布人：one
 * 资质认证 增改查
 *
 * */
public interface IIdentityVerificationService {

    /*
     * 查询
     * */
    List<Identityverification> select_all_identityVerification(Map<String,Object> objectMap);

    /*
     * 修改
     * */
    int update_identityVerification(Identityverification identityverification);

    /*
     * 新增
     * */
    int insert_identityVerification(Identityverification identityverification);

    //判断是否存在
    int select_identityVerification(Identityverification identityverification);

    //根据房源id查询
    int select_identityVerification_haiId(String haiId);
    //根据房源id查询
    Identityverification select_identityVerification_haiId2(String haiId);
}
