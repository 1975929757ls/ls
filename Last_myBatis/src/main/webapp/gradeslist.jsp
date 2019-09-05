<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/26
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生成绩</title>
</head>
<body>
<h2 style="text-align: center">学生成绩</h2>
<form action="/grades/add">
    <div>
        <input type="submit" value="添加">
    </div>
</form>
<table style="text-align: center" border="3">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>课程号</td>
        <td>课程名</td>
        <td>分数</td>
        <td>老师</td>
        <td>操作</td>
    </tr>
<c:forEach  var="grades" items="${grades}">
    <tr>
    <td>${grades.studentID}</td>
    <td>${grades.studentname}</td>
    <td>${grades.courseID}</td>
    <td>${grades.courseName}</td>
    <td>${grades.num}</td>
    <td>${grades.teachername}</td>
        <td><a href="/grades/geadeslist?studentID=${grades.studentID}">删除</a><a  href="/grades/update?studentID=${grades.studentID}&courseID=${grades.courseID}">修改</a></td>
    </tr>
     </c:forEach>
    </table>
</body>
</html>
