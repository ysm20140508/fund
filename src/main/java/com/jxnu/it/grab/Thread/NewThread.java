package com.jxnu.it.grab.Thread;

import com.jxnu.it.business.model.FundNew;
import com.jxnu.it.business.store.FundStore;
import com.jxnu.it.grab.DomainParse;
import com.jxnu.it.grab.FundConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NewThread implements Runnable {
	private FundStore fundStore;
	private FundConfig fundConfig;

	public NewThread(FundStore fundStore, FundConfig fundConfig) {
		this.fundStore = fundStore;
		this.fundConfig = fundConfig;
	}

	@Override
	public void run() {
		List<FundNew> fundNewList = new ArrayList<>();
		String response = DomainParse.parseStringUtf8(fundConfig.getFundNew());
		response = response.replace("[[", "{{");
		response = response.replace("]]", "}}");
		response = response.replace("{{", "{[");
		response = response.replace("}}", "]}");
		String[] models = StringUtils.substringsBetween(response, "[", "]");
		for (String model : models) {
			FundNew fundNew = new FundNew();
			String[] fields = model.split(",");
			fundNew.setCode(fields[0].replace("\"",""));
			fundNew.setFundName(fields[1].replace("\"",""));
			fundNew.setFundCompanyName(fields[2].replace("\"",""));
			fundNew.setFundCompanyCode(fields[3].replace("\"",""));
			fundNew.setPeriod(fields[5].replace("\"",""));
			fundNewList.add(fundNew);
		}
		fundStore.insertFundNew(fundNewList);
	}
}
