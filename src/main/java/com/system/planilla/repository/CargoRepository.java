package com.system.planilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.system.planilla.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

	
	
	List<Cargo> findByCodArea(Integer codArea);
	
	
}
