package util;

import java.text.DecimalFormat;

public class UtilLimitarDecimal {

	
  private UtilLimitarDecimal() {
		
	}
	
	public static String limitarDecimal(Double decimalDouble){


		
		DecimalFormat df = new DecimalFormat("#.00");
	    String decimal = df.format(decimalDouble);
	    return decimal;
	  }

}
