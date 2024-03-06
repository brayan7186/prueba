package com.system.planilla.service;

import java.util.List;

import com.system.planilla.controller.dto.TrabajadorBusquedaResponse;
import com.system.planilla.controller.dto.request.TrabajadorRequest;
import com.system.planilla.controller.dto.response.TrabajadorResponse;

public interface TrabajadorService {

	public abstract List<TrabajadorResponse> listarTrabajador();
	
	public abstract Integer registrarTrabajador(TrabajadorRequest trabajadorRequest);
	
	public abstract TrabajadorBusquedaResponse obtenerTrabajador(Integer codTrabajador);
	
	public abstract     TrabajadorBusquedaResponse     Trabjadordistrito(String distrito);
	
	public abstract Integer eliminarTrabajador(Integer codTrabajador);
	
	public abstract Integer actualizarTrabajador(TrabajadorRequest trabajadorRequest  );
	
	//public abstract Integer crearTrabajador(TrabajadorRequest trabajadorRequest);
	
	public abstract List<TrabajadorResponse> listarTrabajadorPorCodAreaCarcoEstadoCivil(Integer codArea ,Integer codCargo ,Integer codEsatdoCivil,Integer codDistrito);
}
