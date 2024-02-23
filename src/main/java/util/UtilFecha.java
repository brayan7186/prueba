package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilFecha {

	private UtilFecha() {

	}

	public static String convertDateToStringFormat(Date date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return  dateFormat.format(date);
	}


	
	// Método para convertir una fecha en el formato deseado ("dd/MM/yyyy") al formato de la base de datos ("yyyy-MM-dd")
		public static LocalDate parseFechaBaseDatos(String fechaString) {
		    // Define el formato del String de fecha
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    // Devuelve la fecha parseada
		    return  LocalDate.parse(fechaString, formatter);
		}
		
	public static String formatoFechaBaseDatos(LocalDate fecha) {
	    // Define el formato deseado
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	   
	    // Devuelve la fecha formateada como String
	    return   fecha.format(formatter);
	}

	
}
