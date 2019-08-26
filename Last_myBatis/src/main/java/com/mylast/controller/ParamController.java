package com.mylast.controller;

import com.mylast.domain.Students;
import com.mylast.domain.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping(value = "/chuancan",method={RequestMethod.POST})
    public String work(Students students){
        System.out.println(students);
        return "success";
    }
    @RequestMapping(value = "/chuan",method = {RequestMethod.POST})
    public String works(Users users){
        System.out.println(users);
        return "success";
    }
    @RequestMapping(value = "/testRequestParam",method = {RequestMethod.GET})
    public String testRequestParam(@RequestParam(name = "name") String value){
        System.out.println(value);
        return "success";
    }
    @RequestMapping(value = "/testRequestBody",method = {RequestMethod.POST})
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping(value = "/testPathVariable/{id}",method = {RequestMethod.GET})
    public String testPathVariable(@PathVariable(name = "id") String value){
        System.out.println(value);
        return "success";
    }
}
