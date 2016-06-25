package com.jxnu.it.business.service;


import com.jxnu.it.business.model.FundRank;
import com.jxnu.it.business.store.FundRankStore;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class FundRankServiceImpl implements FundRankService {
	@Resource
	private FundRankStore store;

	@Override
	public List<FundRank> query(Integer status, Integer code, Integer page, Integer pageSize) {
		return store.query(status,code,page,pageSize);
	}

	@Override
	public boolean edit(Integer id) {
		return store.edit(id);
	}

	@Override
	public void delete(Integer id) {
		store.delete(id);
	}
}
