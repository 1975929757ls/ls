<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/26
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">修改学生信息</h2>
    <form action="/grades/submit" >
        <div style="text-align: center">
            <label>学号：</label>
            <input type="text"  name="studentID" value="${grades.studentID}"  />
        </div>
        <div style="text-align:center ">
            <label>学生姓名：</label>
            <input type="text"  name="studentname" value="${grades.studentname}" />
        </div>
        <div style="text-align: center">
            <label>课程号：</label>
            <input type="text"  name="CourseID" value="${grades.courseID}"  />
        </div>
        <div style="text-align:center ">
            <label>课程名：</label>
            <input type="text" name="coursename"  value="${grades.courseName}"   />
        </div>
        <div style="text-align:center ">
            <label>成绩：</label>
            <input type="text"  name="num" value="${grades.num}"/>
        </div>
        <div style="text-align:center ">
            <label>教师：</label>
            <input type="text"  name="teachername" value="${grades.teachername}"  />
        </div>
        <div style="text-align:center ">
            <input type="submit" name="submit" value="提交" />
            <input  type="reset" value="重置" />
        </div>
    </form>
</body>
</html>
