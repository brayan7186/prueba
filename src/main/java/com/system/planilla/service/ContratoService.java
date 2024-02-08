package com.system.planilla.service;

import java.util.List;

import com.system.planilla.controller.dto.request.ContratoRequest;
import com.system.planilla.controller.dto.response.ContratoResponse;


public interface ContratoService {

	public abstract List<ContratoResponse> listarContrato();
	
	public abstract Integer registrarContrato(ContratoRequest contratoRequest);
}
