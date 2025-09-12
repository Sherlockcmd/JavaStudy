<%@ page import="com.easy.web.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.easy.web.util.PageInfo" %>
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
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
    %>
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
        <%
            for (Student student : pageInfo.getList()) {
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
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <%
                if (pageInfo.getPageNo() == 1) {
            %>
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
            <%
                } else {
            %>
                    <li>
                        <a href="/student?method=selectByPage&pageNo=<%=pageInfo.getPageNo()-1%>&pageSize=5" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
            <%
                }
            %>



            <%
                for (int i = 1; i <= pageInfo.getTotalPage(); i++) {
                    if (i == pageInfo.getPageNo()) {
            %>
                        <li class="active"><a href="#"><%=i%></a></li>
            <%
                    } else {
            %>
                        <li><a href="/student?method=selectByPage&pageNo=<%=i%>&pageSize=5"><%=i%></a></li>
            <%
                    }
                }
            %>

            <li>
                <a href="/student?method=selectByPage&pageNo=<%=pageInfo.getPageNo()+1%>&pageSize=5" aria-label="Next">
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
