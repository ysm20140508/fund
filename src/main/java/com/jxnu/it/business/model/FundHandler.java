package com.jxnu.it.business.model;

//基金经理人
public class FundHandler {
	private Integer id;               //编号
	private String name;              //基金经理人名称
	private String fundHandlerCode;   //基金经理人代码
	private FundCompany fundCompany;  //基金公司


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FundCompany getFundCompany() {
		return fundCompany;
	}

	public void setFundCompany(FundCompany fundCompany) {
		this.fundCompany = fundCompany;
	}

	public String getFundHandlerCode() {
		return fundHandlerCode;
	}

	public void setFundHandlerCode(String fundHandlerCode) {
		this.fundHandlerCode = fundHandlerCode;
	}

	@Override
	public String toString() {
		return "FundHandler{" +
				"id=" + id +
				", name='" + name + '\'' +
				", fundHandlerCode='" + fundHandlerCode + '\'' +
				", fundCompany=" + fundCompany +
				'}';
	}
}
