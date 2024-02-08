package com.system.planilla.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.planilla.controller.dto.request.trabajadorRequest;
import com.system.planilla.controller.dto.response.trabajadorResponse;
import com.system.planilla.model.Trabajador;
import com.system.planilla.service.TrabajadorService;

@RestController
@RequestMapping("/planilla")
public class TrabajadorController {

	
	@Autowired 
	TrabajadorService trabajadorService;
	
	       //http://localhost:8080/planilla/listadoTrabajo
			@RequestMapping(value = "/listadoTrabajo" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<trabajadorResponse>> listado(){
				List<trabajadorResponse> listaTrabajadorResponse = new ArrayList<trabajadorResponse>();
				
				listaTrabajadorResponse = trabajadorService.listarTrabajador();
				 
				listaTrabajadorResponse.forEach(a -> System.out.println(a));
				
				return new ResponseEntity<List<trabajadorResponse>>(listaTrabajadorResponse, HttpStatus.OK);
}
		
			//http://localhost:8080/planilla/crearTrabajador
			@RequestMapping(value = "/crearTrabajador" , method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<?> registrarTrabajadaor(@RequestBody trabajadorRequest trabajadorRequest  ){
				
				
				HashMap<String, String>	response = new HashMap<>();
		         	Integer resultado = trabajadorService.registrarTrabajador(trabajadorRequest);
				  
				    
				   if( resultado > 0 ) {
					   response.put("respuesta", "registro  exitoso"); 
				   }
				   else {
					   response.put("respuesta", "registro incorrecto"); 
				   }
				 
				 return new ResponseEntity<Map<String, String>>(response,HttpStatus.CREATED);
				
			}
      
			 /* 

	
	@Autowired
	TrabajadorService trabajadorService;
	
	//http://localhost:8080/planilla/crearTrabajador
	@RequestMapping(value = "/crearTrabajador" , method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarTrabajadaor(@RequestBody TrabajadorRequest trabajadorRequest  ){
		
		
		HashMap<String, String>	response = new HashMap<>();
         	Integer resultado = trabajadorService.registrarTrabajador(trabajadorRequest);
		  
		    
		   if( resultado > 0 ) {
			   response.put("respuesta", "registro  exitoso"); 
		   }
		   else {
			   response.put("respuesta", "registro incorrecto"); 
		   }
		 
		 return new ResponseEntity<Map<String, String>>(response,HttpStatus.CREATED);
		
	}
	
}
 */  
}
