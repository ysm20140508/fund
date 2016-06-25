package com.jxnu.it.user;

import com.jxnu.it.constant.Constants;
import com.jxnu.it.constant.LoginResp;
import com.jxnu.it.constant.Result;
import com.jxnu.it.management.model.User;
import com.jxnu.it.management.model.LoginLog;
import com.jxnu.it.management.model.Resource;
import com.jxnu.it.management.service.ResourceService;
import com.jxnu.it.management.service.UserService;
import com.jxnu.it.util.PasswordUtil;
import com.jxnu.it.util.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceService resourceService;

	@RequestMapping("/")
	public String welcome() {
		return "login";
	}

	@RequestMapping(path = "/user/login")
	@ResponseBody
	public LoginResp login(@RequestBody User user) {

		logger.debug("user:{} login.", user);

		List<User> users = userService.query(null, user.getAccount(), null, null);

		LoginResp resp = new LoginResp();

		if (null == users || users.size() != 1) {
			resp.setResult(Result.RESULT_ERR_USER_NO_EXISTS);
			return resp;
		} else {
			User storeUser = users.get(0);
			if (!StringUtils.equals(PasswordUtil.encrypt(user.getPassword()), storeUser.getPassword())) {
				resp.setResult(Result.RESULT_ERR_PASSWORD);
				return resp;
			} else if (!StringUtils.equals(storeUser.getStatus(), Constants.STATE_USER_OPEN)) {
				resp.setResult(Result.RESULT_ERR_STATE);
				return resp;
			} else {
				//设置session
				SessionUtil.saveSessionAttribute(Constants.SESSION_USER_KEY, storeUser);
				SessionUtil.saveSessionAttribute(Constants.SESSION_IP_KEY, SessionUtil.getRequestIp());

				//获取用户权限
				List<Resource> parentResources = resourceService.getRoleAllParentResource(storeUser.getRole().getId());
				SessionUtil.saveSessionAttribute(Constants.SESSION_USER_RESOURCE_KEY, parentResources);

				//记录登录日志
				LoginLog log = new LoginLog();
				log.setUserId(storeUser.getId());
				log.setUserAgent(SessionUtil.getRequestUserAgent());
				log.setIp(SessionUtil.getRequestIp());
				userService.save(log);

				String mainUrl = SessionUtil.getRealPath();
				resp.setUrl(mainUrl.concat("/main"));
				resp.setResult(Result.RESULT_OK);
			}
		}
		return resp;
	}

	@RequestMapping("/main")
	public ModelAndView main() {
		return new ModelAndView("main");
	}

	@RequestMapping("/user/obtainrole")
	public void obtainrole() {
		User user = (User) SessionUtil.getSessionAttribute(Constants.SESSION_USER_KEY);
		Integer roleId = user.getRole().getId();
		//商务
		List<User> bussiness = new ArrayList<User>();
		//主管
		List<User> charge = new ArrayList<User>();
		//业务员
		List<User> salesman = new ArrayList<User>();
		switch (roleId) {
			//管理员 财务
			case 1:
			case 4:
				bussiness = userService.query("", "", "1", null);
				charge = userService.query("", "", "1", 2);
				salesman = userService.query("", "", "1", 3);
				break;
			//通道主管
			case 2:
				//查询主管下面的业务员
				bussiness = userService.query(user.getId(), null);
				salesman = bussiness;
				bussiness.add(user);
				charge.add(user);
				break;
			//通道推广
			default:
				charge.add(user.getManager());
				bussiness.add(user);
				salesman.add(user);
				break;
		}
		SessionUtil.saveSessionAttribute(Constants.SESSION_CHARGE, charge);
		SessionUtil.saveSessionAttribute(Constants.SESSION_BUSSINESS, bussiness);
		SessionUtil.saveSessionAttribute(Constants.SESSION_SALESMAN, salesman);
		//获取用户的操作权限
		Map opeateMap = new HashMap<String, Object>();
		List<Resource> resources = user.getRole().getResources();
		for (Resource resource : resources) {
			if (resource == null) continue;
			opeateMap.put(resource.getPath(), resource.getOperate());
		}
		SessionUtil.saveSessionAttribute(Constants.SEESION_OPERATE_MAP_KEY, opeateMap);
	}

	@RequestMapping(path = "/user/logout")
	public String logout() {
		SessionUtil.invalidateSession();
		return "login";
	}
}
