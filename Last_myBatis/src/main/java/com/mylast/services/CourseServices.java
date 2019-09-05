package com.mylast.services;

import com.mylast.dao.CourseDao;
import com.mylast.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {
    @Autowired
    CourseDao courseDao;
    public List<Course> find(){
        return courseDao.findall();
    }
    public Course findbyCourseID(int CourseID){
        return courseDao.findbyCourseID(CourseID);
    }
    public Course findbybane(String CourseName){
        return courseDao.findbyname(CourseName);
    }
    public List<Course> findbystudentID(int studentID){
        return courseDao.findbystudentID(studentID);
    }
}
