package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Values {
    private String materials;
    private String style;
    private String size;
    private String color;
    private String sex;
    private String clothes;
    private String username;
    private String remarks;
    private Integer price;
}
