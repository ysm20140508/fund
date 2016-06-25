package com.jxnu.it.business.store;

import com.jxnu.it.business.model.FundCompany;
import com.jxnu.it.management.store.BaseStore;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class FundCompanyStore extends BaseStore {

	public boolean create(FundCompany fundCompany) {
		int row = template.insert("fundCompany.create", fundCompany);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean edit(FundCompany fundCompany) {
		int row = template.update("fundCompany.edit", fundCompany);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public FundCompany find(Integer id) {
		FundCompany user = template.selectOne("fundCompany.find", id);
		return user;
	}

	public boolean delete(Integer id) {
		int row = template.delete("fundCompany.delete", id);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<FundCompany> query(String keyword, Integer page, Integer pageSize) {
		Map<String, Object> params = new HashMap<>();
		params.put("keyword", keyword);
		if (null != page && null != pageSize) {
			int startIndex = page * pageSize;
			params.put("startIndex", startIndex);
			params.put("pageSize", pageSize);
		}
		return template.selectList("fundCompany.query", params);
	}
}
