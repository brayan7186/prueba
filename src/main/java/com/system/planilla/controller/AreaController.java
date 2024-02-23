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

import com.system.planilla.controller.dto.response.AreaResponse;
import com.system.planilla.service.AreaService;

@RestController
@RequestMapping("/planilla")
public class AreaController {
	
	private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

	@Autowired
	AreaService areaService;
	
	//http://localhost:8080/planilla/listadoArea
	@RequestMapping(value = "/listadoArea" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AreaResponse>> listado(){
		
		List<AreaResponse> listaAreaResponse  = areaService.listarAreas();
		
		
		  listaAreaResponse.forEach(a -> logger.info(a.toString()));
	
		return new ResponseEntity<>(listaAreaResponse, HttpStatus.OK);


	}
	

 
}
