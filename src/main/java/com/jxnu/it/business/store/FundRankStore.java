package com.jxnu.it.business.store;

import com.jxnu.it.business.model.*;
import com.jxnu.it.management.store.BaseStore;
import com.jxnu.it.util.DecimalUtil;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class FundRankStore extends BaseStore {

	public boolean edit(Integer id) {
		int row = template.update("fundRank.updateFundRank", id);
		if (row == 1) {
			FundRank fundRank = template.selectOne("fundRank.findById", id);
			template.insert("insertFundMon", fundRank.getCode());
			return true;
		} else {
			return false;
		}
	}

	public List<FundRank> query(Integer status, Integer code, Integer page, Integer pageSize) {
		Map<String, Object> params = new HashMap<>();
		params.put("status", status);
		params.put("code", code);
		if (null != page && null != pageSize) {
			int startIndex = page * pageSize;
			params.put("startIndex", startIndex);
			params.put("pageSize", pageSize);
		}
		List<FundRank> fundRankList = template.selectList("fundRank.queryFundRank", params);
		return fundRankList;
	}

	public List<Integer> queryFundMon() {
		return template.selectList("fundRank.queryFundMon");
	}

	public void delete(Integer id) {
		 template.delete("fundRank.deleteFundRank", id);
	}
}
