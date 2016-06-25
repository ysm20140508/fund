<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
    <script type="text/javascript" src="/scripts/custom/user-edit.js"></script>
    <script type="text/javascript" src="/static/lib/Validform/5.3.2/Validform.min.js"></script>
    <title>销量管理平台</title>
</head>
<body ng-app="channelApp">
<div class="pd-20" ng-controller="user_edit">

    <input type="hidden" id="id" value="${user.id}"/>

    <form method="post" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>用户名：
            </label>

            <div class="formControls col-5">
                <input type="text" class="input-text" placeholder=""
                       ng-model="from.name" name="user-name"
                       datatype="*1-30" nullmsg="用户名不能为空" ng-required="true" ng-minlength="1"
                       ng-maxlength="30">
            </div>
            <div class="col-4"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>账号：</label>

            <div class="formControls col-5">
                <input type="text" class="input-text" ng-model="from.account" placeholder="" ng-focus="textfocus()"
                       id="user-account" ng-blur="validName()" name="user-name" datatype="*1-30" ng-required="true"
                       ng-minlength="1"
                       ng-maxlength="30">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>密码：</label>

            <div class="formControls col-5">
                <input type="password" placeholder="密码" ng-model="from.password" autocomplete="off" class="input-text"
                       datatype="*1-20" nullmsg="密码不能为空" ng-required="true" ng-minlength="1"
                       ng-maxlength="30">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">&nbsp;</span>电话：</label>

            <div class="formControls col-5">
                <input type="text" class="input-text" ng-model="from.phone" placeholder="" id="user-tel" name="user-tel"
                       datatype="*0-20" nullmsg="手机不能为空" ng-maxlength="20">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red" required>&nbsp;</span>邮箱：</label>

            <div class="formControls col-5">
                <input type="text" class="input-text" ng-model="from.email" placeholder="@" name="email" id="email"
                       datatype="e" nullmsg="请输入邮箱！" ng-maxlength="30">
            </div>
            <div class="col-4"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-3">角色：</label>

            <div class="formControls col-5">
                <select class="select-box inline-text" style="width:150px" id="selectType"
                        datatype="*"
                        ng-model="from.role.id"
                        ng-options="role.id as role.name for role in roles" ng-required="true">
                    <option value="">--选择用户角色--</option>
                </select>
                <select class="select-box inline-text" style="width:150px" ng-model="from.manager.id"
                        ng-options="manager.id as manager.name for manager in parents">
                    <option value="">--选择主管--</option>
                </select>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">&nbsp;</span>状态：</label>

            <div class="formControls col-5">
                <select name="type" class="select" style="width:150px" ng-model="form.status">
                    <option value="">---请选择状态---</option>
                    <option value="0">关闭</option>
                    <option value="1">正常</option>
                </select>
            </div>
            <div class="col-4"></div>
        </div>

        <script type="text/javascript" src="/static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>

        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"
                       ng-click="editUser()">
            </div>
        </div>
    </form>
</div>


</body>
</html>
