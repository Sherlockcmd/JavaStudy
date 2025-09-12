<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
</head>
<body>
    <form class="layui-form" lay-filter="formFilter" action="">
        <input type="hidden" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">课程名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学分</label>
            <div class="layui-input-block">
                <input type="text" name="credit" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit lay-filter="formFilter">编辑</button>
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

            var queryString = window.location.search;
            // ?id=1
            console.log('queryString: ' + queryString);
            var urlParams = new URLSearchParams(queryString);
            var id = urlParams.get("id");
            console.log("id: " + id);

            $.post(
                '/course?method=selectById',
                {'id': id},
                function (result) {
                    console.log(result);
                    if (result.code == 0) {
                        //$('input[name="id"]').val(result.data.id);
                        //$('input[name="name"]').val(result.data.name);
                        //$('input[name="address"]').val(result.data.address);
                        form.val('formFilter', result.data);
                    }
                },
                'json'
            );


            // 提交事件
            form.on('submit(formFilter)', function(data){
                var field = data.field; // 获取表单字段值
                //{name: 'Java班级', address: '信息楼'}
                console.log(field);
                // 此处可执行 Ajax 等操作
                $.post(
                    '/course?method=update',
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
