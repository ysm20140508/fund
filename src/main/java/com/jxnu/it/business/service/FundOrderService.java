package com.jxnu.it.business.service;

import com.jxnu.it.business.model.FundMarkLineData;
import com.jxnu.it.business.model.FundMarkPointData;
import com.jxnu.it.business.model.FundOrder;

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
