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
    <script type="text/javascript" src="/static/lib/layer/2.1/layer.js"></script>
    <script type="text/javascript" src="/static/js/H-ui.js"></script>
    <script type="text/javascript" src="/static/js/H-ui.admin.js"></script>
    <script type="text/javascript" src="/scripts/angularjs/angular.js"></script>
    <script type="text/javascript" src="/scripts/angularjs/angular-confirm.js"></script>
    <script type="text/javascript" src="/scripts/custom/resource.js"></script>
    <title>销量管理平台</title>
</head>
<body ng-app="channelApp">
<div class="pd-20" ng-controller="resource">
    <div class="">
        <input type="text" class="input-text" style="width:250px" placeholder="输入资源名称" id="" name=""
               ng-model="form.name">
        <span class="select-box inline">
		<select name="" class="select" ng-model="form.parentId">
            <option value="">---请选择上级资源---</option>
            <option ng-repeat="option in parentResources" value="{{option.id}}">{{option.name}}</option>
        </select>
		</span>
        <c:if test="${null != operate && operate.query == 1}">
            <button type="submit" class="btn btn-success" id="dd" name="" ng-click="query()"><i class="Hui-iconfont">
                &#xe665;</i> 查询
            </button>
        </c:if>
    </div>
    <c:if test="${null != operate && operate.create == 1}">
        <div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l">
        <a href="javascript:;" onclick="admin_add('添加资源','/resource/create/init','800','500')"
           class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加资源</a></span>
            <span class="r">&nbsp;</span></div>
    </c:if>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="9">资源列表</th>
        </tr>
        <tr class="text-c">
            <th width="40">编号</th>
            <th width="150">资源名称</th>
            <th width="150">上级资源</th>
            <th width="150">路径</th>
            <th width="90">建立时间</th>
            <th width="90">更新时间</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr class="text-c" ng-repeat="resource in resources">
            <td>{{resource.id}}</td>
            <td>{{resource.name}}</td>
            <td>{{resource.parent.name}}</td>
            <td>{{resource.path}}</td>
            <td>{{resource.createTime|date:'yyyy-MM-dd HH:mm:ss'}}</td>
            <td>{{resource.updateTime|date:'yyyy-MM-dd HH:mm:ss'}}</td>
            <td class="td-manage">
                <c:if test="${null != operate && operate.edit == 1}">
                    <a title="编辑"
                       href="javascript:;"
                       ng-click='edit(resource)'
                       class="ml-5"
                       style="text-decoration:none"><i
                            class="Hui-iconfont">&#xe6df;</i></a>
                </c:if>
                <c:if test="${null != operate && operate.delete == 1}">
                    <a title="删除" href="javascript:;"
                       ng-click='delete(resource)'
                       class="ml-5"
                       style="text-decoration:none">
                        <i class="Hui-iconfont">
                            &#xe6e2;</i></a>
                </c:if>
            </td>
        </tr>
        </tbody>
    </table>
</div>

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
    function admin_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }
    /*管理员-删除*/
    function admin_del(obj, id) {
        layer.confirm('确认要删除吗？' + id, function (index) {
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
