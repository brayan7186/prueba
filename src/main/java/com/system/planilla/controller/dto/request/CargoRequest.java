package com.system.planilla.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CargoRequest {

	private static final long serialVersionUID = 1L;
	
  @JsonProperty("codigo")
  private Integer codCargo ; 
	
  @JsonProperty("nombre")
  private String descripcion ;

  
}
