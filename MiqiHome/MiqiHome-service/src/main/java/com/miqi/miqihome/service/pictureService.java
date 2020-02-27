package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IPictureService;
import com.miqi.miqihome.Iservice.IPictureTypeService;
import com.miqi.miqihome.dao.IPictureDao;
import com.miqi.miqihome.dao.IPictureTypeDao;
import com.miqi.miqihome.entity.Picture;
import com.miqi.miqihome.entity.Picturetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 *
 * * 发布者：one
 * * 房屋图片的增、改、查 以及相关信息表的查询
 */


@Service
public class pictureService implements IPictureService {


    @Autowired
    IPictureDao pictureDao;

    public List<Picture> select_all_picture() {
        return pictureDao.select_all_picture();
    }

    public List<Picture> select_picture_by_pId(int pId) {
        return pictureDao.select_picture_by_pId(pId);
    }

    public List<Picture> select_picture_by_ptId(int ptId) {
        return pictureDao.select_picture_by_ptId(ptId);
    }

    public int update_picture(Map<String, Object> objectMap) {
        return pictureDao.update_picture(objectMap);
    }

    public int insert_picture(Map<String, Object> objectMap) {
        return pictureDao.insert_picture(objectMap);
    }

    //    //根据房源id获取图片
    public List<Picture> select_all_img(String haiId) {
        return pictureDao.select_all_img(haiId);
    }
    //删除图片
    public int delete_picture(String pId) {
        return pictureDao.delete_picture(pId);
    }
}
