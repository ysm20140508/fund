package com.jxnu.it.business.service;

import com.jxnu.it.business.model.FundRank;

import java.util.List;

public interface FundRankService {
	public List<FundRank> query(Integer status, Integer code, Integer page, Integer pageSize);

	public boolean edit(Integer id);

	public void delete(Integer id);
}
