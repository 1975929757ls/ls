<%--
  Created by IntelliJ IDEA.
  User: 19759
  Date: 2019/8/19
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>传统文件上传</h2>
<form action="user/file" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
<h2>springMVC文件上传</h2>
<form action="user/file1" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
