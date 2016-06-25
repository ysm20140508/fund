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
    <script type="text/javascript" src="/static/lib/laypage/1.2/laypage.js"></script>
    <script type="text/javascript" src="/static/lib/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="/static/js/H-ui.js"></script>
    <script type="text/javascript" src="/static/js/H-ui.admin.js"></script>
    <script type="text/javascript" src="/scripts/angularjs/angular.js"></script>
    <script type="text/javascript" src="/scripts/custom/user.js"></script>
    <title>销量管理平台</title>
</head>
<body ng-app="channelApp">
<div class="pd-20" ng-controller="userCtlr">
    <div class="">
        <input type="text" class="input-text" style="width:150px" placeholder="用户名称" ng-model="form.name">
        <input type="text" class="input-text" style="width:150px" placeholder="账号" ng-model="form.account">
        <select class="select-box inline-text" style="width:150px"
                ng-model="form.status">
            <option value="">--选择状态--</option>
            <option value="0">关闭</option>
            <option value="1">正常</option>
            <option value="2">已删除</option>
        </select>
        <select class="select-box inline-text" style="width:150px" id="selectType" ng-model="form.role.id"
                ng-options="role.id as role.name for role in roles">
            <option value="">--选择用户角色--</option>
        </select>
        <button type="submit" class="btn btn-success" id="" name=""
                ng-click="query()"><i class="Hui-iconfont">&#xe665;</i> 查询
        </button>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l"> <a href="javascript:;" ng-click="user_add()"
                                                                class="btn btn-primary radius"><i class="Hui-iconfont">
        &#xe600;</i> 添加用户</a></span></div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="10">员工列表</th>
        </tr>
        <tr class="text-c">
            <th width="40">编号</th>
            <th width="40">用户名称</th>
            <th width="70">账号</th>
            <th width="90">手机</th>
            <th width="150">邮箱</th>
            <th width="40">所属主管</th>
            <th width="40">角色</th>
            <th width="130">加入时间</th>
            <th width="100">是否已启用</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr class="text-c" ng-repeat="user in users">
            <td>{{user.id}}</td>
            <td>{{user.name}}</td>
            <td>{{user.account}}</td>
            <td>{{user.phone}}</td>
            <td>{{user.email}}</td>
            <td>{{user.manager.name}}</td>
            <td>{{user.role.name}}</td>
            <td>{{user.createTime|date:'yyyy-MM-dd HH:mm:ss'}}</td>
            <td class="td-status">
                <span ng-if="user.status ==1" class="label label-success radius">正常</span>
                <span ng-if="user.status ==0" class="label radius">关闭</span>
                <span ng-if="user.status ==2" class="label radius">已删除</span>
            </td>
            <td class="td-manage">
                <a ng-if="user.status !=1" style="text-decoration:none" ng-click="user_start(user)" href="javascript:;"
                   title="启用">
                    <i class="Hui-iconfont">&#xe615;</i>
                </a>
                <a title="编辑" href="javascript:;" ng-click="edit(user)" class="ml-5" style="text-decoration:none">
                    <i class="Hui-iconfont">&#xe6df;</i>
                </a>
                <a title="删除" href="javascript:;" ng-click="delete(user,this)" class="ml-5"
                   style="text-decoration:none">
                    <i class="Hui-iconfont">&#xe6e2;</i>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
