package com.system.planilla.service;

import java.util.List;

import com.system.planilla.controller.dto.response.CargoResponse;


public interface CargoService {

	public abstract List<CargoResponse> listarCargos(); 
	
	public abstract List<CargoResponse> listarCargoPorCodArea(Integer codArea);
}
