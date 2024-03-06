package com.system.planilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.planilla.model.Distrito;

@Repository
public interface DistritoRepository extends  JpaRepository<Distrito, Integer> {

}
