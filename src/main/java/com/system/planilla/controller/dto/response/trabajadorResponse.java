package com.system.planilla.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class trabajadorResponse {

	
	@JsonProperty("codigo")
	 private Integer codTrabajador;
	
	
	@JsonProperty("apellidoM")
	 private  String apeMaterno;
	
	
	@JsonProperty("apellidoP")
	 private String apePaterno;
	
	
	@JsonProperty("celular")
	 private  String celular;
	
	
	@JsonProperty("descripcionArea")
	 private   String  descripcionArea;
	
	
	@JsonProperty("descripcionCargo")
	 private String descripcionCargo; 
	
	
	@JsonProperty("descripcionEstadoCivil")
	 private  String descripcionEstadoCivil;
	
	
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


	public Integer getCodTrabajador() {
		return codTrabajador;
	}


	public void setCodTrabajador(Integer codTrabajador) {
		this.codTrabajador = codTrabajador;
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


	public String getDescripcionArea() {
		return descripcionArea;
	}


	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}


	public String getDescripcionCargo() {
		return descripcionCargo;
	}


	public void setDescripcionCargo(String descripcionCargo) {
		this.descripcionCargo = descripcionCargo;
	}


	public String getDescripcionEstadoCivil() {
		return descripcionEstadoCivil;
	}


	public void setDescripcionEstadoCivil(String descripcionEstadoCivil) {
		this.descripcionEstadoCivil = descripcionEstadoCivil;
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
