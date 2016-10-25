package com.jxnu.it.business.service.bill;

import com.jxnu.it.business.model.bill.BillOrder;

import java.util.List;

/**
 * @author shoumiao_yao
 * @date 2016-10-24
 */
public interface BillBalanceService {
    public List<BillOrder> query(String keyword, Integer page, Integer pageSize);
}
