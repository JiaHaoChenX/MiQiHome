package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHomeRequirementReflectService;
import com.miqi.miqihome.entity.Homerequirementreflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 发布人：丁火钦
 * 入住规则表【对房客的要求表对应表(与房客要求表和入住规则表进行关联)】
 */
@RestController
@RequestMapping(value = "HomeRequirementReflect")
public class HomeRequirementReflectController {

    @Autowired
    IHomeRequirementReflectService iHomeRequirementReflectService;

    //查询
    @PostMapping(value = "/select_HomeRequirementReflect")
    public List<Homerequirementreflect> select_Homerequirement(@RequestBody Homerequirementreflect homerequirementreflect){
        return  iHomeRequirementReflectService.select_Homerequirementreflect(homerequirementreflect);
    }
    //添加
    @PostMapping(value = "/insert_HomeRequirementReflect")
    public int insert_Homerequirement(@RequestBody Homerequirementreflect homerequirementreflect){
        return iHomeRequirementReflectService.insert_Homerequirementreflect(homerequirementreflect);
    }
    //删除
    @PostMapping(value = "/delete_HomeRequirementReflect")
    public int delete_Homerequirement(@RequestBody Homerequirementreflect homerequirementreflect){
        return iHomeRequirementReflectService.delete_Homerequirementreflect(homerequirementreflect);
    }
    //根据id删除
    @PostMapping(value = "/delete_HomeRequirementReflect_hrId")
    public int delete_HomeRequirementReflect_hrId(String hrId){
        return iHomeRequirementReflectService.delete_HomeRequirementReflect_hrId(hrId);
    }
}
