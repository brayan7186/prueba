package util;

import java.text.DecimalFormat;

public class UtilLimitarDecimal {

	private UtilLimitarDecimal() {

	}

	public static String limitarDosDecimal(Double decimalDouble) {

		DecimalFormat df = new DecimalFormat("#.00");
		String decimal = df.format(decimalDouble);
		return decimal;
	}

	public static String limitarTresDecimales(Double decimalDouble) {

		DecimalFormat df = new DecimalFormat("#.000");
		String decimal = df.format(decimalDouble);
		return decimal;
	}

}
