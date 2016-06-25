<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
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
    <script type="text/javascript" src="../static/lib/html5.js"></script>
    <script type="text/javascript" src="../static/lib/respond.min.js"></script>
    <script type="text/javascript" src="../static/lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="../static/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/H-ui.admin.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/H-ui.login.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../static/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin"/>
    <link href="../static/lib/Hui-iconfont/1.0.6/iconfont.css" rel="stylesheet" type="text/css"/>

    <!--[if IE 6]>
    <script type="text/javascript" src="../../static/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>销量管理平台</title>
    <script type="text/javascript" src="../static/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="/static/lib/layer/2.1/layer.js"></script>
    <script type="text/javascript" src="../static/js/H-ui.js"></script>
    <script type="text/javascript" src="../static/lib/Validform/5.3.2/Validform.min.js"></script>
    <script type="text/javascript" src="../static/lib/icheck/jquery.icheck.min.js"></script>
    <script type="text/javascript" src="../static/lib/Highcharts/4.1.7/js/highcharts.js"></script>
    <script type="text/javascript" src="../static/lib/Highcharts/4.1.7/js/modules/exporting.js"></script>
    <script type="text/javascript" src="../static/lib/Highcharts/4.1.7/js/highcharts-3d.js"></script>
    <script type="text/javascript" src="../static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="../static/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
    <script type="text/javascript" src="../static/lib/laypage/1.2/laypage.js"></script>
    <script type="text/javascript" src="../static/lib/ueditor/1.4.3/ueditor.config.js"></script>
    <script type="text/javascript" src="../static/lib/ueditor/1.4.3/ueditor.all.min.js"></script>
    <script type="text/javascript" src="../static/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="../scripts/angularjs/angular.js"></script>
    <script src="../scripts/custom/login.js"></script>
</head>
<body ng-app="channelApp">
<div class="header"></div>
<div class="loginWraper" ng-controller="userLogin">
    <div class="loginBox">
        <form id="loginForm" name="loginForm" class="form form-horizontal" method="post"
              ng-submit="login(loginForm.$valid)" novalidate>
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-8">
                    <input type="text" id="account" name="account" placeholder="账户" ng-model='user.account'
                           ng-required="true" class="input-text size-L"
                           ng-maxlength="20" ng-minlength="1">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-8">
                    <input type="password" placeholder="密码" ng-model='user.password' ng-required="true"
                           class="input-text size-L">
                </div>
            </div>
            <div class="row">
                <div class="formControls col-8 col-offset-3">
                    <input name="" type="submit" class="btn btn-success radius size-L"
                           value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                    <input name="" type="reset" class="btn btn-default radius size-L"
                           value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="footer">Copyright @2016 by Yunva</div>
</body>
</html>

