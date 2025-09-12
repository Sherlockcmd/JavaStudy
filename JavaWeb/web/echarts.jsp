<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 为 ECharts 准备一个定义了宽高的 DOM -->
    <div id="main1" style="width: 600px;height:400px;"></div>
    <div id="main2" style="width: 600px;height:400px;"></div>

    <script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
    <script src="/static/echarts.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart1 = echarts.init(document.getElementById('main1'));
        var myChart2 = echarts.init(document.getElementById('main2'));
        $.post(
            '/echarts',
            function (result) {
                console.log(result);
                if (result.code == 0) {
                    //[{name: 'java1807', value: 3},{name: '大数据班', value: 1}]
                    var xArray = new Array();
                    var yArray = new Array();
                    $(result.data).each(function () {
                        //this: [{name: 'java1807', value: 3}
                        xArray.push(this.name);
                        yArray.push(this.value);
                    })

                    // 指定图表的配置项和数据
                    var option1 = {
                        title: {
                            text: '班级人数统计'
                        },
                        tooltip: {},
                        legend: {
                            data: ['人数']
                        },
                        xAxis: {
                            data: xArray
                        },
                        yAxis: {},
                        series: [
                            {
                                name: '销量',
                                type: 'bar',
                                data: yArray
                            }
                        ]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart1.setOption(option1);


                    var option2 = {
                        title: {
                            text: 'Referer of a Website',
                            subtext: 'Fake Data',
                            left: 'center'
                        },
                        tooltip: {
                            trigger: 'item'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left'
                        },
                        series: [
                            {
                                name: 'Access From',
                                type: 'pie',
                                radius: '50%',
                                data: result.data,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };

                    myChart2.setOption(option2);
                }

            },
            'json'
        );


    </script>
</body>
</html>
