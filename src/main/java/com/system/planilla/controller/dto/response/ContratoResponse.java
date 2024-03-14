package com.system.planilla.controller.dto.response;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.system.planilla.controller.dto.ContratoBase;

import lombok.Getter;
import lombok.Setter;


 @Getter
 @Setter
public class ContratoResponse extends ContratoBase {
	 
	 private static final long serialVersionUID = 1L; 
		
 
	 @JsonProperty("sueldoBruto")
		private String sueldoBruto;

	 
	
	@JsonProperty("nombreCompletoTrabajador")
   @JsonInclude(JsonInclude.Include.NON_NULL)
	private String nombreCompletoTrabajador;
	
	
	@JsonProperty("estado")
	private String estado;
	
	 
	
	
	 
}