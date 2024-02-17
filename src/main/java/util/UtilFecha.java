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
		String dateToStr = dateFormat.format(date);
		return dateToStr;
	}


	
	// Método para convertir una fecha en el formato deseado ("dd/MM/yyyy") al formato de la base de datos ("yyyy-MM-dd")
		public static LocalDate parseFechaBaseDatos(String fechaString) {
		    // Define el formato del String de fecha
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    // Parsea el String a LocalDate
		    LocalDate fecha = LocalDate.parse(fechaString, formatter);
		    // Devuelve la fecha parseada
		    return fecha;
		}
		
	public static String formatoFechaBaseDatos(LocalDate fecha) {
	    // Define el formato deseado
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    // Formatea la fecha usando el formateador
	    String fechaFormateada = fecha.format(formatter);
	    // Devuelve la fecha formateada como String
	    return fechaFormateada;
	}

	
}
