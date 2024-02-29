package com.system.planilla.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoResponse {

	
  @JsonProperty("codCargo")
  private Integer codCargo ; 
	
  @JsonProperty("descripcion")
  private String descripcion ;

  @JsonProperty("codArea")
  private Integer codArea ;

  
  
  
}
