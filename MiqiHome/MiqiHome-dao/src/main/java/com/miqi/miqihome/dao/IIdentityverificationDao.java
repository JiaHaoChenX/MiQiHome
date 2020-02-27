package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Identityverification;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * 发布人：one
 * 资质认证 增改查
 *
 * */
public interface IIdentityverificationDao {

    /*
    * 查询
    * */
    List<Identityverification>select_all_identityVerification(Map<String,Object>objectMap);

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
    int  select_identityVerification_haiId(String haiId);
    //
    Identityverification select_identityVerification_haiId2(String haiId);
}
