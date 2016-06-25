package com.jxnu.it.business.model;

public class FundMarkPointData {
	private String name;
	private String xAxis;
	private String yAxis;
	private String value;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getxAxis() {
		return xAxis;
	}

	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}

	public String getyAxis() {
		return yAxis;
	}

	public void setyAxis(String yAxis) {
		this.yAxis = yAxis;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FundMarkPointData{" +
				"name='" + name + '\'' +
				", xAxis='" + xAxis + '\'' +
				", yAxis='" + yAxis + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}
