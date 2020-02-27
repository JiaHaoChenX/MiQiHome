package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHomeRulesService;
import com.miqi.miqihome.Iservice.IReceptiontimeService;
import com.miqi.miqihome.entity.Homerules;
import com.miqi.miqihome.entity.Receptiontime;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* 发布人：丁火钦
* 入住规则表【接待房客时间表(关联入住规则表)】
* */
@RestController
@RequestMapping(value = "Receptiontime")
public class ReceptiontimeController {

    @Autowired
    IReceptiontimeService iReceptiontimeService;

    /**
     * 根据homeRules【入住规则表ID】查询【接待房客时间表】
     * */
    @PostMapping(value = "/select_Receptiontime")
    public List<Receptiontime> select_Receptiontime(String hrId){
        return iReceptiontimeService.select_Receptiontime(hrId);
    }

    /**
     * 添加
     * */
    @PostMapping(value = "/insert_Receptiontime")
    public int insert_Receptiontime(@RequestBody Receptiontime receptiontime){
        return iReceptiontimeService.insert_Receptiontime(receptiontime);
    }

    /**
     * 修改
     * */
    @PostMapping(value = "/update_Receptiontime")
    public int update_Receptiontime(@RequestBody Receptiontime receptiontime){
        return iReceptiontimeService.update_Receptiontime(receptiontime);
    }

    /**
     * 删除
     * */
    @PostMapping(value = "/delete_Receptiontime")
    public int delete_Receptiontime(@RequestBody Receptiontime receptiontime){
        return iReceptiontimeService.delete_Receptiontime(receptiontime);
    }

    /**
     * 根据id删除
     * */
    @PostMapping(value = "/delete_Receptiontime_hrId")
    public int delete_Receptiontime_haiId(String hrId){
        return iReceptiontimeService.delete_Receptiontime_haiId(hrId);
    }
}
