package com.jxnu.it.management.service;

import com.jxnu.it.management.model.Role;

import java.util.List;

public interface RoleService {
    public int create(String name);

    public int edit(Integer id, String name);

    public int delete(Integer id);

    public List<Role> query(Integer id,String name,Integer page,Integer pageSize);
}
