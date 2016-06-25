package com.jxnu.it.grab.Thread;

import com.jxnu.it.business.model.Fund;
import com.jxnu.it.business.model.FundNetWorth;
import com.jxnu.it.business.model.FundRank;
import com.jxnu.it.business.store.FundRankStore;
import com.jxnu.it.business.store.FundStore;
import com.jxnu.it.grab.DomainParse;
import com.jxnu.it.grab.FundConfig;
import com.jxnu.it.util.FundUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Random;

//基金每日净值
public class NetThread implements Runnable {
	private final static Random ranm = new Random(10000);
	private FundStore fundStore;
	private FundConfig fundConfig;
	private FundRankStore fundRankStore;

	public NetThread(FundRankStore fundRankStore, FundStore fundStore, FundConfig fundConfig) {
		this.fundStore = fundStore;
		this.fundConfig = fundConfig;
		this.fundRankStore = fundRankStore;
	}

	@Override
	public void run() {
		List<Fund> fundList = fundStore.query(null, null, null, null);
		for (Fund fund : fundList) {
			if (fund == null) continue;
			String domain = fundConfig.getFundNetWorth().replace("$", format(fund.getCode())).replace("%", ranm.nextInt() + "");
			String response = DomainParse.parseString(domain);
			FundNetWorth fundNetWorth = FundUtil.parseFundNetWorht(fund.getCode(), response);
			if (fundNetWorth == null || StringUtils.isEmpty(fundNetWorth.getTime()) || fundNetWorth.getNetWorth() == null)
				continue;
			fundStore.insertFundNetWorth(fundNetWorth);
		}

		List<Integer> fundRankList = fundRankStore.queryFundMon();
		for (Integer code : fundRankList) {
			if (code == null) continue;
			String domain = fundConfig.getFundNetWorth().replace("$", format(code)).replace("%", ranm.nextInt() + "");
			String response = DomainParse.parseString(domain);
			FundNetWorth fundNetWorth = FundUtil.parseFundNetWorht(code, response);
			if (fundNetWorth == null || StringUtils.isEmpty(fundNetWorth.getTime()) || fundNetWorth.getNetWorth() == null)
				continue;
			fundStore.insertFundNetWorth(fundNetWorth);
		}
	}


	//补全位数
	public String format(Integer code) {
		if (code == null) return null;
		String codeFormat = code.toString();
		int length = code.toString().length();
		switch (length) {
			case 1:
				codeFormat = "00000" + code;
				break;
			case 2:
				codeFormat = "0000" + code;
				break;
			case 3:
				codeFormat = "000" + code;
				break;
			case 4:
				codeFormat = "00" + code;
				break;
			case 5:
				codeFormat = "0" + code;
				break;
		}
		return codeFormat;
	}

}
