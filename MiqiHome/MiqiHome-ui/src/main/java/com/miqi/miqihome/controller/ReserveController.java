package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IHouseSiteService;
import com.miqi.miqihome.Iservice.IReserveService;
import com.miqi.miqihome.entity.Housesite;
import com.miqi.miqihome.entity.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 预定信息
 * 发布者: xyz
 */
@Controller
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    IReserveService service;

    /**
     * 预定信息 添加
     * @param entity 根据预定信息表实体类对象
     * @return
     */
    @RequestMapping("/insertReserve")
    @ResponseBody
    public int insert(HttpServletRequest request , @RequestBody Reserve entity){
        // 登录后,获取用户编号
        int id = (int)request.getSession().getAttribute("uiId");
        entity.setUiId(id);
        return service.insertReserve(entity);
    }

    /**
     * 修改
     * @param entity 根据预定信息表实体类对象
     * @return
     */
    @RequestMapping("/updateReserve")
    @ResponseBody
    public int update(@RequestBody Reserve entity){
        int result=service.updateReserve(entity);
        if(result>0){
            WebsocketController wbs = new WebsocketController();
            wbs.onMessage(result);
        }
        return result;
    }

    /**
     * 预定信息 综合查询
     * @param map
     * @return
     */
    @RequestMapping("/selectReserve")
    @ResponseBody
    public Map select( @RequestParam(required=false) @RequestBody Map map, HttpServletRequest request){
        int id = (int)request.getSession().getAttribute("uiId");
        map.put("uiId", id);
        return service.selectReserves(map);
    }

    /**
     * 房东名:userName
     * 卫生评价星平均分:eHygiene
     * 交通位置评价星平均分:eTraffic
     * 设施环境评价星平均分:eEnvironmental
     * 房东服务评价星平均分:eService
     * 性价比评价星平均分:eCostPerformance
     * 待支付:pay
     * 待确认:Confirmed
     * 待入住:toStayIn
     * 已入住:hasBeenIn
     * 已离店:checkOut
     * 已取消:cancel
     * @param request
     * @return
     */
    @RequestMapping("/selectRegsistAdmin")
    @ResponseBody
    public Map selectRegsistAdmin(HttpServletRequest request){
        int id = (int)request.getSession().getAttribute("uiId");
        return service.selectRegsistAdmin(id);
    }

}
