package com.miqi.miqihome.dao;

import com.miqi.miqihome.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 发布者  张育威
 * 操作  房屋详细
 * */
public interface IHouseBedDao {
    //对出租方式表的操作
    //查询
    List<Rentalmode> select_rentalMode();
    //添加
    int insert_rentalMode(String rmName);
    //修改
    int update_rentalMode(@Param("rmName") String rmName,@Param("rmId") int rmId);
    //对房屋类型表的操作
    //查询
    List<Housetype> select_houseType();
    //添加
    int insert_houseType(String htName);
    //修改
    int update_houseType(@Param("htName") String htName,@Param("htId") int htId);
    //对房屋类型详细表(与房屋类型表之间是多对一的关系)的操作
    //查询全部
    List<Housetypedetails> select_houseTypeDetails();
    //添加
    int insert_houseTypeDetails(Housetypedetails housetypedetails);
    //修改
    int update_houseTypeDetails(Housetypedetails housetypedetails);
    //对房屋景观表的操作
    //查询
    List<Housescenery> select_houseScenery();
    //添加
    int insert_houseScenery(String hcName);
    //修改
    int update_houseScenery(@Param("hcName") String hcName,@Param("hcId") int hcId);
    //对房屋户型表的操作
    //查询
    Houseapartment select_houseApartment(@Param("haiid") String haiid);
    //添加
    int insert_houseApartment(Houseapartment houseapartment);
    //修改
    int update_houseApartment(Houseapartment houseapartment);
    //对房屋详细表的操作
    //查询
    List<Housedetails> selct_houseDetails(Map<String,Object> map);
    //添加
    int insert_houseDetails(Housedetails housedetails);
    //修改
    int update_houseDetails(Housedetails housedetails);
    //对床型床类型表的操作

    //查询总数
    int select_houseBedTypeCount();
    //查询
    List<Housebedtype> select_houseBedType(Map<String,Object>objectMap);
    //添加
    int insert_houseBedType(String hbtName);
    //修改
    int update_houseBedType(@Param("hbtName") String hbtName,@Param("hbtId") int hbtId);
    //zywds
    //查询床型床类型表
    List<Housebedtype> select_houseBedTypes();
    //查询床型床类型对应宽高
    List<Housebedsize> select_houseBedSizes(@Param("hbtId") int hbtId);
    //对床型床宽高表的操作
    //查询总数
    int select_houseBedSize_count();
    //查询
    List<Housebedsize> select_houseBedSize(Map<String,Object>objectMap);
    //添加
    int insert_houseBedSize(@Param("hbtId") int hbtId,@Param("hbsSize") String hbsSize);
    //修改
    int update_houseBedSize(@Param("hbtId") int hbtId,@Param("hbsSize") String hbsSize,@Param("hdsId") int hdsId);
    //对床型表(一个房子有多个床型),关联房屋详细表的操作
    //查询
    List<Housebed> select_houseBed(Map<String,Object> map);
    //添加
    int insert_houseBed(@Param("hdId") int hdId,@Param("hdsId") int hdsId,@Param("hbtNumber") String hbtNumber);
    //修改
    int update_houseBed(@Param("hdId") int hdId,@Param("hdsId") int hdsId,@Param("hbtNumber") String hbtNumber,@Param("hbId") int hbId);
    //根据房源id查询房屋详细
    Homeallinformation select_houseDetails(@Param("haiId") String haiId);

    //根据房屋id查询houseDetails表是否存在
    Housedetails selct_houseDetails_haiId(@Param("haiId") String haiId);
    //根据房屋详细表id删除床型表
    int delete_houseBed(@Param("hdId") int hdId);
}
