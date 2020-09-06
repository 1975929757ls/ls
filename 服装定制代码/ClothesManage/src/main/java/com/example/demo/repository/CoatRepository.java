package com.example.demo.repository;

import com.example.demo.entity.Coat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoatRepository extends JpaRepository<Coat,Integer> {
}
