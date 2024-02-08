package com.system.planilla.service;

import java.util.List;

import com.system.planilla.controller.dto.request.trabajadorRequest;
import com.system.planilla.controller.dto.response.trabajadorResponse;
import com.system.planilla.model.Trabajador;

public interface TrabajadorService {

	public abstract List<trabajadorResponse> listarTrabajador();
	
	public abstract Integer registrarTrabajador(trabajadorRequest trabajadorRequest);
}
