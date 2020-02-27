package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.ICirclesService;
import com.miqi.miqihome.Iservice.IlivePeopleService;
import com.miqi.miqihome.entity.Circles;
import com.miqi.miqihome.entity.Livepeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 *
 * 入住人信息表
 * 发布者：xyz
 */
@RestController
@RequestMapping("/livePeople")
public class LivePeopleController {

    @Autowired
    IlivePeopleService service;

    /**
     * 入住人信息添加
     *
     * @param entity 入住人信息表对象
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public int insert(@RequestBody Livepeople entity) {
        return service.insert(entity);
    }

    /**
     * 修改
     * @param entity 入住人信息表对象
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public int update(@RequestBody Livepeople entity) {
        return service.update(entity);
    }

    /**
     * 删除
     * @param id 入住个人信息编号
     * @return 删除条数
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public int delete(int id) {
        return service.delete(id);
    }

    /**
     * 查询 入住个人信息(姓名，身份证)
     * @param id  房屋编号
     * @return
     */
    @RequestMapping(value = "/selectList")
    @ResponseBody
    public List<Livepeople> selectList(int id) {
        return service.selectList(id);
    }



}
