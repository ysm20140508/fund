package com.jxnu.it.business.controlller;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.FundCompany;
import com.jxnu.it.business.service.FundCompanyService;
import com.jxnu.it.business.service.FundService;
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
public class FundCompanyController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private FundCompanyService fundCompanyService;

	@RequestMapping(path = "/fund-company")
	public String init() {
		return "fund-company";
	}

	@RequestMapping(path = "/fund-company/create/init")
	public String createPage() {
		return "fund-company-add";
	}

	@RequestMapping(path = "/fund-company/edit/init")
	public ModelAndView editPage(@RequestParam("id") Integer id) {
		Map model = new HashMap<>();
		model.put("id", id);
		return new ModelAndView("fund-company-edit", model);
	}

	@RequestMapping(path = "/fund-company/create")
	@ResponseBody
	public CommonResp create(@RequestBody FundCompany fundCompany) {
		logger.debug("create fundCompany:{}.", fundCompany);
		CommonResp resp = new CommonResp();
		int result = fundCompanyService.create(fundCompany);
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/fund-company/edit")
	@ResponseBody
	public CommonResp edit(@RequestBody FundCompany fundCompany) {
		logger.debug("edit fundCompany:{}.", fundCompany);

		CommonResp resp = new CommonResp();
		int result = fundCompanyService.edit(fundCompany);
		resp.setResult(result);

		return resp;
	}

	@RequestMapping(path = "/fund-company/delete")
	@ResponseBody
	public CommonResp delete(@RequestBody FundCompany fundCompany) {
		logger.debug("delete fundCompany:{}.", fundCompany);

		CommonResp resp = new CommonResp();
		int result = fundCompanyService.delete(fundCompany.getId());
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/fund-company/find")
	@ResponseBody
	public FundCompany find(@RequestParam Integer id) {
		logger.debug("find:{}.", id);
		FundCompany fundCompany = fundCompanyService.find(id);
		return fundCompany;
	}

	@RequestMapping(path = "/fund-company/query")
	@ResponseBody
	public List<FundCompany> query(@RequestBody(required = false) Query query) {
		logger.debug("query:{}.", query);

		if (null == query) {
			query = new Query();
		}
		List<FundCompany> resources = fundCompanyService.query(query.getKeyword(), query.getPage(), query.getPageSize());

		return resources;
	}

	@RequestMapping(path = "/fund-company/list")
	@ResponseBody
	public List<FundCompany> list() {
		List<FundCompany> fundCompanyList = fundCompanyService.query(null, null, null);
		return fundCompanyList;
	}



}
