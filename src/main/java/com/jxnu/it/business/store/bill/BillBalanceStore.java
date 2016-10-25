package com.jxnu.it.business.store.bill;

import com.jxnu.it.business.model.bill.BillOrder;
import com.jxnu.it.management.store.BaseStore;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shoumiao_yao
 * @date 2016-10-24
 */
@Component
public class BillBalanceStore extends BaseStore {
    public boolean queryMonthBill() {
        template.selectOne("billBalance.queryMonthBill");
        return true;
    }
    
    public List<BillOrder> query(String keyword, Integer page, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        if (null != page && null != pageSize) {
            int startIndex = page * pageSize;
            params.put("startIndex", startIndex);
            params.put("pageSize", pageSize);
        }
        return template.selectList("billBalance.query", params);
    }
}
