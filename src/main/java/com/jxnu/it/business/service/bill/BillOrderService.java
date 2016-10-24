package com.jxnu.it.business.service.bill;

import com.jxnu.it.business.model.bill.BillOrder;

import java.util.List;

/**
 * @author shoumiao_yao
 * @date 2016-10-24
 */
public interface BillOrderService {
    public List<BillOrder> query(String keyword, Integer page, Integer pageSize);

    public BillOrder find(Integer id);

    public Integer create(BillOrder billOrder);

    public Integer edit(BillOrder billOrder);

    public Integer delete(Integer id);
}
