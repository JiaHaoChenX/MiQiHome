package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.ICirclesService;
import com.miqi.miqihome.Iservice.ICollegeService;
import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    发布者：丁火钦
    高校
* */

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    ICollegeService iCollegeService;

    /*
    * 查询
    * */
    @GetMapping(value = "/select_College")
    List<College> select_College(String City){
        return iCollegeService.select_College(City);
    }

}
