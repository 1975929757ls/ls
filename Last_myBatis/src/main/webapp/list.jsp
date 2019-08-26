<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/23
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">学生信息管理系统</h2>
<form action="/info/add">
    <div>
        <input type="submit" value="添加">
    </div>
</form>
<form action="/info/find">
<div>
<label >学号</label>
<input type="text" name="studentID"  >
<input type="submit" value="查询"  >
</div>
</form>
 <table style="text-align: center" border="3">
    <tr>
        <th><input type="checkbox" id="firstCb"></th>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>学院</td>
        <td>专业</td>
        <td>电话</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <c:forEach  var="students" items="${studentlist}">
        <tr>
            <td><input type="checkbox" name="uid" value="${students.studentID}"></td>
            <td>${students.studentID}</td>
            <td>${students.name}</td>
            <td>${students.sex}</td>
            <td>${students.colege}</td>
            <td>${students.major}</td>
            <td>${students.phone}</td>
            <td>${students.password}</td>
            <td><a href="/info/delete?studentID=${students.studentID}">删除</a><a  href="/info/update?studentID=${students.studentID}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
