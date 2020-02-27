package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.MainRooms;

/**
 * 作者: xyz
 * 更新时间: 2019年3月8日10:17:18
 * 描述: 手机端 上房
 */
public interface IAppMainRoomsDao {
    MainRooms selectmainrooms(int uiId);
}
