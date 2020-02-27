package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IlivePeopleService;
import com.miqi.miqihome.dao.IlivePeopleDao;
import com.miqi.miqihome.entity.Livepeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 入住人信息表
 * 发布者：xyz
 */
@Service
public class LivePeopleService implements IlivePeopleService {

    @Autowired
    IlivePeopleDao dao;

    public int insert(@RequestBody Livepeople entity) {
        return dao.insert(entity);
    }

    public int update(@RequestBody Livepeople entity) {
        return dao.update(entity);
    }


    public int delete(int id) {
        return dao.delete(id);
    }


    public List<Livepeople> selectList(int id) {
        return dao.selectList(id);
    }
}
