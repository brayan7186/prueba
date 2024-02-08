package com.system.planilla.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.planilla.controller.dto.response.AreaResponse;
import com.system.planilla.repository.AreaRepository;


@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	AreaRepository areaRepository;

	@Override
	public List<AreaResponse> listarAreas() {
		List<AreaResponse> listadoAreaResponse ;
		
		listadoAreaResponse = areaRepository.findAll()
				.stream()
				.map(area -> {
					AreaResponse areaResponse = new AreaResponse();
					areaResponse.setCodArea(area.getCodArea());
					areaResponse.setDescripcion(area.getDescripcion());
					return areaResponse;
		}).collect(Collectors.toList());
		
		return listadoAreaResponse;
	}

}
