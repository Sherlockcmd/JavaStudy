<%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 2025/3/6
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <style>
        .demo-login-container{width: 320px; margin: 21px auto 0;}
        .demo-login-other .layui-icon{position: relative; display: inline-block; margin: 0 2px; top: 2px; font-size: 26px;}
    </style>
</head>
<body>
    <%--<form action="/user?method=login" method="post">
        用户名：<input type="text" name="name"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit" value="登录">
    </form>--%>

    <form class="layui-form">
        <div class="demo-login-container">
            <div class="layui-form-item">
                <div class="layui-input-wrap">
                    <div class="layui-input-prefix">
                        <i class="layui-icon layui-icon-username"></i>
                    </div>
                    <input type="text" name="name" value="" lay-verify="required" placeholder="用户名" lay-reqtext="请填写用户名" autocomplete="off" class="layui-input" lay-affix="clear">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-wrap">
                    <div class="layui-input-prefix">
                        <i class="layui-icon layui-icon-password"></i>
                    </div>
                    <input type="password" name="password" value="" lay-verify="required" placeholder="密   码" lay-reqtext="请填写密码" autocomplete="off" class="layui-input" lay-affix="eye">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-row">
                    <div class="layui-col-xs7">
                        <div class="layui-input-wrap">
                            <div class="layui-input-prefix">
                                <i class="layui-icon layui-icon-vercode"></i>
                            </div>
                            <input type="text" name="code" value="" lay-verify="required" placeholder="验证码" lay-reqtext="请填写验证码" autocomplete="off" class="layui-input" lay-affix="clear">
                        </div>
                    </div>
                    <div class="layui-col-xs5">
                        <div style="margin-left: 10px;">
                            <img src="/verifyCode" onclick="this.src='/verifyCode?t='+ new Date().getTime();">
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="demo-login">登录</button>
            </div>
        </div>
    </form>



    <script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
    <script src="/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <script src="/static/mylayer.js" type="text/javascript" charset="utf-8"></script>
    <script>
        layui.use(function(){
            var form = layui.form;
            var layer = layui.layer;
            // 提交事件
            form.on('submit(demo-login)', function(data){
                var field = data.field; // 获取表单字段值
                // 此处可执行 Ajax 等操作
                $.post(
                    '/user?method=login',
                    field,
                    function (result) {
                        console.log(result);
                        if (result.code == 0) {
                            mylayer.okUrl(result.msg, '/')
                        } else {
                            mylayer.errorMsg(result.msg);
                        }
                    },
                    'json'
                );

                // …
                return false; // 阻止默认 form 跳转
            });
        });
    </script>
</body>
</html>
