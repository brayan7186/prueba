package com.system.planilla.controller.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 public class ContratoBase {

	@JsonProperty("codContrato")
	private Integer codContrato;

	@JsonProperty("modContrato")
	private String modContrato;

	@JsonProperty("fechaInicio")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaInicio;

	@JsonProperty("fechaFin")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaFin;

	
	@JsonProperty("bonificacion")
	private Double bonificacion;
	
	
	@JsonProperty("codTrabajador")
	 private Integer codTrabajador;
	
	@JsonProperty("dni")
	 private String dni; 
	
	
}
