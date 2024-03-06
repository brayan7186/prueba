package com.system.planilla.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DistritoRequest {

	

	@JsonProperty( "codDistrito")
	private Integer codDistrito;
	
	
	

	@JsonProperty("descripcion")
	private String descripcion;


}
