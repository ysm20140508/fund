package com.jxnu.it.business.controller.bill;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.bill.BillOrder;
import com.jxnu.it.business.service.bill.BillOrderService;
import com.jxnu.it.business.service.bill.BillOrderService;
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
public class BillOrderController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private BillOrderService service;

    @RequestMapping(path = "/bill-order")
    public String init() {
        return "bill-order";
    }

    @RequestMapping(path = "/bill-order/create/init")
    public String createPage() {
        return "bill-order-add";
    }

    @RequestMapping(path = "/bill-order/edit/init")
    public ModelAndView editPage(@RequestParam("id") Integer id) {
        Map model = new HashMap<>();
        model.put("id", id);
        return new ModelAndView("bill-order-edit", model);
    }

    @RequestMapping(path = "/bill-order/create")
    @ResponseBody
    public CommonResp create(@RequestBody BillOrder billOrder) {
        logger.debug("create billOrder:{}.", billOrder);
        CommonResp resp = new CommonResp();
        int result = service.create(billOrder);
        resp.setResult(result);
        return resp;
    }

    @RequestMapping(path = "/bill-order/edit")
    @ResponseBody
    public CommonResp edit(@RequestBody BillOrder billOrder) {
        logger.debug("edit billOrder:{}.", billOrder);

        CommonResp resp = new CommonResp();
        int result = service.edit(billOrder);
        resp.setResult(result);

        return resp;
    }

    @RequestMapping(path = "/bill-order/delete")
    @ResponseBody
    public CommonResp delete(@RequestBody BillOrder billOrder) {
        logger.debug("delete billOrder:{}.", billOrder);

        CommonResp resp = new CommonResp();
        int result = service.delete(billOrder.getId());
        resp.setResult(result);
        return resp;
    }

    @RequestMapping(path = "/bill-order/find")
    @ResponseBody
    public BillOrder find(@RequestParam Integer id) {
        logger.debug("find:{}.", id);
        BillOrder billOrder = service.find(id);
        return billOrder;
    }

    @RequestMapping(path = "/bill-order/query")
    @ResponseBody
    public List<BillOrder> query(@RequestBody(required = false) Query query) {
        logger.debug("query:{}.", query);

        if (null == query) {
            query = new Query();
        }
        List<BillOrder> resources = service.query(query.getKeyword(), query.getPage(), query.getPageSize());

        return resources;
    }
}
