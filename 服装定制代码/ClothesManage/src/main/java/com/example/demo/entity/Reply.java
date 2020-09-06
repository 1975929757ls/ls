package com.example.demo.entity;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class Reply {
    private Integer cid;
    private Integer bid;
    private String reply;
}
