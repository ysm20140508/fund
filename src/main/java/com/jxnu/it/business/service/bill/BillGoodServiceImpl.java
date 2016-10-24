package com.jxnu.it.business.service.bill;

import com.jxnu.it.business.model.bill.BillGood;
import com.jxnu.it.business.store.bill.BillGoodStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shoumiao_yao
 * @date 2016-10-24
 */
@Service
public class BillGoodServiceImpl implements BillGoodService {
    @Resource
    private BillGoodStore store;

    @Override
    public List<BillGood> query(String keyword, Integer page, Integer pageSize) {
        return store.query(keyword, page, pageSize);
    }

    @Override
    public BillGood find(Integer id) {
        return store.find(id);
    }

    @Override
    public Integer create(BillGood billGood) {
        if (store.create(billGood))
            return 0;
        else return 1;
    }

    @Override
    public Integer edit(BillGood billGood) {
        if (store.edit(billGood))
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
