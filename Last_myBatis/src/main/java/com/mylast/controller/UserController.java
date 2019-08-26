package com.mylast.controller;

import com.mylast.domain.Students;
import com.mylast.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    StudentServices studentServices;
    @RequestMapping("/login1")
    public String login1(String name,String password){
        System.out.println("cdhdfkjkfjlk;fj;sa");
        if(name.equals("") || password.equals("")){
            return "false";
        }else {
            Students students=studentServices.findBynameAndpassword(name,password);
            if(students==null){
                return "false";
            }else{
                return "add";
            }
        }
    }
    @RequestMapping("/pass")
    public String pass(){
        ModelAndView mv=new ModelAndView();
        return "pass";
    }
}
