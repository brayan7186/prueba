package com.system.planilla.service;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.planilla.controller.dto.request.ContratoRequest;
import com.system.planilla.controller.dto.response.ContratoResponse;
import com.system.planilla.model.Area;
import com.system.planilla.model.Cargo;
import com.system.planilla.model.Contrato;
import com.system.planilla.model.EstadoCivil;
import com.system.planilla.model.Trabajador;
import com.system.planilla.repository.ContratoRepository;

import util.UtilFecha;
import util.UtilLimitarDecimal;

@Service
public class ContratoServiseImpl implements ContratoService{

	
	@Autowired 
	ContratoRepository contratoRepository;
	
	    
	
	@Override
	public List<ContratoResponse> listarContrato() {
		
		List<ContratoResponse> listadoContratoResponse;

       
		listadoContratoResponse  = contratoRepository.findAll()
				 .stream()
				 .map( contrato -> {
					 ContratoResponse contratoResponse = new ContratoResponse();
					 contratoResponse.setCodContrato(contrato.getCodContrato());
					 contratoResponse.setModContrato(contrato.getModContrato());
					 contratoResponse.setFechaInicio(UtilFecha.convertDateToStringFormat(contrato.getFechaInicio(), "") );
					 contratoResponse.setFechaFin(UtilFecha.convertDateToStringFormat ( contrato.getFechaFin(), "dd/mm/yyyy"));
					 contratoResponse.setBonificacion(contrato.getBonificacion());
					 contratoResponse.setNombreCompletoTrabajador(contrato.getTrabajador().getNombre() + "  "+  contrato.getTrabajador().getApePaterno()+  "  "+ contrato.getTrabajador().getApeMaterno());
					 
					 contratoResponse.setSueldoBruto(UtilLimitarDecimal.limitarDosDecimal(contrato.getSueldoBruto())  );
					   return contratoResponse;
				 }).collect(Collectors.toList());
		
		return listadoContratoResponse;
	}

	@Override
	public Integer registrarContrato(ContratoRequest contratoRequest) {
		
            Contrato contrato = new Contrato();
		
		
		contrato.setCodContrato(contratoRequest.getCodContrato());
		contrato.setModContrato(contratoRequest.getModContrato());
		contrato.setFechaInicio(contratoRequest.getFechaInicio());
		contrato.setFechaFin( contratoRequest.getFechaFin());
		contrato.setBonificacion(contratoRequest.getBonificacion());
		contrato.setSueldoBruto(contratoRequest
				.getSueldoBruto())  ;
		
		/*contrato.setSueldoBruto(UtilLimitarDecimal.limitarDecimal(contratoRequest
				.getSueldoBruto())  );
		contrato.setFechaInicio(UtilFecha.convertDateToString(contratoRequest.getFechaInicio()));
		contrato.setFechaFin(UtilFecha.convertDateToString ( contratoRequest.getFechaFin()));*/
		
		
		
		
		//Double.parseDouble(contrato.setSueldoBruto);
		
		/*Date fechaInicio = UtilFecha.convertStringToDate(fechaInicioString); // Necesitas implementar este método
		contrato.setFechaInicio(fechaInicio);*/

		
		Trabajador trabajador = new Trabajador(contratoRequest.getCodTrabajador());
		 contrato.setTrabajador(trabajador);
	

		return contratoRepository.save(contrato).getCodContrato();
	}

}


 