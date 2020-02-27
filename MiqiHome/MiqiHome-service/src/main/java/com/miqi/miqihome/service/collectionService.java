package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.ICollectionsService;
import com.miqi.miqihome.dao.ICollectionsDao;
import com.miqi.miqihome.entity.Collections;
import com.miqi.miqihome.entity.Homeallinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
*
    发布者：one
    房屋收藏表 增删改查
* */
@Service
public class collectionService implements ICollectionsService {

    @Autowired
    ICollectionsDao collectionsDao;

    public List<Collections> select_all_collection(Map<String, Object> objectMap) {
        return collectionsDao.select_all_collection(objectMap);
    }

    public int insert_collection(String uiId,String haiId) {
        return collectionsDao.insert_collection(uiId,haiId);
    }

    public int update_collection(Map<String, Object> objectMap) {
        return collectionsDao.update_collection(objectMap);
    }

    public int delete_collection(String uiId,String haiId) {
        return collectionsDao.delete_collection(uiId,haiId);
    }

    /**
     *  发布人：丁火钦
     *  添加：根据用户id查询该用户是否收藏了该房间
     */
    public int select_ui_collection(String uiId, String haiId) {
        return collectionsDao.select_ui_collection(uiId,haiId);
    }


    /**
     *  发布人：丁火钦
     *  作用  ：根据用户id查询该用户收藏的房间
     */
    public List<Homeallinformation> select_ui_collection_list(String uiId) {
        return collectionsDao.select_ui_collection_list(uiId);
    }
}
