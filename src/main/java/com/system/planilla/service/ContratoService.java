package com.system.planilla.service;

import java.time.LocalDate;
import java.util.List;


import com.system.planilla.controller.dto.request.ContratoRequest;
import com.system.planilla.controller.dto.response.ContratoResponse;


public interface ContratoService {

	public abstract List<ContratoResponse> listarContrato();
	
	public abstract Integer registrarContrato(ContratoRequest contratoRequest);
	
	public abstract Integer actualizarContrato(ContratoRequest contratoRequest  );
	
	
	public abstract ContratoResponse obtenerContrato(Integer codContrato);
	
	
	public abstract List<ContratoResponse> listarContratoPorFechaInicioFechaFinSuedoBruto(LocalDate fechaInicio, LocalDate fechaFin, Double sueldoBruto);
	
}
