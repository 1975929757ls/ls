package com.mylast.controller;

//控制器类

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/user")
public class HelloController {
    //@RequestMapping(path = "/hello")
    @RequestMapping(value= "/hello",method = {RequestMethod.GET})
    public String say(){
        System.out.println("HELLO");
        return "success";
    }

}
