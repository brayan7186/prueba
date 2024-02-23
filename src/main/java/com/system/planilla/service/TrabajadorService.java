package com.system.planilla.service;

import java.util.List;

import com.system.planilla.controller.dto.request.TrabajadorRequest;
import com.system.planilla.controller.dto.response.TrabajadorResponse;

public interface TrabajadorService {

	public abstract List<TrabajadorResponse> listarTrabajador();
	
	public abstract Integer registrarTrabajador(TrabajadorRequest trabajadorRequest);
}
