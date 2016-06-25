package com.jxnu.it.business.controlller;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.FundNew;
import com.jxnu.it.business.service.FundNewService;
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
public class FundNewController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private FundNewService fundNewService;

	@RequestMapping(path = "/fund-new")
	public String init() {
		return "fund-new";
	}


	@RequestMapping(path = "/fund-new/update")
	@ResponseBody
	public CommonResp edit(@RequestParam("id") Integer id) {

		CommonResp resp = new CommonResp();
		int result = fundNewService.update(id)?0:1;
		resp.setResult(result);
		return resp;
	}


	@RequestMapping(path = "/fund-new/query")
	@ResponseBody
	public List<FundNew> query(@RequestBody(required = false) Query query) {
		logger.debug("query:{}.", query);

		if (null == query) {
			query = new Query();
		}
		List<FundNew> resources = fundNewService.query(query.getKeyword(), query.getPage(), query.getPageSize());

		return resources;
	}

}
