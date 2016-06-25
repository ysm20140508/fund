package com.jxnu.it.springboot;

import com.jxnu.it.constant.Constants;
import com.jxnu.it.management.model.Operate;
import com.jxnu.it.management.model.User;
import com.jxnu.it.util.SessionUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class OperateInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		User user = (User) SessionUtil.getSessionAttribute(Constants.SESSION_USER_KEY);
		if (null != user) {
			Map opeateMap = (HashMap) SessionUtil.getSessionAttribute(Constants.SEESION_OPERATE_MAP_KEY);
			if (opeateMap != null) {
				String url = request.getServletPath();
				if (opeateMap.containsKey(url)) {
					Operate operate = (Operate) opeateMap.get(url);
					SessionUtil.saveRequestAttribute(Constants.SESSION_OPERATE_KEY, operate);
				} else {
					SessionUtil.removeSessionAttribute(Constants.SESSION_OPERATE_KEY);
				}
			} else {
				SessionUtil.removeSessionAttribute(Constants.SESSION_OPERATE_KEY);
			}
		} else {
			SessionUtil.removeSessionAttribute(Constants.SESSION_OPERATE_KEY);
		}
		return true;
	}
}
