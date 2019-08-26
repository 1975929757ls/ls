package com.mylast.controller;

import com.mylast.domain.Manager;
import com.mylast.domain.Students;
import com.mylast.domain.Users;
import com.mylast.services.ManagerServices;
import com.mylast.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/first")
public class admin {
    @Autowired
    StudentServices studentServices;
    @Autowired
    ManagerServices managerServices;

    @RequestMapping("/student")
    public String changeStudent(){
        return "students";
    }
    @RequestMapping("/teacher")
    public String changeTeacher(){
        return "teachers";
    }
    @RequestMapping("/loginst")
    public String login(String name,String password){
        if(name.equals("") || password.equals("")){
            return "false";
        }else {
            Students students=studentServices.findBynameAndpassword(name,password);
            if(students==null){
                return "false";
            }else{
                return "st";
            }
        }
    }
    @RequestMapping("/loginth")
    public String login1(String name,String password, Model model){
        if(name.equals("") || password.equals("")){
            return "false";
        }else {
            Manager manager = managerServices.findBynameAndpassword(name, password);
            if(manager==null){
                return "false";
            }else{
                return "information";
            }
        }
    }
}
