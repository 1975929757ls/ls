package com.example.demo.controller;

import com.example.demo.entity.Picture;
import com.example.demo.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    PictureRepository pictureRepository;
    @GetMapping("/find")
    public List<String> list(){
        return pictureRepository.findsrc();
    }
    @GetMapping("/info")
    public List<String> infolist(){
        return pictureRepository.findinfo();
    }
    @GetMapping("/all")
    private List<Picture> find(){
        return pictureRepository.findAll();
    }
    @PostMapping("/delete/{rid}")
    public void delete(@PathVariable("rid") Integer id){
        pictureRepository.deleteById(id);
    }
    @PostMapping("/add")
    public void add(){

    }
}
