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
    <script type="text/javascript" src="/scripts/custom/user-add.js"></script>
    <script type="text/javascript" src="/static/lib/Validform/5.3.2/Validform.js"></script>
    <script type="text/javascript" src="/static/lib/icheck/jquery.icheck.min.js"></script>


    <title>销量管理平台</title>
</head>
<body ng-app="channelApp">
<div class="pd-20" ng-controller="admin_add">
    <form method="post" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>用户名：</label>

            <div class="formControls col-5">
                <input type="text" class="input-text" value="" placeholder="" ng-model="form.name" name="user-name"
                       datatype="*1-30" nullmsg="用户名不能为空" ng-required="true" ng-minlength="1" ng-maxlength="30">
            </div>
            <div class="col-4"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>账号：</label>

            <div class="formControls col-5">
                <input type="text" class="input-text" value="" placeholder="" ng-focus="textfocus()" id="user-account"
                       ng-blur="validName()" ng-model="form.account" name="user-name" datatype="*1-30" nullmsg="账号不能为空"
                       ng-required="true" ng-minlength="1" ng-maxlength="30">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>初始密码：</label>

            <div class="formControls col-5">
                <input type="password" placeholder="密码" ng-model="form.password" autocomplete="off" value=""
                       class="input-text" datatype="*6-20" nullmsg="密码不能为空" ng-required="true">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>确认密码：</label>

            <div class="formControls col-5">
                <input type="password" placeholder="确认新密码" autocomplete="off" ng-required="true"
                       class="input-text Validform_error" errormsg="您两次输入的新密码不一致！"
                       datatype="*" nullmsg="请再输入一次新密码！"
                       recheck="newpassword" id="newpassword2" name="newpassword2">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">&nbsp;</span>电话：</label>

            <div class="formControls col-5">
                <input type="text" class="input-text" value="" ng-model="form.phone" placeholder=""
                       id="user-tel" name="user-tel" datatype="*0-20" nullmsg="手机不能为空" ng-maxlength="20">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">&nbsp;</span>邮箱：</label>

            <div class="formControls col-5">
                <input type="text" class="input-text" placeholder="@" name="email" ng-model="form.email"
                       id="email" datatype="*0-30" ng-maxlength="30">
            </div>
            <div class="col-4"></div>
        </div>


        <div class="row cl">
            <label class="form-label col-3">角色：</label>

            <div class="formControls col-5">
                <select class="select-box inline-text" style="width:150px" id="selectType" ng-model="form.role.id"
                        ng-options="role.id as role.name for role in roles" ng-required="true" datatype="*">
                    <option value="">--选择用户角色--</option>
                </select>
                <select class="select-box inline-text" style="width:150px" ng-model="form.manager.id"
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

        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"
                       ng-click="createUser()">
            </div>
        </div>
    </form>
</div>

<style type="text/css">
    .hide_text {
        display: none;
    }

    .view_text {
        display: block;
    }


</style>
</body>
</html>
