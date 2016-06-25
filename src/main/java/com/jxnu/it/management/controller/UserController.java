package com.jxnu.it.management.controller;

import com.jxnu.it.constant.Constants;
import com.jxnu.it.constant.Result;
import com.jxnu.it.management.form.UserPasswdQuery;
import com.jxnu.it.management.model.User;
import com.jxnu.it.management.service.UserService;
import com.jxnu.it.util.PasswordUtil;
import com.jxnu.it.constant.CommonResp;
import com.jxnu.it.management.form.UserQuery;
import com.jxnu.it.util.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/user")
	public String init() {
		return "user";
	}

	@RequestMapping(path = "/user/add/init")
	public String viewAddUser() {
		return "user-add";
	}


	@RequestMapping(path = "/user/edit/init")
	public ModelAndView viewEditUser(@RequestParam("id") Integer id) {
		Map<String, Object> model = new HashMap<>();
		User user = null;
		user = userService.findById(id);
		if (user != null) {
			model.put("user", user);
		}
		return new ModelAndView("user-edit", model);
	}

	@RequestMapping(path = "/user/edit/initializeVuale")
	@ResponseBody
	public User initializeVuale(@RequestParam("id") Integer id) {
		Map<String, Object> model = new HashMap<>();
		User user = null;
		user = userService.findById(id);
		return user;
	}

	@RequestMapping("/user/create")
	@ResponseBody
	public CommonResp create(@RequestBody User user) {
		logger.debug("user:{} create.", user);
		Integer result = userService.create(user);

		CommonResp resp = new CommonResp();
		resp.setResult(result);
		return resp;
	}

	@RequestMapping("/user/edit")
	@ResponseBody
	public CommonResp edit(@RequestBody User user) {
		logger.debug("user:{} edit.", user);
		Integer result = userService.edit(user);

		CommonResp resp = new CommonResp();
		resp.setResult(result);
		return resp;
	}

	@RequestMapping("/user/delete")
	@ResponseBody
	public CommonResp delete(@RequestBody User user) {

		Integer result = userService.delete(user.getId());

		CommonResp resp = new CommonResp();
		resp.setResult(result);
		return resp;
	}

	@RequestMapping("/user/query")
	@ResponseBody
	public List<User> query(@RequestBody(required = false) UserQuery user) {
		List<User> users = null;
		if (user != null) {
			try {
				users = userService.query(user.getName(), user.getAccount(), user.getStatus(), user.getRoleId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			users = userService.query(null, null, null, null);

		}
		return users;
	}


	@RequestMapping("/user/queryByRoleId")
	@ResponseBody
	public List<User> queryByRoleId(@RequestParam("roleId") Integer roleId) {
		List<User> users = userService.query("", "", "", roleId);
		return users;
	}


	@RequestMapping("/parent/list")
	@ResponseBody
	public List<User> parentList() {
		List<User> users = userService.parentManagement();
		return users;
	}

	@RequestMapping("/user/startUser")
	@ResponseBody
	public CommonResp startUser(@RequestBody User user) {
		logger.debug("user:{} create.", user);
		Integer result = userService.startUser(user.getId());
		CommonResp resp = new CommonResp();
		resp.setResult(result);
		return resp;
	}

	@RequestMapping("/user/update-passwd/init")
	public String passwdInit() {
		return "user-edit-passwd";
	}

	@RequestMapping("/user/edit-passwd")
	@ResponseBody
	public CommonResp editPasswd(@RequestBody(required = false) UserPasswdQuery query) {
		CommonResp commonResp = new CommonResp();
		User user = (User) SessionUtil.getSessionAttribute(Constants.SESSION_USER_KEY);
		user = userService.findById(user.getId());
		String passwd = PasswordUtil.encrypt(query.getPassword());
		if (user == null || !StringUtils.equals(passwd, user.getPassword())) {
			commonResp.setMsg("密码不正确");
			commonResp.setResult(Result.RESULT_ERR_PASSWORD);
			return commonResp;
		}
		commonResp.setResult(userService.editPasswd(PasswordUtil.encrypt(query.getNewPassword()), user.getId()));
		return commonResp;
	}

}
