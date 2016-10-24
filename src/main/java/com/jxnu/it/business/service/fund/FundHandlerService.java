package com.jxnu.it.business.service.fund;

import com.jxnu.it.business.model.fund.FundHandler;

import java.util.List;

public interface FundHandlerService {
	public List<FundHandler> query(String keyword, Integer page, Integer pageSize);

	public FundHandler find(Integer id);

	public Integer create(FundHandler fundHandler);

	public Integer edit(FundHandler fundHandler);

	public Integer delete(Integer id);
}
