<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="Hui-header cl"><a class="Hui-logo l" title="销量管理平台" href="/">销量管理平台</a>
    <a class="Hui-logo-m l" href="/" title="H-ui.admin">H-ui</a> <span class="Hui-subtitle l">&nbsp;</span>

    <ul class="Hui-userbar">
        <li>[<strong><c:out value="${user.name}"/></strong>]，欢迎你！您使用[<strong><c:out value="${ip}"/></strong>]IP登录！</li>
        <li class="dropDown dropDown_hover"><a href="#" class="dropDown_A">控制面版 <i class="Hui-iconfont">
            &#xe6d5;</i></a>
            <ul class="dropDown-menu radius box-shadow">
                <li><a href="javascript:;" onclick="updatePassword()">修改密码</a></li>
                <li><a href="/user/logout">退出</a></li>
            </ul>
        </li>
        <li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" title="换肤"><i
                class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
            <ul class="dropDown-menu radius box-shadow">
                <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                <li><a href="javascriphttps://www.baidu.com/link?url=N6HtYpj_0WMCH0i5tJdbBLYM5XZDxMWqHvL1XjV_dFYNTOIaKyxQppW-oIksquUUpHkAMx4P4UoiW-0FxqFQYtuDEBBzRbY0-LTpODyJduC&wd=&eqid=e8ee5e6900122fc00000000656d8eefat:;" data-val="red" title="红色">红色</a></li>
                <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
            </ul>
        </li>
    </ul>
    <a href="javascript:;" class="Hui-nav-toggle Hui-iconfont" aria-hidden="false">&#xe667;</a>
    
    <script type="text/javascript" src="/static/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="/static/lib/layer/2.1/layer.js"></script>
    <script  type="text/javascript">
    	 function updatePassword()
    	 {
    		 layer.open({
					type: 2,
					area: ['410'+'px', '310' +'px'],
					fix: false, //不固定
					maxmin: true,
					shade:0.4,
					title: '修改密码',
					content: '/user/sale-passwd/init'
				});
    	 }
    </script>
</header>
