package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IReceptiontimeService;
import com.miqi.miqihome.dao.IReceptiontimeDao;
import com.miqi.miqihome.entity.Receptiontime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 发布人：丁火钦
* 入住规则表【接待房客时间表(关联入住规则表)】
* */
@Service
public class receptiontimeService implements IReceptiontimeService{

    @Autowired
    IReceptiontimeDao iReceptiontimeDao;

    public List<Receptiontime> select_Receptiontime(String hrId) {
        return iReceptiontimeDao.select_Receptiontime(hrId);
    }

    public int insert_Receptiontime(Receptiontime receptiontime) {
        return iReceptiontimeDao.insert_Receptiontime(receptiontime);
    }

    public int update_Receptiontime(Receptiontime receptiontime) {
        return iReceptiontimeDao.update_Receptiontime(receptiontime);
    }

    public int delete_Receptiontime(Receptiontime receptiontime) {
        return iReceptiontimeDao.delete_Receptiontime(receptiontime);
    }
    //根据id删除
    public int delete_Receptiontime_haiId(String hrId) {
        return iReceptiontimeDao.delete_Receptiontime_haiId(hrId);
    }
}
