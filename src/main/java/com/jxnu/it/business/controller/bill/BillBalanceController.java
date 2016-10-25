package com.jxnu.it.business.controller.bill;


import com.jxnu.it.business.form.Query;
import com.jxnu.it.business.model.bill.BillOrder;
import com.jxnu.it.business.service.bill.BillBalanceService;
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
public class BillBalanceController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private BillBalanceService service;

    @RequestMapping(path = "/bill-balance")
    public String init() {
        return "bill-balance";
    }

    @RequestMapping(path = "/bill-balance/query")
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
