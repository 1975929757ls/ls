package com.mylast.services;

import com.mylast.dao.GradesDao;
import com.mylast.domain.Grades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradesServices {
    @Autowired
    GradesDao gradesDao;
    public List<Grades> find(){
        return gradesDao.findall();
    }
    public List<Grades> findBystudentID(int studentID){
        return gradesDao.findBystudentID(studentID);
    }
    public List<Grades> findByCourseID(int CourseID){
        return gradesDao.findByCourseID(CourseID);
    }
    public Grades findbyCourseIDandstudentID(int studentID,int CourseID){
        return gradesDao.findByCourseIDandCouseID(studentID,CourseID);
    }
    public void add(Grades grades){
        gradesDao.insert(grades);
        System.out.println("添加成功");
    }
    public void delete(int studentID,int CourseID){
        gradesDao.delete(studentID,CourseID);
    }
    public void delete1(int studentID){
        gradesDao.delete1(studentID);
    }
    public void update(Grades grades){
        gradesDao.update(grades);
    }
    public void update1(String  CourseName){
        gradesDao.update1(CourseName);
    }
}
