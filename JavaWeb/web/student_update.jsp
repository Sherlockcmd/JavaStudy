<%@ page import="com.easy.web.pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Student student = (Student) request.getAttribute("student");
    %>
    <form action="/student?method=update" method="post">
        <input type="hidden" name="id"  value="<%=student.getId()%>">
        姓名：<input type="text" name="name" value="<%=student.getName()%>"><br>
        年龄：<input type="text" name="age" value="<%=student.getAge()%>"><br>
        性别：<input type="text" name="gender" value="<%=student.getGender()%>"><br>
        <input type="submit" value="修改">
    </form>
</body>
</html>
