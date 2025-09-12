<%@ page import="com.easy.web.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.easy.web.util.PageInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
    <a class="btn btn-primary" href="/student_add.jsp">添加</a>
    <a class="btn btn-primary" href="/student?method=toAdd">添加</a>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>删除</td>
            <td>编辑</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.gender}</td>
                <td><a href="javascript:void(0)" onclick="deleteById(${student.id})">删除</a></td>
                <td><a href="/student?method=toUpdate&id=${student.id}">编辑</a></td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageInfo.pageNo == 1}">
                <li class="disabled">
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${pageInfo.pageNo != 1}">
                <li>
                    <a href="/student?method=selectByPage&pageNo=${pageInfo.pageNo-1}&pageSize=5" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${pageInfo.totalPage}" var="i" step="1">
                <c:if test="${pageInfo.pageNo == i}">
                    <li class="active"><a href="#">${i}</a></li>
                </c:if>
                <c:if test="${pageInfo.pageNo != i}">
                    <li><a href="/student?method=selectByPage&pageNo=${i}&pageSize=5">${i}</a></li>
                </c:if>
            </c:forEach>

            <li>
                <a href="/student?method=selectByPage&pageNo=${pageInfo.pageNo+1}&pageSize=5" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

    <script>
        function deleteById(id) {
            var isDelete = confirm('您确认要删除么？');
            if (isDelete) {
                //location.href = '/deleteStudent?id=' + id;
                location.href = '/student?method=deleteById&id=' + id;
            }
        }
    </script>
</body>
</html>
