package com.jxnu.it.grab;

import com.jxnu.it.business.model.FundNew;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-09-29.
 */
public class DomainParse {
	private final static Logger logger = LoggerFactory.getLogger(DomainParse.class);

	public static String parseString(String domain) {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection connection = null;
		BufferedReader reader = null;

		try {
			java.net.URL url = new URL(domain);
			connection = (HttpURLConnection) url.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Content-Type", "charset=utf-8");
			connection.connect();
			Thread.sleep(10000);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			while ((lines = reader.readLine()) != null) {
				sb.append(lines);
			}
		} catch (Exception e) {
			return sb.toString();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static String parseStringUtf8(String domain) {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection connection = null;
		BufferedReader reader = null;

		try {
			java.net.URL url = new URL(domain);
			connection = (HttpURLConnection) url.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Content-Type", "charset=utf-8");
			connection.connect();
			Thread.sleep(10000);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String lines;
			while ((lines = reader.readLine()) != null) {
				sb.append(lines);
			}
		} catch (Exception e) {
			return sb.toString();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		try {
			List<FundNew> fundNewList = new ArrayList<>();
			String response = DomainParse.parseStringUtf8("http://fund.eastmoney.com/data/FundNewIssue.aspx?t=zs&sort=jzrgq,desc&page=1,50&isbuy=1&v=%");
			response = response.replace("[[", "{{");
			response = response.replace("]]", "}}");
			response = response.replace("{{", "{[");
			response = response.replace("}}", "]}");
			String[] models = StringUtils.substringsBetween(response, "[", "]");
			for (String model : models) {
				FundNew fundNew = new FundNew();
				String[] fields = model.split(",");
				fundNew.setCode(fields[0]);
				fundNew.setFundName(fields[1]);
				fundNew.setFundCompanyName(fields[2]);
				fundNew.setFundCompanyCode(fields[3]);
				fundNewList.add(fundNew);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			logger.debug("exception:{}", "123123");
		}
	}
}
