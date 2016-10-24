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
    <script type="text/javascript" src="/scripts/business/fund/fund-edit.js"></script>
    <title>销量管理平台</title>
</head>
<body ng-app="channelApp">
<div class="pd-20" ng-controller="fund-edit">
    <div class="pd-20">
        <form method="post" class="form form-horizontal" id="form-admin-add">
            <input type="hidden" id="id" value="${id}"/>

            <div class="row cl">
                <label class="form-label col-3"><span class="c-red">*</span>基金代码：</label>

                <div class="formControls col-5">
                    <input class="input-text" value=""
                           ng-model="form.code" width="500" readonly>
                </div>
                <div class="col-4"></div>
            </div>
            <div class="row cl">
                <label class="form-label col-3"><span class="c-red">*</span>基金名称：</label>

                <div class="formControls col-5">
                    <input class="input-text" value=""
                           ng-model="form.name" width="500">
                </div>
                <div class="col-4"></div>
            </div>
            <div class="row cl">
                <label class="form-label col-3"><span class="c-red">*</span>规模：</label>

                <div class="formControls col-5">
                    <input class="input-text" value=""
                           ng-model="form.scale" width="500">
                </div>
                <div class="col-4"></div>
            </div>
            <div class="row cl">
                <label class="form-label col-3"><span class="c-red">*</span>基金经理人：</label>

                <div class="formControls col-5">
                    <span class="select-box">
                    <select name="business" class="select" ng-model="form.fundHandler.id">
                        <option value="">基金经理人</option>
                        <option ng-repeat="option in fundHandlers" ng-selected="form.fundHandler.id==option.id" value="{{option.id}}">{{option.name}}</option>
                    </select>
                    </span>
                </div>

            </div>
            <div class="row cl">
                <label class="form-label col-3"><span class="c-red">*</span>基金公司：</label>

                <div class="formControls col-5">
                    <span class="select-box">
                    <select name="business" class="select" ng-model="form.fundCompany.id">
                        <option value="">基金公司</option>
                        <option ng-repeat="option in fundCompanys" ng-selected="form.fundCompany.id==option.id" value="{{option.id}}">{{option.fundCompanyName}}</option>
                    </select>
                    </span>
                </div>
            </div>
            <div class="row cl">
                <div class="col-9 col-offset-3">
                    <input class="btn btn-primary radius" type="submit" ng-click="edit()"
                           value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
                </div>
            </div>
        </form>
    </div>
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
