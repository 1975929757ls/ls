<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/19
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>添加学生信息</h2>
<form action="/info/add1">
    <div>
        学号：<input type="text"  name="studentID" placeholder="请输入学号"></div>
    <div>
        姓名：<input type="text"  name="name" placeholder="请输入姓名"></div>
    <div>
        性别： <input type="radio" name="sex" value="男" checked="checked"/>男
        <input type="radio" name="sex" value="女"/>女</div>
    <div>
        学院：<input type="text"  name="colege" placeholder="请输入所在学院"></div>
    <div>
        专业：<input type="text"  name="major" placeholder="请输入专业名称"></div>
    <div>
        电话：<input type="text"  name="phone" placeholder="请输入电话号码"></div>
    <div>
        密码：<input type="text"  name="password" placeholder="请输入密码"></div>
    <input type="submit" value="提交">
</form>
</body>
</html>
