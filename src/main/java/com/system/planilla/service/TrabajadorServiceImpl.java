package com.system.planilla.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.planilla.controller.dto.TrabajadorBusquedaResponse;
import com.system.planilla.controller.dto.request.TrabajadorRequest;
import com.system.planilla.controller.dto.response.TrabajadorResponse;
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
	public List<TrabajadorResponse> listarTrabajador() {
		
		  List<TrabajadorResponse> listadoTrabajadorResponse;
			 
			 
		  listadoTrabajadorResponse  = trabajadorRepository.findAll()
					 .stream()
					 .map(trabajador -> {
						 TrabajadorResponse trabajadorResponse = new TrabajadorResponse();
						
					 
					
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
	public 	Integer registrarTrabajador(TrabajadorRequest trabajadorRequest) {
		
		
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

/* List<CargoResponse> listadoCargoResponse;
		 
		 
		 listadoCargoResponse  = cargoRepository.findByCodArea(codArea)
				 .stream()
				 .map(cargo -> {
					CargoResponse cargoResponse = new CargoResponse();
					
					 cargoResponse.setCodCargo(cargo.getCodCargo());
					 cargoResponse.setDescripcion(cargo.getDescripcion());
					 cargoResponse.setCodArea(cargo.getCodArea());
					   return cargoResponse;
				 }).collect(Collectors.toList());
		 
		 return listadoCargoResponse;
	}*/
	@Override
	public List<TrabajadorBusquedaResponse> listarTrabajadorPorCodAreaCarcoEstadoCivil(Integer codArea, Integer codCargo,
			Integer codEsatdoCivil) {
		
		List<TrabajadorBusquedaResponse> listarTrabajadorResponse;
		
				
	
		listarTrabajadorResponse = trabajadorRepository.findByCodAreaAndCodCargoAndCodEstadoCivilJPQL(codArea, codCargo, codEsatdoCivil)
				.stream()
				.map(trabajador ->{
					TrabajadorBusquedaResponse trabajadorResponse = new TrabajadorBusquedaResponse();
					
					intercambiarValores(trabajador, trabajadorResponse);
					 
					trabajadorResponse.setDescripcionEstadoCivil(trabajador.getEstadoCivil().getDescripcion());
					 trabajadorResponse.setDescripcionArea(trabajador.getArea().getDescripcion());
					 trabajadorResponse.setDescripcionCargo(trabajador.getCargo().getDescripcion());
					 
					   return trabajadorResponse;
					   
				}).collect(Collectors.toList());
		return listarTrabajadorResponse;
	}
	


	@Override
	public Integer eliminarTrabajador(Integer codTrabajador) {
	    // Buscar el trabajador por su código
	    Optional<Trabajador> optionalTrabajador = trabajadorRepository.findById(codTrabajador);
	    
	   
	    if (optionalTrabajador.isPresent()) {
	        trabajadorRepository.delete(optionalTrabajador.get());
	        return 1; 
	    } else {
	       
	        return 0;
	    }
	}


	


	@Override
	public TrabajadorBusquedaResponse obtenerTrabajador(Integer codTrabajador) {
		
		//TrabajadorBusquedaResponse listarTrabajadorResponse;
		
		
		  Trabajador trabajador  = trabajadorRepository.getOne(codTrabajador);
			
			
			TrabajadorBusquedaResponse trabajadorResponse = new TrabajadorBusquedaResponse();
					
					 intercambiarValores(trabajador, trabajadorResponse);
					 
				
		return trabajadorResponse;
			
	}


	private void intercambiarValores(Trabajador trabajador, TrabajadorBusquedaResponse trabajadorResponse) {
		
		 trabajadorResponse.setCodTrabajador(trabajador.getCodTrabajador());
		 trabajadorResponse.setNombre(trabajador.getNombre());
		 trabajadorResponse.setApeMaterno(trabajador.getApeMaterno());
		 trabajadorResponse.setApePaterno(trabajador.getApePaterno());
	     trabajadorResponse.setCorreo(trabajador.getCorreo());
		 trabajadorResponse.setEdad(trabajador.getEdad());
		 trabajadorResponse.setCelular(trabajador.getCelular());
		 trabajadorResponse.setDireccion(trabajador.getDireccion());
		 trabajadorResponse.setDni(trabajador.getDni());
		 
	}



}
