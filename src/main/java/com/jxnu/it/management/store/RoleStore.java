package com.jxnu.it.management.store;

import com.jxnu.it.management.model.Role;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoleStore extends BaseStore {
    public boolean create(String name) {
        int row = template.insert("role.create", name);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean edit(Role role) {
        int row = template.update("role.edit", role);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Integer id) {
        int row = template.delete("role.delete", id);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<Role> query(Integer id, String name, Integer page, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        if (null != page && null != pageSize) {
            int startIndex = page * pageSize;
            params.put("startIndex", startIndex);
            params.put("pageSize", pageSize);
        }

        return template.selectList("role.query", params);
    }
}
