package com.system.planilla.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.planilla.controller.dto.request.trabajadorRequest;
import com.system.planilla.controller.dto.response.trabajadorResponse;
import com.system.planilla.model.Area;
import com.system.planilla.model.Cargo;
import com.system.planilla.model.EstadoCivil;
import com.system.planilla.model.Trabajador;
import com.system.planilla.repository.TrabajadorRepository;


@Service
public class TrabajadorServiceImpl  implements TrabajadorService{

	
	 @Autowired
	 TrabajadorRepository trabajadorRepository;
	
	@Override
	public List<trabajadorResponse> listarTrabajador() {
		  List<trabajadorResponse> listadoTrabajadorResponse;
			 
			 
		  listadoTrabajadorResponse  = trabajadorRepository.findAll()
					 .stream()
					 .map(trabajador -> {
						 trabajadorResponse trabajadorResponse = new trabajadorResponse();
						
					 
					
						 trabajadorResponse.setCodTrabajador(trabajador.getCodTrabajador());
						 trabajadorResponse.setNombre(trabajador.getNombre());
						 trabajadorResponse.setApeMaterno(trabajador.getApeMaterno());
						 trabajadorResponse.setApePaterno(trabajador.getApePaterno());
			  			 trabajadorResponse.setCorreo(trabajador.getCorreo());
						 trabajadorResponse.setEdad(trabajador.getEdad());
						 trabajadorResponse.setCelular(trabajador.getCelular());
						 trabajadorResponse.setDireccion(trabajador.getDireccion());
						 trabajadorResponse.setDni(trabajador.getDni());
						 trabajadorResponse.setDescripcionEstadoCivil(trabajador.getEstadoCivil().getDescripcion());
						 trabajadorResponse.setDescripcionArea(trabajador.getArea().getDescripcion());
						 trabajadorResponse.setDescripcionCargo(trabajador.getCargo().getDescripcion());
						 
						   return trabajadorResponse;
					 }).collect(Collectors.toList());
	
		return listadoTrabajadorResponse;
	}

	 
	@Override
	public 	Integer registrarTrabajador(trabajadorRequest trabajadorRequest) {
		
		
		Trabajador trabajador = new Trabajador();
		
		trabajador.setNombre(trabajadorRequest.getNombre());
		trabajador.setApeMaterno(trabajadorRequest.getApeMaterno());
		trabajador.setApePaterno(trabajadorRequest.getApePaterno());
		trabajador.setCorreo(trabajadorRequest.getCorreo());
		trabajador.setEdad(trabajadorRequest.getEdad());
		trabajador.setCelular(trabajadorRequest.getCelular());
		trabajador.setDireccion(trabajadorRequest.getDireccion());
		trabajador.setDni(trabajadorRequest.getDni());
		
		
		   
		 EstadoCivil estadoCivil = new EstadoCivil(trabajadorRequest.getCodEstCivil());
		trabajador.setEstadoCivil(estadoCivil);
	
		Cargo cargo = new Cargo(trabajadorRequest.getCodCargo());
		trabajador.setCargo(cargo);
		
		Area area = new Area(trabajadorRequest.getCodArea());
		trabajador.setArea(area);
		

		return trabajadorRepository.save(trabajador).getCodTrabajador();
	}

}
