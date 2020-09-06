package com.example.demo.repository;

import com.example.demo.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StyleRepository extends JpaRepository<Style,Integer> {
    @Query(value = "SELECT styles FROM style WHERE styles IS NOT NULL",nativeQuery = true)
    public List<String> findstyle();
    @Query(value = "SELECT styles FROM style WHERE id=?",nativeQuery = true)
    public String findStyleByid(@Param("id") Integer id);

    @Query(value = "SELECT id FROM style WHERE styles=?",nativeQuery = true)
    public Integer findid(@Param("styles") String styles);
}
