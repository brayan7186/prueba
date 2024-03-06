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
public class Cargo {

	
	@Id
	@Column(name = "codCargo")
	private Integer codCargo;
	
	
	

	@Column(name = "descripcion" , length = 50)
	private String descripcion;

	

	@Column(name = "codArea")
	private Integer codArea;
	
	
	
	
	
	
	
	public Cargo(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	

	public Cargo() {
		super();
	}



	public Cargo(Integer codCargo) {
		super();
		this.codCargo = codCargo;
	}

	
	
	
}
