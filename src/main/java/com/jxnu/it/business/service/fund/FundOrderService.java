package com.jxnu.it.business.service.fund;

import com.jxnu.it.business.model.fund.FundMarkLineData;
import com.jxnu.it.business.model.fund.FundMarkPointData;
import com.jxnu.it.business.model.fund.FundOrder;

import java.util.List;

public interface FundOrderService {
	public List<FundOrder> query(String keyword, String status, Integer page, Integer pageSize);

	public FundOrder find(Integer id);

	public Integer create(FundOrder fundOrder);

	public Integer edit(FundOrder fundOrder);

	public Integer sale(FundOrder fundOrder);

	public List<FundMarkPointData> query(Integer code);

	public List<FundMarkLineData> queryLineData(Integer code);

}
