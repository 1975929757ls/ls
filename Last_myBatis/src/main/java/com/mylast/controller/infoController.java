package com.mylast.controller;

import com.mylast.domain.Students;
import com.mylast.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/info")
public class infoController {
    @Autowired
    StudentServices studentServices;
    @RequestMapping("/self")
    public String self(Model model){
        List<Students> studentsList=studentServices.findall();
        model.addAttribute("studentlist",studentsList);
        return "list";
    }
    @RequestMapping("/update")
    public String  updatetest(@RequestParam(name="studentID") String studentID,Model model){
       System.out.println(studentID);
        int id=Integer.parseInt(studentID);
        Students students=studentServices.findBystudentID(id);
        model.addAttribute("student",students);
        return "update";
    }
    @RequestMapping("/upsubmint")
    public String  updatesunbmint(Model model,String studentID,String name,String sex,String colege,String major,String phone){
        int id=Integer.parseInt(studentID);
        Students students1=studentServices.findBystudentID(id);
        Students students=new Students();
        students.setStudentID(id);
        students.setName(name);
        students.setColege(colege);
        students.setSex(sex);
        students.setPhone(phone);
        students.setMajor(major);
        students.setPassword(students1.getPassword());
        studentServices.update(students);
        List<Students> studentsList=studentServices.findall();
        model.addAttribute("studentlist",studentsList);
        return "list";
    }
    @RequestMapping("/delete")
    public String deletetest(String studentID,Model model){
        int id=Integer.parseInt(studentID);
        studentServices.delete(id);
        List<Students> studentsList=studentServices.findall();
        model.addAttribute("studentlist",studentsList);
        return "list";
    }
    @RequestMapping("/add1")
    public String add(Model model,String studentID,String name,String sex,String colege,String major,String phone,String password){
        int id=Integer.parseInt(studentID);
        Students students=new Students();
        students.setMajor(major);
        students.setPhone(phone);
        students.setName(name);
        students.setSex(sex);
        students.setColege(colege);
        students.setStudentID(id);
        students.setPassword(password);
        studentServices.add(students);
        List<Students> studentsList=studentServices.findall();
        model.addAttribute("studentlist",studentsList);
        return "list";
    }
    @RequestMapping("/add")
    public String addtest(){
        return "add";
    }
    @RequestMapping("/find")
    public String findtest(String studentID,Model model){
        int id=Integer.parseInt(studentID);
        Students students=studentServices.findBystudentID(id);
        model.addAttribute("students",students);
        return "findlist";
    }
}
