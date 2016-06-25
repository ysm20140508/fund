package com.jxnu.it.management.service;

import com.jxnu.it.constant.Result;
import com.jxnu.it.management.model.LoginLog;
import com.jxnu.it.management.model.User;
import com.jxnu.it.management.store.UserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserStore userStore;

	@Override
	public List<User> query(String name, String account, String status, Integer roleId) {
		return userStore.query(name, account, status, roleId);
	}

	@Override
	public Integer create(User user) {
		boolean created = userStore.create(user);
		if (created) {
			return Result.RESULT_OK;
		} else {
			return Result.RESULT_ERR_RECORD_DUPLICATE;
		}
	}

	@Override
	public Integer edit(User user) {
		boolean updated = userStore.edit(user);
		if (updated) {
			return Result.RESULT_OK;
		} else {
			return Result.RESULT_ERR_RECORD_DUPLICATE;
		}
	}

	@Override
	public Integer editPasswd(String passwd, Integer userId) {
		boolean updated = userStore.editPasswd(passwd, userId);
		if (updated) {
			return Result.RESULT_OK;
		} else {
			return Result.RESULT_ERR_RECORD_DUPLICATE;
		}
	}

	@Override
	public Integer delete(Integer id) {
		boolean deleted = userStore.delete(id);
		if (deleted) {
			return Result.RESULT_OK;
		} else {
			return Result.RESULT_ERR_RECORD_NO_EXISTS;
		}
	}

	@Override
	public List<User> parentManagement() {
		return userStore.parentManagement();
	}

	@Override
	public User findById(Integer userId) {
		return userStore.findById(userId);
	}

	@Override
	public Integer startUser(Integer userId) {
		boolean deleted = userStore.startUser(userId);
		if (deleted) {
			return Result.RESULT_OK;
		} else {
			return Result.RESULT_ERR_RECORD_NO_EXISTS;
		}
	}

	@Override
	public List<User> query(Integer parentId, Integer roleId) {
		return userStore.query(parentId, roleId);
	}

	@Override
	public void save(LoginLog log) {
		userStore.save(log);
	}
}
