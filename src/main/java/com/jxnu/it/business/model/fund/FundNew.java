package com.jxnu.it.business.model.fund;

public class FundNew {
	private Integer id;
	private String code;
	private String fundName;
	private String fundCompanyName;
	private String fundCompanyCode;
	private String period;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFundCompanyName() {
		return fundCompanyName;
	}

	public void setFundCompanyName(String fundCompanyName) {
		this.fundCompanyName = fundCompanyName;
	}

	public String getFundCompanyCode() {
		return fundCompanyCode;
	}

	public void setFundCompanyCode(String fundCompanyCode) {
		this.fundCompanyCode = fundCompanyCode;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
