package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IPictureService;
import com.miqi.miqihome.common.utils.returnDataStandard;
import com.miqi.miqihome.entity.Picture;
import com.sun.xml.internal.bind.api.impl.NameConverter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 *
 * * 发布者：one
 * * 房屋图片的增、改、查 以及相关信息表的查询
 */


@RestController
@RequestMapping(value = "/pictureController")
public class PictureController {

    @Autowired
    IPictureService pictureService;

    //根据房源id获取图片
    @PostMapping("/select_all_img")
    public List<Picture> select_all_img(@Param("haiId") String haiId){
        return pictureService.select_all_img(haiId);
    }

    @PostMapping("/select_all_picture")
    public List<Picture> select_all_picture(){
        return pictureService.select_all_picture();
    }

    @PostMapping("/select_picture_by_pId")
    public List<Picture> select_picture_by_pId(String pid){
        if(pid!=""&&!pid.equals("")) {
            return pictureService.select_picture_by_pId(Integer.parseInt(pid));
        }
        return null;
    }

    @PostMapping("/select_picture_by_ptId")
    public List<Picture> select_picture_by_ptId(String ptid){
        if(ptid!=""&&!ptid.equals("")) {
            return pictureService.select_picture_by_ptId(Integer.parseInt(ptid));
        }
        return null;
    }


    //添加
    @RequestMapping(value = "/insert_picture",method = RequestMethod.POST)
    @ResponseBody
    public int insert_picture(HttpServletRequest request,MultipartFile file,String ptId)throws IOException {
        //文件存放的位置
        String path=request.getServletContext().getRealPath("/picture");
        File fi=new File(path);
        if(!fi.exists()){
            fi.mkdir();
        }
        //UUID
        String newPicName = UUID.randomUUID().toString();
        String uuid= newPicName+file
                .getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf("."));

        File tempFile=new File(path, uuid);
        file.transferTo(tempFile);

        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("pId","");
        objectMap.put("pUrl","picture"+"\\"+uuid);
        objectMap.put("pPagePicture",0);
        objectMap.put("ptId",ptId);
        int i= pictureService.insert_picture(objectMap);
        return Integer.parseInt(objectMap.get("pId").toString());
    }

    @PostMapping(value = "/update_picture")
    public int update_picture(@RequestBody List<Object> objectList){

        /*
         * 括号后面的参数：根据实际前端请求情况 再填写
         * */
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("pUrl","");
        objectMap.put("pPagePicture",1);
        objectMap.put("ptId",1);
        objectMap.put("pId",1);
        return pictureService.update_picture(objectMap);
    }

    /*
     * 文件上传
     *
     * */
    @PostMapping("/fileUpload")
    public returnDataStandard fileUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //文件存放的位置
        String path = request.getServletContext().getRealPath("/image");

        System.out.println("path:"+path);
        File fi = new File(path);
        if (!fi.exists()) {
            fi.mkdir();
        }
        File tempFile = new File(path, file.getOriginalFilename());
        file.transferTo(tempFile);
        System.out.println(tempFile.getName());
        returnDataStandard standard = new returnDataStandard();
        standard.put("msg", "上传成功!");
        standard.put("data", tempFile.getName());

        return standard;
    }

    //删除图片
    @PostMapping("/delete_picture")
    public int delete_picture(String pId){
        return pictureService.delete_picture(pId);
    }
}
