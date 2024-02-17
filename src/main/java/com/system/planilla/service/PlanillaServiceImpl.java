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
import util.Constante;

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

	double salarioNeto = 0;
	double sumaSalariosNetos = 0;

	@Override
	public Integer registrarPlanilla(PlanillaRequest planillaRequest) {

		Planilla planilla = new Planilla();

		planilla.setAnio(planillaRequest.getAnio());
		planilla.setDescripcion(planillaRequest.getDescripcion());
		planilla.setMes(planillaRequest.getMes());
		// planilla.setMontoTotal(planillaRequest.getMontoTotal());
		

		Integer codigoPlanillaBD = planillaRepository.save(planilla).getCodPlanilla();

		for (DetallePlanillaRequest detRequest : planillaRequest.getDetalle()) {

			DetallePlanilla detallePlanilla = new DetallePlanilla();

			detallePlanilla.setSueldoBruto(detRequest.getSueldoBruto());
			detallePlanilla.setBonoAlimeto(detRequest.getBonoAlimeto());
			detallePlanilla.setBonoInternet(detRequest.getBonoInternet());
			detallePlanilla.setBonoMovilidad(detRequest.getBonoMovilidad());
			detallePlanilla.setDiaNoLaborado(detRequest.getDiaNoLaborado());
			detallePlanilla.setCantidadHoraTardanza(detRequest.getCantidadHoraTardanza());;
			detallePlanilla.setDescuentoAfp(descuentoAfp(detRequest));
			detallePlanilla.setDescuentoAfpSeguro(descuentoAfpSeguro(detRequest));
			detallePlanilla.setDescuentoDia(descuentoPorDia(detRequest));
			detallePlanilla.setDescuentoImpRenta(descuentoImpuestoRenta(detRequest));
			
			
			 detallePlanilla.setDescuentoHora(descuentoPorHora(detRequest));
			detallePlanilla.setCodPlanilla(codigoPlanillaBD);
			detallePlanilla.setCodTrabajador(detRequest.getCodTrabajador());
         
			detallePlanilla.setSalarioNeto((detRequest.getSueldoBruto() - descuentoTotal(detRequest)) + bonificacionTotal(detRequest));

			salarioNeto = detallePlanilla.getSalarioNeto();
			System.out.println(salarioNeto);
			sumaSalariosNetos += salarioNeto;
			planilla.setMontoTotal(sumaSalariosNetos);

			detallePlaniaRepository.save(detallePlanilla);

		}

		return codigoPlanillaBD;

	}

	public double descuentoAfp(DetallePlanillaRequest detalle) {

		return Constante.AFP * detalle.getSueldoBruto();
	}

	public double descuentoAfpSeguro(DetallePlanillaRequest detalle) {

		return Constante.AFP_SEGURURO * detalle.getSueldoBruto();

	}

	public double descuentoImpuestoRenta(DetallePlanillaRequest detalle) {

		return Constante.IMP_RENTA * detalle.getSueldoBruto();

	}

	public double descuentoPorDia(DetallePlanillaRequest detalle) {

		return Constante.DESCUENTO_DIA * detalle.getDiaNoLaborado();
	}
	
	public double descuentoPorHora(DetallePlanillaRequest detalle) {
		return Constante.DESCUENTO_HORA * detalle.getCantidadHoraTardanza();
	}

	public double totaldescuentoLey(DetallePlanillaRequest detalle) {
		return descuentoAfp(detalle) + descuentoAfpSeguro(detalle)  
				+ descuentoImpuestoRenta(detalle);
	}

	public  double totaldescuentoPoliticaEmpresa( DetallePlanillaRequest detalle) {
		  return descuentoPorDia(detalle) + descuentoPorHora(detalle);
	  }
	
	public double bonificacionTotal(DetallePlanillaRequest detalle) {
		return detalle.getBonoAlimeto() + detalle.getBonoInternet() + detalle.getBonoMovilidad();
	}
	
  

	public double descuentoTotal(DetallePlanillaRequest detalle) {

		return totaldescuentoLey(detalle) + totaldescuentoPoliticaEmpresa(detalle) ;
	}
}
