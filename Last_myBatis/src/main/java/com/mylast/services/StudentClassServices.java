package com.mylast.services;

import com.mylast.dao.StudentClassDao;
import com.mylast.domain.Course;
import com.mylast.domain.studentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassServices {
    @Autowired
    StudentClassDao studentClassDao;
    public List<studentClass> find(){
        return studentClassDao.find();
    }
    public List<studentClass> findbystudentID(int studentID){
        return studentClassDao.findbystudentID(studentID);
    }
    public List<Integer> findid(int studentID){
        return studentClassDao.findid(studentID);
    }
    public void add(studentClass studentClass){
        studentClassDao.insert(studentClass);
    }
}
