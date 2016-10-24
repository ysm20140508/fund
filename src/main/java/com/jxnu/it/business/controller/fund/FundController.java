package com.jxnu.it.business.controller.fund;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.fund.Fund;
import com.jxnu.it.business.model.fund.FundNetWorth;
import com.jxnu.it.business.service.fund.FundService;
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
public class FundController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private FundService fundService;

	@RequestMapping(path = "/fund")
	public String init() {
		return "fund";
	}

	@RequestMapping(path = "/fund/create/init")
	public String createPage() {
		return "fund-add";
	}

	@RequestMapping(path = "/fund/edit/init")
	public ModelAndView editPage(@RequestParam("id") Integer id) {
		Map model = new HashMap<>();
		model.put("id", id);
		return new ModelAndView("fund-edit", model);
	}

	@RequestMapping(path = "/fund/lineChart/init")
	public ModelAndView lineChart(@RequestParam("id") Integer id) {
		Map model = new HashMap<>();
		model.put("id", id);
		return new ModelAndView("fund-line-chart", model);
	}

	@RequestMapping(path = "/fund/create")
	@ResponseBody
	public CommonResp create(@RequestBody Fund fund) {
		logger.debug("create fund:{}.", fund);

		CommonResp resp = new CommonResp();
		int result = fundService.create(fund);
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/fund/edit")
	@ResponseBody
	public CommonResp edit(@RequestBody Fund fund) {
		logger.debug("edit fund:{}.", fund);

		CommonResp resp = new CommonResp();
		int result = fundService.edit(fund);
		resp.setResult(result);

		return resp;
	}

	@RequestMapping(path = "/fund/delete")
	@ResponseBody
	public CommonResp delete(@RequestBody Fund fund) {
		logger.debug("delete fund:{}.", fund);

		CommonResp resp = new CommonResp();
		int result = fundService.delete(fund.getCode());
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/fund/find")
	@ResponseBody
	public Fund find(@RequestParam("id") Integer id) {
		logger.debug("find:{}.", id);
		Fund fund = fundService.find(id);
		return fund;
	}

	@RequestMapping(path = "/fund/query")
	@ResponseBody
	public List<Fund> query(@RequestBody(required = false) Query query) {
		logger.debug("query:{}.", query);

		if (null == query) {
			query = new Query();
		}
		List<Fund> resources = fundService.query(query.getKeyword(), query.getCode(), query.getPage(), query.getPageSize());

		return resources;
	}

	@RequestMapping(path = "/fund/netWorth")
	@ResponseBody
	public List<FundNetWorth> fundNetWorth(@RequestParam("code") Integer code) {
		List<FundNetWorth> fundNetWorthList = fundService.queryFundNetWorth(code);
		return fundNetWorthList;
	}

	@RequestMapping(path = "/fund/list")
	@ResponseBody
	public List<Fund> funds() {
		List<Fund> fundList = fundService.query(null, null, null, null);
		return fundList;
	}
}
