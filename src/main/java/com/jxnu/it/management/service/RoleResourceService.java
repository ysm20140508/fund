package com.jxnu.it.management.service;

import com.jxnu.it.management.model.Resource;
import com.jxnu.it.management.model.Role;

import java.util.List;

public interface RoleResourceService {
    public Integer editResource(Role role);

    public List<Resource> queryResource(Role role);
}
