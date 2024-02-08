package com.system.planilla.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DetallePlanillaRequest {

	
	
	
	@JsonProperty("sueldoBruto")
	 private Double  sueldoBruto;
	
	@JsonProperty("onp")
	private Double onp;
	
	@JsonProperty("afp")
	private Double afp;
	
	@JsonProperty("impuestoRenta")
	private Double impuestoRenta;
	
	
	@JsonProperty("codTrabajador")
	private Integer   codTrabajador;

	

	public Double getSueldoBruto() {
		return sueldoBruto;
	}

	public void setSueldoBruto(Double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}

	public Double getOnp() {
		return onp;
	}

	public void setOnp(Double onp) {
		this.onp = onp;
	}

	public Double getAfp() {
		return afp;
	}

	public void setAfp(Double afp) {
		this.afp = afp;
	}

	

	

	public Double getImpuestoRenta() {
		return impuestoRenta;
	}

	public void setImpuestoRenta(Double impuestoRenta) {
		this.impuestoRenta = impuestoRenta;
	}

	public Integer getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(Integer codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

}
