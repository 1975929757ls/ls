package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrdergoodsRepositoryTest {
    @Autowired
    OrdergoodsRepository ordergoodsRepository;
    @Test
    private void test1111(){
        System.out.println(ordergoodsRepository.findpersonal(1));
    }

}