package com.jxnu.it.business.service.fund;


import com.jxnu.it.business.model.fund.FundHandler;
import com.jxnu.it.business.store.fund.FundHandlerStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FundHandlerServiceImpl implements FundHandlerService {
	@Resource
	private FundHandlerStore fundHandlerStore;

	@Override
	public List<FundHandler> query(String keyword, Integer page, Integer pageSize) {
		return fundHandlerStore.query(keyword, page, pageSize);
	}

	@Override
	public FundHandler find(Integer id) {
		return fundHandlerStore.find(id);
	}

	@Override
	public Integer create(FundHandler whiteUser) {
		if (fundHandlerStore.create(whiteUser))
			return 0;
		else return 1;
	}

	@Override
	public Integer edit(FundHandler whiteUser) {
		if (fundHandlerStore.edit(whiteUser))
			return 0;
		else return 1;
	}

	@Override
	public Integer delete(Integer id) {
		if (fundHandlerStore.delete(id))
			return 0;
		else return 1;
	}
}
