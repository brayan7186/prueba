package com.system.planilla.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoCivilRequest {

	
	private static final long serialVersionUID = 1L;  
	
	 @JsonProperty("codEstCivil")
	  private Integer codEstCivil;
	 
	 @JsonProperty("descripcion")
	  private  String descripcion;

	 
	 
}
