package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Picture;
import com.miqi.miqihome.entity.Picturetype;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 *
 * * 发布者：one
 * * 房间图片描述表的增、改、查 以及相关信息表的查询
 */
public interface IPictureDao {
    /*
    * 查询
    * */
    List<Picture> select_all_picture();
    List<Picture> select_picture_by_pId(@Param("pId")int pId);
    List<Picture> select_picture_by_ptId(@Param("ptId")int ptId);

    /*
    * 修改
    * */
    int update_picture(Map<String,Object> objectMap);

    /*
    * 新增
    * */
    int insert_picture(Map<String,Object> objectMap);

    //根据房源id获取图片
    List<Picture> select_all_img(@Param("haiId") String haiId);
    //删除图片
    int delete_picture(@Param("pId") String pId);
}

