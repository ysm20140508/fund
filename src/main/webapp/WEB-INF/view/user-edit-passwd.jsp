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
    <script type="text/javascript" src="/scripts/custom/user-edit-passwd.js"></script>
    <script type="text/javascript" src="/static/lib/Validform/5.3.2/Validform.min.js"></script>
    <script type="text/javascript" src="/static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <title>销量管理平台</title>
</head>
<body ng-app="channelApp">
<div class="pd-20" ng-controller="user_edit_passwd">

    <form method="post" class="form form-horizontal" name="userForm">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>原始密码：</label>

            <div class="formControls col-7">
                <input type="password" placeholder="密码" ng-model="form.password" autocomplete="off" class="input-text"
                       datatype="*1-20" nullmsg="密码不能为空" ng-required="true" ng-minlength="1"
                       ng-maxlength="30">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>新密码：</label>

            <div class="formControls col-7">
                <input type="password" placeholder="新密码" id="password" class="input-text"
                       datatype="*1-12" ng-required="true" nullmsg="新密码不能为空"
                       ng-maxlength="12" ng-minlength="1" ng-model="form.newPassword">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>确认密码：</label>

            <div class="formControls col-7">
                <input type="password" placeholder="确认新密码" ng-model="form.affirmPassword"
                       class="input-text " name="passwd" ng-required="true" nullmsg="请再输入一次新密码！" id="passwd"
                       pass-verify="password">

                <p style="color:red" ng-show="userForm.passwd.$dirty && userForm.passwd.$invalid">密码不一致,请重新输入</p>
            </div>
            <div class="col-4"></div>
        </div>

        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;修改&nbsp;&nbsp;"
                       ng-click="editPasswd(userForm.$valid)">
            </div>
        </div>
    </form>
</div>


</body>
</html>
