package com.jxnu.it.management.store;

import com.jxnu.it.management.model.LoginLog;
import com.jxnu.it.management.model.User;
import com.jxnu.it.util.PasswordUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserStore extends BaseStore {
	public List<User> query(String name, String account, String status, Integer roleId) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("name", name);
			params.put("account", account);
			params.put("status", status);
			params.put("roleId", roleId);

       /*  if (null != page && null != pageSize) {
             int startIndex = page * pageSize;
             params.put("startIndex", startIndex);
             params.put("pageSize", pageSize);
         }*/

			return template.selectList("user.query", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean create(User user) {
		user.setPassword(PasswordUtil.encrypt(user.getPassword()));
		int row = template.insert("user.create", user);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}


	public boolean edit(User user) {
		User old = findById(user.getId());

		if (!StringUtils.equals(user.getPassword(), old.getPassword())) {
			user.setPassword(PasswordUtil.encrypt(user.getPassword()));
		}
		int row = template.update("user.edit", user);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean editPasswd(String passwd, Integer userId) {
		User user = new User();
		user.setId(userId);
		user.setPassword(passwd);
		int row = template.update("user.edit", user);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(Integer id) {
		int row = template.delete("user.delete", id);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> parentManagement() {
		return template.selectList("user.parentManagement");

	}

	public User findById(Integer userId) {
		return template.selectOne("user.find", userId);
	}


	public boolean startUser(Integer userId) {
		int row = template.delete("user.startUser", userId);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> query(Integer parentId, Integer roleId) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("parentId", parentId);
			params.put("roleId", roleId);

       /*  if (null != page && null != pageSize) {
             int startIndex = page * pageSize;
             params.put("startIndex", startIndex);
             params.put("pageSize", pageSize);
         }*/

			return template.selectList("user.queryByPatentId", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(LoginLog log) {
		template.insert("user.saveLog", log);
	}

}
