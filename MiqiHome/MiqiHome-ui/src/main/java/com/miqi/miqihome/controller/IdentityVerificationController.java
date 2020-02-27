package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IIdentityVerificationService;

import com.miqi.miqihome.common.utils.returnDataStandard;
import com.miqi.miqihome.entity.Identityverification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/*
 * 发布人：one
 * 资质认证 增改查
 *
 * */

@RestController
@RequestMapping(value = "/identityVerificationController")
public class IdentityVerificationController {

    @Autowired
    IIdentityVerificationService iIdentityVerificationService;


    @RequestMapping("/select_all_identityVerification")
    @ResponseBody
    public List<Identityverification> select_all_identityVerification(@RequestBody List<Object> objectList){
        /*
        * 根据前端传来的参数而定
        * */
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("","");
        objectMap.put("","");
        objectMap.put("uiId",2);
        return iIdentityVerificationService.select_all_identityVerification(objectMap);
    }

    @RequestMapping("/insert_identityVerification")
    @ResponseBody
    public int insert_identityVerification(@RequestBody Identityverification identityverification){
        if(iIdentityVerificationService.select_identityVerification(identityverification)>0){
            return iIdentityVerificationService.update_identityVerification(identityverification);
        }else {
            return iIdentityVerificationService.insert_identityVerification(identityverification);
        }
    }

    /*
     * 文件上传
     *
     * */
    @RequestMapping(value = "/insert_identityVerification_picture",method = RequestMethod.POST)
    @ResponseBody
    public int insert_picture(HttpServletRequest request,MultipartFile file,String haiId)throws IOException {
        //文件存放的位置
        String path=request.getServletContext().getRealPath("/user_picture");
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
        Identityverification identityverification=new Identityverification();
        identityverification.setIvUrl("user_picture"+"/"+uuid);
        identityverification.setHaiId(Integer.parseInt(haiId));
        if(iIdentityVerificationService.select_identityVerification_haiId(haiId)>0){
            return iIdentityVerificationService.update_identityVerification(identityverification);
        }else {
            return iIdentityVerificationService.insert_identityVerification(identityverification);
        }
    }

    //根据房源编号查询
    @RequestMapping("/select_identityVerification_haiId2")
    @ResponseBody
    public Identityverification select_identityVerification_haiId2(String haiId){
        return iIdentityVerificationService.select_identityVerification_haiId2(haiId);
    }
}
