package com.jxnu.it.management.store;

import com.jxnu.it.management.model.Resource;
import com.jxnu.it.management.model.Role;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoleResourceStore extends BaseStore {
    public Boolean editResource(Role role) {
        template.delete("resource.deleteRoleAllResource", role.getId());
        if (null != role.getResources() && role.getResources().size() > 0) {
            template.insert("resource.createRoleResource", role);
        }
        return true;
    }

    public List<Resource> queryResource(Role role) {
        if (null == role) {
            Map<String, Object> params = new HashMap<>();
            return template.selectList("resource.query", params);
        } else {
            return template.selectList("resource.getRoleResource", role.getId());
        }
    }
}
