package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFecha {

	private UtilFecha() {

	}

	public static String convertDateToStringFormat(Date date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		String dateToStr = dateFormat.format(date);
		return dateToStr;
	}


}
