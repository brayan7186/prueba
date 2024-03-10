package com.system.planilla.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TrabajadorResponse {

	
	@JsonProperty("codTrabajador")
	 private Integer codTrabajador;
	
	
	@JsonProperty("apeMaterno")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private  String apeMaterno;
	
	
	@JsonProperty("apePaterno")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private String apePaterno;
	
	
	@JsonProperty("celular")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private  String celular;
	
	
	
	@JsonProperty("correo")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private String correo;
	
	
	@JsonProperty("direccion")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private  String  direccion;
	
	
	@JsonProperty("dni")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private String dni; 
	
	
	@JsonProperty("edad")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private  Integer edad;
	
	
	@JsonProperty("nombre")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private  String nombre;


	 
	@JsonProperty("descripcionArea")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private   String  descripcionArea;
	
	
	@JsonProperty("descripcionCargo")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private String descripcionCargo; 
	
	
	@JsonProperty("descripcionEstadoCivil")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private  String descripcionEstadoCivil;
	
	  
	
	@JsonProperty("descripcionDistrito")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	 private  String descripcionDistrito;
	
}
