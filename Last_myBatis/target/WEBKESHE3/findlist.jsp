<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/25
  Time: 11:41
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
</body>
</html>
