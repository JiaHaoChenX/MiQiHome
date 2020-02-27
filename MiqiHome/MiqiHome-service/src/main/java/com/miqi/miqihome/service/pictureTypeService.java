package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IPictureTypeService;
import com.miqi.miqihome.dao.IPictureTypeDao;
import com.miqi.miqihome.entity.Picturetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * * 发布者：one
 * * 房屋图片类型表的增、改、查 以及相关信息表的查询
 */


@Service
public class pictureTypeService implements IPictureTypeService {

    @Autowired
    IPictureTypeDao pictureTypeDao;


    public List<Picturetype> select_all_pictureType() {
        return pictureTypeDao.select_all_pictureType();
    }

    public Picturetype select_pictureType_by_ptId(int ptId) {
        return pictureTypeDao.select_pictureType_by_ptId(ptId);
    }

    public List<Picturetype> select_pictureType_by_haiId(int haiId) {
        return pictureTypeDao.select_pictureType_by_haiId(haiId);
    }

    public int update_pictureType(Map<String, Object> objectMap) {
        return pictureTypeDao.update_pictureType(objectMap);
    }

    public int insert_pictureType(Picturetype picturetype) {
        return pictureTypeDao.insert_pictureType(picturetype);
    }


    //判断存不存在
    public int select_pictureType_haiId_ptName(Picturetype picturetype ) {
        return pictureTypeDao.select_pictureType_haiId_ptName(picturetype);
    }
    //存在操作
    public Picturetype select_pictureType(Picturetype picturetype ) {
        return pictureTypeDao.select_pictureType(picturetype);
    }
}
