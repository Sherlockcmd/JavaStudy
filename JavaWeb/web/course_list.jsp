<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
</head>
<body>


    <table class="layui-hide" id="tableId" lay-filter="tableId"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="deleteAll">批量删除</button>
        </div>
    </script>

    <%--右侧工具栏--%>
    <script type="text/html" id="toolDemo">
        <div class="layui-clear-space">
            <a class="layui-btn layui-btn-xs" lay-event="update">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="deleteById">删除</a>
        </div>
    </script>

    <script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
    <script src="/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <script src="/static/mylayer.js" type="text/javascript" charset="utf-8"></script>
    <script>
        layui.use(['table'], function () {
            var table = layui.table;
            // 创建渲染实例
            table.render({
                elem: '#tableId',
                toolbar: '#toolbarDemo',
                url: '/course?method=selectByPage', // 此处为静态模拟数据，实际使用时需换成真实接口
                cellMinWidth: 80,
                page: true,
                cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field:'id', width:180,  fixed: 'left', title: 'ID', sort: true},
                    {field:'name', title: '课程名字'},
                    {field:'credit', title: '学分'},
                    {fixed: 'right', title:'操作', width: 134, minWidth: 125, templet: '#toolDemo'}
                ]],
            });

            // 工具栏事件
            table.on('toolbar(tableId)', function(obj){
                var id = obj.config.id;
                var checkStatus = table.checkStatus(id);
                var othis = lay(this);
                switch(obj.event){
                    case 'add':
                        layer.open({
                            type: 2,
                            title: '添加数据',
                            area: ['90%', '40%'],
                            content: '/course_add.jsp'
                        });
                        break;
                    case 'deleteAll':
                        var data = checkStatus.data;
                        //[{"id":20,"name":"大数据班","address":"1号教学楼"},{"id":21,"name":"人工智能","address":"2号教学楼"}]
                        console.log(data);
                        var ids = new Array();
                        $(data).each(function () {
                            //this : {"id":20,"name":"大数据班","address":"1号教学楼"}
                            ids.push(this.id);
                        });
                        layer.confirm('您确认要删除么?', function () {
                            $.post(
                                '/course?method=deleteAll',
                                {'ids': ids},
                                function (result) {
                                    console.log(result);
                                    if (result.code == 0) {
                                        mylayer.okMsg(result.msg);
                                        //删除之后刷新表格，展示最新的数据
                                        table.reload('tableId');
                                    }
                                },
                                'json'
                            );
                        });
                        break;
                };
            });

            // 触发单元格工具事件
            table.on('tool(tableId)', function(obj){ // 双击 toolDouble
                var data = obj.data; // 获得当前行数据
                console.log(data)
                if(obj.event === 'update'){
                    layer.open({
                        title: '编辑',
                        type: 2,
                        area: ['80%','30%'],
                        content: '/course_update.jsp?id='+data.id
                    });
                } else if(obj.event === 'deleteById'){
                    layer.confirm('您确认要删除么?', function () {
                        $.post(
                            '/course?method=deleteById',
                            {'id': data.id},
                            function (result) {
                                console.log(result);
                                if (result.code == 0) {
                                    mylayer.okMsg(result.msg);
                                    //删除之后刷新表格，展示最新的数据
                                    table.reload('tableId');
                                }
                            },
                            'json'
                        );
                    });
                }
            });

        });
    </script>
</body>
</html>
