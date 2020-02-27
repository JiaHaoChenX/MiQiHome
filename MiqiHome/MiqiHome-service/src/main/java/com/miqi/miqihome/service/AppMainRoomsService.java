package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IAppMainRoomsService;
import com.miqi.miqihome.Iservice.IHomeAllInformationService;
import com.miqi.miqihome.dao.IAppMainRoomsDao;
import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.MainRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者: xyz
 * 更新时间: 2019年3月8日10:17:18
 * 描述: 手机端 上房
 */
@Service
public class AppMainRoomsService implements IAppMainRoomsService {

    @Autowired
    IAppMainRoomsDao appMainRooms;

    @Autowired
    IHomeAllInformationService homeAllInformationService;

    public MainRooms selectmainrooms(int uiId) {
        MainRooms mainRooms = appMainRooms.selectmainrooms(uiId);
        if(mainRooms != null && mainRooms.getHaiId() > 0 ){
            return mainRooms;
        }
        Homeallinformation homeallinformation = new Homeallinformation();
        homeallinformation.setUiId(uiId);
        int id = homeAllInformationService.insert_HomeAllInformation(homeallinformation);
        mainRooms = new MainRooms();
        mainRooms.setHaiId(homeallinformation.getHaiId());
        return mainRooms;
    }
}
