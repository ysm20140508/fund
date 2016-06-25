package com.jxnu.it.business.service;

import com.jxnu.it.business.model.FundCompany;

import java.util.List;

public interface FundCompanyService {
	public List<FundCompany> query(String keyword, Integer page, Integer pageSize);

	public FundCompany find(Integer id);

	public Integer create(FundCompany fundCompany);

	public Integer edit(FundCompany fundCompany);

	public Integer delete(Integer id);
}
