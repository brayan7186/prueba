package com.system.planilla.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


  @Getter
  @Setter
public class TrabajadorBusquedaDni {
	
	
	 @JsonProperty("codTrabajador")
	 private Integer codTrabajador;
	
	
	@JsonProperty("apeMaterno")
	 private  String apeMaterno;
	
	
	@JsonProperty("apePaterno")
	 private String apePaterno;
	
	
	 @JsonProperty("dni")
	 private String dni; 
	
	
	@JsonProperty("nombre")
	 private  String nombre;


	
	
	

	

}
