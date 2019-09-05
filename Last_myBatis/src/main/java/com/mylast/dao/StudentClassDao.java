package com.mylast.dao;

import com.mylast.domain.Course;
import com.mylast.domain.studentClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentClassDao {
    @Select("select * from studentclass")
    public List<studentClass> find();

    @Select("select * from studentclass where studentID=#{studentID}  ")
    public List<studentClass> findbystudentID(@Param("studentID") int studentID);

    @Select("select CourseID from studentclass where studentID=#{studentID}  ")
    public List<Integer> findid(@Param("studentID") int studentID);

    @Insert("insert into studentclass(CourseID,studentID,CourseName) value(#{CourseID},#{studentID},#{CourseName})")
    public void insert(studentClass studentClass);
}
