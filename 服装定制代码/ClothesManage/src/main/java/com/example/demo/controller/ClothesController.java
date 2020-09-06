package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {
    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BuliaoRepository buliaoRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    StyleRepository styleRepository;
    @Autowired
    OrdergoodsRepository ordergoodsRepository;
    @PostMapping("/test")
    public String test1(@RequestBody Values values){
        System.out.println(values.toString());
        Clothes clothes=new Clothes();
        int wid=userRepository.findId(values.getUsername());
        System.out.println(wid);
        clothes.setBuliao(values.getMaterials());
        clothes.setClothes(values.getClothes());
        clothes.setColor(values.getColor());
        clothes.setSex(values.getSex());
        clothes.setStyle(values.getStyle());
        clothes.setSize(values.getSize());
        clothes.setWid(wid);
        clothes.setState("未提交");
        clothes.setMake("未制作");
        clothes.setRemarks(values.getRemarks());
        clothes.setPrice(values.getPrice());
        clothesRepository.save(clothes);
        return values.getUsername();
    }
    @PostMapping("/addordergoods")
    public String addorder(@RequestBody Values values){
        System.out.println(values.toString());
       Ordergoods ordergoods=new Ordergoods();
       ordergoods.setSex(values.getSex());
       ordergoods.setSize(values.getSize());
       ordergoods.setClothes(values.getClothes());
       ordergoods.setMake("未制作");
       ordergoods.setRemarks(values.getRemarks());
       ordergoods.setState("未提交");
       int bid=buliaoRepository.findid(values.getMaterials());
       int cid=colorRepository.findid(values.getColor());
       int sid=styleRepository.findid(values.getStyle());
       int uid=userRepository.findId(values.getUsername());
       ordergoods.setBid(bid);
       ordergoods.setCid(cid);
       ordergoods.setSid(sid);
       ordergoods.setUid(uid);
       ordergoodsRepository.save(ordergoods);
        return values.getUsername();
    }
    @GetMapping("/order/{username}")
    public List<OrderResult> findorder(@PathVariable("username")String username){
        int wid=userRepository.findId(username);
        System.out.println(wid);
        return ordergoodsRepository.findpersonal(wid);
    }
    @GetMapping("/ordergoods/{username}")
    public List<OrderResult> findorders(@PathVariable("username")String username){
        int wid=userRepository.findId(username);
        System.out.println(wid);
        return ordergoodsRepository.findpersonal(wid);
    }
    @GetMapping("/orders/{orderid}")
    public List<OrderResult> findbyidorder(@PathVariable("orderid")Integer orderid){
        System.out.println(orderid);
        List<OrderResult> list=new ArrayList<>();
        OrderResult clothes=ordergoodsRepository.findbyid(orderid);
        list.add(clothes);
        return list;
    }

    @GetMapping("/findbyid/{id}")
    public OrderResult find(@PathVariable("id") Integer id){
        return ordergoodsRepository.findbyid(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody ClothesResult clothes){
        Ordergoods r=ordergoodsRepository.findById(clothes.getId()).get();
        Ordergoods ordergoods=new Ordergoods();
        ordergoods.setSex(clothes.getSex());
        ordergoods.setSize(clothes.getSize());
        ordergoods.setClothes(clothes.getClothes());
        ordergoods.setRemarks(clothes.getRemarks());
        ordergoods.setState(clothes.getState());
        ordergoods.setMake(clothes.getMake());
        int bid=buliaoRepository.findid(clothes.getMaterials());
        int cid=colorRepository.findid(clothes.getColors());
        int sid=styleRepository.findid(clothes.getStyles());
        ordergoods.setBid(bid);
        ordergoods.setCid(cid);
        ordergoods.setSid(sid);
        ordergoods.setUid(r.getUid());
        ordergoods.setId(clothes.getId());
        Ordergoods ordergoods1=ordergoodsRepository.save(ordergoods);
        System.out.println(ordergoods1.toString());
        if(ordergoods1!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @PostMapping("/submit/{id}")
    public String submit(@PathVariable("id") Integer id){
        Ordergoods ordergoods=ordergoodsRepository.findById(id).get();
        Ordergoods result=new Ordergoods();
        result.setState("已提交");
        result.setMake(ordergoods.getMake());
        result.setBid(ordergoods.getBid());
        result.setClothes(ordergoods.getClothes());
        result.setCid(ordergoods.getCid());
        result.setSex(ordergoods.getSex());
        result.setSize(ordergoods.getSize());
        result.setSid(ordergoods.getSid());
        result.setUid(ordergoods.getUid());
        result.setId(ordergoods.getId());
        result.setRemarks(ordergoods.getRemarks());
        Ordergoods r=ordergoodsRepository.save(result);
        if(r!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @PostMapping("/makes/{rid}")
    public String makes(@PathVariable("rid") Integer id){
        Ordergoods ordergoods=ordergoodsRepository.findById(id).get();
        Ordergoods result=new Ordergoods();
        result.setState("已提交");
        result.setMake("已制作");
        result.setBid(ordergoods.getBid());
        result.setClothes(ordergoods.getClothes());
        result.setCid(ordergoods.getCid());
        result.setSex(ordergoods.getSex());
        result.setSize(ordergoods.getSize());
        result.setSid(ordergoods.getSid());
        result.setUid(ordergoods.getUid());
        result.setId(ordergoods.getId());
        result.setRemarks(ordergoods.getRemarks());
        Ordergoods r=ordergoodsRepository.save(result);
        if(r!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @PostMapping("/delete/{rid}")
    public String delete(@PathVariable("rid") Integer id){
        Ordergoods ordergoods=ordergoodsRepository.findById(id).get();
        ordergoodsRepository.delete(ordergoods);
        return "success";
    }
}
