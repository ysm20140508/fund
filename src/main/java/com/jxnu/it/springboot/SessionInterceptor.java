package com.jxnu.it.springboot;

import com.jxnu.it.constant.Constants;
import com.jxnu.it.util.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        String path = request.getServletPath();
        if (!StringUtils.equals("/", path)
                && !StringUtils.contains(url, "login")
                && !StringUtils.contains(url, "index")) {
            if (null == SessionUtil.getSessionAttribute(Constants.SESSION_USER_KEY)) {
                request.setAttribute("result", false);
                request.setAttribute("errorMsg", "<strong>登陆信息无效</strong>，请重新进行登陆。");
                // request.getRequestDispatcher("/").forward(request, response);
                String mainUrl = SessionUtil.getRealPath();
                //request.getServletContext().getRequestDispatcher("/").forward(request,response);
                response.sendRedirect(mainUrl);
                return false;
            }
        }
        return true;
    }
}
