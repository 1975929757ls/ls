package com.example.demo.controller;

import com.example.demo.entity.Pants;
import com.example.demo.repository.PantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pant")
public class PantController {
    @Autowired
    PantRepository pantRepository;
    @GetMapping("/find")
    public List<Pants> find(){
        return pantRepository.findAll();
    }
}
