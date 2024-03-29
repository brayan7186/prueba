package com.system.planilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.system.planilla.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

}
