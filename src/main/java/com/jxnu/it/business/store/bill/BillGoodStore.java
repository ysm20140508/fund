package com.jxnu.it.business.store.bill;

import com.jxnu.it.business.model.bill.BillGood;
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
public class BillGoodStore extends BaseStore {
    public boolean create(BillGood billGood) {
        int row = template.insert("billGood.create", billGood);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean edit(BillGood billGood) {
        int row = template.update("billGood.edit", billGood);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public BillGood find(Integer id) {
        BillGood billGood = template.selectOne("billGood.find", id);
        return billGood;
    }

    public boolean delete(Integer id) {
        int row = template.delete("billGood.delete", id);
        if (row == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<BillGood> query(String keyword, Integer page, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("keyword", keyword);
        if (null != page && null != pageSize) {
            int startIndex = page * pageSize;
            params.put("startIndex", startIndex);
            params.put("pageSize", pageSize);
        }
        return template.selectList("billGood.query", params);
    }
}
