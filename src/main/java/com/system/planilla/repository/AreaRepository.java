package com.system.planilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.system.planilla.model.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

}
