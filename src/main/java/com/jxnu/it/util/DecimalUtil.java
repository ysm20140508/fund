package com.jxnu.it.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalUtil {
	private static DecimalFormat df = new DecimalFormat("######0.0000");

	public static Double div(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		BigDecimal db3 = bd1.divide(bd2, 4, BigDecimal.ROUND_HALF_UP);

		return Double.parseDouble(df.format(db3.doubleValue()));
	}

	public static Double mul(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		BigDecimal db3 = bd1.multiply(bd2);

		return Double.parseDouble(df.format(db3.doubleValue()));
	}

	public static Double sub(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		BigDecimal db3 = bd1.subtract(bd2);

		return Double.parseDouble(df.format(db3.doubleValue()));
	}
}
