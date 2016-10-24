package com.jxnu.it.business.service.fund;


import com.jxnu.it.business.model.fund.FundCompany;
import com.jxnu.it.business.store.fund.FundCompanyStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FundCompanyServiceImpl implements FundCompanyService {
	@Resource
	private FundCompanyStore fundCompanyStore;

	@Override
	public List<FundCompany> query(String keyword, Integer page, Integer pageSize) {
		return fundCompanyStore.query(keyword, page, pageSize);
	}

	@Override
	public FundCompany find(Integer id) {
		return fundCompanyStore.find(id);
	}

	@Override
	public Integer create(FundCompany whiteUser) {
		if (fundCompanyStore.create(whiteUser))
			return 0;
		else return 1;
	}

	@Override
	public Integer edit(FundCompany whiteUser) {
		if (fundCompanyStore.edit(whiteUser))
			return 0;
		else return 1;
	}

	@Override
	public Integer delete(Integer id) {
		if (fundCompanyStore.delete(id))
			return 0;
		else return 1;
	}
}
