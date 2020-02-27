package com.miqi.miqihome.Iservice;


import com.miqi.miqihome.entity.Identityaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * 发布人：one
 * 认证方式 增删改查
 *
 * */
public interface IIdentityActionService {

    /*
     * 查询
     * */
    List<Identityaction> select_all_identityAction();
    Identityaction select_identityAction_by_iaId(@Param("iaId") int iaId);

    /*
     * 新增
     * */
    int insert_identityAction(@Param("iaName")String iaName);

    /*
     * 修改
     * */
    int update_identityAction(Map<String,Object> objectMap);
}
