package com.system.planilla.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.planilla.controller.dto.response.CargoResponse;
import com.system.planilla.service.CargoService;

@RestController
@RequestMapping("/planilla")
public class CargoController {

	
	@Autowired 
	CargoService cargoService;
	
	//http://localhost:8080/planilla/listadoCargo
		@RequestMapping(value = "/listadoCargo" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<CargoResponse>> listado(){
			List<CargoResponse> listaCargoResponse = new ArrayList<CargoResponse>();
			
			listaCargoResponse = cargoService.listarCargos();
			
			listaCargoResponse.forEach(a -> System.out.println(a));
			
			return new ResponseEntity<List<CargoResponse>>(listaCargoResponse, HttpStatus.OK);
}
}

