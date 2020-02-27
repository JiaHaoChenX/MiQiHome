package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Housedecription;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * * 发布者：one
 * * 房屋描述表的增、改、查 以及相关信息表的查询
 */
public interface IHouseDecriptionDao {
    /*
    * 查询
    * */
    List<Housedecription> select_all_houseDecription();
    Housedecription select_houseDecription_by_hdpId(@Param("hdpId") int hdpId);
    Housedecription select_houseDecription_by_haiId(@Param("haiId") int haiId);

    /*
    * 新增
    * */
    int insert_houseDecription(Map<String, Object> objectMap);

    /*
    * 通过主键修改
    * */
    int update_houseDecription(Map<String, Object> objectMap);

    /*
    * 查询总数
    * */
    int select_all_houseDecription_count();


    int select_houseDecription_haiId(Map<String, Object> objectMap);
}
