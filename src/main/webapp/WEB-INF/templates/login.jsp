<jsp:include page="resource.jsp"></jsp:include>
<script type="text/javascript" src="../../scripts/angularjs/angular.js"></script>
<script src="../../scripts/custom/login.js"></script>
</head>
<body ng-app="channelApp">
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper" ng-controller="userLogin">
  <div id="loginform" class="loginBox">
    <form name="loginForm" class="form form-horizontal" method="post" ng-submit="login(loginForm.$valid)" novalidate>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input type="text" placeholder="账户" ng-model='user.account' ng-required="true" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input type="password" placeholder="密码" ng-model='user.password' ng-required="true" class="input-text size-L">
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright @2016 by Yunva</div>
</body>
</html>

