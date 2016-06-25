package com.jxnu.it.business.store;

import com.jxnu.it.business.model.FundHandler;
import com.jxnu.it.management.store.BaseStore;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class FundHandlerStore extends BaseStore {

	public boolean create(FundHandler fundHandler) {
		int row = template.insert("fundHandler.create", fundHandler);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean edit(FundHandler fundHandler) {
		int row = template.update("fundHandler.edit", fundHandler);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public FundHandler find(Integer id) {
		FundHandler user = template.selectOne("fundHandler.find", id);
		return user;
	}

	public boolean delete(Integer id) {
		int row = template.delete("fundHandler.delete", id);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<FundHandler> query(String keyword, Integer page, Integer pageSize) {
		Map<String, Object> params = new HashMap<>();
		params.put("keyword", keyword);
		if (null != page && null != pageSize) {
			int startIndex = page * pageSize;
			params.put("startIndex", startIndex);
			params.put("pageSize", pageSize);
		}
		return template.selectList("fundHandler.query", params);
	}
}
