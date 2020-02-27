package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IHouseSiteService;
import com.miqi.miqihome.Iservice.IReserveService;
import com.miqi.miqihome.dao.IHouseSiteDao;
import com.miqi.miqihome.dao.IReserveDao;
import com.miqi.miqihome.dao.IlivePeopleDao;
import com.miqi.miqihome.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 预定信息表
* 发布人：xyz
* */
@Service
public class ReserveService implements IReserveService {

    @Autowired
    IReserveDao dao;

    @Autowired
    IlivePeopleDao ilivePeopleDao;

    /**
     * 生成订单号
     * @return
     */
    private String CreateOrder(){
        return String.valueOf(new Date().getTime());
    }

    /**
     * 添加订单
     * @param reserve
     * @return
     */
    public int insertReserve(Reserve reserve) {
        //预定时间
        reserve.setRvBelowOrder(new Date());
        //添加订单号
        reserve.setRvSerialNumber(CreateOrder());
        int result = dao.insertReserve(reserve);

        //判断是否存在入住信息
        if(result>0 && reserve.getLivepeopleList().size() >0){
            for (int i=0; i<reserve.getLivepeopleList().size(); i++){
                reserve.getLivepeopleList().get(i).setRvId(reserve.getRvId());
            }
            //添加入住信息
            ilivePeopleDao.insertList(reserve.getLivepeopleList());
        }
        return reserve.getRvId();
    }

    /**
     * 修改订单
     * @param reserve
     * @return
     */
    public int updateReserve(Reserve reserve) {
        return dao.updateReserve(reserve);
    }

    /**
     * 综合查询
     * @param map
     * @return
     */
    public Map selectReserves(Map map) {
        Map result = new HashMap();
        Object number = map.get("pageNumber");
        Object size = map.get("pageSize");
        if(size != null && number != null){
            int pageNumber = (Integer.parseInt(number.toString())-1)*Integer.parseInt(size.toString());
            map.put("pageNumber",pageNumber);
        }
        result.put("data",dao.selectReserves(map));
        result.put("dataCount",dao.selectCount(map));
        return result;
    }

    public Map selectRegsistAdmin(int id) {
        List<Reserve> reserveList = dao.selectStateCount(id);
        Evaluate evaluate = dao.selectEvaluateSum(id);
        Userinformation userinformation = dao.selectUserInformation(id);
        Map map = new HashMap();
        map.put("userName",userinformation.getuNickName());
        //卫生评价星平均分
        int eHygiene = evaluate.geteHygiene()/evaluate.geteId();
        //交通位置评价星平均分
        int eTraffic = evaluate.geteTraffic()/evaluate.geteId();
        //设施环境评价星平均分
        int eEnvironmental = evaluate.geteEnvironmental()/evaluate.geteId();
        //房东服务评价星平均分
        int eService = evaluate.geteService()/evaluate.geteId();
        //性价比评价星平均分
        int eCostPerformance = evaluate.geteCostPerformance()/evaluate.geteId();
        int totalScore = (eHygiene+eTraffic+eEnvironmental+eService+eCostPerformance)/5;
        map.put("totalScore", totalScore);
        map.put("eHygiene", eHygiene);
        map.put("eTraffic", eTraffic);
        map.put("eEnvironmental", eEnvironmental);
        map.put("eService", eService);
        map.put("eCostPerformance", eCostPerformance);
        String[] arr = new String[6];
        //待支付
        arr[0] = "pay";
        //待确认
        arr[1] = "Confirmed";
        //待入住
        arr[2] = "toStayIn";
        //已入住
        arr[3] = "hasBeenIn";
        //已离店
        arr[4] = "checkOut";
        //已取消
        arr[5] = "cancel";
        for(int i=0; i<reserveList.size(); i++){
            map.put(arr[reserveList.get(i).getRvHomeState()],reserveList.get(i).getRvPayState());
        }
        //审核中的房屋
        return map;
    }


}
