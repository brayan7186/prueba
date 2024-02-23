package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class RedondeoNumeroDecimal {

	 
	
	
	 private RedondeoNumeroDecimal() {
		 
	 }
	
	
	 public static  double roundNumbersDecimal( double sueldoBruto) {
		 
		 double redondeo;
		   
		
	        String numeroComoCadena = Double.toString(sueldoBruto);
	        char ultimoDigitoChar = numeroComoCadena.charAt(numeroComoCadena.length() - 1);

	      
	        int ultimoDigito = Character.getNumericValue(ultimoDigitoChar);

	        if (ultimoDigito >= 5) {
	            BigDecimal bdSueldo = new BigDecimal(String.valueOf(sueldoBruto));
	            bdSueldo = bdSueldo.setScale(1, RoundingMode.HALF_UP);
	            double roundedNum = bdSueldo.doubleValue();

	            String formattedNum = String.format("%.2f", roundedNum);

	            
	            redondeo = Double.parseDouble(formattedNum);
				
	          
				
	        } else  {
	          
	        	redondeo = sueldoBruto;
	        }
	        
			return redondeo;
			
			
	    }
			
	 }

