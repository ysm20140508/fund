package com.jxnu.it.grab.Thread;

import com.jxnu.it.business.store.bill.BillBalanceStore;
import com.jxnu.it.business.store.fund.FundRankStore;
import com.jxnu.it.business.store.fund.FundStore;
import com.jxnu.it.constant.Constants;
import com.jxnu.it.grab.FundConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class TheadSet {
	@Resource
	private FundStore fundStore;
	@Resource
	private FundConfig fundConfig;
	@Resource
	private FundRankStore fundRankStore;
	@Resource
	private BillBalanceStore billBalanceStore;

	@PostConstruct
	public void init() {
		//基金排名
		RankThread rankThread = new RankThread(fundStore, fundConfig);
		FundThreadPool.newSheduledInstance().scheduleAtFixedRate(rankThread, Constants.FUND_THREAD_DEPLAY, fundConfig.getPeriod(), TimeUnit.HOURS);
		//基金净值
		NetThread netThread = new NetThread(fundRankStore,fundStore, fundConfig);
		FundThreadPool.newSheduledInstance().scheduleAtFixedRate(netThread, Constants.FUND_THREAD_DEPLAY, 10, TimeUnit.MINUTES);
		//新基金
		NewThread newThread =new NewThread(fundStore,fundConfig);
		FundThreadPool.newSheduledInstance().scheduleAtFixedRate(newThread, Constants.FUND_THREAD_DEPLAY, fundConfig.getPeriod(), TimeUnit.HOURS);
        //账单
		BillThread billThread=new BillThread(billBalanceStore);
		FundThreadPool.newSheduledInstance().scheduleAtFixedRate(billThread,Constants.FUND_THREAD_DEPLAY,fundConfig.getPeriod(),TimeUnit.HOURS);

	}


}
