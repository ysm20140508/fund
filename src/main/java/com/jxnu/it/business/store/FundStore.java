package com.jxnu.it.business.store;

import com.jxnu.it.business.model.*;
import com.jxnu.it.management.store.BaseStore;
import com.jxnu.it.util.DecimalUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Component
public class FundStore extends BaseStore {

	public boolean create(Fund fund) {
		int row = template.insert("fund.create", fund);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}


	public boolean edit(Fund fund) {
		int row = template.update("fund.edit", fund);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Fund find(Integer id) {
		Fund user = template.selectOne("fund.find", id);
		return user;
	}

	public boolean delete(Integer id) {
		int row = template.delete("fund.delete", id);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<Fund> query(String keyword, Integer code, Integer page, Integer pageSize) {
		Map<String, Object> params = new HashMap<>();
		params.put("keyword", keyword);
		params.put("code", code);
		if (null != page && null != pageSize) {
			int startIndex = page * pageSize;
			params.put("startIndex", startIndex);
			params.put("pageSize", pageSize);
		}
		return template.selectList("fund.query", params);
	}

	public List<FundNetWorth> queryFundNetWorth(Integer code) {
		Map<String, Object> params = new HashMap<>();
		params.put("code", code);
		return template.selectList("fund.queryFundNetWorth", params);
	}

	public boolean insertFundShare(FundShare fundShare, FundAccount fundAccount) {
		int row = template.insert("fund.insertFundShare", fundShare);
		template.insert("fund.insertFundAccount", fundAccount);
		if (row == 1) {
			return true;
		} else {
			return false;
		}
	}


	public void insertFundRankList(List<FundRank> fundRankList) {
		for (FundRank fundRank : fundRankList) {
			if (fundRank == null || StringUtils.isEmpty(fundRank.getTime())) continue;
			Integer count = template.selectOne("fund.queryFundBankCount", fundRank);
			if (count > 0) continue;
			template.insert("fund.insertFundBank", fundRank);
		}
	}


	public void insertFundNetWorth(FundNetWorth fundNetWorth) {
		Integer count = template.selectOne("fund.queryFundNetWorthCount", fundNetWorth);
		if (count > 0) return;
		//插入各个基金的最新净值
		int row = template.insert("fund.insertFundNetWorth", fundNetWorth);
		//实时更新各个订单的
		Map params = new HashMap<>();
		params.put("code", fundNetWorth.getCode());
		params.put("status", "0");
		List<FundOrder> fundOrderList = template.selectList("fundOrder.query", params);
		for (FundOrder fundOrder : fundOrderList) {
			FundOrderRatio fundOrderRatio = new FundOrderRatio();
			fundOrderRatio.setCode(fundNetWorth.getCode());
			fundOrderRatio.setFundOrderId(fundOrder.getId());
			fundOrderRatio.setNetWorth(Double.parseDouble(fundNetWorth.getNetWorth().toString()));
			fundOrderRatio.setRatio(DecimalUtil.div(DecimalUtil.sub(fundNetWorth.getNetWorth(), fundOrder.getStartNetWorth()), fundOrder.getStartNetWorth()));
			template.insert("fundOrder.insertFundOrderRatio", fundOrderRatio);
		}
		if (row == 1) {
			return;
		} else {
			return;
		}
	}

	public void insertFundAccount(FundAccount fundAccount) {
		int row = template.insert("fund.insertFundNetWorth", fundAccount);
		if (row == 1) {
			return;
		} else {
			return;
		}
	}

	public void insertFundNew(List<FundNew> fundNewList) {
		for (FundNew fundNew : fundNewList) {
			Integer count = template.selectOne("fund.queryFundNewCount", fundNew);
			if (count > 0) continue;
			template.insert("fund.insertFundNew", fundNew);
		}
	}
}
