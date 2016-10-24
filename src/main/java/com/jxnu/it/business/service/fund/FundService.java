package com.jxnu.it.business.service.fund;

import com.jxnu.it.business.model.fund.Fund;
import com.jxnu.it.business.model.fund.FundAccount;
import com.jxnu.it.business.model.fund.FundNetWorth;
import com.jxnu.it.business.model.fund.FundShare;

import java.util.List;

public interface FundService {
	public List<Fund> query(String keyword, Integer code, Integer page, Integer pageSize);

	public Fund find(Integer id);

	public Integer create(Fund fund);

	public Integer edit(Fund fund);

	public Integer delete(Integer id);

	public List<FundNetWorth> queryFundNetWorth(Integer code);

	public boolean insertFundShare(FundShare fundShare,FundAccount fundAccount);
}
