package com.jxnu.it.business.service.bill;

import com.jxnu.it.business.model.bill.BillGood;
import com.jxnu.it.business.model.bill.BillOrder;
import com.jxnu.it.business.store.bill.BillGoodStore;
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
    @Resource
    private BillGoodStore goodStore;


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
        BillGood billGood=goodStore.find(billOrder.getGood().getId());
        Float total = billOrder.getNum() * billGood.getPrice();
        billOrder.setTotal(total);
        if (store.create(billOrder))
            return 0;
        else return 1;
    }

    @Override
    public Integer edit(BillOrder billOrder) {
        BillGood billGood=goodStore.find(billOrder.getGood().getId());
        Float total = billOrder.getNum() * billGood.getPrice();
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
