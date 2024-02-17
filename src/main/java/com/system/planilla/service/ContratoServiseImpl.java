package com.system.planilla.service;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.planilla.controller.dto.request.ContratoRequest;
import com.system.planilla.controller.dto.response.ContratoResponse;
import com.system.planilla.model.Contrato;
import com.system.planilla.model.Trabajador;
import com.system.planilla.repository.ContratoRepository;
import util.UtilFecha;
import util.UtilLimitarDecimal;

@Service
public class ContratoServiseImpl implements ContratoService{

	
	private static final Logger log =  LogManager.getLogger(ContratoServiseImpl.class.getName());
	
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
					 contratoResponse.setFechaInicio(contrato.getFechaInicio());
					 contratoResponse.setFechaFin(contrato.getFechaFin());
					 
			contratoResponse.setFechaInicio(UtilFecha.parseFechaBaseDatos(UtilFecha.formatoFechaBaseDatos(contrato.getFechaInicio())));
		    contratoResponse.setFechaFin(UtilFecha.parseFechaBaseDatos(UtilFecha.formatoFechaBaseDatos(contrato.getFechaFin())));
					
					 
					 
					 contratoResponse.setBonificacion(contrato.getBonificacion());
					 contratoResponse.setNombreCompletoTrabajador(contrato.getTrabajador().getNombre() + "  "+  contrato.getTrabajador().getApePaterno()+  "  "+ contrato.getTrabajador().getApeMaterno());
					 
					 contratoResponse.setSueldoBruto(UtilLimitarDecimal.limitarDosDecimal(contrato.getSueldoBruto())  );
					 
					
					   return contratoResponse;
				 }).collect(Collectors.toList());
		
		return listadoContratoResponse;
	}
	
	// Convertir la fecha recibida a LocalDate
   

    
        

	@Override
	public Integer registrarContrato(ContratoRequest contratoRequest) {
		
            Contrato contrato = new Contrato();
		                            
		
		contrato.setCodContrato(contratoRequest.getCodContrato());
		contrato.setModContrato(contratoRequest.getModContrato());
		
		
		contrato.setFechaInicio(contratoRequest.getFechaInicio());
		contrato.setFechaFin(contratoRequest.getFechaFin());
		contrato.setFechaInicio(UtilFecha.parseFechaBaseDatos(UtilFecha.formatoFechaBaseDatos(contratoRequest.getFechaInicio())));
        contrato.setFechaFin(UtilFecha.parseFechaBaseDatos(UtilFecha.formatoFechaBaseDatos(contratoRequest.getFechaFin())));
		
		contrato.setBonificacion(contratoRequest.getBonificacion());
		contrato.setSueldoBruto(contratoRequest.getSueldoBruto())  ;
		
		

		
		Trabajador trabajador = new Trabajador(contratoRequest.getCodTrabajador());
		 contrato.setTrabajador(trabajador);
	

		return contratoRepository.save(contrato).getCodContrato();
	}

}


 