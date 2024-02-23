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

import com.system.planilla.controller.dto.request.ContratoRequest;
import com.system.planilla.controller.dto.response.ContratoResponse;
import com.system.planilla.service.ContratoService;

@RestController
@RequestMapping("/planilla")
public class ContratoController {

	
	 private static final Logger logger = LoggerFactory.getLogger(ContratoController.class);


	@Autowired 
	ContratoService contratoService;
	
	//http://localhost:8080/planilla/listadoContrato
		
			// http://localhost:8080/planilla/listadoContrato
			@RequestMapping(value = "/listadoContrato", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<ContratoResponse>> listado() {
			    List<ContratoResponse> listaContratoResponse = contratoService.listarContrato();
			    
			    
			    listaContratoResponse.forEach(a -> logger.info(a.toString()));
			    return new ResponseEntity<>(listaContratoResponse, HttpStatus.OK);
			}

			
			
			//crear
			@RequestMapping(value = "/crearContrato" , method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Map<String, String>> registrarContrato(@RequestBody  ContratoRequest contratoRequest  ){
				
				
				HashMap<String, String>	response = new HashMap<>();
		         	Integer resultado = contratoService.registrarContrato(contratoRequest);
				  
				    
				   if( resultado > 0) {
					   response.put("respuesta", "registro  exitoso"); 
				   }
				   else {
					   response.put("respuesta", "registro  incorrecto"); 
				   }
				 
				 return new ResponseEntity<>(response,HttpStatus.CREATED);
				
			}
}