package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer wid;
    private Integer price;
    private String style;
    private String color;
    private String buliao;
    private String sex;
    private String size;
    private String clothes;
    private String state;
    private String remarks;
    private String make;
}
