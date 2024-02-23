package util;

import java.text.DecimalFormat;

public class UtilLimitarDecimal {

	private UtilLimitarDecimal() {

	}

	public static String limitarDosDecimal(Double decimalDouble) {

		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(decimalDouble);

	}

	public static String limitarTresDecimales(Double decimalDouble) {

		DecimalFormat df = new DecimalFormat("#.000");
		return df.format(decimalDouble);
	}

}
