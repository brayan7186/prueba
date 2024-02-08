package com.system.planilla.controller.dto.request;




import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ContratoRequest {
	
	private static final long serialVersionUID = 1L; 
	 
	@JsonProperty( "codigo")
	private Integer codContrato;
	
	@JsonProperty( "modContrato")
	private String modContrato;
	
	@JsonProperty( "fechaInicio")
	private Date fechaInicio;
	
	@JsonProperty( "fechaFin")
	private Date fechaFin;
	
	@JsonProperty( "sueldoBruto")
	private Double sueldoBruto;
	
	@JsonProperty( "bonificacion")
	private Double bonificacion;
	
	@JsonProperty( "codTrabajador")
	private   Integer codTrabajador;
	
	
	
	

	

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

	public Date getFechaInicio() {
		return fechaInicio;
	}




	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getSueldoBruto() {
		return sueldoBruto;
	}


	public void setSueldoBruto(Double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}


	public Double getBonificacion() {
		return bonificacion;
	}


	public void setBonificacion(Double bonificacion) {
		this.bonificacion = bonificacion;
	}


	public Integer getCodTrabajador() {
		return codTrabajador;
	}


	public void setCodTrabajador(Integer codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	}