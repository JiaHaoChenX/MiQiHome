package com.miqi.miqihome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/test")
public class testController {
    @GetMapping("/test01")
    public String test01(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        return "我只是一个测试类";
    }
}
