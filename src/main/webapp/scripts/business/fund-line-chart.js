var markPortData = {
    name: "",
    value: "",
    x: "",
    y: ""
}
var time = new Array();
var temp = new Array();
var markPointData = new Array(markPortData);
var code = document.getElementById("id");
var myChart = echarts.init(document.getElementById('main'));

$.get('/fund-order/fund-buy-net-worth?code=' + code.value, function (data) {
    for (var i = 0; i < data.length; i++) {
        markPortData.name = data.name;
        markPortData.value = data.value;
        markPortData.x = data.x;
        markPortData.y = data.y;
        markPointData[i] = markPortData;
    }
});

$.get('/fund/netWorth?code=' + code.value, function (data) {
    for (var i = 0; i < data.length; i++) {
        time[i] = data[i].time;
        temp[i] = data[i].netWorth;
    }
    // 指定图表的配置项和数据
    var option = {
        tooltip: {},
        grid: {backgroundColor: 'rgba(0,0,0,0.5)'},
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
                effect: {
                    show: true
                },
                data: markPointData
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
});