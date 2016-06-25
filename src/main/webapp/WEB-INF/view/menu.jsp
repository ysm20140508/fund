<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="menu_dropdown bk_2">
    <!--//左侧菜单导航-->
    <c:if test="${null != resources}">
        <c:forEach var="p" items="${resources}">
            <dl id="menu-system">
                <dt><i class="Hui-iconfont">&#xe62e;</i> <c:out value="${p.name}"/><i
                        class="Hui-iconfont menu_dropdown-arrow">
                    &#xe6d5;</i></dt>
                <dd>
                    <ul>
                        <c:if test="${null != user.role.resources}">
                            <c:forEach var="r" items="${user.role.resources}">
                                <c:if test="${r.parent.id == p.id}">
                                    <li>
                                        <a _href="<c:out value="${r.path}"/>" data-title="<c:out value="${r.name}"/>"
                                           href="javascript:void(0)"><c:out value="${r.name}"/>
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </ul>
                </dd>
            </dl>
        </c:forEach>
    </c:if>
</div>
