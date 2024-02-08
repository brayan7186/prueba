package com.system.planilla.controller.dto.response;




import com.fasterxml.jackson.annotation.JsonProperty;

public class ContratoResponse {
	
	@JsonProperty( "codigo")
	private Integer codContrato;
	
	@JsonProperty( "Contrato")
	private String modContrato;
	
	@JsonProperty( "fechaI")
	private String fechaInicio;
	
	@JsonProperty( "fechaF")
	private String fechaFin;
	
	@JsonProperty( "sueldoBruto")
	private String sueldoBruto;
	
	@JsonProperty( "bonificacion")
	private Double bonificacion;
	
	@JsonProperty( "nombreCompletoTrabajador")
	private String nombreCompletoTrabajador;

	public Integer getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(Integer codContrato) {
		this.codContrato = codContrato;
	}

	public String getModContrato() {
		return modContrato;
	}

	public void setModContrato(String modContrato) {
		this.modContrato = modContrato;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getSueldoBruto() {
		return sueldoBruto;
	}

	public void setSueldoBruto(String sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}

	public Double getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(Double bonificacion) {
		this.bonificacion = bonificacion;
	}

	public String getNombreCompletoTrabajador() {
		return nombreCompletoTrabajador;
	}

	public void setNombreCompletoTrabajador(String nombreCompletoTrabajador) {
		this.nombreCompletoTrabajador = nombreCompletoTrabajador;
	}


			}