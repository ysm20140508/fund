package com.jxnu.it.business.model.fund;

public class FundOrderRatio {
	private Integer id;
	private Integer fundOrderId;
	private Integer code;
	private Double ratio;
	private Double netWorth;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFundOrderId() {
		return fundOrderId;
	}

	public void setFundOrderId(Integer fundOrderId) {
		this.fundOrderId = fundOrderId;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public Double getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(Double netWorth) {
		this.netWorth = netWorth;
	}
}
