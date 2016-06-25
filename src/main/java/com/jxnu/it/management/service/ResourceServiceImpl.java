package com.jxnu.it.management.service;

import com.jxnu.it.constant.Result;
import com.jxnu.it.management.model.Resource;
import com.jxnu.it.management.store.ResourceStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceStore resourceStore;

    public Resource find(Integer id) {
        return resourceStore.find(id);
    }

    @Override
    public List<Resource> getRoleAllParentResource(Integer roleId) {
        return resourceStore.getRoleAllParentResource(roleId);
    }

    @Override
    public List<Resource> getAllParentResource() {
        return resourceStore.getAllParentResource();
    }

    @Override
    public List<Resource> query(Integer id, String name, Integer parentId, Integer page, Integer pageSize) {
        return resourceStore.query(id, name, parentId, page, pageSize);
    }

    @Override
    public Integer create(Resource resource) {
        boolean created = resourceStore.create(resource);
        if (created) {
            return Result.RESULT_OK;
        } else {
            return Result.RESULT_ERR_RECORD_DUPLICATE;
        }
    }

    @Override
    public Integer edit(Resource resource) {
        boolean updated = resourceStore.edit(resource);
        if (updated) {
            return Result.RESULT_OK;
        } else {
            return Result.RESULT_ERR_RECORD_DUPLICATE;
        }
    }

    @Override
    public Integer delete(Integer id) {
        List<Resource> resources = resourceStore.query(null, null, id, null, null);
        if (null != resources && resources.size() > 0) {
            return Result.RESULT_ERR_RESOURCE_HAS_CHILD;
        }

        boolean deleted = resourceStore.delete(id);

        if (deleted) {
            //删除已分配的角色资源
            resourceStore.deleteDeployAllResource(id);
            return Result.RESULT_OK;
        } else {
            return Result.RESULT_ERR_RECORD_NO_EXISTS;
        }
    }
}
