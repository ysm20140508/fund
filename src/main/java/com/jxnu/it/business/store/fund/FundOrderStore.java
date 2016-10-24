package com.jxnu.it.business.store.fund;

import com.jxnu.it.business.model.fund.FundMarkPointData;
import com.jxnu.it.business.model.fund.FundOrder;
import com.jxnu.it.management.store.BaseStore;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class FundOrderStore extends BaseStore {

	public boolean create(FundOrder fundOrder) {
		int row = template.insert("fundOrder.create", fundOrder);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean edit(FundOrder fundOrder) {
		int row = template.update("fundOrder.edit", fundOrder);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public FundOrder find(Integer id) {
		FundOrder user = template.selectOne("fundOrder.find", id);
		return user;
	}

	public boolean sale(FundOrder fundOrder) {
		int row = template.update("fundOrder.update", fundOrder);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<FundOrder> query(String keyword, String status, Integer page, Integer pageSize) {
		Map<String, Object> params = new HashMap<>();
		params.put("code", keyword);
		params.put("status", status);
		if (null != page && null != pageSize) {
			int startIndex = page * pageSize;
			params.put("startIndex", startIndex);
			params.put("pageSize", pageSize);
		}
		return template.selectList("fundOrder.query", params);
	}

	public List<FundMarkPointData> query(Integer code) {
		return template.selectList("fundOrder.queryCodeStartSale", code);
	}
}
