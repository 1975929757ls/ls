<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/11
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 >请求参数绑定入门实例</h2>
<!--请求参数绑定-->
<!--<a href="param/chuancan?name=xiaoli&passsword=1234">入门</a>-->
<form action="param/chuancan"method="post">
    <div>
        姓名：<input type="text"name="name"/>
    </div>
   <div>
       密码：<input type="password"name="password"/>
   </div>
    <div>
        学号：<input type="text"name="studentID"/>
    </div>
    <div>
        性别：<input type="text"name="sex"/>
    </div>
    <div>
        学院：<input type="text"name="colege"/>
    </div>
    <div>
        专业：<input type="text"name="major"/>
    </div>
    <div>
        电话：<input type="text"name="phone"/>
    </div>
    <input type="submit"value="提交"/>

</form>
</body>
</html>
