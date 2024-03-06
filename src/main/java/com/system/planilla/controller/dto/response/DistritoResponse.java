package com.system.planilla.controller.dto.response;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DistritoResponse {

	
	
	
	@JsonProperty( "codDistrito")
	private Integer codDistrito;
	
	
	

	@JsonProperty("descripcion")
	private String descripcion;


}
