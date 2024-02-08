package com.system.planilla.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CargoResponse {

	
  @JsonProperty("codigo")
  private Integer codCargo ; 
	
  @JsonProperty("nombre")
  private String descripcion ;

public Integer getCodCargo() {
	return codCargo;
}

public void setCodCargo(Integer codCargo) {
	this.codCargo = codCargo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
	
  
  
  
}
