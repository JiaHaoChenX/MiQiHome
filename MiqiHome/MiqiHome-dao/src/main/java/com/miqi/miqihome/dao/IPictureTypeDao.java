package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Picturetype;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 *
 * * 发布者：one
 * * 房间类型图片描述表的增、改、查 以及相关信息表的查询
 */
public interface IPictureTypeDao {
    /*
    * 查询
    * */
    List<Picturetype> select_all_pictureType();
    Picturetype select_pictureType_by_ptId(@Param("ptId")int ptId);
    List<Picturetype> select_pictureType_by_haiId(@Param("haiId")int haiId);

    /*
    * 修改
    * */
    int update_pictureType(Map<String,Object>objectMap);

    /*
    * 新增
    * */
    int insert_pictureType(Picturetype picturetype);
    //判断存不存在
    int select_pictureType_haiId_ptName(Picturetype picturetype);
    //存在操作
    Picturetype select_pictureType(Picturetype picturetype);
}

