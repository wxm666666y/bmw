package com.bimowu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/5
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String Test(){
        System.out.println("访问了test页面……");
        return "test";
    }

}