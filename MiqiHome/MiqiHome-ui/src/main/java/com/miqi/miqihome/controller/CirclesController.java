package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.ICirclesService;
import com.miqi.miqihome.Iservice.ICollectionsService;
import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    发布者：丁火钦
    商圈
* */

@RestController
@RequestMapping("/circles")
public class CirclesController {

    @Autowired
    ICirclesService iCirclesService;

    /*
    * 查询
    * */
    @GetMapping(value = "/select_Circles")
    List<Circles> select_Circles(String City){
        return iCirclesService.select_Circles(City);
    }

}
