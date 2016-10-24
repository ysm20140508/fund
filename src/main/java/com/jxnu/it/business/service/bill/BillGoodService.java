package com.jxnu.it.business.service.bill;

import com.jxnu.it.business.model.bill.BillGood;

import java.util.List;

/**
 * @author shoumiao_yao
 * @date 2016-10-24
 */
public interface BillGoodService {
    public List<BillGood> query(String keyword, Integer page, Integer pageSize);

    public BillGood find(Integer id);

    public Integer create(BillGood billGood);

    public Integer edit(BillGood billGood);

    public Integer delete(Integer id);
}
