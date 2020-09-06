package com.example.demo.repository;

import com.example.demo.entity.Business;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusinessRepository extends JpaRepository<Business,Integer> {
    @Query(value = "select * from business where name=? and password=?",nativeQuery = true)
    public Business findlogin(@Param("name") String name, @Param("password") String password);
}
