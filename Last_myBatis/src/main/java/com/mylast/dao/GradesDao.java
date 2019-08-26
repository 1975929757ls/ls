package com.mylast.dao;


import com.mylast.domain.Grades;
import com.mylast.domain.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GradesDao {
    @Select("select * from grades")
    public List<Grades> findall();
    @Select("select * from grades where studentID=#{studentID}")
    public List<Grades> findBystudentID(@Param("studentID") int studentsID);
    @Select("select * from grades where CourseID=#{CourseID}")
    public List<Grades> findByCourseID(@Param("CourseID") int CourseID);
    @Insert("insert into grades(studentID,,CourseID,CourseName,num,teachername) values(#{studentID},#{CourseID},#{CourseName},#{num},#{teachername})")
    public void insert(Grades grades);
    @Delete("delete from grades where studentID=#{studentID} and CourseID=#{CourseID}")
    public void delete(int studentID, int CourseID);
    @Update("update grades set studentID=#{studentID},CourseID=#{CourseID},CourseName=#{CourseName},num=#{num},teachername=#{teachername} where studentID=#{studentID} and CourseName=#{CourseName}")
    public void update(Grades grades);
}
