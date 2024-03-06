package com.system.planilla.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

 @Getter
 @Setter
public class TrabajadorRequest {

	
	private static final long serialVersionUID = 1L; 
	 
	@JsonProperty("codTrabajador")
	 private Integer codTrabajador;
	
	
	@JsonProperty("nombre")
	 private  String nombre;

	
	@JsonProperty("apeMaterno")
	 private  String apeMaterno;
	
	
	@JsonProperty("apePaterno")
	 private String apePaterno;
	
	
	@JsonProperty("celular")
	 private  String celular;
	
	
	@JsonProperty("codArea")
	 private   Integer  codArea;
	
	
	@JsonProperty("codCargo")
	 private Integer codCargo; 
	
	
	@JsonProperty("codEstCivil")
	 private  Integer codEstCivil;
	
	
	@JsonProperty("codDistrito")
	 private  Integer codDistrito	;
	
	
	@JsonProperty("correo")
	 private String correo;
	
	
	@JsonProperty("direccion")
	 private  String  direccion;
	
	
	@JsonProperty("dni")
	 private String dni; 
	
	
	@JsonProperty("edad")
	 private  Integer edad;
	
	
	

	
	
	
	
	
	
	
	public TrabajadorRequest() {
		super();
	}





	 
	 
	 
	 
	 
	
	  
}
