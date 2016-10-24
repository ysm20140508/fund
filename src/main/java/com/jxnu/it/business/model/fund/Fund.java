package com.jxnu.it.business.model.fund;

public class Fund {
	private Integer code;            //基金代码
	private String name;             //基金名称
	private FundHandler fundHandler;  //基金经理人
	private float scale;              //规模
	private FundCompany fundCompany;  //基金公司
	private FundNetWorth fundNetWorth;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FundHandler getFundHandler() {
		return fundHandler;
	}

	public void setFundHandler(FundHandler fundHandler) {
		this.fundHandler = fundHandler;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public FundCompany getFundCompany() {
		return fundCompany;
	}

	public void setFundCompany(FundCompany fundCompany) {
		this.fundCompany = fundCompany;
	}

	public FundNetWorth getFundNetWorth() {
		return fundNetWorth;
	}

	public void setFundNetWorth(FundNetWorth fundNetWorth) {
		this.fundNetWorth = fundNetWorth;
	}

	@Override
	public String toString() {
		return "Fund{" +
				"code=" + code +
				", name='" + name + '\'' +
				", fundHandler=" + fundHandler +
				", scale=" + scale +
				", fundCompany=" + fundCompany +
				'}';
	}
}
