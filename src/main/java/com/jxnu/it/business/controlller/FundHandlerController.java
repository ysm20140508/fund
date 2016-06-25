package com.jxnu.it.business.controlller;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.FundHandler;
import com.jxnu.it.business.service.FundCompanyService;
import com.jxnu.it.business.service.FundHandlerService;
import com.jxnu.it.constant.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FundHandlerController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private FundHandlerService fundHandlerService;

	@RequestMapping(path = "/fund-handler")
	public String init() {
		return "fund-handler";
	}

	@RequestMapping(path = "/fund-handler/create/init")
	public String createPage() {
		return "fund-handler-add";
	}

	@RequestMapping(path = "/fund-handler/edit/init")
	public ModelAndView editPage(@RequestParam("id") Integer id) {
		Map model = new HashMap<>();
		model.put("id", id);
		return new ModelAndView("fund-handler-edit", model);
	}

	@RequestMapping(path = "/fund-handler/create")
	@ResponseBody
	public CommonResp create(@RequestBody FundHandler fundHandler) {
		logger.debug("create fundHandler:{}.", fundHandler);

		CommonResp resp = new CommonResp();
		int result = fundHandlerService.create(fundHandler);
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/fund-handler/edit")
	@ResponseBody
	public CommonResp edit(@RequestBody FundHandler fundHandler) {
		logger.debug("edit fundHandler:{}.", fundHandler);

		CommonResp resp = new CommonResp();
		int result = fundHandlerService.edit(fundHandler);
		resp.setResult(result);

		return resp;
	}

	@RequestMapping(path = "/fund-handler/delete")
	@ResponseBody
	public CommonResp delete(@RequestBody FundHandler fundHandler) {
		logger.debug("delete fundHandler:{}.", fundHandler);

		CommonResp resp = new CommonResp();
		int result = fundHandlerService.delete(fundHandler.getId());
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/fund-handler/find")
	@ResponseBody
	public FundHandler find(@RequestParam Integer id) {
		logger.debug("find:{}.", id);
		FundHandler fundHandler = fundHandlerService.find(id);
		return fundHandler;
	}

	@RequestMapping(path = "/fund-handler/query")
	@ResponseBody
	public List<FundHandler> query(@RequestBody(required = false) Query query) {
		logger.debug("query:{}.", query);

		if (null == query) {
			query = new Query();
		}
		List<FundHandler> resources = fundHandlerService.query(query.getKeyword(), query.getPage(), query.getPageSize());

		return resources;
	}

	@RequestMapping(path = "/fund-handler/list")
	@ResponseBody
	public List<FundHandler> list() {
		List<FundHandler> fundCompanyList = fundHandlerService.query(null, null, null);
		return fundCompanyList;
	}
}
