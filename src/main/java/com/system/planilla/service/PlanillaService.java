package com.system.planilla.service;

import java.util.List;


import com.system.planilla.controller.dto.request.PlanillaRequest;
import com.system.planilla.controller.dto.response.PlanillaResponse;

public interface PlanillaService {

	
	   public abstract List<PlanillaResponse> listarPlanilla();
	   
	   
	   public abstract Integer registrarPlanilla(PlanillaRequest planillaRequest);
	   
	   public abstract PlanillaResponse obtenerPlanilla(Integer codPlanilla);
	   
}
