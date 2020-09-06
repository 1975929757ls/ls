package com.example.demo.controller;

import com.example.demo.entity.Clothes;
import com.example.demo.entity.ClothesResult;
import com.example.demo.entity.OrderResult;
import com.example.demo.entity.Ordergoods;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class AllOrder {
    @Autowired
    ClothesRepository waitaoRepository;
    @Autowired
    OrdergoodsRepository ordergoodsRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    BuliaoRepository buliaoRepository;
    @Autowired
    StyleRepository styleRepository;
    @GetMapping("/order")
    public List<Clothes> find(){
        return waitaoRepository.findAll();
    }
    @GetMapping("/allgoods")
    public List<ClothesResult> allorder(){
        List<ClothesResult> res=new ArrayList<>();
        List<Ordergoods> list=ordergoodsRepository.findAll();
        for(int i=0;i<list.size();i++){
            ClothesResult clothes=new ClothesResult();
            clothes.setId(list.get(i).getId());
            clothes.setClothes(list.get(i).getClothes());
            clothes.setMake(list.get(i).getMake());
            clothes.setState(list.get(i).getState());
            clothes.setRemarks(list.get(i).getRemarks());
            clothes.setSex(list.get(i).getSex());
            clothes.setSize(list.get(i).getSize());
            clothes.setColors(colorRepository.findColorsByid(list.get(i).getCid()));
            clothes.setMaterials(buliaoRepository.findBuliaoByoByid(list.get(i).getBid()));
            clothes.setPrice(buliaoRepository.findPriceByid(list.get(i).getBid()));
            clothes.setStyles(styleRepository.findStyleByid(list.get(i).getSid()));
            res.add(clothes);
        }
        return res;
    }
    @GetMapping("/pageall/{page}/{size}")
    public Page<Clothes> findpage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<Clothes> page1=waitaoRepository.findAll(pageRequest);
        System.out.println(page1.getTotalElements());
        return waitaoRepository.findAll(pageRequest);
    }
    @GetMapping("/ceshi")
    public List<OrderResult> ceshi(){
        return ordergoodsRepository.findres();
    }
    @GetMapping("/pagetest/{page}/{size}")
    public Page<OrderResult> pagetest(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<OrderResult> page1=ordergoodsRepository.findpage(pageRequest);
        return ordergoodsRepository.findpage(pageRequest);
    }
    @GetMapping("/findmake")
    public List<OrderResult> findmake(){
        return ordergoodsRepository.findmake("已制作");
    }

    @PostMapping("/orderid/{id}")
    public String orderbyid(@PathVariable("id") Integer id){
        System.out.println(id);
        Ordergoods clothes=ordergoodsRepository.findById(id).get();
        System.out.println(clothes);
        if(clothes!=null){
            return "success";
        }else {
            return "error";
        }
    }

}
