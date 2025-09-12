<%@ page import="com.easy.web.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
    <%--${list}--%>
    <%
        //jsp脚本，这里面可以任意写java代码
        //内置对象：jsp页面已经new好了这个对，名字也起好了
        List<Student> list = (List<Student>) request.getAttribute("list");
    %>
    <a href="/student_add.jsp">添加</a>
    <a href="/student?method=toAdd">添加</a>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>删除</td>
            <td>编辑</td>
        </tr>
        <%
            for (Student student : list) {
        %>
                <tr>
                    <td><%=student.getId()%></td>
                    <td><%=student.getName()%></td>
                    <td><%=student.getAge()%></td>
                    <td><%=student.getGender()%></td>
                    <%--<td><a href="/deleteStudent?id=<%=student.getId()%>">删除</a></td>--%>
                    <td><a href="javascript:void(0)" onclick="deleteById(<%=student.getId()%>)">删除</a></td>
                    <td><a href="/student?method=toUpdate&id=<%=student.getId()%>">编辑</a></td>
                </tr>
        <%
            }
        %>
    </table>

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
