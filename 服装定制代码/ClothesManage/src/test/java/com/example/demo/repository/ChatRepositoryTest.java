package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChatRepositoryTest {
    @Autowired
    ChatRepository chatRepository;
    @Autowired
    AskRepository askRepository;
    @Test
    public void test1(){
        System.out.println(chatRepository.findname());
    }
    @Test
    public void test2(){
        System.out.println(askRepository.findreplybyinfo("将ID为1的订单尺寸改为xl"));
    }
}