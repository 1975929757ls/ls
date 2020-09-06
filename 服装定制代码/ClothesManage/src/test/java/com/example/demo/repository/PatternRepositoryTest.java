package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatternRepositoryTest {
    @Autowired
    private PatternRepository patternRepository;
    @Autowired
    private ClothesRepository waitaoRepository;
    @Test
    void fid(){
        System.out.println(patternRepository.findsize());
    }
//    @Test
//    void findw(){
//        System.out.println(waitaoRepository.findAll());
//    }
}