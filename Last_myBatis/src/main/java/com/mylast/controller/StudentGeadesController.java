package com.mylast.controller;

import com.mylast.domain.Grades;
import com.mylast.services.GradesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/grades")
public class StudentGeadesController {
    @Autowired
    GradesServices gradesServices;
    @RequestMapping("/geadeslist")
    public String allList(Model model){
        List<Grades> gradesList=gradesServices.find();
        model.addAttribute("grades",gradesList);
        return "gradeslist";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam(name="studentID") String studentID, Model model){
        int id=Integer.parseInt(studentID);
        gradesServices.delete1(id);
        List<Grades> gradesList=gradesServices.find();
        model.addAttribute("grades",gradesList);
        return "gradeslist";
    }
    @RequestMapping("/update")
    public String update(@RequestParam(name="studentID") String studentID,@RequestParam(name = "courseID")String courseID, Model model){
        System.out.println(studentID);
        int id=Integer.parseInt(studentID);
        int cid=Integer.parseInt(courseID);
        Grades grades=gradesServices.findbyCourseIDandstudentID(id,cid);
        model.addAttribute("grades",grades);
        return "gradesupdate";
    }
    @RequestMapping("/submit")
    public String updatesubmit(Model model,String studentID,String CourseID,String coursename,String num,String studentname,String teachername ){
        int id=Integer.parseInt(studentID);
        int cid=Integer.parseInt(CourseID);
        int n=Integer.parseInt(num);
        Grades grades1=new Grades();
        grades1.setStudentID(id);
        grades1.setCourseID(cid);
        grades1.setCourseName(coursename);
        grades1.setNum(n);
        grades1.setStudentname(studentname);
        grades1.setTeachername(teachername);
        gradesServices.update(grades1);
        List<Grades> grades=gradesServices.find();
        model.addAttribute("grades",grades);
        return "gradeslist";
    }
    @RequestMapping("/add")
    public String add(){
        return "gradesadd";
    }
    @RequestMapping("/addsubmint")
    public String addsubmint(String studentID, String CourseID, String studentname, String num, String CourseName, String teachername,Model model){
        int stuid=Integer.parseInt(studentID);
        int cid=Integer.parseInt(CourseID);
        int sum=Integer.parseInt(num);
        Grades grades1=new Grades();
        grades1.setStudentID(stuid);
        grades1.setCourseID(cid);
        grades1.setTeachername(teachername);
        grades1.setStudentname(studentname);
        grades1.setNum(sum);
        grades1.setCourseName(CourseName);
        gradesServices.add(grades1);
        List<Grades> grades=gradesServices.find();
        model.addAttribute("grades",grades);
        return "gradeslist";
    }
}
