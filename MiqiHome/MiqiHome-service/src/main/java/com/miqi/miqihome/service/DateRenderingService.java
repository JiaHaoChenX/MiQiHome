package com.miqi.miqihome.service;

import com.miqi.miqihome.Iservice.IDateRenderingService;
import com.miqi.miqihome.Iservice.IReserveService;
import com.miqi.miqihome.dao.IDateRenderingDao;
import com.miqi.miqihome.dao.IReserveDao;
import com.miqi.miqihome.entity.DateRendering;
import com.miqi.miqihome.entity.Reserve;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
* 发布人：xyz
 * 日期渲染
* */
@Service
public class DateRenderingService implements IDateRenderingService {

    @Autowired
    IDateRenderingDao dao;

    /**
     * 字符串转Date
     * @param times
     * @return
     */
    Date toDate(String times){
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(times);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取时间段所有日期
     * @param begin
     * @param end
     * @return
     */
    public List<Date> getBetweenDate(Date begin,Date end){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> betweenList = new ArrayList<Date>();
        String endString = format.format(end);
        try{
            Calendar startDay = Calendar.getInstance();
            //Date beginDate = format.parse(begin);
            startDay.setTime(begin);
            startDay.add(Calendar.DATE, -1);

            while(true){
                startDay.add(Calendar.DATE, 1);
                Date newDate = startDay.getTime();
                String newend=format.format(newDate);
                betweenList.add(newDate);
                if(endString.equals(newend)){
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return betweenList;
    }

    /**
     * 获取日期房屋信息
     * @param haiId 房屋编号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 集合对象，对象参数:日期(String) 当日价格，剩余房间数
     */
    public List<DateRendering> selectReserveDate(int haiId, String startTime, String endTime) {
        /*房屋单日价格设置*/
        List<DateRendering> listDateRendering = dao.selectReserveDate(haiId,startTime,endTime);
        //开始时间
        Date sTime = toDate(startTime);
        //结束时间
        Date eTime = toDate(endTime);
        // 判断参数
        if(haiId<=0 || eTime.getTime()<sTime.getTime()){
            return null;
        }
        /*房屋预定订单*/
        List<Reserve> listReserve = dao.selectReserve(haiId,startTime,endTime);
        /*房屋总数量与原价信息*/
        DateRendering rendering = dao.selectHouse(haiId);
        //返回结果
        List<DateRendering> dateRenderingList = new ArrayList<DateRendering>();

        //比较时间
        List<Date> listString = getBetweenDate(sTime,eTime);
        DateRendering dateRendering = null;

        for(int i=0; i<listString.size(); i++) {

            //从房屋日期设置获取
            for(int j=0; j<listDateRendering.size(); j++){
                if(listString.get(i).getTime() == listDateRendering.get(j).getDate().getTime()){
                    // 获取剩余数量
                    listDateRendering.get(j)
                            .setNumber(rendering.getNumber()-listDateRendering.get(j).getNumber());
                    dateRenderingList.add(listDateRendering.get(j));
                    break;
                }
            }
            if(dateRenderingList.size() < i){
                //从订单中获取
                int houseNumebr = 0;
                for(int k=0; k<listReserve.size(); k++){
                    if( listReserve.get(k).getRvStartTime().getTime()<= listString.get(i).getTime()
                            && listReserve.get(k).getRvEndTime().getTime()>= listString.get(i).getTime()){
                        //获取房屋总订单房间数量
                        houseNumebr += listReserve.get(k).getRvHouseNumeb();
                    }
                }
                dateRendering = new DateRendering();
                //添加时间
                dateRendering.setDate(listString.get(i));
                //价格
                dateRendering.setPrice(rendering.getPrice());
                if( houseNumebr !=0){
                    //添加剩余数量
                    int number =rendering.getNumber()-houseNumebr;
                    //dateRendering.setNumber(number>0?number:0);
                    dateRendering.setNumber(number);
                } else {
                    dateRendering.setNumber(rendering.getNumber());
                }
                dateRenderingList.add(dateRendering);
            }
        }
        return dateRenderingList;
    }



}
