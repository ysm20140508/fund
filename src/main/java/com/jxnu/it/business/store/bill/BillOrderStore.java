package com.jxnu.it.business.store.bill;

import com.jxnu.it.business.model.bill.BillBalance;
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
public class BillOrderStore extends BaseStore {
    public boolean create(BillOrder billOrder) {
        int row = template.insert("billOrder.create", billOrder);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean edit(BillOrder billOrder) {
        int row = template.update("billOrder.edit", billOrder);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public BillOrder find(Integer id) {
        BillOrder billOrder = template.selectOne("billOrder.find", id);
        return billOrder;
    }

    public boolean delete(Integer id) {
        int row = template.delete("billOrder.delete", id);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<BillOrder> query(String keyword, Integer page, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("keyword", keyword);
        if (null != page && null != pageSize) {
            int startIndex = page * pageSize;
            params.put("startIndex", startIndex);
            params.put("pageSize", pageSize);
        }
        return template.selectList("billOrder.query", params);
    }
}
