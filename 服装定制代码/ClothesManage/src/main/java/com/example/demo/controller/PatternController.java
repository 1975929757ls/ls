package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.BuliaoRepository;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.PatternRepository;
import com.example.demo.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pattern")
public class PatternController {
    @Autowired
    private PatternRepository patternRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    BuliaoRepository buliaoRepository;
    @Autowired
    StyleRepository styleRepository;
    @GetMapping("/find")
    public List<Pattern> find(){
        return patternRepository.findAll();
    }
    @GetMapping("/findcolor")
    public List<String> findc(){
        return colorRepository.findcolor();
    }
    @GetMapping("/findall")
    public List<Type> findall(){
        List<Color> list=colorRepository.findAll();
        List<Buliao> list1=buliaoRepository.findAll();
        List<Style> list2=styleRepository.findAll();
        List<Type> typeList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Type type=new Type();
            type.setBuliao(list1.get(i).getMaterials());
            type.setPrice(list1.get(i).getPrice());
            type.setColor(list.get(i).getColors());
            type.setStyle(list2.get(i).getStyles());
            typeList.add(type);
        }
        return typeList;
    }
    @GetMapping("/style")
    public List<String> findstyle(){
        return styleRepository.findstyle();
    }
    @GetMapping("/price/{buliao}")
    public int findprice(@PathVariable("buliao") String buliao){
        return buliaoRepository.findprice(buliao);
    }

    @GetMapping("/color")
    public List<String> findcolor(){
        return colorRepository.findcolor();
    }
    @GetMapping("/size")
    public List<String> findsize(){
        return patternRepository.findsize();
    }
    @GetMapping("/buliao")
    public List<String> findbuliao(){
        return buliaoRepository.findmaterials();
    }
    @PostMapping("/add")
    public String add(@RequestBody Pattern pattern){
        System.out.println(pattern.toString());
        Pattern result=new Pattern();
        result.setBuliao(pattern.getBuliao());
        result.setColor(pattern.getColor());
        result.setSize(pattern.getSize());
        result.setStyle(pattern.getStyle());
        Pattern pattern1=patternRepository.save(result);
        if(pattern1!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @PostMapping("/addall")
    public String addall(@RequestBody Type type){
        System.out.println(type.toString());
        Color color=new Color();
        Style style=new Style();
        Buliao buliao=new Buliao();
        color.setColors(type.getColor());
        style.setStyles(type.getStyle());
        buliao.setMaterials(type.getBuliao());
        buliao.setPrice(type.getPrice());
        Color color1=colorRepository.save(color);
        Buliao buliao1=buliaoRepository.save(buliao);
        Style style1=styleRepository.save(style);
        if(color1!=null||buliao1!=null||style1!=null){
            return "success";
        }else {
            return "error";
        }

    }
}
