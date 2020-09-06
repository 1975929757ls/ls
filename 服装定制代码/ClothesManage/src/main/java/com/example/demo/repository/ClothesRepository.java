package com.example.demo.repository;

import com.example.demo.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClothesRepository extends JpaRepository<Clothes,Integer> , JpaSpecificationExecutor {
    @Query(value = "select * from clothes where wid=?",nativeQuery = true)
    public List<Clothes> findbywid(@Param("wid") int wid);
    @Query(value = "select * from clothes where make=?",nativeQuery = true)
    public List<Clothes> findmake(@Param("make") String make);
//    @Query(value = "select sum( where make=?)from clothes ",nativeQuery = true)
//    public List<Clothes> sum(@Param("make") String make);
    @Query(value = "select * from clothes where id=?",nativeQuery = true)
     public Clothes findid(@Param("id") Integer id);
    @Query(value = "select price from clothes ",nativeQuery = true)
    public List<Integer> sum();
    @Query(value = "select price from clothes where wid=? ",nativeQuery = true)
    public List<Integer> findsum(@Param("wid") Integer wid);
    @Query(value = "select price ,buliao from clothes  ",nativeQuery = true)
    public List<String> test1();
}
