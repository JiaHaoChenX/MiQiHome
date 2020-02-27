package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHouseSiteService;
import com.miqi.miqihome.Iservice.IPriceReflectService;
import com.miqi.miqihome.entity.Housesite;
import com.miqi.miqihome.entity.Pricereflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 房屋多种价格对应表
 * 发布者: xyz
 */
@Controller
@RequestMapping("/priceReflect")
public class PriceReflectController {

    @Autowired
    IPriceReflectService service;

    /*
     * 房屋多种价格对应 添加
     * */
    @RequestMapping(value = "/insertPriceReflect", method = RequestMethod.POST)
    @ResponseBody
    public int insertPriceReflect(@RequestBody Pricereflect entity){
        return service.insertPricereflect(entity);
    }

    /**
     * 多添加
     * @param list 集合 房屋多种价格对应
     * @return 成功执行条数
     */
    @RequestMapping(value = "/insertPriceReflects", method = RequestMethod.POST)
    @ResponseBody
    public int insertPriceReflects(@RequestBody List<Pricereflect> list){
        return service.insertPricereflects(list);
    }

    /*
     * 房屋多种价格对应 修改
     * */
    @RequestMapping(value = "/updatePriceReflect", method = RequestMethod.POST)
    @ResponseBody
    public int updatePriceReflect(@RequestBody Pricereflect entity){
        return service.updatePricereflect(entity);
    }

    /*
     * 房屋多种价格对应 查询
     * */
    @RequestMapping(value = "/selectPriceReflect", method = RequestMethod.GET)
    @ResponseBody
    public List<Pricereflect> selectPriceReflect(int haiId){
        return service.selectPricereflects(haiId);
    }

    /*
     * 房屋多种价格对应 多删除
     * */
    @RequestMapping(value = "/deletePricereflects")
    @ResponseBody
    public int deletePricereflects(@RequestBody List list){
        return service.deletePricereflects(list);
    }


}
