package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "TB_CARGO")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Cargo {

	
	@Id
	@Column(name = "codCargo")
	@NonNull
	private Integer codCargo;
	
	
	@Column(name = "descripcion" , length = 50)
	private String descripcion;

	
	

	
	
}
