package com.jxnu.it.util;

import com.jxnu.it.business.model.FundNetWorth;
import com.jxnu.it.business.model.FundRank;
import com.jxnu.it.constant.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.stream.events.EndElement;
import java.util.ArrayList;
import java.util.List;

public class FundUtil {

	//解析基金排行
	public static List<FundRank> parseFundRankContent(String response) {
		List<FundRank> fundRankList = new ArrayList<>();
		String[] texts = new String[Constants.FUND_RANK_COUNT];
		Document document = Jsoup.parse(response);
		Elements elements = document.getElementsByTag("tbody");
		for (Element element : elements) {
			Elements subElements = element.select("tr");
			for (int i = 0; i < Constants.FUND_RANK_COUNT; i++) {
				Element element1 = subElements.get(i);
				texts[i] = element1.text().replace("估算图基金吧档案", "").replace(" ", "|");
			}
		}
		for (String text : texts) {
			FundRank fundRank = new FundRank();
			if (text.indexOf("|") > -1) {
				fundRank.setRank(Integer.parseInt(text.substring(0, text.indexOf("|")).trim()));
				if(text.indexOf("|")==-1) continue;
				text = text.substring(text.indexOf("|") + 1);
				if(text.indexOf("|")==-1) continue;
				fundRank.setCode(Integer.parseInt(text.substring(0, text.indexOf("|")).trim()));
				if(text.indexOf("|")==-1) continue;
				text = text.substring(text.indexOf("|") + 1);
				if(text.indexOf("|")==-1) continue;
				fundRank.setFundName(text.substring(0, text.indexOf("|")));
			}
			fundRank.setTime(TimeUtils.getCurrentTime());
			fundRankList.add(fundRank);
		}
		return fundRankList;
	}

   //基金净值
	public static FundNetWorth parseFundNetWorht(Integer code, String response) {
		FundNetWorth fundNetWorth = new FundNetWorth();
		fundNetWorth.setCode(code);
		Document document = Jsoup.parse(response);
		Elements elements = document.getElementsByTag("tbody");
		Element element = elements.first();
		String text = element.text().replace(" ", "|");
		if (text.indexOf("|") > -1) {
			fundNetWorth.setTime(text.substring(0, text.indexOf("|")).trim());
			if(text.indexOf("|")==-1)return null;
			text = text.substring(text.indexOf("|") + 1);
			if(text.indexOf("|")==-1)return null;
			fundNetWorth.setNetWorth(Float.parseFloat(text.substring(0, text.indexOf("|")).trim()));
			if(text.indexOf("|")==-1)return null;
			text = text.substring(text.indexOf("|") + 1);
			if(text.indexOf("|")>0 && text.indexOf("%")>0){
				fundNetWorth.setRatio(Float.parseFloat(text.substring(text.indexOf("|") + 1, text.indexOf("%")).trim()));
			}
		}
		return fundNetWorth;
	}
}
