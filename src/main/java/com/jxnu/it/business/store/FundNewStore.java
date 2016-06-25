package com.jxnu.it.business.store;

import com.jxnu.it.business.model.FundCompany;
import com.jxnu.it.business.model.FundNew;
import com.jxnu.it.management.store.BaseStore;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class FundNewStore extends BaseStore {

	public boolean update(Integer id) {
		int row = template.delete("fundNew.edit", id);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<FundNew> query(String keyword, Integer page, Integer pageSize) {
		Map<String, Object> params = new HashMap<>();
		params.put("keyword", keyword);
		if (null != page && null != pageSize) {
			int startIndex = page * pageSize;
			params.put("startIndex", startIndex);
			params.put("pageSize", pageSize);
		}
		return template.selectList("fundNew.query", params);
	}
}
