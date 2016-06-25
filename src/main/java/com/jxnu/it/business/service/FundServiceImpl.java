package com.jxnu.it.business.service;


import com.jxnu.it.business.model.Fund;
import com.jxnu.it.business.model.FundAccount;
import com.jxnu.it.business.model.FundNetWorth;
import com.jxnu.it.business.model.FundShare;
import com.jxnu.it.business.store.FundStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FundServiceImpl implements FundService {
	@Resource
	private FundStore fundStore;

	@Override
	public List<Fund> query(String keyword, Integer code, Integer page, Integer pageSize) {
		return fundStore.query(keyword, page, code, pageSize);
	}

	@Override
	public Fund find(Integer id) {
		return fundStore.find(id);
	}

	@Override
	public Integer create(Fund whiteUser) {
		if (fundStore.create(whiteUser))
			return 0;
		else return 1;
	}

	@Override
	public Integer edit(Fund whiteUser) {
		if (fundStore.edit(whiteUser))
			return 0;
		else return 1;
	}

	@Override
	public Integer delete(Integer id) {
		if (fundStore.delete(id))
			return 0;
		else return 1;
	}

	@Override
	public List<FundNetWorth> queryFundNetWorth(Integer code) {
		return fundStore.queryFundNetWorth(code);
	}

	@Override
	public boolean insertFundShare(FundShare fundShare,FundAccount fundAccount) {
		return fundStore.insertFundShare(fundShare,fundAccount);
	}
}
