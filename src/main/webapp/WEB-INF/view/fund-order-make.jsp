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
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="/static/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <script type="text/javascript" src="/static/lib/layer/2.1/layer.js"></script>
    <script type="text/javascript" src="/static/js/H-ui.js"></script>
    <script type="text/javascript" src="/static/js/H-ui.admin.js"></script>
    <script type="text/javascript" src="/scripts/angularjs/angular.js"></script>
    <script type="text/javascript" src="/static/lib/laypage/1.2/laypage.js"></script>
    <script type="text/javascript" src="/scripts/business/fund/fund-order-make.js"></script>
    <title>销量管理平台</title>
</head>
<body ng-app="channelApp">
<div class="pd-20" ng-controller="fund-order">
    <div class="">
        <input type="text" class="input-text" style="width:200px" placeholder="关键字" ng-model="queryForm.keyword">
        <c:if test="${null != operate && operate.query == 1}">
            <button type="submit" class="btn btn-success" id="" name="" ng-click="query()"><i class="Hui-iconfont">
                &#xe665;</i>查询
            </button>
        </c:if>
    </div>
    <table class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr>
            <th scope="col" colspan="14">数据列表</th>
        </tr>
        <tr class="text-c">
            <th width="2%">编号</th>
            <th width="10%">基金</th>
            <th width="12%">基金名称</th>
            <th width="10%">投资金额</th>
            <th width="7%">最低卖出净值</th>
            <th width="7%">最高卖出份额</th>
            <th width="7%">最高卖出净值</th>
            <th width="7%">最低卖出份额</th>
            <th width="5%">买入时间</th>
            <th width="5%">卖出时间</th>
            <th width="5%">买入净值</th>
            <th width="5%">卖出净值</th>
            <th width="4%">比例</th>
            <th width="12%">份额</th>
        </tr>
        </thead>
        <tbody>
        <tr class="text-c" ng-repeat="p in items">
            <td>{{$index+1}}</td>
            <td>{{p.fund.code | numberOrFormat}}</td>
            <td>{{p.fund.name}}</td>
            <td>{{p.money | number:2}}</td>
            <td>{{p.startSaleNetWorth | number:4}}</td>
            <td>{{p.startSaleShare | number:4}}</td>
            <td>{{p.endSaleNetWorth | number:4}}</td>
            <td>{{p.endSaleShare | number:4}}</td>
            <td>{{p.startTime}}</td>
            <td>{{p.saleTime}}</td>
            <td>{{p.startNetWorth | number:4}}</td>
            <td>{{p.saleNetWorth | number:4}}</td>
            <td>{{p.ratio}}</td>
            <td class="td-manage">
                <strong ng-if="p.status==1" class="c-red f-11">( {{p.makeShare|number:2}} | {{p.saleMoney}} )</strong>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="/static/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/static/lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="/static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="/static/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/static/js/H-ui.js"></script>
<script type="text/javascript" src="/static/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">

    /*
     参数解释：
     title	标题
     url		请求的url
     id		需要操作的数据id
     w		弹出层宽度（缺省调默认值）
     h		弹出层高度（缺省调默认值）
     */
    /*管理员-增加*/
    function consumer_add(title, url, w, h) {
        layer_show(title, url, w, h);

    }
    /*管理员-删除*/
    function admin_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //此处请求后台程序，下方是成功后的前台处理……

            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }
    /*管理员-编辑*/
    function admin_edit(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }
    /*管理员-停用*/
    function admin_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {
            //此处请求后台程序，下方是成功后的前台处理……

            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
            $(obj).remove();
            layer.msg('已停用!', {icon: 5, time: 1000});
        });
    }

    /*管理员-启用*/
    function admin_start(obj, id) {
        layer.confirm('确认要启用吗？', function (index) {
            //此处请求后台程序，下方是成功后的前台处理……


            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6, time: 1000});
        });
    }
</script>
</body>
</html>
