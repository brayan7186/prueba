package com.system.planilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.planilla.model.DetallePlanilla;


@Repository
public interface DetallePlaniaRepository extends JpaRepository<DetallePlanilla, Integer>{

}
