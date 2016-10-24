package com.jxnu.it.business.service.fund;

import com.jxnu.it.business.model.fund.FundNew;

import java.util.List;

public interface FundNewService {
	public boolean update(Integer id);

	public List<FundNew> query(String keyword, Integer page, Integer pageSize);
}
