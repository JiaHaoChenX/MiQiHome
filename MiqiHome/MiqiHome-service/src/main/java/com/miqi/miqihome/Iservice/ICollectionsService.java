package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Collections;
import com.miqi.miqihome.entity.Homeallinformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
*
    发布者：one
    房屋收藏表 增删改查
* */
public interface ICollectionsService {

    /*
     * 查询全部
     * */
    List<Collections> select_all_collection(Map<String,Object> objectMap);

    /*
     * 新增
     * */
    int insert_collection(String uiId,String haiId);

    /*
     * 修改
     * */
    int update_collection(Map<String,Object>objectMap);

    /*
     * 删除
     * */
    int delete_collection(String uiId,String haiId);

    /**
     *  发布人：丁火钦
     *  添加：根据用户id查询该用户是否收藏了该房间
     */
    int select_ui_collection(String uiId, String haiId);

    /**
     *  发布人：丁火钦
     *  作用  ：根据用户id查询该用户收藏的房间
     */
    List<Homeallinformation> select_ui_collection_list(String uiId);
}
