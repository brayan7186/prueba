package com.system.planilla.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.planilla.controller.dto.response.DistritoResponse;
import com.system.planilla.controller.dto.response.EstadoCivilResponse;
import com.system.planilla.repository.DistritoRepository;


@Service
public class DistritoServiceImpl  implements DistritoService {

	
	 @Autowired
	  DistritoRepository distritoRepository;

	
	@Override
	public List<DistritoResponse> listarDistrito() {
		
		
	
		 List<DistritoResponse> listadoDistritoResponse;
		 
		 
		    listadoDistritoResponse  = distritoRepository.findAll()
					 .stream()
					 .map(distrito -> {
					 DistritoResponse distritoResponse  = new DistritoResponse();
						
					 
					 distritoResponse.setCodDistrito(distrito.getCodDistrito());
					 distritoResponse.setDescripcion(distrito.getDescripcion());
						 
						   return distritoResponse;
					 }).collect(Collectors.toList());
		    
			return  listadoDistritoResponse;

	}
	
	
}
