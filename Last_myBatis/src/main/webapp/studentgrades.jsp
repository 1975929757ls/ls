<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/28
  Time: 21:08
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
        <td>学号</td>
        <td>姓名</td>
        <td>课程号</td>
        <td>课程名</td>
        <td>分数</td>
        <td>老师</td>
    </tr>
    <c:forEach  var="grades" items="${grades}">
        <tr>
            <td>${grades.studentID}</td>
            <td>${grades.studentname}</td>
            <td>${grades.courseID}</td>
            <td>${grades.courseName}</td>
            <td>${grades.num}</td>
            <td>${grades.teachername}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
