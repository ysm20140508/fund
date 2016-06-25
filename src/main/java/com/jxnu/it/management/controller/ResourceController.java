package com.jxnu.it.management.controller;

import com.jxnu.it.constant.CommonResp;
import com.jxnu.it.constant.Result;
import com.jxnu.it.management.form.ResourceQuery;
import com.jxnu.it.management.model.Resource;
import com.jxnu.it.management.service.ResourceService;
import com.jxnu.it.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ResourceController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(path = "/resource")
    public String init() {
        return "resource";
    }

    @RequestMapping(path = "/resource/create/init")
    public String createPage() {
        return "resource-add";
    }

    @RequestMapping(path = "/resource/edit/init")
    public ModelAndView editPage(@RequestParam("id") Integer id) {
        SessionUtil.saveRequestAttribute("id", id);
        return new ModelAndView("resource-edit");
    }

    @RequestMapping(path = "/resource/create")
    @ResponseBody
    public CommonResp create(@RequestBody Resource resource) {
        logger.debug("create resource:{}.", resource);

        CommonResp resp = new CommonResp();
        int result = resourceService.create(resource);
        resp.setResult(result);
        return resp;
    }

    @RequestMapping(path = "/resource/edit")
    @ResponseBody
    public CommonResp edit(@RequestBody Resource resource) {
        logger.debug("edit resource:{}.", resource);

        CommonResp resp = new CommonResp();
        if (resource.getParent() != null) {
            if (resource.getId() == resource.getParent().getId()) {
                resp.setResult(Result.RESULT_ERR_RESOURCE_PARENT);
                return resp;
            }
        }

        int result = resourceService.edit(resource);
        resp.setResult(result);

        return resp;
    }

    @RequestMapping(path = "/resource/delete")
    @ResponseBody
    public CommonResp delete(@RequestBody Resource resource) {
        logger.debug("delete resource:{}.", resource);

        CommonResp resp = new CommonResp();
        int result = resourceService.delete(resource.getId());
        resp.setResult(result);
        return resp;
    }

    @RequestMapping(path = "/resource/find")
    @ResponseBody
    public Resource find(@RequestParam Integer id) {
        logger.debug("find:{}.", id);
        Resource resource = resourceService.find(id);
        return resource;
    }

    @RequestMapping(path = "/resource/query")
    @ResponseBody
    public List<Resource> query(@RequestBody(required = false) ResourceQuery query) {
        logger.debug("query:{}.", query);

        if (null == query) {
            query = new ResourceQuery();
        }
        List<Resource> resources = resourceService.query(null, query.getName(), query.getParentId(), query.getPage(), query.getPageSize());

        return resources;
    }

    @RequestMapping(path = "/resource/query/parent")
    @ResponseBody
    public List<Resource> queryParent() {
        List<Resource> resources = resourceService.getAllParentResource();

        return resources;
    }
}
