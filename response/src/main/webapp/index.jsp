<%--
&lt;%&ndash;解决中文乱码&ndash;%&gt;
<%@ page contentType="text/html; charset=gb2312"%>

<html>
<body>
<h2>Hello servlet project start interface</h2>
<form method="post" action="/TomcatTest/UploadServlet" enctype="multipart/form-data">
    Choose File:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>

--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
</head>
<body>
<h1>使用 GET 方法读取数据</h1>
<ul>
    <li><p><b>站点名:</b>
        <%= request.getParameter("name")%>
    </p></li>
    <li><p><b>网址:</b>
        <%= request.getParameter("url")%>
    </p></li>
</ul>
</body>
</html>
