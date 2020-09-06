package com.example.demo.repository;

import com.example.demo.entity.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatternRepository extends JpaRepository<Pattern,Integer> {
    @Query(value = "SELECT style FROM pattern WHERE style IS NOT NULL",nativeQuery = true)
    public List<String> findstyle();
    @Query(value = "SELECT buliao FROM pattern WHERE buliao IS NOT NULL",nativeQuery = true)
    public List<String> findbuliao();
    @Query(value = "SELECT color FROM pattern WHERE color IS NOT NULL",nativeQuery = true)
    public List<String> findcolor();
    @Query(value = "SELECT size FROM pattern WHERE size IS NOT NULL",nativeQuery = true)
    public List<String> findsize();

}
