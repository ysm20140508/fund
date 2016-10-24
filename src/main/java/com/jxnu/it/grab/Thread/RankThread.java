package com.jxnu.it.grab.Thread;

import com.jxnu.it.business.model.fund.FundRank;
import com.jxnu.it.business.store.fund.FundStore;
import com.jxnu.it.grab.DomainParse;
import com.jxnu.it.grab.FundConfig;
import com.jxnu.it.util.FundUtil;

import java.util.List;

//每天的基金排名
public class RankThread implements Runnable {
	private FundStore fundStore;
	private FundConfig fundConfig;

	public RankThread(FundStore fundStore, FundConfig fundConfig) {
		this.fundStore = fundStore;
		this.fundConfig = fundConfig;
	}

	@Override
	public void run() {
		String response = DomainParse.parseString(fundConfig.getFundRamkUrl());
		List<FundRank> fundRankList = FundUtil.parseFundRankContent(response);
		fundStore.insertFundRankList(fundRankList);
	}
}
