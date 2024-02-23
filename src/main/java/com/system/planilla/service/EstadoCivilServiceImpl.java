package com.system.planilla.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.planilla.controller.dto.response.EstadoCivilResponse;
import com.system.planilla.repository.EstadoCivlRepository;

@Service
public class EstadoCivilServiceImpl  implements EstadoCivilService{

	
	
	
	  @Autowired
	  EstadoCivlRepository estadoCivlRepository;

	  
	@Override
	public List<EstadoCivilResponse> listarEstadoCivil() {
		
		
        List<EstadoCivilResponse> listadoEstadoCivilResponse;
		 
		 
        listadoEstadoCivilResponse  = estadoCivlRepository.findAll()
				 .stream()
				 .map(estadoCivil -> {
				 EstadoCivilResponse estadoCivilResponse = new EstadoCivilResponse();
					
				 
				 estadoCivilResponse.setCodEstCivil(estadoCivil.getCodEstCivil());
				 estadoCivilResponse.setDescripcion(estadoCivil.getDescripcion());
					 
					   return estadoCivilResponse;
				 }).collect(Collectors.toList());
        
		return  listadoEstadoCivilResponse;
	}
	
	
	

}
