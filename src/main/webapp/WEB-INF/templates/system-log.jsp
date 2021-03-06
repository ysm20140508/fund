﻿<%@ page contentType="text/html; charset=utf-8" %>
<jsp:include page="resource.jsp"/>
</head>
<body>
<header class="Hui-header cl"> <a class="Hui-logo l" title="H-ui.admin v2.3" href="/">H-ui.admin</a> <a class="Hui-logo-m l" href="/" title="H-ui.admin">H-ui</a> <span class="Hui-subtitle l">V2.3</span>
  <nav class="mainnav cl" id="Hui-nav">
    <ul>
      <li class="dropDown dropDown_click"><a href="javascript:;" aria-expanded="true" aria-haspopup="true" data-toggle="dropdown" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
        <ul class="dropDown-menu radius box-shadow">
          <li><a href="javascript:;" onclick="article_add('添加资讯','article-add.jsp')"><i class="Hui-iconfont">&#xe616;</i> 资讯</a></li>
          <li><a href="javascript:;" onclick="picture_add('添加资讯','picture-add.jsp')"><i class="Hui-iconfont">&#xe613;</i> 图片</a></li>
          <li><a href="javascript:;" onclick="product_add('添加资讯','product-add.jsp')"><i class="Hui-iconfont">&#xe620;</i> 产品</a></li>
          <li><a href="javascript:;" onclick="member_add('添加用户','member-add.jsp','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
        </ul>
      </li>
    </ul>
  </nav>
  <ul class="Hui-userbar">
    <li>超级管理员</li>
    <li class="dropDown dropDown_hover"><a href="#" class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
      <ul class="dropDown-menu radius box-shadow">
        <li><a href="#">个人信息</a></li>
        <li><a href="#">切换账户</a></li>
        <li><a href="#">退出</a></li>
      </ul>
    </li>
    <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
    <li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
      <ul class="dropDown-menu radius box-shadow">
        <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
        <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
        <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
        <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
        <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
        <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
      </ul>
    </li>
  </ul>
  <a href="javascript:;" class="Hui-nav-toggle Hui-iconfont" aria-hidden="false">&#xe667;</a> </header>
