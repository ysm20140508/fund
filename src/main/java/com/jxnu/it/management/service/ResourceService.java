package com.jxnu.it.management.service;

import com.jxnu.it.management.model.Resource;

import java.util.List;

public interface ResourceService {
    public List<Resource> getRoleAllParentResource(Integer roleId);

    public List<Resource> getAllParentResource();

    public List<Resource> query(Integer id,String name,Integer parentId, Integer page, Integer pageSize);

    public Resource find(Integer id);

    public Integer create(Resource resource);

    public Integer edit(Resource resource);

    public Integer delete(Integer id);
}
