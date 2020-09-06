package com.example.demo.repository;

import com.example.demo.entity.Business;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BusinessRepositoryTest {
    @Autowired
    private BusinessRepository businessRepository;
    @Test
    void find(){
        Business business=businessRepository.findlogin("admin","admin");
        System.out.println(business.toString());
    }
}