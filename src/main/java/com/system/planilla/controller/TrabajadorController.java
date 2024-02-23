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

import com.system.planilla.controller.dto.request.TrabajadorRequest;
import com.system.planilla.controller.dto.response.TrabajadorResponse;
import com.system.planilla.service.TrabajadorService;

@RestController
@RequestMapping("/planilla")
public class TrabajadorController {

	
	private static final Logger logger = LoggerFactory.getLogger(TrabajadorController.class);

	@Autowired 
	TrabajadorService trabajadorService;
	
	       //http://localhost:8080/planilla/listadoTrabajo
			@RequestMapping(value = "/listadoTrabajo" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<TrabajadorResponse>> listado(){
				List<TrabajadorResponse> listaTrabajadorResponse = trabajadorService.listarTrabajador();
				
				
				 
				listaTrabajadorResponse.forEach(a -> logger.info(a.toString()));
				
				return new ResponseEntity<>(listaTrabajadorResponse, HttpStatus.OK);
				
}
		
			//http://localhost:8080/planilla/crearTrabajador
			@RequestMapping(value = "/crearTrabajador" , method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Map<String, String>> registrarTrabajadaor(@RequestBody TrabajadorRequest trabajadorRequest  ){
				
				
				HashMap<String, String>	response = new HashMap<>();
		         	Integer resultado = trabajadorService.registrarTrabajador(trabajadorRequest);
				  
				    
				   if( resultado > 0 ) {
					   response.put("respuesta", "registro  exitoso"); 
				   }
				   else {
					   response.put("respuesta", "registro incorrecto"); 
				   }
				 
				 return new ResponseEntity<>(response,HttpStatus.CREATED);
				
			}
      

}
