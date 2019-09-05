package com.mylast.services;

import com.mylast.dao.StudentsDao;
import com.mylast.domain.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServices {
    @Autowired
    private StudentsDao studentsDao;
    public List<Students> findall(){
        return studentsDao.findall();
    }
    public Students findBynameAndpassword(String name,String password){
        return studentsDao.findBynameAndpassword(name,password);
    }
    public Students findBstudentsIDAndpassword(int studentID,String password){
        return studentsDao.findBstudentsIDAndpassword(studentID,password);
    }
    public Students findBystudentID(int studentID){
        return studentsDao.findBstudentsID(studentID);
    }
    public Students findnameidpassword(String name,int studnetID,String password){
        return studentsDao.findBynameAndstudentID(name,studnetID,password);
    }
    public void add(Students students){
        studentsDao.insertStudent(students);
    }
    public void delete(int studentID){
        studentsDao.delete(studentID);
    }
    public void update(Students students){
        studentsDao.update(students);
        System.out.println("修改成功");
    }
}
