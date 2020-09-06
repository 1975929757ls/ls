package com.example.demo.repository;


import com.example.demo.entity.Clothes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClothesRepositoryTest {
    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired CoatRepository coatRepository;
    @Test
    void tests(){
        System.out.println(clothesRepository.test1());
    }
    @Test
    void tests1(){
        System.out.println(coatRepository.findAll());
    }
    @Test
    void test(){
        System.out.println(clothesRepository.findById(2));
    }
    @Test
    void test1(){
        Clothes waitao=new Clothes();
        waitao.setWid(13);
        waitao.setStyle("工装");
        waitao.setSize("L");
        waitao.setSex("女");
        waitao.setClothes("外套");
        waitao.setBuliao("混纺");
        waitao.setColor("黑色");
//        System.out.println(waitaoRepository.findAll());
//        waitaoRepository.insert("丝绸","ins潮","XL","白色","男","外套",2);
//
//         waitaoRepository.insert(2,"ins潮","红","丝绸","女","外套","L");
        clothesRepository.save(waitao);
    }
    @Test
    public void test5(){
        System.out.println(clothesRepository.findmake("已制作"));
    }
//    @Test
//    public void sum(){
//        System.out.println(clothesRepository.sum("已制作"));
//    }
}