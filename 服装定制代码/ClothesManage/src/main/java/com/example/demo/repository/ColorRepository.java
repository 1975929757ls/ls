package com.example.demo.repository;

import com.example.demo.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color,Integer> {
    @Query(value = "SELECT colors FROM color WHERE colors IS NOT NULL",nativeQuery = true)
    public List<String> findcolor();
    @Query(value = "SELECT colors FROM color WHERE id=?",nativeQuery = true)
    public String findColorsByid(@Param("id") Integer id);

    @Query(value = "SELECT id FROM color WHERE colors=?",nativeQuery = true)
    public Integer findid(@Param("colors") String colors);
}
