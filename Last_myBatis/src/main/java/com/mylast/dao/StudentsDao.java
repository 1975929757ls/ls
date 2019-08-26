package com.mylast.dao;


import com.mylast.domain.Students;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentsDao {
    @Select("select * from students")
    public List<Students> findall();

    @Select("select * from students where name=#{name}and password=#{password}")
    public Students findBynameAndpassword(@Param("name") String name, @Param("password") String password);

    @Select("select * from students where name=#{name}")
    Students findbyename(@Param("name") String name);

    @Select("select * from students where name=#{name}and studentID=#{studentID} and password=#{password}")
    public Students findBynameAndstudentID(@Param("name") String name,@Param("studentID") int studentID, @Param("password") String password);

    @Select("select * from students where studentID=#{studentID}and password=#{password}")
    public Students findBstudentsIDAndpassword(@Param("studentID") int studentID, @Param("password") String password);

    @Select("select * from students where studentID=#{studentID}")
    public Students findBstudentsID(@Param("studentID") int studentID);

    @Insert("insert into students(studentID,name,password,sex,colege,major,phone) values(#{studentID},#{name},#{password},#{sex},#{colege},#{major},#{phone})")
    void insertStudent(Students students);
    @Delete("delete from students where studentID=#{studentID}")
    void delete(int studentID);

    @Update("update students set studentID=#{studentID},name=#{name},password=#{password},sex=#{sex},colege=#{colege},major=#{major},phone=#{phone} where studentID=#{studentID} and name=#{name}")
    void update(Students students);
    //模糊查找
    @Select("select * from students where name like #{name}")
    List<Students> findlike(String name);
    //模糊查找
    @Select("select * from students where name like '${value}%'")
    List<Students> findlike1(String name);
    //查询总数
    @Select("select count(*) from students")
    int Number();
}
