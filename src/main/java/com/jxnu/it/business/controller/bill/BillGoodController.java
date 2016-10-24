package com.jxnu.it.business.controller.bill;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.bill.BillGood;
import com.jxnu.it.business.service.bill.BillGoodService;
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
public class BillGoodController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private BillGoodService service;

	@RequestMapping(path = "/bill-good")
	public String init() {
		return "bill-good";
	}

	@RequestMapping(path = "/bill-good/create/init")
	public String createPage() {
		return "bill-good-add";
	}

	@RequestMapping(path = "/bill-good/edit/init")
	public ModelAndView editPage(@RequestParam("id") Integer id) {
		Map model = new HashMap<>();
		model.put("id", id);
		return new ModelAndView("bill-good-edit", model);
	}

	@RequestMapping(path = "/bill-good/create")
	@ResponseBody
	public CommonResp create(@RequestBody BillGood billGood) {
		logger.debug("create billGood:{}.", billGood);
		CommonResp resp = new CommonResp();
		int result = service.create(billGood);
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/bill-good/edit")
	@ResponseBody
	public CommonResp edit(@RequestBody BillGood billGood) {
		logger.debug("edit billGood:{}.", billGood);

		CommonResp resp = new CommonResp();
		int result = service.edit(billGood);
		resp.setResult(result);

		return resp;
	}

	@RequestMapping(path = "/bill-good/delete")
	@ResponseBody
	public CommonResp delete(@RequestBody BillGood billGood) {
		logger.debug("delete billGood:{}.", billGood);

		CommonResp resp = new CommonResp();
		int result = service.delete(billGood.getId());
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/bill-good/find")
	@ResponseBody
	public BillGood find(@RequestParam Integer id) {
		logger.debug("find:{}.", id);
		BillGood billGood = service.find(id);
		return billGood;
	}

	@RequestMapping(path = "/bill-good/query")
	@ResponseBody
	public List<BillGood> query(@RequestBody(required = false) Query query) {
		logger.debug("query:{}.", query);

		if (null == query) {
			query = new Query();
		}
		List<BillGood> resources = service.query(query.getKeyword(), query.getPage(), query.getPageSize());

		return resources;
	}

	@RequestMapping(path = "/bill-good/list")
	@ResponseBody
	public List<BillGood> list() {
		List<BillGood> billGoodList = service.query(null, null, null);
		return billGoodList;
	}



}
