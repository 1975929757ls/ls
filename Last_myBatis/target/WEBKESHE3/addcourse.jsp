<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/9/3
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="text-align: center" border="3">
    <tr>
        <td>课程号</td>
        <td>课程名</td>
        <td>教师</td>
        <td>教室</td>
        <td>课程信息</td>
        <td>操作</td>
    </tr>
    <tr>
        <c:forEach var="courseList" items="${courseList}">
        <td>${courseList.courseID}</td>
        <td>${courseList.courseName}</td>
        <td>${courseList.teacher}</td>
        <td>${courseList.classroom}</td>
        <td>${courseList.info}</td>
        <td><a href="/course/addsubmit?CourseID=${courseList.courseID}&studentID=${studentID}&CourseName=${courseList.courseName}">添加</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
