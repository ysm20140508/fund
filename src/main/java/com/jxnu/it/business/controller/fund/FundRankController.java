package com.jxnu.it.business.controller.fund;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.fund.FundRank;
import com.jxnu.it.business.service.fund.FundRankService;
import com.jxnu.it.constant.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FundRankController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private FundRankService service;

	@RequestMapping(path = "/fund-rank")
	public String init() {
		return "fund-rank";
	}


	@RequestMapping(path = "/fund-rank/update")
	@ResponseBody
	public CommonResp edit(@RequestParam("id") Integer id) {

		CommonResp resp = new CommonResp();
		int result = service.edit(id) ? 0 : 1;
		resp.setResult(result);
		return resp;
	}


	@RequestMapping(path = "/fund-rank/query")
	@ResponseBody
	public List<FundRank> query(@RequestBody(required = false) Query query) {
		logger.debug("query:{}.", query);

		if (null == query) {
			query = new Query();
		}
		List<FundRank> resources = service.query(0, query.getCode(), query.getPage(), query.getPageSize());

		return resources;
	}

	@RequestMapping(path = "/fund-rank/delete")
	@ResponseBody
	public CommonResp delete(@RequestBody FundRank fundRank) {
		CommonResp resp = new CommonResp();
		service.delete(fundRank.getId());
		return resp;
	}

}
