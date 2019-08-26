package com.mylast.dao;

import com.mylast.domain.Manager;
import com.mylast.domain.Students;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDao {
    @Select("select * from manager where name=#{name}and password=#{password}")
    public Manager findBynameAndpassword(@Param("name") String name, @Param("password") String password);
}
