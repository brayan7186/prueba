package com.system.planilla.controller.dto.response;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePlanillaResponse {

	
	@JsonProperty("codDetallePlanilla")
	private Integer   codDetallePlanilla;
	
	@JsonProperty("salario")
	 private Double  salario;
	
	@JsonProperty("codPlanilla")
	private Integer   codPlanilla;
	
	@JsonProperty("codTrabajador")
	private Integer   codTrabajador;


}
