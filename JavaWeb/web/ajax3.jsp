<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    省份：
    <select id="provinceId">
        <option>---请选择省份--</option>
    </select>
    城市：
    <select id="cityId">
        <option>---请选择城市--</option>
    </select>
    区县：
    <select id="areaId">
        <option>---请选择区县--</option>
    </select>

    <script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function () {
            $.post(
                '/ajax3?method=selectProvince',
                function (jsonObj) {
                    //[{id: 220000, name: '吉林省'},{id: 230000, name: '黑龙江省'}]
                    console.log(jsonObj);
                    $(jsonObj).each(function () {
                        // this  {id: 220000, name: '吉林省'}
                        //<option value="111">河北省</option>
                        //$('#provinceId').append('<option value="111">河北省</option>');
                        $('#provinceId').append('<option value="'+this.id+'">'+this.name+'</option>');
                    })
                },
                'json'
            );

            //给省份绑定change事件
            $('#provinceId').change(function () {
                // this   JS DOM
                $.post(
                    '/ajax3?method=selectCity',
                    {'provinceId': $(this).val()},
                    function (jsonObj) {
                        console.log(jsonObj);
                        //清除原来的数据
                        $('#cityId option:gt(0)').remove();
                        //$('#cityId option:not(:first)').remove();
                        $(jsonObj).each(function () {
                            $('#cityId').append('<option value="'+this.id+'">'+this.name+'</option>');
                        })
                    },
                    'json'
                );
            });
            //给城市绑定change事件
            $('#cityId').change(function () {
                // this   JS DOM
                $.post(
                    '/ajax3?method=selectArea',
                    {'cityId': $(this).val()},
                    function (jsonObj) {
                        console.log(jsonObj);
                        //清除原来的数据
                        $('#areaId option:gt(0)').remove();
                        //$('#areaId option:not(:first)').remove();
                        $(jsonObj).each(function () {
                            $('#areaId').append('<option value="'+this.id+'">'+this.name+'</option>');
                        })
                    },
                    'json'
                );
            });
        });
    </script>
</body>
</html>
