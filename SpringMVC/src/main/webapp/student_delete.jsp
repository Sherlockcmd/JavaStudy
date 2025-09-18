<%--
  Created by IntelliJ IDEA.
  User: 92127
  Date: 2025/9/17
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/deleteAll" method="post">
<table border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
    </tr>
    <tr>
        <td><input type="checkbox" name="ids" value="1"/></td>
        <td>张三</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="ids" value="2"/></td>
        <td>李四</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="ids" value="3"/></td>
        <td>王五</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="ids" value="4"/></td>
        <td>赵六</td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="提交"/></td>
    </tr>
</table>
</form>
</body>
</html>
