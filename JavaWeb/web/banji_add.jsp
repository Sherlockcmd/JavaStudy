<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
</head>
<body>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">班级名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">班级地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit lay-filter="formFilter">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
    <script src="/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <script src="/static/mylayer.js" type="text/javascript" charset="utf-8"></script>
    <script>
        layui.use(['form'], function () {
            var form = layui.form;
            // 提交事件
            form.on('submit(formFilter)', function(data){
                var field = data.field; // 获取表单字段值
                //{name: 'Java班级', address: '信息楼'}
                console.log(field);
                // 此处可执行 Ajax 等操作
                $.post(
                    '/banji?method=add',
                    field,
                    function (result) {
                        console.log(result);
                        if (result.code == 0) {
                            mylayer.okMsg(result.msg);
                            setInterval(function () {
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                                //删除之后刷新表格，展示最新的数据
                                //table.reload('tableId');
                                parent.layui.table.reload('tableId');
                            }, 2000)

                        }
                    },
                    'json'
                );

                return false; // 阻止默认 form 跳转
            });
        });
    </script>
</body>
</html>
