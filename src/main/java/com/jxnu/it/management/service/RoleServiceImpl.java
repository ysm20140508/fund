package com.jxnu.it.management.service;

import com.jxnu.it.constant.Result;
import com.jxnu.it.management.model.Role;
import com.jxnu.it.management.model.User;
import com.jxnu.it.management.store.ResourceStore;
import com.jxnu.it.management.store.RoleStore;
import com.jxnu.it.management.store.UserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleStore roleStore;
    @Autowired
    private ResourceStore resourceStore;
    @Autowired
    private UserStore userStore;

    @Override
    public int create(String name) {
        boolean result = roleStore.create(name);

        if (result) {
            return Result.RESULT_OK;
        } else {
            return Result.RESULT_ERR_RECORD_DUPLICATE;
        }
    }

    @Override
    public int edit(Integer id, String name) {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        boolean result = roleStore.edit(role);
        if (result) {
            return Result.RESULT_OK;
        } else {
            return Result.RESULT_ERR_RECORD_DUPLICATE;
        }
    }

    @Override
    public int delete(Integer id) {
        //判断是否有人在使用此角色
        List<User> users = userStore.query(null, null, null, id);

        if (null != users && users.size() > 0) {
            return Result.RESULT_ERR_ROLE_HAS_USER;
        }

        boolean result = roleStore.delete(id);
        if (result) {
            resourceStore.deleteRoleAllResource(id);
            return Result.RESULT_OK;
        } else {
            return Result.RESULT_ERR_RECORD_NO_EXISTS;
        }
    }

    @Override
    public List<Role> query(Integer id, String name, Integer page, Integer pageSize) {
        return roleStore.query(id, name, page, pageSize);
    }
}
