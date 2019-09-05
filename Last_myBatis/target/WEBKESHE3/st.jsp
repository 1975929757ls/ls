<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/23
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>欢迎${student.name}登陆</h2>
<a href="/student/studentgrades?studentID=${student.studentID}">查看个人成绩成绩</a></br>
<a href="/student/infostundent?studentID=${student.studentID}">查看个人信息</a></br>
<a href="/course/owncourse?studentID=${student.studentID}">查看个人课表</a></br>
<a href="/course/addcourse?studentID=${student.studentID}">选课</a></br>
</body>
</html>