<aside class="Hui-aside">
  <input runat="server" id="divScrollValue" type="hidden" value="" />
  <div class="menu_dropdown bk_2">
    <dl id="menu-article">
      <dt><i class="Hui-iconfont">&#xe616;</i> 资讯管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="article-list.jsp" data-title="资讯管理" href="javascript:void(0)">资讯管理</a></li>
        </ul>
      </dd>
    </dl>
    <dl id="menu-picture">
      <dt><i class="Hui-iconfont">&#xe613;</i> 图片管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="picture-list.jsp" data-title="图片管理" href="javascript:void(0)">图片管理</a></li>
        </ul>
      </dd>
    </dl>
    <dl id="menu-product">
      <dt><i class="Hui-iconfont">&#xe620;</i> 产品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="product-brand.jsp" data-title="品牌管理" href="javascript:void(0)">品牌管理</a></li>
          <li><a _href="product-category.jsp" data-title="分类管理" href="javascript:void(0)">分类管理</a></li>
          <li><a _href="product-list.jsp" data-title="产品管理" href="javascript:void(0)">产品管理</a></li>
        </ul>
      </dd>
    </dl>
    <!--<dl id="menu-page">
        <dt><i class="Hui-iconfont">&#xe626;</i> 页面管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
            <ul>
                <li><a _href="page-home.jsp" href="javascript:void(0)">首页管理</a></li>
                <li><a _href="page-flinks.jsp" href="javascript:void(0)">友情链接</a></li>
            </ul>
        </dd>
    </dl>-->
    <dl id="menu-comments">
      <dt><i class="Hui-iconfont">&#xe622;</i> 评论管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="http://h-ui.duoshuo.com/admin/" data-title="评论列表" href="javascript:;">评论列表</a></li>
          <li><a _href="feedback-list.jsp" data-title="意见反馈" href="javascript:void(0)">意见反馈</a></li>
        </ul>
      </dd>
    </dl>
    <!--<dl id="menu-order">
        <dt><i class="Hui-iconfont">&#xe63a;</i> 财务管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
            <ul>
                <li><a _href="order-list.jsp" href="javascript:void(0)">订单列表</a></li>
                <li><a _href="recharge-list.jsp" href="javascript:void(0)">充值管理</a></li>
                <li><a _href="invoice-list.jsp" href="javascript:void(0)">发票管理</a></li>
            </ul>
        </dd>
    </dl>-->
    <dl id="menu-member">
      <dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="member-list.jsp" data-title="会员列表" href="javascript:;">会员列表</a></li>
          <li><a _href="member-del.jsp" data-title="删除的会员" href="javascript:;">删除的会员</a></li>
          <li><a _href="member-level.jsp" data-title="等级管理" href="javascript:;">等级管理</a></li>
          <li><a _href="member-scoreoperation.jsp" data-title="积分管理" href="javascript:;">积分管理</a></li>
          <li><a _href="member-record-browse.jsp" data-title="浏览记录" href="javascript:void(0)">浏览记录</a></li>
          <li><a _href="member-record-download.jsp" data-title="下载记录" href="javascript:void(0)">下载记录</a></li>
          <li><a _href="member-record-share.jsp" data-title="分享记录" href="javascript:void(0)">分享记录</a></li>
        </ul>
      </dd>
    </dl>
    <dl id="menu-admin">
      <dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="admin-role.jsp" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
          <li><a _href="admin-permission.jsp" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
          <li><a _href="admin-list.jsp" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
        </ul>
      </dd>
    </dl>
    <dl id="menu-tongji">
      <dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="charts-1.jsp" data-title="折线图" href="javascript:void(0)">折线图</a></li>
          <li><a _href="charts-2.jsp" data-title="时间轴折线图" href="javascript:void(0)">时间轴折线图</a></li>
          <li><a _href="charts-3.jsp" data-title="区域图" href="javascript:void(0)">区域图</a></li>
          <li><a _href="charts-4.jsp" data-title="柱状图" href="javascript:void(0)">柱状图</a></li>
          <li><a _href="charts-5.jsp" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
          <li><a _href="charts-6.jsp" data-title="3D柱状图" href="javascript:void(0)">3D柱状图</a></li>
          <li><a _href="charts-7.jsp" data-title="3D饼状图" href="javascript:void(0)">3D饼状图</a></li>
        </ul>
      </dd>
    </dl>
    <dl id="menu-system">
      <dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="system-base.jsp" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
          <li><a _href="system-category.jsp" data-title="栏目管理" href="javascript:void(0)">栏目管理</a></li>
          <li><a _href="system-data.jsp" data-title="数据字典" href="javascript:void(0)">数据字典</a></li>
          <li><a _href="system-shielding.jsp" data-title="屏蔽词" href="javascript:void(0)">屏蔽词</a></li>
          <li><a _href="system-log.jsp" data-title="系统日志" href="javascript:void(0)">系统日志</a></li>
        </ul>
      </dd>
    </dl>
  </div>
</aside>
<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
  <div id="Hui-tabNav" class="Hui-tabNav">
    <div class="Hui-tabNav-wp">
      <ul id="min_title_list" class="acrossTab cl">
        <li class="active"><span title="我的桌面" data-href="welcome.jsp">我的桌面</span><em></em></li>
      </ul>
    </div>
    <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
  </div>
  <div id="iframe_box" class="Hui-article">
    <div class="show_iframe">
      <div style="display:none" class="loading"></div>
      <iframe scrolling="yes" frameborder="0" src="welcome.jsp"></iframe>
    </div>
  </div>
</section>

<script type="text/javascript">
  /*资讯-添加*/
  function article_add(title,url){
    var index = layer.open({
      type: 2,
      title: title,
      content: url
    });
    layer.full(index);
  }
  /*图片-添加*/
  function picture_add(title,url){
    var index = layer.open({
      type: 2,
      title: title,
      content: url
    });
    layer.full(index);
  }
  /*产品-添加*/
  function product_add(title,url){
    var index = layer.open({
      type: 2,
      title: title,
      content: url
    });
    layer.full(index);
  }
  /*用户-添加*/
  function member_add(title,url,w,h){
    layer_show(title,url,w,h);
  }
</script>

</body>
