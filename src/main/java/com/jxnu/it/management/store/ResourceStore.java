package com.jxnu.it.management.store;

import com.jxnu.it.management.model.Resource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ResourceStore extends BaseStore {
    public Resource find(Integer id) {
        return template.selectOne("resource.find", id);
    }

    public List<Resource> query(Integer id, String name, Integer parentId, Integer page, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("parentId", parentId);

        if (null != page && null != pageSize) {
            int startIndex = page * pageSize;
            params.put("startIndex", startIndex);
            params.put("pageSize", pageSize);
        }
        return template.selectList("resource.query", params);
    }

    public List<Resource> getRoleAllParentResource(Integer roleId) {
        return template.selectList("resource.getRoleParentResource", roleId);
    }

    public List<Resource> getAllParentResource() {
        return template.selectList("resource.getAllParentResource");
    }

    public void deleteRoleAllResource(Integer roleId) {
        template.delete("resource.deleteRoleAllResource", roleId);
    }

    public void deleteDeployAllResource(Integer ResourceId) {
        template.delete("resource.deleteDeployAllResource", ResourceId);
    }

    public boolean create(Resource resource) {
        //用来查询排序
        if (null != resource.getParent()) {
            resource.setIndex(resource.getParent().getId());
        }
        int row = template.insert("resource.create", resource);
        if (row == 1) {
            if (null == resource.getParent()) {
                resource.setIndex(resource.getId());
                template.update("resource.updateIndex", resource);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean edit(Resource resource) {
        if (null == resource.getParent()) {
            resource.setIndex(resource.getParent().getId());
        } else {
            resource.setIndex(resource.getId());
        }
        int row = template.update("resource.edit", resource);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Integer id) {
        int row = template.delete("resource.delete", id);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }
}
