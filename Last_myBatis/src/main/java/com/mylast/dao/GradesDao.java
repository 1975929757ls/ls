package com.mylast.dao;


import com.mylast.domain.Grades;
import com.mylast.domain.Students;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Repository
public interface GradesDao {
    @Select("select * from grades")
    public List<Grades> findall();

    @Select("select * from grades where studentID=#{studentID}")
    public List<Grades> findBystudentID(@Param("studentID") int studentsID);

    @Select("select * from grades where CourseID=#{CourseID}")
    public List<Grades> findByCourseID(@Param("CourseID") int CourseID);

    @Select("select * from grades where CourseID=#{CourseID} and studentID=#{studentID}")
    public Grades findByCourseIDandCouseID(@Param("studentID") int studentID,@Param("CourseID") int CourseID );

    @Insert("insert into grades(studentID,CourseID,CourseName,num,teachername,studentname) values(#{studentID},#{CourseID},#{CourseName},#{num},#{teachername},#{studentname})")
    public void insert(Grades grades);

    @Delete("delete from grades where studentID=#{studentID} and CourseID=#{CourseID}")
    void delete(int studentID, int CourseID);

    @Update("update grades set  studentID=#{studentID},CourseID=#{CourseID},CourseName=#{CourseName},num=#{num},teachername=#{teachername} ,studentname=#{studentname}  where  CourseID=#{CourseID} and studentID=#{studentID}")
     void update(Grades grades);

    @Update("update grades set studentID=#{studentID},CourseID=#{CourseID},CourseName=#{CourseName},num=#{num},teachername=#{teachername} ,studentname=#{studentname} where  CourseName=#{CourseName}")
    void update1(String  CourseName);

    @Delete("delete from grades where studentID=#{studentID}")
    public void delete1(int studentID);
}
