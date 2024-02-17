package com.system.planilla.controller.dto.response;




import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContratoResponse {
	
	@JsonProperty( "codigo")
	private Integer codContrato;
	
	@JsonProperty( "Contrato")
	private String modContrato;
	
	@JsonProperty( "fechaI")
	 @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaInicio;
	
	@JsonProperty( "fechaF")
	 @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaFin;
	
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

	

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
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