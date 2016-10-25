package com.jxnu.it.business.service.bill;

import com.jxnu.it.business.model.bill.BillOrder;
import com.jxnu.it.business.store.bill.BillBalanceStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shoumiao_yao
 * @date 2016-10-24
 */
@Service
public class BillBalanceServiceImpl implements BillBalanceService {
    @Resource
    private BillBalanceStore store;

    @Override
    public List<BillOrder> query(String keyword, Integer page, Integer pageSize) {
        return store.query(keyword, page, pageSize);
    }

}
