package com.system.planilla.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.planilla.controller.dto.response.EstadoCivilResponse;
import com.system.planilla.service.EstadoCivilService;


@RestController
@RequestMapping("/planilla")
public class EstadoCivilController {
	
	 private static final Logger logger = LoggerFactory.getLogger(EstadoCivilController.class);

	@Autowired 
	EstadoCivilService estadoCivilService;
	
	       //http://localhost:8080/planilla/listadoEstadoCivil
			@RequestMapping(value = "/listadoEstadoCivil" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<EstadoCivilResponse>> listado(){
				List<EstadoCivilResponse> listaEstadoCivilResponse = estadoCivilService.listarEstadoCivil();
				
				 listaEstadoCivilResponse.forEach(a -> logger.info(a.toString()));

				 return new ResponseEntity<>(listaEstadoCivilResponse, HttpStatus.OK);
				  
				  
			}

}
