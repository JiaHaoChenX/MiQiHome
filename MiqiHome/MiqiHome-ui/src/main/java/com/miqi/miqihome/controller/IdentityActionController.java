package com.miqi.miqihome.controller;

import com.miqi.miqihome.Iservice.IIdentityActionService;
import com.miqi.miqihome.entity.Identityaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * 发布人：one
 * 认证方式 增改查
 *
 * */

@RestController
@RequestMapping(value = "/identityActionController")
public class IdentityActionController {

    @Autowired
    IIdentityActionService identityActionService;

    @PostMapping("/select_all_identityAction")
    public List<Identityaction> select_all_identityAction(){
        List<Identityaction> identityactionList=identityActionService.select_all_identityAction();
        return identityactionList;
    }

    @PostMapping("/select_identityAction_by_iaId")
    public Identityaction select_identityAction_by_iaId(HttpServletRequest request){
        String iaId=request.getParameter("iaid");
        if (iaId!="") {
           return identityActionService.select_identityAction_by_iaId(Integer.parseInt(iaId));
        }
        return null;
    }

    @PostMapping("/insert_identityAction")
    public int insert_identityAction(HttpServletRequest request){
        String iaName=request.getParameter("ianame");
        if(iaName!="") {
           return identityActionService.insert_identityAction(iaName);
        }else{
            return -1;
        }
    }

    @PostMapping("/update_identityAction")
    public int update_identityAction(@RequestBody List<Object>objectList){
        Map<String ,Object>objectMap=new HashMap<String, Object>();
        objectMap.put("iaName",objectList.get(0).toString());
        objectMap.put("iaId",objectList.get(1).toString());
        return identityActionService.update_identityAction(objectMap);
    }
}
