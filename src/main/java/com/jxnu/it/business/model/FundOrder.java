package com.jxnu.it.business.model;

import java.util.Date;

//基金订单
public class FundOrder {
	private Integer id;                //编号
	private Double money;              //投资金额
	private String startTime;          //买入时间
	private Double startNetWorth;      //买入净值
	private Fund fund;                 //基金
	private Double startSaleNetWorth;  //最低卖出净值
	private Double endSaleNetWorth;    //最高卖出净值
	private Double startSaleShare;     //最低卖出份额
	private Double endSaleShare;       //最高卖出份额
	private Integer status;            //状态 0:赚钱中  1:已赚钱
	private String saleTime;           //卖出时间
	private Double saleNetWorth;       //卖出的净值
	private Double makeShare;          //赚的份额
	private Double saleShare;          //卖出的份额
	private Date createTime;           //买入时间
	private FundAccount fundAccount;
	private Double saleMoney;          //卖出金额
	private Double ratio;              //赚的比例

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getStartNetWorth() {
		return startNetWorth;
	}

	public void setStartNetWorth(Double startNetWorth) {
		this.startNetWorth = startNetWorth;
	}

	public Double getStartSaleNetWorth() {
		return startSaleNetWorth;
	}

	public void setStartSaleNetWorth(Double startSaleNetWorth) {
		this.startSaleNetWorth = startSaleNetWorth;
	}

	public Double getEndSaleNetWorth() {
		return endSaleNetWorth;
	}

	public void setEndSaleNetWorth(Double endSaleNetWorth) {
		this.endSaleNetWorth = endSaleNetWorth;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getStartSaleShare() {
		return startSaleShare;
	}

	public void setStartSaleShare(Double startSaleShare) {
		this.startSaleShare = startSaleShare;
	}

	public Double getEndSaleShare() {
		return endSaleShare;
	}

	public void setEndSaleShare(Double endSaleShare) {
		this.endSaleShare = endSaleShare;
	}

	public Double getSaleNetWorth() {
		return saleNetWorth;
	}

	public void setSaleNetWorth(Double saleNetWorth) {
		this.saleNetWorth = saleNetWorth;
	}

	public Double getSaleShare() {
		return saleShare;
	}

	public void setSaleShare(Double saleShare) {
		this.saleShare = saleShare;
	}

	public Double getMakeShare() {
		return makeShare;
	}

	public void setMakeShare(Double makeShare) {
		this.makeShare = makeShare;
	}

	public FundAccount getFundAccount() {
		return fundAccount;
	}

	public void setFundAccount(FundAccount fundAccount) {
		this.fundAccount = fundAccount;
	}

	public Double getSaleMoney() {
		return saleMoney;
	}

	public void setSaleMoney(Double saleMoney) {
		this.saleMoney = saleMoney;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}

	@Override
	public String toString() {
		return "FundOrder{" +
				"id=" + id +
				", money=" + money +
				", startTime='" + startTime + '\'' +
				", startNetWorth=" + startNetWorth +
				", fund=" + fund +
				", startSaleNetWorth=" + startSaleNetWorth +
				", endSaleNetWorth=" + endSaleNetWorth +
				", startSaleShare=" + startSaleShare +
				", endSaleShare=" + endSaleShare +
				", status=" + status +
				", saleTime='" + saleTime + '\'' +
				", saleNetWorth=" + saleNetWorth +
				", makeShare=" + makeShare +
				", saleShare=" + saleShare +
				", createTime=" + createTime +
				", fundAccount=" + fundAccount +
				", saleMoney=" + saleMoney +
				", ratio=" + ratio +
				'}';
	}
}
