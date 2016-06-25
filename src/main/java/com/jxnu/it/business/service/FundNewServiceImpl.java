package com.jxnu.it.business.service;


import com.jxnu.it.business.model.FundNew;
import com.jxnu.it.business.store.FundNewStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FundNewServiceImpl implements FundNewService {
	@Resource
	private FundNewStore fundNewStore;

	@Override
	public boolean update(Integer id) {
		return fundNewStore.update(id);
	}

	@Override
	public List<FundNew> query(String keyword, Integer page, Integer pageSize) {
		return fundNewStore.query(keyword, page, pageSize);
	}
}
