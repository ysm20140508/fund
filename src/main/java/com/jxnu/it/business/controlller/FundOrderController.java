package com.jxnu.it.business.controlller;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.*;
import com.jxnu.it.business.service.FundOrderService;
import com.jxnu.it.business.service.FundService;
import com.jxnu.it.constant.CommonResp;
import com.jxnu.it.util.DecimalUtil;
import org.omg.CORBA.INTERNAL;
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
public class FundOrderController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private FundOrderService fundOrderService;
	@Resource
	private FundService fundService;

	@RequestMapping(path = "/fund-order")
	public String init() {
		return "fund-order";
	}

	@RequestMapping(path = "/fund-order-make")
	public String make() {
		return "fund-order-make";
	}

	@RequestMapping(path = "/fund-order/create/init")
	public String createPage() {
		return "fund-order-add";
	}

	@RequestMapping(path = "/fund-order/edit/init")
	public ModelAndView editPage(@RequestParam("id") Integer id) {
		Map model = new HashMap<>();
		model.put("id", id);
		return new ModelAndView("fund-order-edit", model);
	}

	@RequestMapping(path = "/fund-order/create")
	@ResponseBody
	public CommonResp create(@RequestBody FundOrder fundOrder) {
		logger.debug("create fundOrder:{}.", fundOrder);

		CommonResp resp = new CommonResp();
		fundOrder = assem(fundOrder);
		int result = fundOrderService.create(fundOrder);
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/fund-order/edit")
	@ResponseBody
	public CommonResp edit(@RequestBody FundOrder fundOrder) {
		logger.debug("edit fundOrder:{}.", fundOrder);

		CommonResp resp = new CommonResp();
		fundOrder = assem(fundOrder);
		int result = fundOrderService.edit(fundOrder);
		resp.setResult(result);

		return resp;
	}

	@RequestMapping(path = "/fund-order/sale/init")
	public ModelAndView saleInit(@RequestParam("id") Integer id) {
		Map model = new HashMap<>();
		model.put("id", id);
		return new ModelAndView("fund-order-sale", model);
	}

	@RequestMapping(path = "/fund-order/sale")
	@ResponseBody
	public CommonResp sale(@RequestBody FundOrder fundOrder) {
		logger.debug("delete fundOrder:{}.", fundOrder);
		Double money = DecimalUtil.mul(fundOrder.getSaleShare(), fundOrder.getSaleNetWorth());
		//赚的基金份额
		Double share = DecimalUtil.div(fundOrder.getMoney(), fundOrder.getStartNetWorth());
		Double makeShare = DecimalUtil.sub(share , fundOrder.getSaleShare());
		//更改订单的状态
		fundOrder.setSaleMoney(money);
		fundOrder.setMakeShare(makeShare);
		int result = fundOrderService.sale(fundOrder);
		//卖出基金金额
		FundAccount fundAccount = new FundAccount();
		fundAccount.setCode(fundOrder.getFund().getCode());
		fundAccount.setTotal(money);

		fundOrder.setMakeShare(makeShare);
		CommonResp resp = new CommonResp();
		FundShare fundShare = new FundShare();
		fundShare.setCode(fundOrder.getFund().getCode());
		fundShare.setFundOrder(fundOrder);
		fundShare.setShare(makeShare);
		fundService.insertFundShare(fundShare, fundAccount);
		resp.setResult(result);
		return resp;
	}

	@RequestMapping(path = "/fund-order/find")
	@ResponseBody
	public FundOrder find(@RequestParam Integer id) {
		logger.debug("find:{}.", id);
		FundOrder fundOrder = fundOrderService.find(id);
		return fundOrder;
	}

	@RequestMapping(path = "/fund-order/query")
	@ResponseBody
	public List<FundOrder> query(@RequestBody(required = false) Query query) {
		logger.debug("query:{}.", query);

		if (null == query) {
			query = new Query();
		}
		List<FundOrder> resources = fundOrderService.query(query.getKeyword(), "0", query.getPage(), query.getPageSize());

		return resources;
	}

	@RequestMapping(path = "/fund-order/make")
	@ResponseBody
	public List<FundOrder> make(@RequestBody(required = false) Query query) {
		logger.debug("query:{}.", query);

		if (null == query) {
			query = new Query();
		}
		List<FundOrder> resources = fundOrderService.query(query.getKeyword(), "1", query.getPage(), query.getPageSize());

		return resources;
	}

	@RequestMapping(path = "/fund-order/list")
	@ResponseBody
	public List<FundOrder> list() {
		List<FundOrder> fundOrderList = fundOrderService.query(null, null, null, null);
		return fundOrderList;
	}

	//设置开始卖出净值的比例
	public FundOrder assem(FundOrder fundOrder) {
		fundOrder.setStartSaleNetWorth(DecimalUtil.mul(fundOrder.getStartNetWorth(), 1.15));
		fundOrder.setEndSaleNetWorth(DecimalUtil.mul(fundOrder.getStartNetWorth(), 1.20));
		fundOrder.setStartSaleShare(DecimalUtil.div(fundOrder.getMoney(), fundOrder.getStartSaleNetWorth()));
		fundOrder.setEndSaleShare(DecimalUtil.div(fundOrder.getMoney(), fundOrder.getEndSaleNetWorth()));
		return fundOrder;
	}

	//设置买入的净值
	@RequestMapping(path = "/fund-order/fund-buy-net-worth")
	@ResponseBody
	public List<FundMarkPointData> FundBuyNetWorth(@RequestParam("code") Integer code) {
		List<FundMarkPointData> fundMarkPointDataList = fundOrderService.query(code);
		return fundMarkPointDataList;
	}

	//订单的买入和卖出
	@RequestMapping(path = "/fund-order/fund-buy-sale")
	@ResponseBody
	public List<FundMarkLineData> fundMarkLineDatas(@RequestParam("code") Integer code) {
		List<FundMarkLineData> fundMarkLineDataList = fundOrderService.queryLineData(code);
		return fundMarkLineDataList;
	}
}
