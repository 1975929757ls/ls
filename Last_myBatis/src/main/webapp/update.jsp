<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/23
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">修改学生信息</h2>
<div >
    <form action="/info/upsubmint" >
        <div style="text-align: center">
            <label>学号：</label>
            <input type="text"  name="studentID" value="${student.studentID}"  />
        </div>
        <div style="text-align: center">
            <label>姓名：</label>
            <input type="text"  name="name" value="${student.name}"  />
        </div>
        <div style="text-align:center ">
            <label>性别：</label>
            <c:if test="${student.sex == '男'}">
                <input type="radio" name="sex" value="男" checked />男
                <input type="radio" name="sex" value="女"  />女
            </c:if>

            <c:if test="${student.sex == '女'}">
                <input type="radio" name="sex" value="男"  />男
                <input type="radio" name="sex" value="女" checked  />女
            </c:if>
        </div>
        <div style="text-align:center ">
            <label>学院：</label>
            <input type="text" name="colege"  value="${student.colege}"  placeholder="请输入姓名" />
        </div>
        <div style="text-align:center ">
        <label>专业：</label>
        <input type="text"  name="major" value="${student.major}"  placeholder="请输入姓名" />
    </div>
        <div style="text-align:center ">
        <label>电话：</label>
        <input type="text"  name="phone" value="${student.phone}"  placeholder="请输入姓名" />
    </div>
        <div style="text-align:center ">
            <input type="submit" name="submit" value="提交" />
            <input  type="reset" value="重置" />
        </div>
    </form>
</div>
</body>
</html>
