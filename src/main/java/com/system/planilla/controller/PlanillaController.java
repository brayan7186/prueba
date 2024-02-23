package com.system.planilla.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.planilla.controller.dto.request.PlanillaRequest;
import com.system.planilla.controller.dto.response.PlanillaResponse;
import com.system.planilla.service.PlanillaService;

@RestController
@RequestMapping("/planilla")
public class PlanillaController {
     
	 private static final Logger logger = LoggerFactory.getLogger(PlanillaController.class);


	
	  @Autowired
	  PlanillaService planillaService;
	  
	 //http://localhost:8080/planilla/listadoPlanilla
	@RequestMapping(value = "/listadoPlanilla" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PlanillaResponse>> listado(){
		List<PlanillaResponse> listaPlanillaResponse = planillaService.listarPlanilla();
		

		 
		listaPlanillaResponse.forEach(a -> logger.info(a.toString()));
		
		return new ResponseEntity<>(listaPlanillaResponse, HttpStatus.OK);
}
	
	//crear
	@RequestMapping(value = "/crearPlanilla" , method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> registrarContrato(@RequestBody  PlanillaRequest planillaRequest  ){
		                //puse planilla response (?)
		
		HashMap<String, String>	response = new HashMap<>();
		Integer resultado = planillaService.registrarPlanilla(planillaRequest);
		    
		   if( resultado > 0) {
			   response.put("respuesta", "registro  exitoso"); 
		   }
		   else {
			   response.put("respuesta", "registro  incorrecto"); 
		   }
		
		 return new ResponseEntity<>(response, HttpStatus.CREATED);

}
}
	
