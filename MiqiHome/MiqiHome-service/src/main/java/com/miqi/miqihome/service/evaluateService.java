package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IEvaluateService;
import com.miqi.miqihome.dao.IEvaluateDao;
import com.miqi.miqihome.entity.Evaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * * 发布者：one
 * * 房屋评价表 增删改查
 */
@Service
public class evaluateService implements IEvaluateService {

    @Autowired
    IEvaluateDao evaluateDao;

    public List<Evaluate> select_all_evaluate(Map<String, Object> objectMap) {
        return evaluateDao.select_all_evaluate(objectMap);
    }

    public int insert_evaluate(Map<String, Object> objectMap) {
        return evaluateDao.insert_evaluate(objectMap);
    }

    public int update_evaluate(Map<String, Object> objectMap) {
        return evaluateDao.update_evaluate(objectMap);
    }

    public int delete_evaluate(int eid) {
        return evaluateDao.delete_evaluate(eid);
    }

    /**
     * 根据房源id查询评论数量
     * @param eid
     * @return
     */
    public int select_evaluate_count(int eid) {
        return evaluateDao.select_evaluate_count(eid);
    }
}
