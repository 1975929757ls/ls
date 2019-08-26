package com.mylast.controller;

import com.mylast.domain.User;
import com.mylast.domain.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class Response {
    @RequestMapping("/testString")
    public String testString(Model model){
        Users users=new Users();
        users.setName("xiaoli");
        users.setPassword("1234");
        Date date =new Date();
        users.setDate(date);
         model.addAttribute("users",users);
        return "reponsesuccess";
    }
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/page/success.jsp").forward(request,response);
    }
    @RequestMapping("/testVoid1")
    public void testVoid1(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好！欢迎来到我的网页！");
    }
}
