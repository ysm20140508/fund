package com.jxnu.it.management.service;

import com.jxnu.it.constant.Result;
import com.jxnu.it.management.model.Resource;
import com.jxnu.it.management.model.Role;
import com.jxnu.it.management.store.RoleResourceStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleResourceServiceImpl implements RoleResourceService {
    @Autowired
    private RoleResourceStore roleResourceStore;

    @Override
    public Integer editResource(Role role) {
        Boolean result = roleResourceStore.editResource(role);
        if (result) {
            return Result.RESULT_OK;
        } else {
            return Result.RESULT_ERR_RECORD_NO_EXISTS;
        }
    }

    @Override
    public List<Resource> queryResource(Role role) {
        return roleResourceStore.queryResource(role);
    }
}
