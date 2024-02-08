package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "TB_CARGO")
@Getter
@Setter
public class Cargo {

	
	@Id
	@Column(name = "codCargo")
	private Integer codCargo;
	
	@Column(name = "descripcion" , length = 50)
	private String descripcion;

	
	
	
	 public Cargo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Cargo(Integer codCargo2) {
		
		this.codCargo = codCargo2 ;
	}

	@Override
	public String toString() {
		return "Cargo [codCargo=" + codCargo + ", descripcion=" + descripcion + "]";
	}

	public Integer getCodCargo() {
		return codCargo;
	}

	public void setCodCargo(Integer codCargo) {
		this.codCargo = codCargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
