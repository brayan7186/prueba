package com.system.planilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.planilla.model.Planilla;

@Repository
public interface PlanillaRepository extends JpaRepository<Planilla, Integer>{

}
