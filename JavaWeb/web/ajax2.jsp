<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form>
        用户名<input type="text" name="name" id="nameId"><span id="nameSpanId"></span><br>
        密码<input type="text" name="password" id="passwordId"><br>
        <input type="submit" value="注册">
    </form>
    <script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function () {
            $('#nameId').blur(function () {
                // this 当前失去焦点是输入框 JS DOM
                $.post(
                    '/ajax2',
                    {'name': $(this).val()},
                    function (jsonObj) {
                        console.log(jsonObj);
                        //{exist: true, msg: '此用户已经存在，请更换一个'}
                        //{exist: false, msg: '该用户可用'}
                        if (jsonObj.exist) {
                            $('#nameSpanId').html(jsonObj.msg);
                            $('#nameSpanId').css('color', 'red');
                        } else {
                            $('#nameSpanId').html(jsonObj.msg);
                            $('#nameSpanId').css('color', 'green');
                        }
                    },
                    'json'
                );
            });
        })
    </script>
</body>
</html>
