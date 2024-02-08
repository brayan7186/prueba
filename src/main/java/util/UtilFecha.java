package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class UtilFecha {

	private UtilFecha() {
		
	}
	
	public static String convertDateToString(Date fechaDate){
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dateToStr = dateFormat.format(fechaDate);
	    return dateToStr;
	  }


}
