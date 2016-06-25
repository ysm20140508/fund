package com.jxnu.it.management.controller;

import com.jxnu.it.constant.CommonResp;
import com.jxnu.it.management.form.RoleQuery;
import com.jxnu.it.management.model.Role;
import com.jxnu.it.management.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RoleService roleService;

    @RequestMapping(path = "/role")
    public String init() {
        return "role";
    }

    @RequestMapping(path = "/role/create/init")
    public String createPage() {
        return "role-add";
    }

    @RequestMapping(path = "/role/create")
    @ResponseBody
    public CommonResp create(@RequestBody Role role) {
        logger.debug("create:{}.", role);

        CommonResp resp = new CommonResp();
        int result = roleService.create(role.getName());
        resp.setResult(result);
        return resp;
    }

    @RequestMapping(path = "/role/edit")
    @ResponseBody
    public CommonResp edit(@RequestBody(required = true) Role role) {
        logger.debug("edit:{}.", role);

        CommonResp resp = new CommonResp();
        int result = roleService.edit(role.getId(), role.getName());
        resp.setResult(result);
        return resp;
    }

    @RequestMapping(path = "/role/delete")
    @ResponseBody
    public CommonResp delete(
            @RequestParam(name = "id", required = true) Integer id) {
        logger.debug("delete role:{}.", id);

        CommonResp resp = new CommonResp();
        int result = roleService.delete(id);
        resp.setResult(result);
        return resp;
    }

    @RequestMapping(path = "/role/query")
    @ResponseBody
    public List<Role> query(@RequestBody(required = false) RoleQuery roleQuery) {
        logger.debug("query:{}.", roleQuery);

        if (null == roleQuery) {
            List<Role> roles = roleService.query(null, null, null, null);

            return roles;
        } else {
            List<Role> roles = roleService.query(null, roleQuery.getName(), roleQuery.getPage(), roleQuery.getPageSize());

            return roles;
        }
    }
}
