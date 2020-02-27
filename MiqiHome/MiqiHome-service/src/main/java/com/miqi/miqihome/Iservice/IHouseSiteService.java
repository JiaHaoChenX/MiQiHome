package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.Geography;
import com.miqi.miqihome.entity.Housesite;

import java.util.List;

/*
 * 发布人：xyz
 * 房屋位置表
 *
 * */
public interface IHouseSiteService {
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
    Housesite selectHouseSite(int haiId);

    /**
     * 查询城市
     */
    List<Geography> select_geography(String region);
}
