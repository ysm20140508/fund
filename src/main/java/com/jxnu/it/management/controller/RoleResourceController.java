package com.jxnu.it.management.controller;

import com.jxnu.it.management.model.Operate;
import com.jxnu.it.constant.CommonResp;
import com.jxnu.it.management.model.Resource;
import com.jxnu.it.management.model.Role;
import com.jxnu.it.management.service.RoleResourceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleResourceController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RoleResourceService roleResourceService;

    @RequestMapping(path = "/role/resource")
    public String init() {
        return "role-resource";
    }

    @RequestMapping(path = "/role/resource/query")
    @ResponseBody
    public List<Resource> query(@RequestBody(required = false) Role role) {
        logger.debug("query:{}.", role);

        List<Resource> resources = roleResourceService.queryResource(role);
        return resources;
    }

    @RequestMapping(path = "/role/resource/edit")
    @ResponseBody
    public CommonResp edit(@RequestBody(required = true) Role role) {
        logger.debug("edit:{}.", role);

        List<Resource> resources = new ArrayList<>();

        if (role.getResources() != null) {
            for (Resource resource : role.getResources()) {
                if (resource.getParent() != null) {
                    Operate operate = resource.getOperate();
                    if (null != operate) {
                        Operate o = new Operate();
                        boolean has = false;
                        if (StringUtils.equals(operate.getCreate(), "true")
                                || StringUtils.equals(operate.getCreate(), "1")) {
                            o.setCreate("1");
                            has = true;
                        } else {
                            o.setCreate("0");
                        }

                        if (StringUtils.equals(operate.getQuery(), "true")
                                || StringUtils.equals(operate.getQuery(), "1")) {
                            o.setQuery("1");
                            has = true;
                        } else {
                            o.setQuery("0");
                        }

                        if (StringUtils.equals(operate.getEdit(), "true")
                                || StringUtils.equals(operate.getEdit(), "1")) {
                            o.setEdit("1");
                            has = true;
                        } else {
                            o.setEdit("0");
                        }

                        if (StringUtils.equals(operate.getDelete(), "true")
                                || StringUtils.equals(operate.getDelete(), "1")) {
                            o.setDelete("1");
                            has = true;
                        } else {
                            o.setDelete("0");
                        }
                        if (has) {
                            resource.setOperate(o);
                            resources.add(resource);
                        }
                    }
                }
            }
        }

        role.setResources(resources);

        Integer result = roleResourceService.editResource(role);

        CommonResp resp = new CommonResp();
        resp.setResult(result);
        return resp;
    }
}
