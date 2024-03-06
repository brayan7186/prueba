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

import com.system.planilla.controller.dto.response.DistritoResponse;
import com.system.planilla.service.DistritoService;

@RestController
@RequestMapping("/planilla")
public class DistritoController {

	

	 private static final Logger logger = LoggerFactory.getLogger(DistritoController.class);

	@Autowired 
	DistritoService distritoService;
	
	       //http://localhost:8080/planilla/listadoEstadoCivil
			@RequestMapping(value = "/listadoDistrito" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<DistritoResponse>> listado(){
				List<DistritoResponse> listaDistritoResponse = distritoService.listarDistrito();
				
				listaDistritoResponse.forEach(a -> logger.info(a.toString()));

				 return new ResponseEntity<>(listaDistritoResponse, HttpStatus.OK);
				  
				  
			}

}
