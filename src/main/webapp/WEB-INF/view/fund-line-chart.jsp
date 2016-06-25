<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=yes"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <LINK rel="Bookmark" href="/favicon.ico">
    <LINK rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/static/lib/html5.js"></script>
    <script type="text/javascript" src="/static/lib/respond.min.js"></script>
    <script type="text/javascript" src="/static/lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="/static/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/H-ui.admin.css" rel="stylesheet" type="text/css"/>
    <link href="/static/lib/Hui-iconfont/1.0.6/iconfont.css" rel="stylesheet" type="text/css"/>
    <link href="/static/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin"/>
    <link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="/static/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <script type="text/javascript" src="/static/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="/static/lib/echart/echarts.js"></script>
</head>
<body>
<div id="main" style="width: 1500px;height:700px"></div>
<input type="hidden" id="id" value="${id}"/>
</body>
<script>
    var time = new Array();
    var temp = new Array();
    //标识指定的位置
    var markPointData = new Array();
    //标识直线
    var markLineData = new Array();
    var lineData = new Array();
    var code = document.getElementById("id");
    var myChart = echarts.init(document.getElementById('main'));

    $.get('/fund-order/fund-buy-net-worth?code=' + code.value, function (data) {
        for (var i = 0; i < data.length; i++) {
            markPointData[i] = data[i];
        }
    });

    $.get('/fund-order/fund-buy-sale?code=' + code.value, function (data) {
        for (var i = 0; i < data.length; i++) {
            var arr = new Array();
            for (var j = 0; j < data[i].fundMarkPointDataList.length; j++) {
                arr[j] = data[i].fundMarkPointDataList[j];
            }
            lineData[i] = arr;
        }
        lineData[data.length] = [
            {type: 'min', name: '最大'},
            {type: 'max', name: '最大'}
        ]
    });

    $.get('/fund/netWorth?code=' + code.value, function (data) {
        for (var i = 0; i < data.length; i++) {
            time[i] = data[i].time;
            temp[i] = data[i].netWorth;
        }
        // 指定图表的配置项和数据
        var option = {
            tooltip: {},
            xAxis: {
                data: time
            },
            yAxis: {position: 'right'},
            dataZoom: {
                show: true,
                start: 80,
                end: 100
            },
            series: [{
                type: 'line',
                showAllSymbol: true,
                smooth: true,
                data: temp,
                markPoint: {
                    symbolSize: 70,
                    effect: {
                        show: true
                    },
                    data: markPointData
                },
                markLine: {
                    smooth: true,
                    symbol: ['none', 'arrow'],
                    symbolSize: 10,
                    effect: {
                        show: true,
                        color: 'green',
                        shadowColor: 'black',
                        period: 30
                    },
                    itemStyle: {
                        normal: {
                            color: 'green',
                            borderWidth: 6,
                            borderColor: 'green',
                            lineStyle: {
                                type: 'solid'
                            }
                        }
                    },
                    data: lineData
                }
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    });
</script>
</html>
