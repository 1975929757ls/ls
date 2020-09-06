package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Ordergoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer bid;
    private Integer cid;
    private Integer sid;
    private Integer uid;
    private String clothes;
    private String size;
    private String state;
    private String make;
    private String remarks;
    private String sex;
}
