<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/9/1
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/css.css" type="text/css">
</head>
<body>
<table style="text-align: center" border="3">
    <tr>
        <td>课程号</td>
        <td>课程名</td>
        <td>教师</td>
        <td>教室</td>
        <td>课程信息</td>
    </tr>
    <c:forEach var="courselist" items="${courseList}">
        <tr>
            <td>${courselist.courseID}</td>
            <td>${courselist.courseName}</td>
            <td>${courselist.teacher}</td>
            <td>${courselist.classroom}</td>
            <td>${courselist.info}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
