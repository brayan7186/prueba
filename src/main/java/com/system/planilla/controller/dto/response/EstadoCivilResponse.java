package com.system.planilla.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstadoCivilResponse {

	 @JsonProperty("codigo")
	  private int codEstCivil;
	 
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
