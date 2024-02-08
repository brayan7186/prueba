package com.system.planilla.controller.dto.response;



import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanillaResponse {

	@JsonProperty("codigo")
	private Integer codPlanilla;
	
	@JsonProperty("nombre")
	private  String descripcion;
		    
	@JsonProperty("año")
	private	Integer  anio;
	
	@JsonProperty("mes")
	private  String mes;
	
	@JsonProperty("montoTotal")
	private Double montoTotal;

	public Integer getCodPlanilla() {
		return codPlanilla;
	}

	public void setCodPlanilla(Integer codPlanilla) {
		this.codPlanilla = codPlanilla;
	}

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
	
	
}
