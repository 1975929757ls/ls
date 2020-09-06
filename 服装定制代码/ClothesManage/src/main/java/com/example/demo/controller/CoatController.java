package com.example.demo.controller;

import com.example.demo.entity.Coat;
import com.example.demo.repository.CoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coat")
public class CoatController {
    @Autowired
    CoatRepository coatRepository;
    @GetMapping("/find")
    public List<Coat> find(){
        return coatRepository.findAll();
    }
}
