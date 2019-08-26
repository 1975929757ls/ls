<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/10
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>dfjhk</h3>
<a href="param/testRequestParam?name=you">RequestParam</a>
<br>
<form action="param/testRequestBody"method="post">
    <div>
        姓名：<input type="text"name="name"/>
    </div>
    <div>
        密码：<input type="password"name="password"/>
    </div>
    <div>
        出生日期：<input type="text"name="date"/>
    </div>
    <input type="submit"value="提交"/>
    </form>
<br>
<a href="param/testPathVariable/100">PathVariable</a>
</body>

</html>
