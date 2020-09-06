package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer> , JpaSpecificationExecutor{
    @Query(value = "select * from user where name=? and password=?",nativeQuery = true)
    public User findbynamepassword(@Param("name") String name, @Param("password") String password);
    @Query(value = "select * from user where name=?",nativeQuery = true)
    public User findbyname(@Param("name") String name);
    @Query(value = "SELECT id FROM USER WHERE NAME=?",nativeQuery = true)
    public Integer findId(@Param("name") String name);
}
