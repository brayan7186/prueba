package com.system.planilla.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.planilla.controller.dto.response.AreaResponse;
import com.system.planilla.model.Area;
import com.system.planilla.service.AreaService;

@RestController
@RequestMapping("/planilla")
public class AreaController {
	
	@Autowired
	AreaService areaService;
	
	//http://localhost:8080/planilla/listadoArea
	@RequestMapping(value = "/listadoArea" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AreaResponse>> listado(){
		List<AreaResponse> listaAreaResponse = new ArrayList<AreaResponse>();
		
		listaAreaResponse = areaService.listarAreas();
		
		listaAreaResponse.forEach(a -> System.out.println(a));
		
		return new ResponseEntity<List<AreaResponse>>(listaAreaResponse, HttpStatus.OK);
	}
	


}
