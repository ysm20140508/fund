package com.jxnu.it.business.model.fund;

public class FundRank {
	private Integer id;
	private String time;
	private Integer code;
	private String fundName;
	private Integer rank;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FundRank{" +
				"id=" + id +
				", time='" + time + '\'' +
				", code=" + code +
				", fundName='" + fundName + '\'' +
				", rank=" + rank +
				", status=" + status +
				'}';
	}
}
