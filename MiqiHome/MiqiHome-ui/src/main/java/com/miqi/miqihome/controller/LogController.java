package com.miqi.miqihome.controller;


import com.miqi.miqihome.common.utils.JSONUtil;
import com.miqi.miqihome.common.utils.returnDataStandard;
import com.sun.xml.internal.bind.api.impl.NameConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping("logController")
public class LogController {

    @PostMapping("/sendLog")
    public void sendLog(HttpServletRequest request, HttpServletResponse response){
        returnDataStandard standard=new returnDataStandard();

        String pathname = "C:\\Users\\47267\\Desktop\\MiqiLogger\\info.log";
        StringBuilder result = new StringBuilder();
        try{
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");

            InputStreamReader isr = new InputStreamReader(new FileInputStream(pathname), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+"<br/>"+s);
            }
            br.close();
            standard.put("msg",result.toString());
            response.getWriter().print(JSONUtil.toJson(standard));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
