package com.jxnu.it.business.model.fund;

import java.util.Date;

//基金公司
public class FundCompany {
	private Integer id;               //编号
	private String fundCompanyName;   //基金公司名称
	private String fundCompanyCode;   //基金公司代码
	private Float scale;              //注册资金
	private String address;           //地址
	private Date createTime;          //成立时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFundCompanyName() {
		return fundCompanyName;
	}

	public void setFundCompanyName(String fundCompanyName) {
		this.fundCompanyName = fundCompanyName;
	}

	public Float getScale() {
		return scale;
	}

	public void setScale(Float scale) {
		this.scale = scale;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getFundCompanyCode() {
		return fundCompanyCode;
	}

	public void setFundCompanyCode(String fundCompanyCode) {
		this.fundCompanyCode = fundCompanyCode;
	}

	@Override
	public String toString() {
		return "FundCompany{" +
				"id=" + id +
				", fundCompanyName='" + fundCompanyName + '\'' +
				", scale=" + scale +
				", address='" + address + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
