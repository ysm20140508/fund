package com.jxnu.it.management.service;

import com.jxnu.it.management.model.LoginLog;
import com.jxnu.it.management.model.User;

import java.util.List;

public interface UserService {
	public List<User> query(String name, String account, String status, Integer roleId);

	public Integer create(User user);

	public Integer edit(User user);

	public Integer editPasswd(String passwd,Integer userId);

	public Integer delete(Integer id);

	public List<User> parentManagement();

	public User findById(Integer userId);

	public Integer startUser(Integer userId);

	public List<User> query(Integer parentId,Integer roleId);

	public void save(LoginLog log);
}
