package com.system.planilla.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

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





	public int getCodTrabajador() {
		return codTrabajador;
	}


    


	public String getApeMaterno() {
		return apeMaterno;
	}


	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}


	public String getApePaterno() {
		return apePaterno;
	}


	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public Integer getCodArea() {
		return codArea;
	}


	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}


	public Integer getCodCargo() {
		return codCargo;
	}


	public void setCodCargo(Integer codCargo) {
		this.codCargo = codCargo;
	}


	public Integer getCodEstCivil() {
		return codEstCivil;
	}


	public void setCodEstCivil(Integer codEstCivil) {
		this.codEstCivil = codEstCivil;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 
	 
	 
	 
	 
	 
	
	  
}
