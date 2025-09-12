<%@ page import="com.easy.web.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--1、向域对象放数据--%>
    <%
        pageContext.setAttribute("age", 23);
        session.setAttribute("gender", "男");
    %>
    <c:set var="age" value="24" scope="request"></c:set>
    ${age}
    <hr>
    <%--2、条件判断--%>
    <c:if test="${gender=='男'}">
        男性
    </c:if>
    <c:if test="${gender=='女'}">
        女性
    </c:if>
    <hr>
    <%--3、多条件判断--%>
    <c:set var="score" value="78"></c:set>
    <c:choose>
        <c:when test="${score>=90 && score<= 100}">
            优秀
        </c:when>
        <c:when test="${score>=80 && score< 90}">
            良好
        </c:when>
        <c:when test="${score>=70 && score< 80}">
            一般
        </c:when>
        <c:when test="${score>=60 && score< 70}">
            及格
        </c:when>
        <c:otherwise>
            不及格
        </c:otherwise>
    </c:choose>
    <hr>
    <%--4、集合遍历 List<Student>--%>
    <%
        List<Student> list = new ArrayList<>();
        Student student1 = new Student(1, "zhangsan1", 23, "男");
        Student student2 = new Student(2, "zhangsan2", 23, "男");
        Student student3 = new Student(3, "zhangsan3", 23, "男");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        application.setAttribute("list", list);
    %>
    <c:forEach items="${list}" var="student">
        ${student.id}--${student.name}--${student.gender}<br>
    </c:forEach>
</body>
</html>
