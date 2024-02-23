package com.system.planilla.controller.dto.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AreaResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("codAre")
	private Integer codArea;
	
	@JsonProperty("descripcion")
	private String descripcion;

}
