package com.jxnu.it.grab.Thread;

import com.jxnu.it.business.store.FundRankStore;
import com.jxnu.it.business.store.FundStore;
import com.jxnu.it.constant.Constants;
import com.jxnu.it.grab.FundConfig;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class TheadSet {
	@Resource
	private FundStore fundStore;
	@Resource
	private FundConfig fundConfig;
	@Resource
	private FundRankStore fundRankStore;

	@PostConstruct
	public void init() {
		//基金排名
		RankThread rankThread = new RankThread(fundStore, fundConfig);
		FundThreadPool.newSheduledInstance().scheduleAtFixedRate(rankThread, Constants.FUND_THREAD_DEPLAY, fundConfig.getPeriod(), TimeUnit.HOURS);
		//基金净值
		NetThread netThread = new NetThread(fundRankStore,fundStore, fundConfig);
		FundThreadPool.newSheduledInstance().scheduleAtFixedRate(netThread, Constants.FUND_THREAD_DEPLAY, fundConfig.getPeriod(), TimeUnit.HOURS);
		//新基金
		NewThread newThread =new NewThread(fundStore,fundConfig);
		FundThreadPool.newSheduledInstance().scheduleAtFixedRate(newThread, Constants.FUND_THREAD_DEPLAY, fundConfig.getPeriod(), TimeUnit.HOURS);

	}


}