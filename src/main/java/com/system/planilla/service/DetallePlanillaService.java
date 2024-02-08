package com.system.planilla.service;

import java.util.List;

import com.system.planilla.controller.dto.request.DetallePlanillaRequest;
import com.system.planilla.controller.dto.response.DetallePlanillaResponse;


public interface DetallePlanillaService {

public abstract List<DetallePlanillaResponse> listarDetallePlanilla();
	
public abstract Integer registrarDetallePlanilla(DetallePlanillaRequest detallePlanillaRequest);
}
