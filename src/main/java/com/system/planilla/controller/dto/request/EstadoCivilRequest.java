package com.system.planilla.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstadoCivilRequest {

	
	private static final long serialVersionUID = 1L;  
	
	 @JsonProperty("codigo")
	  private Integer codEstCivil;
	 
	 @JsonProperty("nombre")
	  private  String descripcion;

	public int getCodEstCivil() {
		return codEstCivil;
	}

	public void setCodEstCivil(int codEstCivil) {
		this.codEstCivil = codEstCivil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
	 
}
