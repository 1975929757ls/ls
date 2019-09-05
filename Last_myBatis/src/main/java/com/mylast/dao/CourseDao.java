package com.mylast.dao;

import com.mylast.domain.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    @Select("select * from schooltimetable")
    public List<Course> findall();
    @Select("select * from schooltimetable where CourseID=#{CourseID}")
    public Course findbyCourseID(@Param("CourseID")int CourseID);
    @Select("select * from schooltimetable where  CourseName=#{CourseName}")
    public Course findbyname(@Param("CourseName")String CourseName);
    //SELECT * FROM schooltimetable INNER  JOIN  studentclass ON studentclass.CourseID=schooltimetable.CourseID AND studentID=416
    @Select("select * from schooltimetable inner join studentclass on studentclass.CourseID=schooltimetable.CourseID AND studentID=#{studentID}")
    public List<Course> findbystudentID(@Param("studentID")int studentID);

    @Insert("insert into schooltimetable(CourseID,CourseName,teacher,classroom,info) value(#{CourseID},#{CourseName},#{teacher},#{classroom},#{info})")
    public void insert(Course course);
}
