package com.mylast.controller;

import com.mylast.dao.StudentClassDao;
import com.mylast.domain.Course;
import com.mylast.domain.studentClass;
import com.mylast.services.CourseServices;
import com.mylast.services.StudentClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import static java.lang.System.out;

@Controller
@RequestMapping("/course")
public class studentClassController {
    @Autowired
    StudentClassServices studentClassServices;
    @Autowired
    CourseServices courseServices;
    @RequestMapping("/owncourse")
    public String ownCourse(@RequestParam(name = "studentID")String studentID,Model model){
        int id=Integer.parseInt(studentID);
       List<Course> courseList=courseServices.findbystudentID(id);
       model.addAttribute("courseList",courseList);
        return "ownCourselist";
    }
    @RequestMapping("/addcourse")
    public String addcourse(Model model,@RequestParam(name = "studentID")String studentID){
        List<Course> courseList=courseServices.find();
        model.addAttribute("studentID",studentID);
        model.addAttribute("courseList",courseList);
        return "addcourse";
    }
    @RequestMapping("/addsubmit")
    public String addsubmit(Model model,String studentID,String CourseID,String CourseName){
        int sid=Integer.parseInt(studentID);
        int cid=Integer.parseInt(CourseID);
        studentClass studentClass=new studentClass();
        studentClass.setCourseID(cid);
        studentClass.setStudentID(sid);
        studentClass.setCourseName(CourseName);
        List<studentClass> studentClasses=studentClassServices.find();
        if(studentClasses.contains(studentClass)){
            return "have";
        }else {
            studentClassServices.add(studentClass);
            List<Course> courseList = courseServices.findbystudentID(sid);
            model.addAttribute("courseList", courseList);
            return "ownCourselist";
        }
    }
}
