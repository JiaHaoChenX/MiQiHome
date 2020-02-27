package com.miqi.miqihome.Iservice;

import com.miqi.miqihome.entity.HouseFacilities;
import com.miqi.miqihome.entity.HouseFacilitiesReflect;
import com.miqi.miqihome.entity.Housefacilitiesdetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 发布者: 张育威
 * 操作： 房屋设施服务对应表服务层接口
 * */
public interface IHouseFacilitiesReflectService {
    //对设施服务表进行的操作
    //查询设施服务表
    List<HouseFacilities> select_houseFacilities();
    //添加
    int insert_houseFacilities(String hfName);
    //修改
    int update_houseFacilities(@Param("hfName") String hfName, @Param("hfId") int hfId);
    //对设施服务详细表进行操作
    //添加
    int insert_housefacilitiesdetails(@Param("hfId") int hfId,@Param("hfdName") String hfdName);
    //修改
    int update_housefacilitiesdetails(@Param("hfdName") String hfdName,@Param("hfId") int hfId,@Param("hfdId") int hfdId);
    //查询设施服务表与设施服务详细表
    List<Housefacilitiesdetails> select_housefacilitiesdetails(@Param("hfId") String hfId,@Param("page") int page,@Param("limit") int limit);
    //查询设施服务表对应表（里面包括用户信息，房屋信息，设施所有信息）
    List<HouseFacilitiesReflect> select_houseFacilitiesReflect(Map<String,Object> map);
    //添加设施服务表对应表
    int insert_houseFacilitiesReflect(@Param("haiId") int haiId,@Param("hfdId") int hfdId);
    //修改设施服务对应表
    int update_houseFacilitiesReflect(@Param("haiId") int haiId,@Param("hfdId") int hfdId,@Param("hfrId") int hfrId);
    //删除设施服务对应表信息
    int delete_houseFacilitiesReflect(String haiId);
    //根据房源id查询设施服务
    List<HouseFacilitiesReflect> select_HouseFacilitiesDetails_haiId(String haiId);
}
