package com.system.planilla.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTrabajadorContratoResponse {

	
	@JsonProperty("nombreCompletoTrabajador")
	private String nombreCompletoTrabajador;
	
	
	@JsonProperty("bonificacion")
	private Double bonificacion;


	@JsonProperty("sueldoBruto")
	private String sueldoBruto;
	
	
	@JsonProperty("codTrabajador")
	private Integer codTrabajador;

	


	

}
