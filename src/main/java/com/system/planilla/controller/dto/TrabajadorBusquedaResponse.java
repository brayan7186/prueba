package com.system.planilla.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

 @Getter
 @Setter
public class TrabajadorBusquedaResponse {

	
	 @JsonProperty("codTrabajador")
	 private Integer codTrabajador;
	
	
	@JsonProperty("apeMaterno")
	 private  String apeMaterno;
	
	
	@JsonProperty("apePaterno")
	 private String apePaterno;
	
	
	@JsonProperty("celular")
	 private  String celular;
	
	
	
	@JsonProperty("correo")
	 private String correo;
	
	
	@JsonProperty("direccion")
	 private  String  direccion;
	
	
	@JsonProperty("dni")
	 private String dni; 
	
	
	@JsonProperty("edad")
	 private  Integer edad;
	
	
	@JsonProperty("nombre")
	 private  String nombre;


	 
	@JsonProperty("descripcionArea")
	 private   String  descripcionArea;
	
	
	@JsonProperty("descripcionCargo")
	 private String descripcionCargo; 
	
	
	@JsonProperty("descripcionEstadoCivil")
	 private  String descripcionEstadoCivil;
	
	  
}
