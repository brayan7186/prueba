package com.system.planilla.controller.dto.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AreaResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("codigo")
	private Integer codArea;
	
	@JsonProperty("nombre")
	private String descripcion;

	public Integer getCodArea() {
		return codArea;
	}

	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
