package com.system.planilla.controller.dto.response;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanillaResponse {

	@JsonProperty("codPlanilla")
	private Integer codPlanilla;
	
	@JsonProperty("descripcion")
	private  String descripcion;
		    
	@JsonProperty("año")
	private	Integer  anio;
	
	@JsonProperty("mes")
	private  String mes;
	
	@JsonProperty("montoTotal")
	private Double montoTotal;

	
	
}
