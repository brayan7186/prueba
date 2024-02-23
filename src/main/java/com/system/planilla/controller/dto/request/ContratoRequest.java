package com.system.planilla.controller.dto.request;





import com.fasterxml.jackson.annotation.JsonProperty;
import com.system.planilla.controller.dto.ContratoBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratoRequest extends  ContratoBase {
	
	private static final long serialVersionUID = 1L; 
	 
	
	
	@JsonProperty( "codTrabajador")
	private   Integer codTrabajador;
	
	@JsonProperty("sueldoBruto")
	private Double sueldoBruto;

	
	

	}