package com.example.demo.repository;

import com.example.demo.entity.Buliao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuliaoRepository extends JpaRepository<Buliao,Integer> {
    @Query(value = "SELECT price FROM buliao WHERE materials=?",nativeQuery = true)
    public Integer findprice(@Param("materials")String materials);
    @Query(value = "SELECT materials FROM buliao WHERE id=?",nativeQuery = true)
    public String findBuliaoByoByid(@Param("id") Integer id);

    @Query(value = "SELECT price FROM buliao WHERE id=?",nativeQuery = true)
    public Integer findPriceByid(@Param("id") Integer id);

    @Query(value = "SELECT id FROM buliao WHERE materials=?",nativeQuery = true)
    public Integer findid(@Param("materials") String materials);

    @Query(value = "SELECT materials FROM buliao WHERE materials IS NOT NULL",nativeQuery = true)
    public List<String> findmaterials();
}
