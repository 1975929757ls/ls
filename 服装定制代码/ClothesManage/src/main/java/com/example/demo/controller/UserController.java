package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/find")
    public User findby(){
        return userRepository.findbyname("mf");
    }

    @GetMapping("/findall")
    public User find(){
        return userRepository.findById(1).get();
    }
    @GetMapping("/pageall/{page}/{size}")
    public Page<User> findpage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return userRepository.findAll(pageRequest);
    }
    @GetMapping("/alluser")
    public List<User> findall(){
        return userRepository.findAll();
    }
    @GetMapping("/data/{username}")
    public List<User> findbyname(@PathVariable("username") String username){
        System.out.println(username);
        List<User> list=new ArrayList<>();
        int id=userRepository.findId(username);
        User user=userRepository.findById(id).get();
        System.out.println(user.toString());
        list.add(user);
        return list;
    }
    @GetMapping("/info/{username}")
    public User findinfo(@PathVariable("username") String username){
        System.out.println(username);
        int id=userRepository.findId(username);
        User user=userRepository.findById(id).get();
        return user;
    }
    @PostMapping("/login")
    public String findbynamepassword(@RequestBody User user){
        System.out.println(user.getName()+user.getPassword());
        User user1=userRepository.findbynamepassword(user.getName(),user.getPassword());
        if(user1!=null){
            System.out.println("success");
            System.out.println(user1.getId());
            return "success";

        }else {
            System.out.println("error");
            return "error";
        }
    }
    @PostMapping("/findresult/{username}")
    public String findresult(@PathVariable("username") String username){
        System.out.println(username);
        User user=userRepository.findbyname(username);
        if(user!=null){
            return "success";
        }else {
            return "error";
        }

    }
    @PostMapping("/register")
    public String save(@RequestBody User user){
        System.out.println(user.getName()+user.getPhone()+user.getPassword());
        User ur=userRepository.findbyname(user.getName());
        if(ur!=null){
            System.out.println("已有用户");
            return "error";
        }else {
            User user1=userRepository.save(user);
            return "success";
        }
    }
    @PostMapping("/findid")
    public String findid(@RequestBody User user){
        System.out.println(user.getName()+"前端传到后端");
        int id=userRepository.findId(user.getName());
        System.out.println(id+"获取到的值");
        if(id!=0) {
            String s1 = String.valueOf(id);
            return s1;
        }else {
            return "error";
        }
    }
    @PostMapping("/update")
    public String updatedata(@RequestBody User user){
        userRepository.save(user);
        return "success";
    }
}
