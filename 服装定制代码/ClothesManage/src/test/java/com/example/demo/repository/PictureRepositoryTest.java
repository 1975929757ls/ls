package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PictureRepositoryTest {
    @Autowired
    PictureRepository pictureRepository;
    @Test
    public void test1(){
        System.out.println(pictureRepository.findAll());
    }
    @Test
    public void test2(){
        System.out.println(pictureRepository.findsrc());
    }
}