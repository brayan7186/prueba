package com.system.planilla.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.planilla.controller.dto.request.DetallePlanillaRequest;
import com.system.planilla.controller.dto.request.PlanillaRequest;
import com.system.planilla.controller.dto.response.PlanillaResponse;
import com.system.planilla.model.Area;
import com.system.planilla.model.Cargo;
import com.system.planilla.model.DetallePlanilla;
import com.system.planilla.model.EstadoCivil;
import com.system.planilla.model.Planilla;
import com.system.planilla.model.Trabajador;
import com.system.planilla.repository.DetallePlaniaRepository;
import com.system.planilla.repository.PlanillaRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service

public class PlanillaServiceImpl implements PlanillaService {

	@Autowired
	PlanillaRepository planillaRepository;

	@Autowired
	DetallePlaniaRepository detallePlaniaRepository;

	@Override
	public List<PlanillaResponse> listarPlanilla() {

		List<PlanillaResponse> listadoPlanillaResponse;

		listadoPlanillaResponse = planillaRepository.findAll().stream().map(planilla -> {
			PlanillaResponse planillaResponse = new PlanillaResponse();
			planillaResponse.setCodPlanilla(planilla.getCodPlanilla());
			planillaResponse.setDescripcion(planilla.getDescripcion());
			planillaResponse.setAnio(planilla.getAnio());
			planillaResponse.setMes(planilla.getMes());
			planillaResponse.setMontoTotal(planilla.getMontoTotal());

			return planillaResponse;
		}).collect(Collectors.toList());

		return listadoPlanillaResponse;
	}

	 double salarioNeto =  0;
	  double sumaSalariosNetos = 0;
	 
	@Override
	public Integer registrarPlanilla(PlanillaRequest planillaRequest) {

		Planilla planilla = new Planilla();

		planilla.setAnio(planillaRequest.getAnio());
		planilla.setDescripcion(planillaRequest.getDescripcion());
		planilla.setMes(planillaRequest.getMes());
		//planilla.setMontoTotal(planillaRequest.getMontoTotal());

		Integer codigoPlanillaBD = planillaRepository.save(planilla).getCodPlanilla();

		for (DetallePlanillaRequest detRequest : planillaRequest.getDetalle()) {

			
			DetallePlanilla detallePlanilla = new DetallePlanilla();

			detallePlanilla.setSueldoBruto(detRequest.getSueldoBruto());
			detallePlanilla.setAfp(detRequest.getAfp());
			detallePlanilla.setOnp(detRequest.getOnp());
			detallePlanilla.setImpuestoRenta(detRequest.getImpuestoRenta());
			detallePlanilla.setCodTrabajador(detRequest.getCodTrabajador());
			detallePlanilla.setCodPlanilla(codigoPlanillaBD);

			     detallePlanilla.setSalarioNeto(  detRequest.getSueldoBruto() - detRequest.getAfp() - detRequest.getOnp()
					- detRequest.getImpuestoRenta());

			  
			    
			    		   salarioNeto =  detallePlanilla.getSalarioNeto();

			    		  sumaSalariosNetos += salarioNeto;
			    		    planilla.setMontoTotal( sumaSalariosNetos);
			     
			    		  
			    		    
			           detallePlaniaRepository.save(detallePlanilla);  

		}
		
	
		

		return codigoPlanillaBD;

	}
	
	
	
  
	/*
	 * for (int i = 0; i < planillaRequest.getDetalle().size(); i++) {
	 * 
	 * DetallePlanilla detallePlanilla = new DetallePlanilla();
	 * 
	 * detallePlanilla.setSalario(planillaRequest.getDetalle().get(i).getSalario());
	 * detallePlanilla.setPlanilla(new Planilla(codigoPlanillaBD));
	 * detallePlanilla.setTrabajador(new
	 * Trabajador(planillaRequest.getDetalle().get(i).getCodTrabajador()));
	 * 
	 * detallePlaniaRepository.save(detallePlanilla); }
	 */
}
