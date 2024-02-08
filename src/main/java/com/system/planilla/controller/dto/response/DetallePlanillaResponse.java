package com.system.planilla.controller.dto.response;



import com.fasterxml.jackson.annotation.JsonProperty;


public class DetallePlanillaResponse {

	
	@JsonProperty("codigo")
	private Integer   codDetallePlanilla;
	
	@JsonProperty("salario")
	 private Double     salario;
	
	@JsonProperty("codPlanilla")
	private Integer   codPlanilla;
	
	@JsonProperty("trabajador")
	private Integer   codTrabajador;

	public Integer getCodDetallePlanilla() {
		return codDetallePlanilla;
	}

	public void setCodDetallePlanilla(Integer codDetallePlanilla) {
		this.codDetallePlanilla = codDetallePlanilla;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getCodPlanilla() {
		return codPlanilla;
	}

	public void setCodPlanilla(Integer codPlanilla) {
		this.codPlanilla = codPlanilla;
	}

	public Integer getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(Integer codTrabajador) {
		this.codTrabajador = codTrabajador;
	}
	
	
	
}
