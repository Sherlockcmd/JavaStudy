<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    <button onclick="ajaxGet()">ajax get</button>
    <button onclick="ajaxPost()">ajax post</button>
    <button onclick="ajax()">ajax</button>

    <script src="/static/jquery-2.1.4.js"></script>
    <script>
        function ajaxGet() {
            //$.get(url, [data], [callback], [type])  后面三个是可选的可以没有
            $.get(
                '/ajax1',
                {'name': '张三1'},
                function (jsonObj) {
                    console.log(jsonObj);
                },
                'json'
            );
        }

        function ajaxPost() {
            //$.post(url, [data], [callback], [type])  后面三个是可选的可以没有
            $.post(
                '/ajax1',
                {'name': '张三2'},
                function (jsonObj) {
                    console.log(jsonObj);
                },
                'json'
            );
        }

        function ajax() {
            //$.ajax( { option1:value1,option2:value2... } );    语法：$.ajax({键值对});
            $.ajax({
                async: true, //不写默认就是true，发送异步请求
                url: '/ajax1',
                type: 'GET',
                data: {'name': '王五'},
                success: function (jsonObj) {
                    console.log(jsonObj);
                },
                dataType: 'json'
            });
        }
    </script>
</body>
</html>
