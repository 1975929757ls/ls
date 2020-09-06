package com.example.demo.repository;

import com.example.demo.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture,Integer> {
    @Query(value = "SELECT src FROM picture",nativeQuery = true)
    public List<String> findsrc();
    @Query(value = "SELECT info FROM picture",nativeQuery = true)
    public List<String> findinfo();
}
