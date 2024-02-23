package com.system.planilla.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoCivilResponse {

	 @JsonProperty("codEstCivil")
	  private int codEstCivil;
	 
	 @JsonProperty("descripcion")
	  private  String descripcion;

	
	 
}
