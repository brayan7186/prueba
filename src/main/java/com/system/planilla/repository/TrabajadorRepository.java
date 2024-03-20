package com.system.planilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.system.planilla.model.Trabajador;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
	
	@Query("SELECT t FROM Trabajador t WHERE t.area.codArea = :codArea AND t.cargo.codCargo = :codCargo AND t.estadoCivil.codEstCivil = :codEstadoCivil AND t.distrito.codDistrito = :codDistrito")
	List<Trabajador> findByCodAreaAndCodCargoAndCodEstadoCivilAndCodDistritoJPQL(@Param("codArea") Integer codArea, @Param("codCargo") Integer codCargo, @Param("codEstadoCivil") Integer codEstadoCivil, @Param("codDistrito") Integer codDistrito);

	
	Trabajador findByDni(String dni);
	
	
  
}