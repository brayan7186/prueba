package com.system.planilla.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.planilla.model.Cargo;
import com.system.planilla.model.Contrato;
import com.system.planilla.model.Trabajador;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

	
	 @Query("SELECT c FROM Contrato c WHERE c.fechaInicio = :fechaInicio AND c.fechaFin = :fechaFin AND c.sueldoBruto = :sueldoBruto")
	    List<Contrato> findByFechaInicioAndFechaFinAndSueldoBrutoJPQL(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin, @Param("sueldoBruto") Double sueldoBruto);

	 
	 
	 @Query("SELECT c FROM Contrato c WHERE c.trabajador.codTrabajador = :codTrabajador")
	 Contrato findByCodTrabajadorJPQL(@Param("codTrabajador") Integer codTrabajador);

	
		
}
