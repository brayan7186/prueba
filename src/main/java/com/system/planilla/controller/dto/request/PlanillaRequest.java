package com.system.planilla.controller.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanillaRequest {

	
	
	@JsonProperty("nombre")
	private  String descripcion;
		    
	@JsonProperty("anio")
	private	Integer  anio;
	
	@JsonProperty("mes")
	private  String mes;
	
	@JsonProperty("montoTotal")
	private Double montoTotal;

	
	
	 
	private List<DetallePlanillaRequest> detalle;




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public Integer getAnio() {
		return anio;
	}




	public void setAnio(Integer anio) {
		this.anio = anio;
	}




	public String getMes() {
		return mes;
	}




	public void setMes(String mes) {
		this.mes = mes;
	}




	public Double getMontoTotal() {
		return montoTotal;
	}




	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}




	public List<DetallePlanillaRequest> getDetalle() {
		return detalle;
	}




	public void setDetalle(List<DetallePlanillaRequest> detalle) {
		this.detalle = detalle;
	}
	
	
	
	
}
