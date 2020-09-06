package com.example.demo.repository;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void fid(){
        User user=userRepository.findById(1).get();
        System.out.println(user.toString());
    }
    @Test
    void findall(){
        System.out.println(userRepository.findbynamepassword("mf","1234"));
    }
    @Test
    void all(){
        System.out.println(userRepository.findAll());
    }
    @Test
    void save(){
        User user=new User();
        user.setName("ly");
        user.setPassword("1234");
        user.setPhone("17882786601");
        user.setId(15);
        userRepository.save(user);
    }
    @Test
    void page(){
        PageRequest pageRequest=PageRequest.of(0,3);
        Page<User> page=userRepository.findAll(pageRequest);
        int i=1;
    }
}