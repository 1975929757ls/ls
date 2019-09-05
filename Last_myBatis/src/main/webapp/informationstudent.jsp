<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/29
  Time: 12:59
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
        <td>性别</td>
        <td>学院</td>
        <td>专业</td>
        <td>电话</td>
        <td>密码</td>
    </tr>
    <tr>
        <td>${students.studentID}</td>
        <td>${students.name}</td>
        <td>${students.sex}</td>
        <td>${students.colege}</td>
        <td>${students.major}</td>
        <td>${students.phone}</td>
        <td>${students.password}</td>
    </tr>
    </table>

<div>
    <form action="/student/update?studentID=${students.studentID}">
    <input type="submit" value="修改个人信息">
    </form>
</div>
</body>
</html>
