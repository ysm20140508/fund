package com.jxnu.it.business.service.bill;

import com.jxnu.it.business.model.bill.BillOrder;
import com.jxnu.it.business.store.bill.BillOrderStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shoumiao_yao
 * @date 2016-10-24
 */
@Service
public class BillOrderServiceImpl implements BillOrderService {
    @Resource
    private BillOrderStore store;


    @Override
    public List<BillOrder> query(String keyword, Integer page, Integer pageSize) {
        return store.query(keyword, page, pageSize);
    }

    @Override
    public BillOrder find(Integer id) {
        return store.find(id);
    }

    @Override
    public Integer create(BillOrder billOrder) {
        Float total = billOrder.getNum() * billOrder.getGood().getPrice();
        billOrder.setTotal(total);
        if (store.create(billOrder))
            return 0;
        else return 1;
    }

    @Override
    public Integer edit(BillOrder billOrder) {
        Float total = billOrder.getNum() * billOrder.getGood().getPrice();
        billOrder.setTotal(total);
        if (store.edit(billOrder))
            return 0;
        else return 1;
    }

    @Override
    public Integer delete(Integer id) {
        if (store.delete(id))
            return 0;
        else return 1;
    }
}
