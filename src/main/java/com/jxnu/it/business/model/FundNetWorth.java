package com.jxnu.it.business.model;

import java.util.Date;

//基金净值
public class FundNetWorth {
	private Integer id;       //编号
	private Integer code;     //基金代码
	private String time;      //时间
	private Float netWorth;   //净值
	private Float ratio;      //比例
	private Date createTime;  //创建时间

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Float getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(Float netWorth) {
		this.netWorth = netWorth;
	}

	public Float getRatio() {
		return ratio;
	}

	public void setRatio(Float ratio) {
		this.ratio = ratio;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "FundNetWorth{" +
				"id=" + id +
				", code=" + code +
				", time='" + time + '\'' +
				", netWorth=" + netWorth +
				", ratio=" + ratio +
				", createTime=" + createTime +
				'}';
	}
}
