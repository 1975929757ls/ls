package com.example.demo.controller;

import com.example.demo.entity.Business;
import com.example.demo.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class BusinessController {
    @Autowired
    private BusinessRepository businessRepository;
    @PostMapping("/pass")
    public String find(@RequestBody Business business){
        System.out.println(business.getName()+business.getPassword());
        Business result=businessRepository.findlogin(business.getName(),business.getPassword());
        if(result!=null){
            return "success";
        }else {
            return "error";
        }
    }
}
