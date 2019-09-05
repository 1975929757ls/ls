<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/28
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/grades/addsubmint">
    <div>
        学号：<input type="text"  name="studentID" placeholder="请输入学号"></div>
    <div>
        姓名：<input type="text"  name="studentname" placeholder="请输入姓名"></div>
    <div>
        课程号：<input type="text"  name="CourseID" placeholder="请输入课程号"></div>
    <div>
        课程名：<input type="text"  name="CourseName" placeholder="请输入课程名"></div>
    <div>
        教师：<input type="text"  name="teachername" placeholder="请输入教师姓名"></div>
    <div>
        成绩：<input type="text"  name="num" placeholder="请输入成绩"></div>
    <input type="submit" value="提交">
</form>
</body>
</html>
