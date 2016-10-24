package com.jxnu.it.business.model.fund;

import com.jxnu.it.business.model.fund.FundOrder;

import java.util.Date;

//基金收益
public class FundShare {
	private Integer id;
	private Integer code;
	private Double share;
	private FundOrder fundOrder;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Double getShare() {
		return share;
	}

	public void setShare(Double share) {
		this.share = share;
	}

	public FundOrder getFundOrder() {
		return fundOrder;
	}

	public void setFundOrder(FundOrder fundOrder) {
		this.fundOrder = fundOrder;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "FundShare{" +
				"id=" + id +
				", code=" + code +
				", share=" + share +
				", fundOrder=" + fundOrder +
				", createTime=" + createTime +
				'}';
	}
}
