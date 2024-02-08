package com.system.planilla.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.planilla.controller.dto.response.CargoResponse;
import com.system.planilla.repository.CargoRepository;

@Service
public class CargoServiceImpl implements CargoService {

	
	@Autowired
	CargoRepository cargoRepository;
	
	@Override
	public List<CargoResponse> listarCargos() {
		
		 List<CargoResponse> listadoCargoResponse;
		 
		 
		 listadoCargoResponse  = cargoRepository.findAll()
				 .stream()
				 .map(cargo -> {
					CargoResponse cargoResponse = new CargoResponse();
					
					 cargoResponse.setCodCargo(cargo.getCodCargo());
					 cargoResponse.setDescripcion(cargo.getDescripcion());
					   return cargoResponse;
				 }).collect(Collectors.toList());
		 return listadoCargoResponse;
	}
	
}
