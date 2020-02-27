package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.Geography;
import com.miqi.miqihome.entity.Housesite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * 发布人：xyz
 * 房屋位置表
 * */
public interface IHouseSiteDao {

    /**
     * 添加房屋位置
     * @param housesite
     * @return
     */
    int insertHouseSite(Housesite housesite);

    /**
     * 修改房屋位置
     * @param housesite
     * @return
     */
    int updateHouseSite(Housesite housesite);

    /**
     * 根据编号查询房屋位置
     * @param haiId
     * @return
     */
    Housesite selectHouseSite(@Param("haiId") int haiId);



    /**
     * 查询城市
     */
    List<Geography> select_geography(@Param("region") String region);
}
