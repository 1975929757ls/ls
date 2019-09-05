package com.mylast.controller;

import com.mylast.domain.Grades;
import com.mylast.domain.Students;
import com.mylast.services.GradesServices;
import com.mylast.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServices studentServices;
    @Autowired
    GradesServices gradesServices;
    @RequestMapping("/studentgrades")
    public String studentgrades(@RequestParam(name = "studentID")String studentID,Model model){
        System.out.println(studentID);
        int id =Integer.parseInt(studentID);
        List<Grades> gradesList=gradesServices.findBystudentID(id);
        model.addAttribute("grades",gradesList);
        return "studentgrades";
    }
    @RequestMapping("/infostundent")
    public String studentinfo(@RequestParam(name = "studentID")String studentID,Model model){
        int id=Integer.parseInt(studentID);
        Students students=studentServices.findBystudentID(id);
        model.addAttribute("students",students);
        return "informationstudent";
    }
    @RequestMapping("/update")
    public String  updatetest(@RequestParam(name="studentID") String studentID,Model model){
        System.out.println(studentID);
        int id=Integer.parseInt(studentID);
        Students students=studentServices.findBystudentID(id);
        model.addAttribute("student",students);
        return "update";
    }
}
