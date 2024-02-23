package com.system.planilla.controller.dto.response;


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
	private String nombreCompletoTrabajador;
	
	 
}