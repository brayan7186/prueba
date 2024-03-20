package com.system.planilla.controller.dto.request;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePlanillaRequest {

	
	
	
	@JsonProperty("sueldoBruto")
	 private Double  sueldoBruto;
	
 
	
	 @JsonProperty( "bonificacion")
	 private  Double bonificacion;
	 
	
	
	 @JsonProperty("codTrabajador")
	 private Integer   codTrabajador;

	

}
