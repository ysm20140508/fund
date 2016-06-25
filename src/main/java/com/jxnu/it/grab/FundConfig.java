package com.jxnu.it.grab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FundConfig {
	@Value("${fund.rank}")
	private String fundRamkUrl;
	@Value("${fund.thred.num}")
	private Integer fundThredNum;
	@Value("${thread.period}")
	private Integer period;
	@Value("${fund.net.worth}")
	private String fundNetWorth;
	@Value("${fund.new}")
	private String fundNew;


	public String getFundRamkUrl() {
		return fundRamkUrl;
	}

	public void setFundRamkUrl(String fundRamkUrl) {
		this.fundRamkUrl = fundRamkUrl;
	}

	public Integer getFundThredNum() {
		return fundThredNum;
	}

	public void setFundThredNum(Integer fundThredNum) {
		this.fundThredNum = fundThredNum;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getFundNetWorth() {
		return fundNetWorth;
	}

	public void setFundNetWorth(String fundNetWorth) {
		this.fundNetWorth = fundNetWorth;
	}

	public String getFundNew() {
		return fundNew;
	}

	public void setFundNew(String fundNew) {
		this.fundNew = fundNew;
	}
}
