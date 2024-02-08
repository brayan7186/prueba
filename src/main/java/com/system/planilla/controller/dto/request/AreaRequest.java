package com.system.planilla.controller.dto.request;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AreaRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("codigo")
	private Integer codArea;
	
	@JsonProperty("nombre")
	private String descripcion;

	
	
	

}
