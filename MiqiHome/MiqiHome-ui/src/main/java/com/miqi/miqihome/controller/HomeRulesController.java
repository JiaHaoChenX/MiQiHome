package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHomeRulesService;
import com.miqi.miqihome.Iservice.IUserInformationService;
import com.miqi.miqihome.entity.Homeallinformation;
import com.miqi.miqihome.entity.Homerules;
import com.miqi.miqihome.entity.Userinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 发布人：丁火钦
* 入住规则
* */
@RestController
@RequestMapping(value = "HomeRules")
public class HomeRulesController {

    @Autowired
    IHomeRulesService iHomeRulesService;

    /**
     * 查询
     * */
    @PostMapping(value = "/select_HomeRules")
    public Homerules select_HomeRules(String hrId){
        return iHomeRulesService.select_HomeRules(hrId);
    }

    /**
     * 根据房源id查询入住规则
     */
    @RequestMapping(value = "/select_HomeRules_haiId")
    @ResponseBody
    public Homeallinformation select_HomeRules_haiId(String haiId){
        return iHomeRulesService.select_HomeRules_haiId(haiId);
    }

    /**
     * 添加
     * */
    @PostMapping(value = "/insert_HomeRules")
    public int insert_HomeRules(@RequestBody Homerules homerules){
        iHomeRulesService.insert_HomeRules(homerules);
        return homerules.getHrId();
    }

    /**
     * 修改
     * */
    @PostMapping(value = "/update_HomeRules")
    public int update_HomeRules(@RequestBody Homerules homerules){
        return iHomeRulesService.update_HomeRules(homerules);
    }
}
